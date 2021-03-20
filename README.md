# Karkinos-Patient

This project was generated with JDK 1.8, Maven 4, SpringBoot 2.2.7 release (Take this as parent version), ThymeLeaf, H2 database

## Development Server

Choose the Spring Boot Application file (search for @SpringBootApplication),right Click on the file and Run as Java Application

The entry point address of the backend API is at http://localhost:8080/

# Local Setup Steps

## For building and running the application you need:

## Database
It uses a H2 in memory database (for now), can be changed easily in the application.properties for any other database.

## H2 Console
URL to access H2 console: http://localhost:8080/h2-console/login.jsp or https://192.168.99.102:8080/h2-console/login.jsp if SSL is enabled.

Fill the login form as follows and click on Connect:

Driver class: org.h2.Driver
JDBC URL: jdbc:h2:mem:patientdb
User Name: sa
Password:

## Running the application locally
There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the com.karkinos.PatientApplication class from your IDE.

Alternatively you can use the Spring Boot Maven plugin like so:

mvn spring-boot:run
Running the application with IDE
There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the com.karkinos.PatientApplication class from your IDE.

Download the zip or clone the Git repository.
Unzip the zip file (if you downloaded one)
Open Command Prompt and Change directory (cd) to folder containing pom.xml
Open Eclipse
File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
Select the project
Choose the Spring Boot Application file (search for @SpringBootApplication)
Right Click on the file and Run as Java Application



