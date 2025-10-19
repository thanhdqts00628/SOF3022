# Application Architecture

## Component Flow Diagram

```
┌─────────────────────────────────────────────────────────────────────┐
│                           Web Browser                                │
└────────────────────────────┬────────────────────────────────────────┘
                             │
                             ▼
┌─────────────────────────────────────────────────────────────────────┐
│                      Spring MVC Controllers                          │
│  ┌──────────────┐  ┌──────────────┐  ┌─────────────────────────┐   │
│  │AuthController│  │MailController│  │AccessHistoryController  │   │
│  └──────────────┘  └──────────────┘  └─────────────────────────┘   │
└────────────────────────────┬────────────────────────────────────────┘
                             │
                             ▼
┌─────────────────────────────────────────────────────────────────────┐
│                         Interceptors                                 │
│  ┌──────────────────┐              ┌──────────────────┐             │
│  │  AuthInterceptor │              │  LogInterceptor  │             │
│  │  (Security)      │              │  (Logging)       │             │
│  └──────────────────┘              └──────────────────┘             │
└────────────────────────────┬────────────────────────────────────────┘
                             │
                             ▼
┌─────────────────────────────────────────────────────────────────────┐
│                        Service Layer                                 │
│  ┌──────────────────┐              ┌──────────────────┐             │
│  │ AccountService   │              │   MailService    │             │
│  │                  │              │                  │             │
│  │ - authenticate() │              │ - send()         │             │
│  │ - findById()     │              │ - push()         │             │
│  └──────────────────┘              │ - @Scheduled run │             │
│                                     └──────────────────┘             │
└────────┬───────────────────────────────────┬─────────────────────────┘
         │                                   │
         ▼                                   ▼
┌─────────────────┐                 ┌─────────────────┐
│   AccountDAO    │                 │ JavaMailSender  │
│ (JPA Repository)│                 │  (Spring Mail)  │
└────────┬────────┘                 └────────┬────────┘
         │                                   │
         ▼                                   ▼
┌─────────────────┐                 ┌─────────────────┐
│  MySQL Database │                 │  Gmail SMTP     │
│   (J5Shop)      │                 │   Server        │
└─────────────────┘                 └─────────────────┘
```

## Request Flow Examples

### 1. Login Flow
```
Browser → /auth/login (GET)
    → AuthController.showLoginForm()
    → Returns login.html

Browser → /auth/login (POST with credentials)
    → AuthController.login()
    → AccountService.authenticate()
    → AccountDAO.findById()
    → MySQL query
    → If valid: Store in session, redirect
    → If invalid: Show error
```

### 2. Send Mail Flow
```
Browser → /mail/form (GET)
    → AuthInterceptor.preHandle() [checks session]
    → LogInterceptor.preHandle() [logs access]
    → MailController.showMailForm()
    → Returns mail.html

Browser → /mail/send (POST with mail data)
    → AuthInterceptor.preHandle()
    → LogInterceptor.preHandle()
    → MailController.sendDirect()
    → MailService.send()
    → JavaMailSender creates MIME message
    → Sends to Gmail SMTP
    → Returns success message
```

### 3. Queue Mail Flow
```
Browser → /mail/push (POST with mail data)
    → MailController.pushToQueue()
    → MailService.push() [adds to queue List]
    → Returns queued message

Background:
    @Scheduled (every 500ms)
    → MailService.run()
    → Processes queue
    → For each mail in queue:
        → MailService.send()
        → JavaMailSender → Gmail SMTP
```

## Session Management

```
┌──────────────────────────────────────┐
│         HttpSession                  │
├──────────────────────────────────────┤
│ Attributes:                          │
│  - user: Account                     │
│    └─ Current logged in user         │
│                                      │
│  - securedUri: String                │
│    └─ URI user tried to access       │
│       before being redirected        │
│       to login                       │
│                                      │
│  - accessLogs: List<AccessLog>       │
│    └─ History of page accesses       │
│       for this session               │
└──────────────────────────────────────┘
```

## Data Models

```
┌──────────────────────────────────────┐
│           Account (JPA Entity)       │
├──────────────────────────────────────┤
│ - username: String (PK)              │
│ - password: String                   │
│ - fullname: String                   │
│ - email: String                      │
│ - photo: String                      │
│ - activated: Boolean                 │
│ - admin: Boolean                     │
└──────────────────────────────────────┘

┌──────────────────────────────────────┐
│           Mail (POJO)                │
├──────────────────────────────────────┤
│ - from: String                       │
│ - to: String                         │
│ - cc: String                         │
│ - bcc: String                        │
│ - subject: String                    │
│ - body: String (HTML)                │
│ - filenames: String (comma-sep)      │
└──────────────────────────────────────┘

┌──────────────────────────────────────┐
│         AccessLog (POJO)             │
├──────────────────────────────────────┤
│ - uri: String                        │
│ - timestamp: LocalDateTime           │
│ - username: String                   │
└──────────────────────────────────────┘
```

## Security Layers

```
1. Authentication Layer (AuthInterceptor)
   └─ Checks if user is logged in
   └─ Protects: /mail/**, /access-history
   └─ Excludes: /auth/**

2. Access Logging Layer (LogInterceptor)
   └─ Logs all secured page access
   └─ Stores in session for display

3. Error Sanitization
   └─ Catches exceptions
   └─ Logs details server-side
   └─ Shows generic message to user
```
