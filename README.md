# Discovery Service with Eureka Server and Reactive Webclient, R2DBC

### This project is to demonstrate some of the new Spring features listed below:
* [Service Discovery](https://spring.io/guides/gs/service-registration-and-discovery/) using Eureka Server and Spring Cloud **Discovery Client**
* Spring's reactive [Webclient](https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html#webflux-client)
* Spring's [R2DBC](https://docs.spring.io/spring-data/r2dbc/docs/1.1.0.M4/reference/html/#get-started:first-steps:what)

There are total **4** Spring Boot individual projects attached. 

**Note:** These are separate and not multimodule projects.

## Project Import
Import each of the four folders as individual projects into your respective **IDE's**

## Postman API Collection
Import the **apis.json** collection into your postman. The usages of API's are mentioned below.

## Initial Setup before running the projects
1. Make sure to have **Java 11** installed since all the projects use the same. If you want to change the java version, then change it inside all the **pom.xml** of the individual projects and rebuild the projects.
2. The projects **user-service** and **reactive-movie-service** have **schema.sql** inside their resource folder. Run the script files in your **MYSQL database** to create respective schema's, tables and sample data for api testing.
3. Modify the **application.yml** according to your **MYSQL username and password** as well as the** port no**
4. *(Optional step):* In case if there are any error's in starting some of the projects using **Java 11** , add the jaxb dependencies which can be found in **user-service** project's **pom.xml**. 

## Steps to testing the projects
* After importing the projects in your IDE and proper build of the projects,
start the individual projects in the following order:
1. **eureka-server**
2. **user-service**
3. **reactive-movie-service**
4. **reactive-consumer**

* Next, you can head over to the **Eureka Dashboard** at http://localhost:8761/ to check the services registered with eureka in the **Instances currently registered with Eureka** section. If you want to play around, you can create two instances of the same service by creating a jar file using ```maven clean install``` command and run the jar file with port no other than **8081, 8082, 8083, 8761** by specifying an additional arguement ```-Dserver.port=portNo```. You will find the instance count increased for the given dashboard. Currently this project uses ```DiscoveryClient``` and java stream's ```findAny()``` method to select the instance, although in reality this is done by Spring Cloud Gateway but that will be for another project.

* Now to check if api's of the individual microservices are working properly as expected. Please make sure the above mentioned sql scripts have run properly and you have the MYSQL database running. Also, there are sample responses present for all the API's in the postman collection.
  1. Hit the *Get User Data By Id from microservice* API inside the **user-service** folder of postman collection from Postman. It should an object of user with some user details.
  2. Hit the *Get movies from id's from microservice* API inside the **movie-service** folder of postman collection from Postman. It should a list of objects containing movie details.
  3. If the above api's are working properly, that means the micro services are working properly as expected and we can proceed to test service discovery.
  4. Now hit the *Get movies from id's using service discovery* inside the **reactive-consumer** folder of postman collection and you should get the same result as *step 2*.
  5. Hit the *Get user details by id using service discovery* inside the **reactive-consumer** folder of postman collection and you should get the same result as *step 1*.

And there you go! You have tested the *service discovery* through **Eureka** server.
Feel free to play around with the project by adding more data to the tables or creating more instances of the **user-service** and **reactive-movie-service** to see the DiscoveryClient in action. Also do go through the source code of the Repositories demonstrating the **R2DBC** with **MYSQL** as well as the *Service classes* of **reactive-consumer** for usage of Spring's fully reactive **Webclient** as well as **DiscoveryClient**!