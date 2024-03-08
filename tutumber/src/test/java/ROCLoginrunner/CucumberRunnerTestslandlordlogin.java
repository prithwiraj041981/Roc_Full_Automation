package ROCLoginrunner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;




@CucumberOptions(glue = "TestCases/validate_login",
features = "src/test/resources/roc.feature",
tags = "@SmokeTest", 
plugin ={"pretty", "html:target//cucu//cucumber-reports.html"},
monochrome=true)


public class CucumberRunnerTestslandlordlogin extends AbstractTestNGCucumberTests{
	
}