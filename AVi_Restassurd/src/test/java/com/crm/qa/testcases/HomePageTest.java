package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;



	@Test(priority=0,enabled=true)
	public void login() throws InterruptedException{
		TestBase.logger.log(Status.PASS,"#################### LoginPage Test : Initializing ################## ");
		
		loginPage = new LoginPage();
		homePage = new HomePage();
	
		
		loginPage.navigateToLoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		if(homePage.verifyhomeIcon()) {
		TestBase.logger.log(Status.PASS, "Login and navigation to CRM HomePage Completed.");
		}
		else {
		TestBase.logger.log(Status.FAIL, "Login and navigation to CRM HomePage has failed.");	
			
		}
	}
	

	
	@Test(priority=1)
	public void verifyHomePageTitleTest() throws InterruptedException{
		System.out.println("#################### HomePage Test : Test 1 executing ################## ");
		String homePageTitle = homePage.verifyHomePageTitle();
		
		if (homePageTitle.contains("Cogmento CRM")) {
			Assert.assertTrue(true);
			TestBase.logger.log(Status.PASS, "Home Page Title verified successfully as : Cogmento CRM");
		}
		else {
			TestBase.logger.log(Status.FAIL, "Home Page Title could not be verified successfully");
		}
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() throws InterruptedException{
		System.out.println("#################### HomePage Test : Test 2 executing ################## ");
		String userProp = prop.getProperty("first_name")+" "+prop.getProperty("last_name");
		String userDisplayed = homePage.verifyCorrectUserName();
		if (userProp.contains(userDisplayed)) {
			TestBase.logger.log(Status.PASS, "UserName verified successfully");	
		}
		else {
			TestBase.logger.log(Status.FAIL, "UserName not verified successfully");
		}
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() throws InterruptedException{
		System.out.println("#################### HomePage Test : Test 3 executing ################## ");
		//testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
		if (homePage.verifyContactsPage()) {
		TestBase.logger.log(Status.PASS, "Contacts Link clicked successfully.");
		}
		else {
		TestBase.logger.log(Status.FAIL, "Contacts Link not clicked properly");	
		}
	}
	

}
