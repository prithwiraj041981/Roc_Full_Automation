package Base;

import java.io.ByteArrayInputStream;


import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import io.qameta.allure.Allure;

import io.qameta.allure.Step;


public class HomePage extends TestBase {
	//private WebDriver driver;

	
    //private static SoftAssert softAssertion;

	@FindBy(name = "userName")
	private WebElement username;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submit;

	
	@SuppressWarnings("deprecation")
	@Step("This is a failed step")
	public void login(String user, String pwd) throws InterruptedException {
		Thread.sleep(2000);
		Allure.addAttachment("username", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
		
		
		Allure.step("THis is step 1 to login");
		//Allure.addAttachment("Console log: ", String.valueOf(webDriverActions.getDriver().manage().logs().get(LogType.BROWSER).getAll()));
		Allure.description("This is test result i");
		
		//Asserts.check(false, "user id is wrong");
		username.sendKeys(user);
		
		Allure.story("you have just entered username");
		
		Thread.sleep(2000);
		password.sendKeys(pwd);
		
		Allure.addAttachment("password", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
		Thread.sleep(2000);
		submit.click();
	}

	/*
	 * public HomePage(WebDriver driver) { System.out.println("Constructir driver:"
	 * +driver); this.driver = driver; PageFactory.initElements(driver, this); }
	 */

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
