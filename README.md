#Introduction:
- This is an open-source testing framework that supports Behaviour Driven Development for automation testing of web application.
- The tests are written in a simple scenario form that describes the expected behaviour of the system from the user's perspective.

- The project structure includes some main layers:
  - First: the "core" folder contains common classes to use commonly like BasePage class to wrapper all actions of the framework cucumber.
  - Second: the "page" folder includes classes for each web page that contain locators and methods to interact with the page. 
  - Third: the "feature" folder store all cucumber feature files. These files contain Gherkin syntax that describes your scenario.
  - Fourth: the "stepDefinitions" folder define step definitions in Java classes. These classes contain code that corresponds to the steps defined in feature files.
  - Fifth: "Runner" class to execute Cucumber tests. This class specifies the location of your feature files and step definitions.
#Precondition: 
  - Make sure you had IntelliJ, Visual Studio Code,... and install maven and cucumber plugin on these tools
#Install
  - Step-1: Download source code and extra file
  - Step-2: Open the project by IntelliJ
  - Step-3: Checking Java, Selenium, Cucumber and TestNG in file pom.xml
  - Step-4: Right-click on the "pom.xml" file, select Maven and Reload project to be sure the libraries are installed
  - Step-5: To run test cases in project, you can click on "Run" button on the top right of IntelliJ. Alternatively, you can run the "Runner" file to do the same thing. If you want to run a specific scenario, you can put tag name of these scenarios and run "Runner" file, or you can run them in feature file one by one.
  - Step-6: After running, you can get the url of report in command and open it in browser to check report.