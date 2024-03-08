package buttonexample;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown_Example {
public static WebDriver driver=null;
	
	final static long TIMEOUT = 30;
	@FindBy(xpath="//select[@name='dropdown-class-example']")
	static WebElement mySelectObj;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WebDriverManager.chromedriver().setup();
		 
		 
			
			


			driver = new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
			PageFactory.initElements(driver, Dropdown_Example.class);
			//Select select = new Select(driver.findElement(By.id("oldSelectMenu")));
			Select dropdown = new Select(mySelectObj);
			List <WebElement> op = dropdown.getOptions();
			 int size = op.size();
			 for(int i =0; i<size ; i++){
		         String options = op.get(i).getText();
		         System.out.println(options);
		      }
			 op.get(1).click();
		

	
	}

}
