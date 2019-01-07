# SmartboxCodingTask
Interview Coding Task

Used IDE:
IntelliJ IDEA Community Edition

Used Technology:
Java, Selenium Webdriver, TestNG, Cucumber

Used browser for testing:
Mozilla Firefox

Architecture:
- BaseUtil package: In this package I declared the basic often used variables.
- Features package: I created the .feature files for the two stories, written in BDD format.
- Runner package: The TestRuner.java is responsible for run the test.
- Steps package: Here are the .java files what are responsible for the each feature step.

Report file creation:
1. Run the test with the Runner.java
2. After the test run finishes the basic cucumber report appers under the target/cucumber-reports/cucumber-pretty folder.
   It shows only the success or failed Scenarios.

Additional information:
In some point the specification and the actual working of the website didn't meet, so I used Ignore annotations for those Tests, 
because these tests would be false positive.

...
