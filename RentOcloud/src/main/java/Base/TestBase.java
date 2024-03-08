package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestBase {
	
	 public static WebDriver driver=null;
		

		
		public void Base_url() throws IOException {
		     
		    final long TIMEOUT = 30;
			
		    String filePath = "C:\\ROC\\ROCCloud\\src\\main\\resources\\datafile.properties";
		    
		       //String filepath1="C:\Users\PRITHWIRAJ PC\eclipse-workspace\seleniumBasics\src\ReadingFiles";
		       
//		       Initializing File Input Stream
		       FileInputStream fileInputStream = new FileInputStream(filePath);

//		       Initializing Properties Class
		     
		       Properties properties = new Properties();
//		       Loading Properties file
		       properties.load(fileInputStream);
		       
		       String s2=String.valueOf(properties.get("URL"));
		       System.out.println(s2);
			
			System.out.println("0");
			//WebDriver driver=null;
			System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
			System.out.println("1");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("2");
			//ReadingPropertiesFIles readurl=new ReadingPropertiesFIles();
			
			driver.get(s2);
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
			driver.manage().window().maximize();
			System.out.println("3");
			//return driver;

		    // Write code here that turns the phrase above into concrete actions
		    // Write code here that turns the phrase above into concrete actions

		}


}
