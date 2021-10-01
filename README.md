# ANZ_Automation
Read Me:

@To run the Test cases
-> Right Click on the Repository and click Maven->Update Project.(to refresh)
-> Navigate to path src\test\java\runners\ANZTestRunner.java
-> Select one of the tags to run (@Borrow-estimate-check or @estimate-message-check)
-> Provide the tag name in ANZTestRunner.java under cucumberOptions
   E.g tags = "@Borrow-estimate-check"
-> Right click on the mouse and Run as Testng runner or click ctrl+F11 to start the runner


@To access the reports
-> Once the Test run is completed, Right Click on the Repository and click refresh
-> Navigate to Practise_Cucumber\target\cucumber-reports\advanced-reports\extentreports\extent.html
-> Open extent.html on browser
-> For Cucumber reports navigate to
   Practise_Cucumber\target\cucumber-html-report\cucumber.html
-> Open cucumber.html on browser
