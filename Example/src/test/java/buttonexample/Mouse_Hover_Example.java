package buttonexample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mouse_Hover_Example {
public static WebDriver driver=null;
	
	final static long TIMEOUT = 30;
	@FindBy(xpath="//button[@id='mousehover']")
	static WebElement mouseover;
	@FindBy(xpath = "//a[contains(text(),'Top')]")
	static
	WebElement subMenu;
	public static void main(String[] args) throws Exception {
		
WebDriverManager.chromedriver().setup();
		 
		 
		
		


		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		PageFactory.initElements(driver, Mouse_Hover_Example.class);

	       JavascriptExecutor js = (JavascriptExecutor) driver;
	 
	       //specify the number of pixels the page has to be scrolled
	       js.executeScript("window.scrollBy(0,1200)");
	       Thread.sleep(2000);
	       Actions actions = new Actions(driver);

	     //Hovering on main menu
	     actions.moveToElement(mouseover).perform();

	     // Locating the element from Sub Menu
	     //WebElement subMenu = driver.findElement(By.xpath("<Xpath of the sub element>"));

	     //To mouseover on sub menu
	     actions.moveToElement(subMenu).perform();

	     //build()- used to compile all the actions into a single step 
	     actions.click().build().perform();
		// TODO Auto-generated method stub

	}

}
