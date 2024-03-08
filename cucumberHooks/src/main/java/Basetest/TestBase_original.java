package Basetest;


import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase_original {
	
	 public static WebDriver driver=null;
	

	 
	public void Base_url() throws IOException {
	     
	    final long TIMEOUT = 30;
		
	
		//WebDriver driver=null;
		WebDriverManager.chromedriver().setup();


		driver = new ChromeDriver();
		//ReadingPropertiesFIles readurl=new ReadingPropertiesFIles();
		
		
		driver.get("https://dev.app.rentoncloud.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//return driver;

	    // Write code here that turns the phrase above into concrete actions
	    // Write code here that turns the phrase above into concrete actions

	}


}

