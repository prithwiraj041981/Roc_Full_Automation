package Testcases_original;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Basetest.TestBase_original;
import Pages_original.LoginPage_original_report;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class validate_ScreenshotHooks extends TestBase_original {
	public static final long TIMEOUTd = 2000;
	@BeforeClass
	@Given("User is on ROCLogin page")
	public void launchBrowser() throws IOException {
		
		TestBase_original tbase= new TestBase_original();
    	tbase.Base_url();
		}
@Test
   @When("User enters username as {string} and password as {string}")
   public void Validate(String username1, String password1) throws Exception {
		
	LoginPage_original_report loguser= new LoginPage_original_report(driver);
	Thread.sleep(TIMEOUTd);
	loguser.Loginpageforlandlord(username1,password1);
	Thread.sleep(TIMEOUTd);
	String hometext=loguser.DashboardLandlordROC();
	SoftAssert softAssert = new SoftAssert();
	softAssert.assertTrue(hometext.equals("welcomeeee"), "Third soft assert failed");
	softAssert.assertAll();
	
			}

@After
@Then("User should be able to login sucessfully to landlord and new Homepage open")
public void takeScreenshot(Scenario scenario) {
	System.out.println("Scenerio name=="+scenario.getName());
	if (scenario.isFailed()) {
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "FailureScreenshot");
    }
	
	/*this one passed*/
	/*if (scenario.isFailed()) {
        try {
            // Capture screenshot
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Define the screenshot destination directory
            String screenshotDirectory = "C:\\ROC\\reportcucumber\\screenshotname\\";

            // Generate a unique file name using timestamp
            String screenshotFileName = generateScreenshotFileName();

            // Define the full path of the screenshot file
            String screenshotFilePath = screenshotDirectory + screenshotFileName;

            // Copy the screenshot file to the destination directory
            Files.copy(screenshotFile.toPath(), new File(screenshotFilePath).toPath(), StandardCopyOption.REPLACE_EXISTING);

            // Print the file path in the console for reference
            System.out.println("Screenshot saved: " + screenshotFilePath);
            
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    */
}

/*public void takeScreenshot(Scenario scenario) {
	
	driver.quit();
        if (scenario.isFailed()) {
            try {
                // Capture screenshot
                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                // Define the screenshot destination directory
                String screenshotDirectory = "C:\\ROC\\reportcucumber\\screenshotname";

                // Generate a unique file name using timestamp
                String screenshotFileName = generateScreenshotFileName();

                // Define the full path of the screenshot file
                String screenshotFilePath = screenshotDirectory + screenshotFileName;

                // Copy the screenshot file to the destination directory
                Files.copy(screenshotFile.toPath(), new File(screenshotFilePath).toPath(), StandardCopyOption.REPLACE_EXISTING);

                // Print the file path in the console for reference
                System.out.println("Screenshot saved: " + screenshotFilePath);
                driver.quit();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    

       
	
}*/
private String generateScreenshotFileName() {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
    return now.format(formatter) + ".png";
}

}
