package Pages_original;





import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import Basetest.TestBase_original;





public class LoginPage_original_report extends TestBase_original{
	
	
	//WebDriver driver;
	public static final long TIMEOUT = 2000;
	 
	
	  
	 
	 
	 
	 @FindBy(xpath="//input[@name='email']")
		WebElement username;

		@FindBy(xpath = "//button[contains(text(),'Login')]")
		WebElement loginButton;

		@FindBy(xpath = "//input[@name='password']")
		WebElement password;

		@FindBy(xpath = "//button[contains(text(),'Login')]")
		WebElement enterbutton;

		@FindBy(xpath = "//h2[contains(text(),'Home')]")
		WebElement homepagename;
		
		public LoginPage_original_report(WebDriver driver) {
			LoginPage_original_report.driver = driver;
			  PageFactory.initElements(driver, this);
		  
		  }
		
		
		
		public void Loginpageforlandlord(String username1, String password1) throws Exception {
			
			
			 
			

			 
			//driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/div/div[2]/form/div[1]/input")).sendKeys("prithwiraj011981@mailinator.com");
			  
			username.sendKeys(username1);
			
			Thread.sleep(TIMEOUT);
			  
			  //driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/div/div[2]/form/div[2]/button")).
			  //click();
			  loginButton.click();
			  
			  
			  
			  Thread.sleep(TIMEOUT);
			  //driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/div/div/form/div[2]/input")).sendKeys("Mylogin@123");
			  
			  password.sendKeys(password1);
			  Thread.sleep(TIMEOUT);
			 // driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/div/div/form/div[4]/button")).click();
			 // Write code here that turns the phrase above into concrete actions
			  enterbutton.click();
			  System.out.println("5");
			// TODO Auto-generated constructor stub
		}

		
		public String DashboardLandlordROC() throws Exception {
			
			String homePageHeading = homepagename.getText();
			
		
			 
			// Soft
			//Assert.assertEquals(homePageHeading,"Home");
			//SoftAssertions softAssert = new SoftAssertions();
			//softAssert.assertTrue(false, "Assertion 3 failed");
			//softAssert.assertAll();
			//Assert.assertTrue(false);
		    // Write code here that turns the phrase above into concrete actions
			
			System.out.println("User has successfully logged in");
			return homePageHeading;
		}


	

		
	
}
