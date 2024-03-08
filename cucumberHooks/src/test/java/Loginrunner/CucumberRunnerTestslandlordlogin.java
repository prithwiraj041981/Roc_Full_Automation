package Loginrunner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;




@CucumberOptions(
features = "classpath:feature",
glue = "Testcases_original",
tags = "@SmokeTest",
plugin ={"pretty", "html:target//Reports//Roc-reports.html"},
monochrome=true)


public class CucumberRunnerTestslandlordlogin extends AbstractTestNGCucumberTests{
	
}