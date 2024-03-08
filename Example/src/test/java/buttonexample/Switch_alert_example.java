package buttonexample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Switch_alert_example {
	
public static WebDriver driver=null;
	
	final static long TIMEOUT = 30;
	@FindBy(xpath="//input[@name='enter-name']")
	static WebElement settext;
	@FindBy(xpath="//input[@id='alertbtn']")
	static WebElement setalert;
	public static void main(String[] args) throws Exception {
		 WebDriverManager.chromedriver().setup();
		 
		 
			
			


			driver = new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
			PageFactory.initElements(driver, Switch_alert_example.class);
			settext.sendKeys("avijit");
			Thread.sleep(2000);
			setalert.click();
			Thread.sleep(2000);
			 Alert alert = driver.switchTo().alert();		
     		
		        // Capturing alert message.    
		        String alertMessage= driver.switchTo().alert().getText();		
		        		
		        // Displaying alert message		
		        System.out.println(alertMessage);	
		        Thread.sleep(5000);
		        		
		        // Accepting alert		
		        alert.accept();
		// TODO Auto-generated method stub

	}

}
