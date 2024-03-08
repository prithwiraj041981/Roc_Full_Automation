package buttonexample;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Web_Table_Example {
public static WebDriver driver=null;
	
	final static long TIMEOUT = 30;
	@FindBy(xpath="//table[@name='courses']")
	static WebElement gettable;
	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		 
		 
		
		


		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		PageFactory.initElements(driver, Web_Table_Example.class);

	       JavascriptExecutor js = (JavascriptExecutor) driver;
	 
	       //specify the number of pixels the page has to be scrolled
	       js.executeScript("window.scrollBy(0,600)");
	       Thread.sleep(2000);
	       List<WebElement> rowsList = gettable.findElements(By.tagName("tr"));
	       Thread.sleep(2000);
	       List<WebElement> columnsList = null;
	       Thread.sleep(2000);
	       for (WebElement row : rowsList) {
	           columnsList = row.findElements(By.tagName("td"));
	           Thread.sleep(2000);

	           for (WebElement column : columnsList) {
	               System.out.println("column text" + column.getText()+ ", ");
	               Thread.sleep(2000);// here is is just printing number of rows, like 1, 2
	           }

	       }
		// TODO Auto-generated method stub

	}

}
