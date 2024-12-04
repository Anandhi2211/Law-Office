Law Firm Management System
Description
The Law Firm Management System is a robust application designed to manage and streamline operations in a law firm. It leverages core Java concepts and a range of advanced technologies to implement CRUD operations for attorneys, clients, and cases. The system includes efficient database design with normalized tables, ensuring optimal performance and data integrity.

CRUD Operations:
Add, update, delete, and retrieve attorney and client details.
Identify attorneys handling specific cases.
Database Normalization:

Designed and implemented normalized MySQL tables with primary and foreign key constraints.
Advanced Parsing and Serialization:

JAXB for adding law firm details to the database.
Jackson for inserting client details.
DOM Parser for retrieving law firm details.
Connection Pooling:

Efficient database management with JDBC connection pooling.
Logging:

Monitored system behavior using loggers for debugging and performance tracking.
Technologies Used
Programming Language: Core Java

Frameworks/Patterns: DAO Design Pattern

Libraries/Tools:

Java Streams and Collections
JDBC Connection Pool
MyBatis
Loggers
JAXB (Java Architecture for XML Binding)
Jackson (JSON Parsing and Mapping)
DOM Parser
Database: MySQL

Database Design
The database schema includes multiple tables for attorneys, clients, and cases with relationships established via primary and foreign keys.

Ensured normalization to reduce redundancy and improve data consistency.
Supported CRUD operations such as:
Retrieve attorney details
Find cases handled by a specific attorney
Update attorney records
Delete records as necessary
