package Testcases_original;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;


import org.testng.annotations.Test;

import Basetest.TestBase_original;
import Pages_original.LoginPage_original;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class validate_login_original extends TestBase_original {

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
	@Given("User is on ROCLogin page")
	public void launchBrowser() throws IOException {
		
		TestBase_original tbase= new TestBase_original();
    	tbase.Base_url();
		}
@Test
   @When("User enters username as {string} and password as {string}")
   public void Validate(String username1, String password1) throws Exception {
		
	LoginPage_original log= new LoginPage_original(driver);	
	log.Loginpageforlandlord(username1,password1);
	log.DashboardLandlordROC();
			}
@AfterClass
@Then("User should be able to login sucessfully to landlord and new Homepage open")
public void Closebrowser()  {
	//Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
	
//Assert.assertFalse(true);
	

	driver.quit();
	
}



}



	
	
	
	