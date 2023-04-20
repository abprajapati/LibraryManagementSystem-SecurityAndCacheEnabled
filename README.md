# SecurityAndCacheEnabledLibraryManagementSystem
# Project Overview
This project is an extension of LibraryManagementUsingSpringBoot. It is an end-to-end Java RESTful Web Service Application. Spring Security, Caching(Redis Cache), and persistent storage are used to make a system more secure, have data consistency, have low data access latency, increased throughput, and ease the load off relation database and application. Every user who accesses any RESTful API must be authenticated and authorized by Spring Security, accept sing up API.
# Used Skills, Technologies and Tools in Developing this Application
1) Java 
2) IntelliJ
3) Maven
4) Spring Boot
5) RESTful API
6) MVC
7) Dependency Injection
8) Inversion of Control
9) Postman(API Testing)
10) JDBC
11) JPA
12) Hibernate(ORM)
13) MySQL(Persistant Storage)
14) Spring Security
15) Redis Caching

# Functioning of Application
There are five entity in this project: Student, User, Book, Author, Transaction. 
REST APIs for Student Functionality:
1) @PostMapping("/student")
2) @GetMapping("/student")
3) @GetMapping("/student_for_admin")

If the Student/User is new in the system then the account should be created using username and password via @PostMapping("/student"). This API will create both User and Student. Well, existing user can see their details upon authentication and authorization via @GetMapping("/student"). Whereas the admin can access any student he/she wants using @GetMapping("/student_for_admin").

REST APIs for Book Functionality:
1) @PostMapping("/book")
2) @GetMapping("/books/search")

A new book can be added to the system by admin via @PostMapping("/book") and the Author will be mapped while creating the book creation only. And the book can be searched by authorized and authenticated users or admin via @GetMapping("/books/search").

REST APIs for Transaction Functionality:
1) @PostMapping("/transaction/issue")
2) @PostMapping("/transaction/return")

A student can issue a book via  @PostMapping("/transaction/issue") and will get transactionId if the issue of the book is successful. Students can return a book via @PostMapping("/transaction/return") API and the student will be charged with a fine if the book is returned late.



