package Runner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/java/Features"},
        tags = {"~@Ignore"},
        format = {"pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json"},
        glue = "Steps")

public class TestRunner extends AbstractTestNGCucumberTests {


}
