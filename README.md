# springboot-hibernate-crud
This repo is build to perform employee CRUD operations and custome exception using springboot-JPA-Hibernate and MySQL

To create schema in MySQL run below command:
  create database ems;
  
Manual Table creation inside schema is not required as "spring.jpa.hibernate.ddl-auto=update" proeprty is set in application.properties file.

Below are the endpoints to test:

1. Saving Employee (Method = Post):

    http://localhost:8080/api/employee/
  
  Body:
    {
    "firstName": "Divyanshu",
    "lastName": "Pandey",
    "email": "dvy@xyz.com"
    }


2. Get All Employees (Method = Get):

    http://localhost:8080/api/employee/
    
3. Get Employee by Id (Method = Get):

    http://localhost:8080/api/employee/1
    
4. Update employee by employee ID (Method = Put):

    http://localhost:8080/api/employee/1
    
     Body:
    {
    "firstName": "Divyanshu2",
    "lastName": "Pandey2",
    "email": "dvy2@xyz.com"
    }
    
5. Delete employee by employee ID (Method = Delete):

    http://localhost:8080/api/employee/1
