package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
public static WebDriver driver=null;

	
	public static void init() throws InterruptedException {
		String browserName = "chrome";
		System.out.println("browser name is " + browserName);
		
			WebDriverManager.chromedriver().setup();
			Thread.sleep(2000);
			driver = new ChromeDriver();
			//System.setProperty("webdriver.chrome.silentOutput", "true");
			Thread.sleep(2000);
			System.out.println("Browser is set to chrome");
			Thread.sleep(2000);
			
			//Thread.sleep(2000);
		

		try {
			driver.get("https://demo.guru99.com/test/newtours/");
			Thread.sleep(2000);
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
			//System.exit(0);
		}
	
	}
	

}
