package ROCLoginrunner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;




@CucumberOptions(glue = "TestCases/validate_login",
features = "src/test/resources/login_one.feature",
tags = "@SmokeTest", 
plugin ={"pretty", "junit:target/JUNITReports/report.xml", "html:target/cucumber", "json:target/JSONReports/report.json"},
monochrome=true)


public class CucumberRunnerTestslandlordlogin extends AbstractTestNGCucumberTests{
	
}