package buttonexample;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Switch_Window_Example {
public static WebDriver driver=null;
	
	final static long TIMEOUT = 30;
	@FindBy(xpath="//button[@id='openwindow']")
	static WebElement getwindow;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 WebDriverManager.chromedriver().setup();
		 
		 
			
			


			driver = new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
			PageFactory.initElements(driver, Switch_Window_Example.class);
			getwindow.click();
			Thread.sleep(2000);
			String parent=driver.getWindowHandle();
			Thread.sleep(2000);
			Set<String>s=driver.getWindowHandles();
			Thread.sleep(2000);
			// Now iterate using Iterator
			Iterator<String> I1= s.iterator();
			Thread.sleep(2000);
			while(I1.hasNext())
			{

			String child_window=I1.next();
			Thread.sleep(2000);

			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			Thread.sleep(2000);

			System.out.println(driver.switchTo().window(child_window).getTitle());
			Thread.sleep(2000);
			driver.close();
			}

			}
			//switch to the parent window
			driver.switchTo().window(parent);

	}

}
