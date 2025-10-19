# Quick Start Guide

## Prerequisites
- Java 17 or higher
- MySQL 8.0 or higher
- Gmail account with App Password configured

## Setup (5 minutes)

### 1. Database Setup
```bash
# Login to MySQL
mysql -u root -p

# Create database and import schema
CREATE SCHEMA IF NOT EXISTS J5Shop;
USE J5Shop;
source src/main/resources/JShop.sql;
```

### 2. Configure Email
Edit `src/main/resources/application.properties`:
```properties
# Replace with your Gmail credentials
spring.mail.username=your-email@gmail.com
spring.mail.password=your-app-password
```

To get Gmail App Password:
1. Go to https://myaccount.google.com/apppasswords
2. Create new app password
3. Copy the 16-character password
4. Paste in application.properties

### 3. Run Application
```bash
./mvnw spring-boot:run
```

The application will start on http://localhost:8080

## First Steps

### Login
1. Open http://localhost:8080/auth/login
2. Use these test credentials:
   - Username: `customer`
   - Password: `123`

### Send Your First Email
1. After login, you'll see the mail form
2. Fill in:
   - **From**: Your Gmail address (same as spring.mail.username)
   - **To**: Any valid email address
   - **Subject**: Test Email
   - **Body**: Hello from Spring Boot Mail!
3. Click **Send Immediately** to send now
4. Or click **Add to Queue** to send in background

### View Access History
1. Click **Access History** button
2. See all your page visits with timestamps

## Test Credentials

From JShop.sql, you can use any of these:
- `customer` / `123`
- `director` / `123`
- `staff` / `123`
- `ALFKI` / `alfki`
- `ANATR` / `anatr`

## Common Issues

### "Could not connect to database"
- Check MySQL is running
- Verify database name is `J5Shop` (case-sensitive)
- Check username/password in application.properties

### "Could not send mail"
- Verify spring.mail.username and password are correct
- Ensure you used App Password, not regular Gmail password
- Check your Gmail account allows less secure apps or has 2FA enabled
- From address must match spring.mail.username

### "Access Denied" after login
- Make sure you logged in successfully
- Check session is maintained (cookies enabled)

## API Quick Reference

| Endpoint | Method | Description | Authentication |
|----------|--------|-------------|----------------|
| `/auth/login` | GET | Login page | No |
| `/auth/login` | POST | Process login | No |
| `/auth/logout` | GET | Logout | Yes |
| `/mail/form` | GET | Mail form page | Yes |
| `/mail/send` | POST | Send mail immediately | Yes |
| `/mail/push` | POST | Add to queue | Yes |
| `/access-history` | GET | View access logs | Yes |

## Features

✅ Send HTML emails
✅ Support CC, BCC
✅ File attachments (specify full path)
✅ Queue emails for background sending
✅ Authentication with session
✅ Access logging and history
✅ Responsive web interface
✅ Security best practices

## Next Steps

1. **Customize**: Modify HTML templates in `src/main/resources/templates/`
2. **Extend**: Add more features like email templates, better queue management
3. **Secure**: Implement Spring Security for production use
4. **Deploy**: Package as WAR and deploy to Tomcat

## Support

- Check README.md for detailed documentation
- See ARCHITECTURE.md for system design
- Read IMPLEMENTATION_SUMMARY.md for technical details

## Production Checklist

Before deploying to production:
- [ ] Enable SSL for database connections
- [ ] Use BCrypt password encoding
- [ ] Store credentials in environment variables
- [ ] Enable HTTPS
- [ ] Add CSRF protection
- [ ] Implement rate limiting
- [ ] Add email validation
- [ ] Set up logging to files
- [ ] Configure proper error pages
- [ ] Add monitoring and alerting

---

**Note**: This is an educational project. See README.md security section for production considerations.
