package TestCases;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import Base.TestBase;

import Pages.LoginPage;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


//@Listeners(TestExecutionListener.class)
public class validate_login extends TestBase {

	//static WebDriver driver;
	/*
	 * @BeforeMethod public static WebElement before_method() throws IOException {
	 * System.out.println("This method will be invoked before every test method");
	 * base_url bum= new base_url(); WebDriver driver=bum.Base_url(); return
	 * (WebElement) driver; }
	 * 
	 * 
	 */ 
	
	@BeforeTest
	public void launchBrowser() throws IOException {
		
		TestBase tbase= new TestBase();
    	tbase.Base_url();
		
	}
	
	
   @Test(description="This is login validate")
   @Description("This is login test validation")
   @Severity(SeverityLevel.NORMAL)
   @Story("THis is logintest")
   @Feature("validate login")
   
	public void Validate() throws IOException {
		
		
		// TODO Auto-generated method stub
		
	//login log=new login();
	//log.Loginpageforlandlord(driver);
	//log.DashboardLandlordROC(driver);
    	
    	//before_method();
    	
    	
	   
    	LoginPage log= new LoginPage(driver);	
    	
    	
    	
	
	log.Loginpageforlandlord();
	//driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/form/div[2]/button")).click();
	  
	log.DashboardLandlordROC();
	Allure.step("this is prithvi");
	
		

	}


@AfterTest
public void Closebrowser()  {
	//Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
	
//Assert.assertFalse(true);
	
	//driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/form/div[2]/button")).click();
	
	Allure.addAttachment("Any text", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
	driver.quit();
	
}



}



	
	
	
	