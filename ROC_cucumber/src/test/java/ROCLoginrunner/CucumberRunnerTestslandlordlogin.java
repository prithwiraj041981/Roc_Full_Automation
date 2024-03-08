package ROCLoginrunner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;




@CucumberOptions(glue = "TestCases/validate_login",
features = "src/test/resources/roc.feature",
tags = "@SmokeTest", 
plugin ={"pretty", "junit:target/JUNITReports/report.xml", "html:target/HTMLReportsone/index.html", "json:target/JSONReports/report.json"},
monochrome=true)


public class CucumberRunnerTestslandlordlogin extends AbstractTestNGCucumberTests{
	
}