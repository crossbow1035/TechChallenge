# Tech Challenge

This repository answers the proposed tech challenge. There are two main folders: PetStoreTests for exercise 1 regarding REST API Automation, and OnlineStore for
exercise 2 for Web FE Automation.

## How to set up the environment

### PetStoreTests has been implemented with Postman and Newman. Set up:

1. Install and open Postman. Create an account and/or a workspace if needed.
2. Import JSON files: Pet Store Tests.postman_collection.json and Pet Store Environment.postman_environment.json.
3. Select Pet Store as environment.

Newman set up:

1. Install Node js.
2. Install Newman with: 
`npm install -g newman`
3. Install Newman HTML report: 
`npm install -g newman-reporter-htmlextra`

### OnlineStore has been implemented with Java, Selenium WebDriver, and Netbeans. Set up with Netbeans:

1. Be sure of having JDK 14 installed and set up PATH and CLASSPATH environment variables.
2. Install and open Apache Netbeans IDE 12.5.
3. Download Firefox browser and driver via https://github.com/mozilla/geckodriver/releases

## How to use

### To run PetStoreTests:

1. Open Runner in Postman.
2. Drag the collection folder and click on run.

If you want to review the test scripts, open each request and go to Test tab.

You also can run the tests with Newman:

1. Execute collection with the script: 
`newman run Pet Store Tests.postman_collection.json -e Pet Store Environment.postman_environment.json -r htmlextra`

2. The results will be available in an HTML report in a folder called newman. To see the HTML report already generated go to https://htmlpreview.github.io/?https://github.com/crossbow1035/TechChallenge/blob/master/PetStoreTests/newman/Pet%20Store%20Tests-2022-11-29-09-11-10-278-0.html 


### To run OnlineStore tests:

1. Open Apache Netbeans IDE 12.5. 
2. Open the project OnlineStore by downloading from GitHub or cloning the repository.
3. Go to project view, right-click on "OnlineStore.java" and click on Test File to compile and run the tests.

## Comments
### REST API AUTOMATION:

- It's organised in 4 folders, one for each scenario, with one or two requests according to the required use case. 
At the beginning, there is one environment variable for the url, but once the "New Pet" request is executed, 4 more environment variables are created to use in the next requests.
- Each request has tests with a Gherkin description and several checks. For instance, in the AvailablePetsByStatus call, the test validates the status and all the pets have all the properties with a FOR loop that validate all the objects of the array.
- Next folders have two calls, the POST, PUT and DELETE calls and a GET, which can be useful to check the result of the previous call was saved properly in a database.

### WEB FRONT-END AUTOMATION:

- It is implemented as a sort of E2E test, a script for all test requirements and checks, specified in comments with Gherkins. 
- As a test made with JUnit, it has different annotations: **@Before** used to instance the Firefox driver before each test, **@After** used to close the Firefox driver after each test, and **@Test** to develop all the tests. 
- Web elements are captured using different ways in order to ensure taking the correct one; by id, by linked text, by class name or even implementing FOR or IF structures,  
as in the deletion of an item of the cart.


