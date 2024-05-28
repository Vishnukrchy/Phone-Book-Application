# Phone Directory Application

## Description
The Phone Directory Application is a web-based tool for managing contacts. It allows users to register, log in, add, edit, delete, and view contacts. This project is implemented using Java and various web technologies.

## Table of Contents
- [Description](#description)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Setup Instructions](#setup-instructions)
- [Usage](#usage)
- [Database Schema](#database-schema)
- [Security and Authentication](#security-and-authentication)
- [License](#license)
- [Acknowledgments](#acknowledgments)

## Features
- **User Registration**: Allows new users to create an account.
- **User Login**: Users can log in with their email and password.
- **Add Contact**: Users can add new contacts to their directory.
- **View Contacts**: Users can view all their saved contacts.
- **Update Contact**: Users can update details of existing contacts.
- **Delete Contact**: Users can delete contacts from their directory.
- **Security and Authentication**: Secure password storage and session management.

## Technologies Used
- **Java**: The primary programming language used.
- **Jakarta Servlet**: For handling HTTP requests and responses.
- **JSP (JavaServer Pages)**: For rendering dynamic web content.
- **Bootstrap**: For styling the web pages.
- **JDBC (Java Database Connectivity)**: For connecting to the MySQL database.
- **MySQL**: The database used to store user and contact information.

## Project Structure
/src/main/java/com/jspider/phone
│
├── connection
│   └── PhoneConnection.java
│
├── controller
│   ├── Register.java
│   ├── LoginController.java
│   ├── DeleteController.java
│   ├── UpdateController.java
│   ├── LogoutController.java
│   └── AddContactController.java
│
├── dao
│   ├── UserDao.java
│   └── ContactDao.java
│
├── dto
│   ├── User.java
│   └── Contact.java
│
└── resources
    └── phonebook.sql

## Setup Instructions
1. **Set up MySQL Database**:
   - Create a database named `phonebook`.
   - Create the necessary tables using the following SQL script:
     ```sql
     CREATE TABLE user (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(255) NOT NULL,
       email VARCHAR(255) NOT NULL,
       password VARCHAR(255) NOT NULL
     );

     CREATE TABLE contact (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(255) NOT NULL,
       email VARCHAR(255) NOT NULL,
       phone VARCHAR(255) NOT NULL,
       about VARCHAR(255),
       userId INT,
       FOREIGN KEY (userId) REFERENCES user(id)
     );
     ```
2. **Configure Database Connection**:
   - Update the `PhoneConnection.java` file with your MySQL database username and password.
     ```java
     String url = "jdbc:mysql://localhost:3306/phonebook";
     String user = "root";
     String pass = "your_password";
     ```
3. **Deploy the Application**:
   - Use an IDE like Eclipse or IntelliJ IDEA to build and deploy the project.
   - Ensure your IDE supports servlet and JSP development.
   - Configure your server (e.g., Apache Tomcat) and deploy the project.
   - Access the application via `http://localhost:8080/your_project_name`.

## Usage
- **Register**: Go to the registration page and create a new account.
- **Login**: Log in with your registered email and password.
- **Add Contact**: Add new contacts through the add contact form.
- **View Contacts**: View all your contacts on the contacts page.
- **Update Contact**: Update contact details through the edit contact form.
- **Delete Contact**: Remove contacts through the delete option.

## Database Schema
The application uses two main tables: `user` and `contact`.

- `user` table:
  ```sql
  CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
  );
CREATE TABLE contact (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  phone VARCHAR(255) NOT NULL,
  about VARCHAR(255),
  userId INT,
  FOREIGN KEY (userId) REFERENCES user(id)
);

Security and Authentication
Password Encryption: Passwords are stored in the database in encrypted form for security purposes.
Session Management: Sessions are used to maintain user login state and manage authentication throughout the application.

Acknowledgments
Special thanks to the developers and contributors of the various libraries and frameworks used in this project.

Thanks to the open-source community for providing valuable resources and support.
Contact
For any questions or feedback, please contact vishnukrkamat@gmail.com
