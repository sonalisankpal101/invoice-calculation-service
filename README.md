# invoice-calculation-service
------------------------------------------------------------------------------------------------------------------------------------------

Accepts the bill and calculates net amount based on discounts
Java 8 is needed to run this service.
IDE used is IntelliJ IDEA

Clone
-------------------------------------------------------------------------------------------------------------------------------------------

git clone https://github.com/sonalisankpal101/invoice-calculation-service.git

Running the application locally
-------------------------------------------------------------------------------------------------------------------------------------------

There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the com.supermarket.service.invoicecalculation.InvoiceCalculationApplication class from your IDE.

Download the zip or clone the Git repository.
Unzip the zip file (if you downloaded one)
Open Command Prompt and Change directory (cd) to folder containing pom.xml
Open IntelliJ
File -> New -> Project from existing sources -> Navigate to the folder where you unzipped the zip
Select the project -> create project from existing sources -> next -> finish
Choose the Spring Boot Application file (search for @SpringBootApplication)
Right Click on the file and Run as Java Application
Alternatively you can use the Spring Boot Maven plugin like so:

mvn spring-boot:run

Test Coverage 
-----------------------------------------------------------------------------------------------------------------------------------------------
Right click on project in IntelliJ IDEA select Run All test with coverage option

Documentation
------------------------------------------------------------------------------------------------------------------------------------------------------
Swagger - Documentation & TestingAccess

Access
---------------------------------------------------------------------------------------------------------------------------------------------
http://localhost:8080/swagger-ui.html
JSON Request:
{"inVoiceId":"123","items":[{"itemId":"1","itemName":" Oil","itemType":"NonGrocerry","itemPrice":20.0},{"itemId":"2","itemName":"Green Leaves","itemType":"Grocery","itemPrice":30.0}],"customer":{"customerId":"1","customerName":"Soanli","customerType":"Employee","dateOfRegistration":"28-08-2017"}}

Response:
-------------------------------------------------------------------------------------------------------------------------------------------------
36.0

