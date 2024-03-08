package buttonexample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Element_Displayed_Example {
public static WebDriver driver=null;
	
	final static long TIMEOUT = 30;
	@FindBy(xpath="//input[@id='hide-textbox']")
	static WebElement gethide;
	@FindBy(xpath="//input[@id='displayed-text']")
	static WebElement elementdisplayed;
	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		 
		 
		
		


		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		PageFactory.initElements(driver, Element_Displayed_Example.class);

	       JavascriptExecutor js = (JavascriptExecutor) driver;
	 
	       //specify the number of pixels the page has to be scrolled
	       js.executeScript("window.scrollBy(0,600)");
	       Thread.sleep(2000);
	       gethide.click();
	       Thread.sleep(2000);
	       Boolean Display = elementdisplayed.isDisplayed();
	     //To print the value
	     System.out.println("Element text box displayed is :"+Display);
		// TODO Auto-generated method stub

	}

}
