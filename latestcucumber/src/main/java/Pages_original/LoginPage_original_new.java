package Pages_original;





import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import Basetest.TestBase_original;
import Basetest.TestBase_original_new;




public class LoginPage_original_new extends TestBase_original{
	
	
	//WebDriver driver;
	 public static final long TIMEOUT = 2000;
	 
		
		  
		 
	 
	 
	 @FindBy(xpath="//input[@name='email']")
		WebElement usernamebutton;

		@FindBy(xpath = "//button[contains(text(),'Login')]")
		WebElement loginButton;

		@FindBy(xpath = "//input[@name='password']")
		WebElement password;

		@FindBy(xpath = "//button[contains(text(),'Login')]")
		WebElement enterbutton;

		@FindBy(xpath = "//h2[contains(text(),'Home')]")
		WebElement homepagename;
		
		public LoginPage_original_new(WebDriver driver) {
			LoginPage_original_new.driver = driver;
			  PageFactory.initElements(driver, this);
		  
		  }
		
		
		
		public void Loginpageforlandlord(String loginuser2, String loginpassword2) throws Exception {
			
			
			 
			

			 
			//driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/div/div[2]/form/div[1]/input")).sendKeys("prithwiraj011981@mailinator.com");
			  
			usernamebutton.sendKeys(loginuser2);
			
			Thread.sleep(TIMEOUT);
			  
			  //driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/div/div[2]/form/div[2]/button")).
			  //click();
			  loginButton.click();
			  
			  
			  
			  Thread.sleep(TIMEOUT);
			  //driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/div/div/form/div[2]/input")).sendKeys("Mylogin@123");
			  
			  password.sendKeys(loginpassword2);
			  Thread.sleep(TIMEOUT);
			 // driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/div/div/form/div[4]/button")).click();
			 // Write code here that turns the phrase above into concrete actions
			  enterbutton.click();
			 
			// TODO Auto-generated constructor stub
		}

		
		public void DashboardLandlordROC() throws Exception {
			
			Thread.sleep(TIMEOUT);
			
			
			String homePageHeading = homepagename.getText();
			Thread.sleep(TIMEOUT);
		
			 
			 
			Assert.assertEquals(homePageHeading,"Home");
			//Assert.assertTrue(true);
		    // Write code here that turns the phrase above into concrete actions
			
			System.out.println("User has successfully logged in");
		}


	

		
	

}
