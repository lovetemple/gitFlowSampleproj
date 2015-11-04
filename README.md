# MedibankInterviewBDDTest


Hi Liz and David,

I have come up with a POC/ basic framework using Java , BDD ( cucumber jvm), Web Driver, Maven etc using the most standard design pattern ( page objects - page factory) for implementing the tests.

I have spent just under 2 hours to get this basic shell working. I have chosen a basic feature of your website ….checking if the products and packages are displayed on the home page.



My code package structure goes like this:

I have 3 main folders or packages under the src. 

1 Page objects package ( page factory modelled pages)

2 Tests( step def)  package that has the all implementation of the feature / scenarios.

3 Resource - Feature package ( with cucumber feature files)

4 Generic Resource package which has config, utilities methods etc

5 A few config files for 

4 if necessary a Data package with Data objects that contain data for a particular page object or a group based on the need. 

Every Test uses the BaseTest which has common functions or methods to initiate browser  and other common activities. Every Test instantiate's one or multiple relevant Page object’s for its actions and operations. Every Page object extends a generic Page objects which further has all the most widely used driver operations like clicks and checks etc. The whole test model is around this.



The Features can be run from a simple Cuke Runner class using junit runner or run via Maven using Maven with ‘Test’ as its goal.

 I have not implemented every step of the feature…but to give you a high level understanding of how i have used cucumber and Appium for automating Me Bank mobile App on real devices. For reporting i have simply used html and json format reports and not included any fancy reports like Allure, Extent Report etc. 

The runs can be customised across target browsers using config file in the project. I could use soft assertions to collect errors using (ErrorCollector) and fail at the end..but for this test sake as i'm not implementing the full framework, i have chosen to use hard assertions. I have demonstrated Scenario Outline for parameterised test and data table for step feeds.



Hope this is good for an understanding of my experience in using BDD framework. I have uploaded the project onto github and kindly clone and  please let me know your feedback.
