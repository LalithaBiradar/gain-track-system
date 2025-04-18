
# GymTrack Pro - Gym Management System

A complete JavaFX-based gym management system with dedicated dashboards for administrators, members, and trainers.

## Features

### Admin Dashboard
- Member management
- Trainer management
- Payment tracking
- Membership plans
- Reports and analytics
- System settings

### Member Dashboard
- View profile and membership details
- Track workout progress
- Access workout plans
- View payment history
- Schedule sessions with trainers

### Trainer Dashboard
- Manage client list
- Create workout plans
- Track client progress
- Manage schedule
- View earnings

## Database Schema

The system is designed to work with the following database tables:

```
+-------------------+
| Tables_in_gymdb   |
+-------------------+
| members           |
| payments          |
| progress          |
| progress_tracking |
| trainers          |
| users             |
| workout_plans     |
+-------------------+
```

## Demo Credentials

For testing purposes, use the following credentials:

- **Admin**: Username: `admin`, Password: `admin123`
- **Member**: Username: `member1`, Password: `member123`
- **Trainer**: Username: `trainer1`, Password: `trainer123`

## Getting Started

1. Clone the repository
2. Open in your favorite Java IDE (IntelliJ IDEA, Eclipse, etc.)
3. Ensure you have JavaFX SDK installed
4. Configure the database in `DatabaseConnector.java` if connecting to a real database
5. Run the Main.java file

## Technologies Used

- JavaFX for UI
- CSS for styling
- FXML for layout design
- Java for backend logic
- MySQL for database (optional)

## Project Structure

- `src/main/java/com/gymmanagement/` - Java source files
  - `controllers/` - FXML Controllers
  - `models/` - Data models
  - `dao/` - Data Access Objects
  - `utils/` - Utility classes
- `src/main/resources/` - Resources
  - `fxml/` - FXML layout files
  - `css/` - CSS style sheets
  - `images/` - Image resources

## Screenshots

*[Screenshots would be included here once the application is running]*
