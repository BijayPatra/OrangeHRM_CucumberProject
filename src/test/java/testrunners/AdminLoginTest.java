
package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features ={"featurefiles/adminlogin.feature"},
					glue = "stepdefinations",
					dryRun=false,
					plugin = {"pretty","html:testreports/loginresult.html"})

//Its also called as Runner Class
public class AdminLoginTest extends AbstractTestNGCucumberTests
{

}
