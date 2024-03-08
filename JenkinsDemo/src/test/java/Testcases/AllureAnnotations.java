package Testcases;


import org.testng.Assert;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.HomePage;
import Base.TestBase;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

public class AllureAnnotations extends TestBase{
	
	static HomePage hp;
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		init();
		Thread.sleep(2000);
		hp=new HomePage(driver);
		Thread.sleep(2000);
	}
	
	@Test(priority=1, description = "TestNG description 1")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify login")
	@Step("1. Launch URL. 2. Click on Login button 3. Enter username and password. 4. CLick on submit button and verify user gets logged in successfully.")
	public void login() throws InterruptedException {
		Thread.sleep(2000);
		hp.login("admin", "admin");
		Thread.sleep(2000);
	}

	@Test(priority=2, description = "TestNG description 2" )
	
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify fail sceanrio")
	@Step("1. Just to showcase fail scenario")
	public void fail() throws InterruptedException {
		boolean flag=false;
		Thread.sleep(2000);
		Assert.assertFalse(flag);
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
}

