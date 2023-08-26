# SpringBootAssessment
This project is built using 
    * Java 11
    * Gradle
    * SpringBoot 2.7.15
    * h2 embedded database

# Application is accessible on port _**8090**_
# Swagger is accessible at URL localhost:8090/swagger-ui.html 
# H2 is accessible at URL localhost:8090/h2-console

# H2 embedded database prepopulates the below data when application is started.
INSERT INTO TASK (id,title,description,completed) VALUES (1,'JavaQuiz','Exam containing Java Questions',true);
INSERT INTO TASK (id,title,description,completed) VALUES (2,'PythonQuiz','Exam containing Python Questions',false);
INSERT INTO TASK (id,title,description,completed) VALUES (3,'JavaScriptQuiz','Exam containing JavaScript Questions',false);
INSERT INTO TASK (id,title,description,completed) VALUES (4,'CollectionsQuiz','Exam containing Java Collections Questions',true);

# H2 configuration
spring.h2.console.path=/h2-console
spring.datasource.url=jdbc:h2:mem:taskdb 
spring.datasource.username=admin
spring.datasource.password=
