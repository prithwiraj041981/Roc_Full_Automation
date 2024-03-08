package Pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.TestBase;



public class LoginPage extends TestBase{
	
	
	//WebDriver driver;
	 public static final long TIMEOUT = 30;
	 
		
		  
		 
	 
	 
	 @FindBy(how=How.XPATH, using="//*[@id=\"root\"]/div/div/div/div[1]/div[2]/div/form/div[1]/input")
	 WebElement username;
	 
		//@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div/div/div/div[2]/form/div[1]/input")
		//WebElement username;
		
	
		
		@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[1]/div[2]/div/form/div[2]/button")
		WebElement loginButton;
		
		@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[1]/div[2]/div/form/div[2]/input")
		WebElement password;
		
		@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[1]/div[2]/div/form/div[4]/button")
		WebElement enterbutton;
		
		@FindBy(xpath = "//*[@id=\"root\"]/div/section/main/div[1]/div/div[1]/h2")
		WebElement homepagename;
		
		public LoginPage(WebDriver driver) {
			LoginPage.driver = driver;
			  PageFactory.initElements(driver, this);
		  
		  }
		
		
		
		public void Loginpageforlandlord() {
			
			
			 
			

			 
			//driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/div/div[2]/form/div[1]/input")).sendKeys("prithwiraj011981@mailinator.com");
			  
			username.sendKeys("prithwiraj011981@mailinator.com");
			
			driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
			  
			  //driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/div/div[2]/form/div[2]/button")).
			  //click();
			  loginButton.click();
			  
			  
			  
			  driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
			  //driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/div/div/form/div[2]/input")).sendKeys("Mylogin@123");
			  
			  password.sendKeys("Mylogin@123");
			  driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
			 // driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/div/div/form/div[4]/button")).click();
			 // Write code here that turns the phrase above into concrete actions
			  enterbutton.click();
			  System.out.println("5");
			// TODO Auto-generated constructor stub
		}


		
		public void DashboardLandlordROC() {
			System.out.println("6");
			driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
			
			String homePageHeading = homepagename.getText();
			driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
			Assert.assertEquals(homePageHeading,"Home");
			//Assert.assertEquals(homePageHeading,"Home");
		    // Write code here that turns the phrase above into concrete actions
			System.out.println("7");
			System.out.println("User has successfully logged in");
		}

		
	

}
