# library-management-bookstore-spring-boot-testing-and-aop
Author Testing AOP: Spring RESTful app implementing CRUD operations on 'author' entity. Features include data validation, DTO pattern, MapStruct for mapping, unit and integration tests, and AOP-based logging for enhanced functionality.


<h2>Introduction</h2>
This project is a simple RESTful application developed using Spring that includes CRUD operations for a single entity. The project also features validation for data entry, uses DTO pattern instead of exposing entities to the client, and performs dynamic and automatic mapping using MapStruct.
The purpose of this project is to demonstrate the implementation of a simple RESTful application with Spring, as well as the use of various features such as validation, DTO pattern, and MapStruct.

<h2>Features</h2>

<h3>CRUD Operations</h3>
This project includes CRUD operations for a single entity. The available HTTP methods are GET, POST, DELETE, PUT, and PATCH.

<h3>Validation</h3>
Data entry is validated during create and update operations.

<h3>DTO Pattern</h3>
The DTO pattern is used instead of exposing entities to the client. This provides an additional layer of abstraction and helps ensure the security of the system.

<h3>MapStruct</h3>
Dynamic and automatic mapping is performed using MapStruct, which eliminates the need for manual mapping.

<h3>Unit and Integration Testing</h3>
The project includes unit tests to test the methods of the Service class(es). The test scenarios are designed to be as rich as possible. Additionally, integration tests are included for Controller methods.

<h3>Logging</h3>
Each method in the Service class(es) logs a message before it is called with information about the input parameters. After each method is executed, a message is logged with information about the return value and the execution time.

<h2>Installation</h2>
To run this project, the following software is required:

Java 8 or higher
Maven
After installing the required software, perform the following steps:

Clone the repository: git clone https://github.com/fahminmahili/library-management-bookstore-spring-boot-testing-and-aop.git.
Navigate to the project directory: cd https://github.com/fahminmahili/library-management-bookstore-spring-boot-testing-and-aop.git.
Build the project: mvn clean package.
Run the project: java -jar target/author-testing-aop.jar

<h2>Conclusion</h2>
This project is a simple, yet comprehensive demonstration of a RESTful application developed using Spring. The features included, such as CRUD operations, validation, DTO pattern, MapStruct, and logging, demonstrate best practices for creating a secure and reliable system.

This is the YouTube Link to watch my Spring Boot Testing and AOP application:
https://www.youtube.com/watch?v=m50N0I7HGDY
