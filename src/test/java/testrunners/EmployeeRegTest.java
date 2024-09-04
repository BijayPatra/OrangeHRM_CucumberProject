package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"featurefiles/employee.feature"},
						glue = "stepdefinations",
						dryRun=false,
						plugin = {"pretty","html:testreports/addempregresult.html"})

public class EmployeeRegTest extends AbstractTestNGCucumberTests
{

}
