package Testcases_original;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;


import org.testng.annotations.Test;

import Basetest.TestBase_original;
import Basetest.TestBase_original_new;
import Pages_original.LoginPage_original;
import Pages_original.LoginPage_original_new;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class validate_login_original_newclass extends TestBase_original{

	//static WebDriver driver;
	/*
	 * @BeforeMethod public static WebElement before_method() throws IOException {
	 * System.out.println("This method will be invoked before every test method");
	 * base_url bum= new base_url(); WebDriver driver=bum.Base_url(); return
	 * (WebElement) driver; }
	 * 
	 * 
	 */ 
	
	@BeforeClass
	@Given("User is on ROCLogin page On DEV")
	public void launchBrowser() throws IOException {
		
		TestBase_original tbase= new TestBase_original();
    	tbase.Base_url();
		}
@Test
   @When("User enters username as {string} and password as {string} on DEV")
   public void Validate(String loginuser2, String loginpassword2) throws Exception {
		
    	LoginPage_original_new log1= new LoginPage_original_new(driver);	
    	log1.Loginpageforlandlord(loginuser2,loginpassword2);
	    log1.DashboardLandlordROC();
			}
@AfterClass
@Then("User should be able to login sucessfully to landlord and new Homepage open ON DEV")
public void Closebrowser()  {
	//Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
	
//Assert.assertFalse(true);
	

	driver.quit();
	
}



}



	
	
	
	