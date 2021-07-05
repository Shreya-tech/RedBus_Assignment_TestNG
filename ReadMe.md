# RebBus Automation Project
This is a TestNG Based Project to Automate Redbus Website.
By Shreya Saxena

## Git Repository Link
```
https://github.com/Shreya-tech/RedBus_Assignment_TestNG.git

```

## Pre-requisites
* TestNG 
* Java
* Selenium
* Maven
* Docker
* Jenkins


## Project Structure

##### Location: src > main > java
* **Base package** - Connections and DockerClass
* **Pages package** - BusSeatPage, HomePage, NavbarPage,RedBusCarePage and SearchPage
* **Utils package** - ConfigReader, ExcelReader and Screenshots

##### Location: src > main > resources
* Log property file

##### Location: src > test > java
* **Base package** - BaseTest, BusSeatTest, NavbarTeat,RedBusCareTest and SearchTest
* **Utils package** - CommonFunctions

##### Location: src > test > resource
* **Drivers Folder** - Contains all browser drivers
* **ExcelFile Folder** - Contains Excel File for TestData
* **Properties Folder** - Contains config.properties file


## Dependencies
* TestNG 
* Selenium
* Log4j


## To Run Project:

##### Maven run: 
* Right click on project and click on run as Maven build and put goal as clean install

##### cmd run: 
* Click on runner bat file 
* Or open cmd at project location and type:  `mvn clean install` 

##### TestNG run: 
* Open TestNG.xml file, then right click on the file then run as TestNG Suite

**Note**: All the Test data is stored in the excel file where you can change data as per need. Also it contains Executable options that means.. if you want to run keep in execution while running test type yes to keep else type no to remove from the test run.


## To run Project in Headless mode or change the Browser type:
* Open config.properties file at location Location: src > test > resources
* And follow the comments in the file to change as per your need.


## To Project On Docker:

- **STEP 1:** Open config.properties file at location Location: src > test > resources
- **STEP 2:** Change the Docker mode to yes
- **STEP 3:** Then open cmd on the project location and type `docker-compose up -d`
- **STEP 4:** Then run the Bat File to run on docker or open cmd and type  `mvn clean install`  to run on docker.


## To run Project in Parallel mode:
* Open testng.xml file
* And type `parallel = "classes"` in suite tag in testng.xml file


## Jenkins Integration:
Steps of implementation jenkins is on word file named : jenkens-implementation

