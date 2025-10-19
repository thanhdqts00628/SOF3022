# Mail Sending Webapp

This is a Spring Boot application for sending emails with authentication and access logging features.

## Features

1. **Mail Sending Service**
   - Send emails immediately
   - Add emails to a queue for background processing
   - Support for CC, BCC, HTML body, and file attachments
   - Uses Gmail SMTP server

2. **Authentication System**
   - User login/logout
   - Secure pages with authentication interceptor
   - Redirect to originally requested page after login

3. **Access History Logging**
   - Logs all access to secured pages
   - Displays URI, timestamp, and username
   - View access history in a dedicated page

## Configuration

Before running the application, update the mail configuration in `src/main/resources/application.properties`:

```properties
spring.mail.username=your-email@gmail.com
spring.mail.password=your-app-password
```

**Note:** For Gmail, you need to generate an App Password at https://myaccount.google.com/apppasswords

## Database Setup

The application uses MySQL database. Make sure MySQL is running and create the database:

```sql
CREATE SCHEMA IF NOT EXISTS J5Shop;
```

Then run the SQL script in `src/main/resources/JShop.sql` to create tables and sample data.

Update database connection in `application.properties` if needed:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/j5shop?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root
```

**Security Note:** The `useSSL=false` setting is for development only. In production, enable SSL for database connections.

## Running the Application

```bash
./mvnw spring-boot:run
```

Or build and run the WAR file:

```bash
./mvnw clean package
java -jar target/OnlineShoppingSystem-0.0.1-SNAPSHOT.war
```

## Usage

1. **Login**: Navigate to http://localhost:8080/auth/login
   - Use any username/password from the Accounts table in the database
   - Example: username: `customer`, password: `123`
   - **Note:** This is sample data for development. In production, use strong passwords and proper password hashing.

2. **Send Mail**: After login, you'll be redirected to http://localhost:8080/mail/form
   - Fill in the mail form with from, to, subject, body
   - Optional: CC, BCC, attachments
   - Click "Send Immediately" to send right away
   - Click "Add to Queue" to add to background processing queue

3. **View Access History**: Click "Access History" button
   - Shows all page accesses with URI, timestamp, and username

## API Endpoints

- `GET /auth/login` - Login page
- `POST /auth/login` - Login processing
- `GET /auth/logout` - Logout
- `GET /mail/form` - Mail sending form (secured)
- `POST /mail/send` - Send mail immediately (secured)
- `POST /mail/push` - Add mail to queue (secured)
- `GET /access-history` - View access logs (secured)

## Security Considerations

**Important:** This is a student project for learning purposes. For production use, implement the following:

1. **Password Security**: 
   - Current implementation stores passwords in plain text
   - Use Spring Security with BCrypt password encoder for production
   - Never store passwords in plain text

2. **Database Security**: 
   - Enable SSL for database connections
   - Use environment variables for sensitive credentials
   - Never commit credentials to version control

3. **Mail Configuration**: 
   - Use environment variables for mail credentials
   - Never commit email passwords to Git
   - Use OAuth2 instead of app passwords when possible

4. **Session Security**: 
   - Configure secure session management
   - Use HTTPS in production
   - Implement CSRF protection

## Technologies Used

- Spring Boot 3.5.5
- Spring Data JPA
- Thymeleaf
- Spring Mail
- MySQL
- Lombok
- Maven
