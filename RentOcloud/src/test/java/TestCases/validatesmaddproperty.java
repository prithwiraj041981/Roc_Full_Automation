package TestCases;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.Addproperty;
import Pages.LoginPage;
import Pages.Simpleaddproperty;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class validatesmaddproperty extends TestBase {
	
	
	@BeforeTest
	public void launchBrowser() throws IOException {
		
		TestBase tbase= new TestBase();
    	tbase.Base_url();
	}
    	
    	   @Test(description="This is property validate")
    	   @Description("This is property test validation")
    	   @Severity(SeverityLevel.NORMAL)
    	   @Story("THis is propertytest")
    	   @Feature("validate property")
    	   public void Validateproperty() throws IOException
    	   {
    		   LoginPage log= new LoginPage(driver);
    		   log.Loginpageforlandlord();
    		   Simpleaddproperty addpro=new Simpleaddproperty(driver);
    		   addpro.addsmpropertyforlandlord();
    		   
    		   
    	   }
    	   
		
	
	
	

	@AfterTest
	public void Closebrowser()  {
		//Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
	//Assert.assertFalse(true);
		
		//driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/form/div[2]/button")).click();
		
		Allure.addAttachment("Any text", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
		driver.quit();
		
	}

}
