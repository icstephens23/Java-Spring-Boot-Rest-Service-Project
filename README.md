# Java Spring Boot Rest Service Project
 
Before trying to load up the project make sure you have java 8 installed.

When setting up this project in the IDE of your choice you have to build the project using the pom.xml file so all of the dependancies get installed into the project.

Then run the application. The main java file to run the application with is MessageRestAPIApplication.java
If you would like to run the application through command line the you will use this command:
    ./mvnw clean spring-boot:run

POST Message(Windows 10):
    curl -X POST -H "Content-type:application/json" -d "{\"id\":125, \"message\":\"HELLO\"}" -v http://localhost:8080/messages

GET All Messages(Windows 10):
    curl -X GET http://localhost:8080/messages

GET Message By ID(Windows 10):
    curl -X GET http://localhost:8080/messages/{id}

DELETE Message By ID(Windows 10):
    curl -X DELETE http://localhost:8080/messages/{id}

GET Total Word Count of Messages(Windows 10):
    curl -X GET http://localhost:8080/messages/count
