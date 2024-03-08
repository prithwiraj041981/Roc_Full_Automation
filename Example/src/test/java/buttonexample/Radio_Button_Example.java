package buttonexample;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Radio_Button_Example {
	public static WebDriver driver=null;
	
	final static long TIMEOUT = 30;
	@FindBy(xpath="//input[@name='checkBoxOption1']")
	static WebElement  checkbox;
	

	
	public static void main(String[] args) throws Exception  {
		 WebDriverManager.chromedriver().setup();
		 
		 
			
			


			driver = new ChromeDriver();
			
			
			
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
			PageFactory.initElements(driver, Radio_Button_Example.class);
			//List<WebElement> radio = driver.findElements(By.name("radioButton"));
			
			checkbox.click();
}
}
