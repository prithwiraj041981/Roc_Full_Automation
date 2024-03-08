package Testcases;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;


import org.testng.annotations.Test;

import Base.TestBase;

import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




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
	
	@BeforeClass
	@Given("User is on ROCLogin page")
	public void launchBrowser() throws IOException {
		
		TestBase tbase= new TestBase();
    	tbase.Base_url();
		}
@Test
   @When("User enters username as {string} and password as {string}")
   public void Validate(String username1, String password1) throws Exception {
		
    	LoginPage log= new LoginPage(driver);	
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



	
	
	
	