package buttonexample;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Switch_Tab_Example {
public static WebDriver driver=null;
	
	final static long TIMEOUT = 30;
	@FindBy(xpath="//a[@id='opentab']")
	static WebElement gettab;
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		 
		 
		
		


		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		PageFactory.initElements(driver, Switch_Tab_Example.class);
		Thread.sleep(2000);
		gettab.click();
		Thread.sleep(2000);
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	      //switch to new tab
	      driver.switchTo().window(newTb.get(1));
	      Thread.sleep(2000);
	      System.out.println("Page title of new tab: " + driver.getTitle());
	      Thread.sleep(2000);
	      //switch to parent window
	      driver.switchTo().window(newTb.get(0));
	      Thread.sleep(2000);
	      System.out.println("Page title of parent window: " + driver.getTitle());
	      Thread.sleep(2000);
	      driver.quit();
		// TODO Auto-generated method stub

	}

}
