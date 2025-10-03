# SOF3022 - Spring Boot MVC Project

A Spring Boot web application with modern UI using Halfmoon framework.

## Tech Stack

- **Backend**: Spring Boot 3.5.5
- **Template Engine**: Thymeleaf
- **UI Framework**: Halfmoon v2.0.1 (Modern Dark Theme)
- **Java**: 17
- **Build Tool**: Maven

## Features

### Lab 1: Basic Controllers
- Hello page with dynamic content
- Login form with validation
- Rectangle calculator

### Lab 2: Advanced Controllers
- HTTP method testing
- Parameter handling
- Product management forms
- Product list with pagination

### Lab 4: Staff Management
- Staff creation form with file upload
- Form validation
- Multi-field form handling

## UI Design

The application uses **Halfmoon Framework** with modern-dark theme, providing:
- Professional dark mode interface
- Responsive design for mobile and desktop
- Clean, readable markup
- Consistent component styling

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6+

### Run the Application

```bash
# Using Maven wrapper
./mvnw spring-boot:run

# Or using Maven
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

### Build

```bash
# Build without tests
./mvnw clean package -DskipTests

# Build with tests
./mvnw clean verify
```

## Project Structure

```
src/main/
├── java/
│   └── poly/edu/
│       ├── controller/     # Spring MVC controllers
│       ├── bean/          # Data models
│       └── MainApp.java   # Application entry point
└── resources/
    ├── templates/         # Thymeleaf HTML templates
    │   ├── lab1/         # Lab 1 pages
    │   ├── lab2/         # Lab 2 pages
    │   └── lab4/         # Lab 4 pages
    ├── static/           # Static resources (empty)
    └── application.properties
```

## Documentation

- `HALFMOON_MIGRATION.md` - Complete guide on Halfmoon framework migration
- `MIGRATION_SUMMARY.md` - Detailed summary with before/after comparison

## Recent Changes

### UI Framework Migration
- Migrated from custom CSS to Halfmoon v2.0.1
- Removed 470 lines of custom CSS
- Applied modern dark theme
- Improved code maintainability and consistency

See `MIGRATION_SUMMARY.md` for complete details.

## Development

### Running in Development Mode
Spring Boot DevTools is included for automatic restart on code changes.

### Template Locations
All HTML templates are in `src/main/resources/templates/` with Thymeleaf syntax.

### Adding New Pages
1. Create controller method in appropriate controller class
2. Create HTML template in templates folder
3. Use Halfmoon components for consistent styling

## License

Educational project for SOF3022 course.

## Author

Dương Quang Thanh
