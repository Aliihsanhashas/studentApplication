# studentApplication
In this project, we created and dockerized a student CRUD (Create, Read, Update, Delete) application using Java, Spring Boot, PostgreSQL and Docker.  

# Raising the Project
You can get the project up and running by running these commands.

1. git clone <https://github.com/Aliihsanhashas/studentApplication.git> 
2. cd <studentApplication> 
3. docker-compose up

This way, you can pull the project from github and review it.
-------------------------------------------------------------

# You can build the image, pull the postgresql image and run docker.

1. docker build -t my -spring-app .
2. docker pull postgres # version latest
3. docker run -p 8080 : 8080  my -spring-app

---------------------------------------------------------------

If you want to see detailed step-by-step instructions on how to run the project and API tests, you can review the article I wrote about the project.

English:

https://medium.com/@aliihsanhashas1/student-registration-application-with-spring-boot-postgresql-and-docker-582bda7f1dd8

------------------------------------------------------
Turkish:

https://medium.com/@aliihsanhashas1/java-spri̇ng-boot-student-crud-application-3ca2fe53282b




