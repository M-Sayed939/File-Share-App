# File Sharing App

## Overview
The File Sharing App is a backend application built using Java Spring Boot that enables users to upload, download, and manage files efficiently. The application leverages modern backend technologies to provide a robust, secure, and scalable solution for file storage and sharing.

## Features
- **User Authentication and Authorization**: Secure user registration and login functionalities using Spring Security.
- **File Upload**: Users can upload files of various types and sizes.
- **File Download**: Users can download previously uploaded files.
- **File Management**: Users can view a list of their uploaded files and delete unwanted files.
- **Database Integration**: Persistent storage of user and file metadata using PostgreSQL.
- **API Documentation**: Comprehensive API documentation using Swagger for easy testing and integration.

## Technologies Used
- **Java 17**: The primary programming language for developing the application.
- **Spring Boot**: A framework to simplify the bootstrapping and development of new Spring applications.
  - **Spring Web**: For building RESTful web services.
  - **Spring Data JPA**: For data persistence and interaction with the PostgreSQL database.
  - **Spring Security**: For securing the application endpoints.
- **PostgreSQL**: The relational database management system for storing user and file metadata.
- **Maven**: The build automation tool used for project dependency management.
- **Lombok**: A Java library to reduce boilerplate code.

## Getting Started
### Prerequisites
- **Java 17** or higher
- **Maven** for build automation
- **PostgreSQL** database

### Installation
1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/file-sharing-app.git
   cd file-sharing-app
   ```

2. **Configure the database**:
   - Create a PostgreSQL database:
     ```sql
     CREATE DATABASE file_sharing_app;
     ```
   - Update the database configurations in `src/main/resources/application.properties`:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/file_sharing_app
     spring.datasource.username=yourusername
     spring.datasource.password=yourpassword
     spring.jpa.hibernate.ddl-auto=update
     ```

3. **Build and run the application**:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

### API Endpoints
- **User Registration**: `POST /register`
- **User Login**: `POST login`

## Usage
1. **Register a new user** via the registration endpoint.
2. **Login** with the registered credentials to obtain an authentication token.
   
## Contributing
Contributions are welcome! Please fork this repository and submit pull requests with improvements.


## Contact
For any inquiries or support, please contact [maze7.56r9@gmail.com](mailto:maze7.56r9@gmail.com).
