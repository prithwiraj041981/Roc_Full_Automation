package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage ;
	HomePage homePage;
	

	

	
	@Test(priority=1)
	public void loginPageTitleTest() throws InterruptedException{
		System.out.println("#################### LoginPage Test : Test 1 executing ################## ");
		loginPage = new LoginPage();
		//homePage = new HomePage();
		String title = loginPage.validateLoginPageTitle();
		String actualTitle = "Free CRM software for any business with sales, support and customer relationship management";
		System.out.println(title);
		
		
		if (title.contentEquals(actualTitle)) {
			Assert.assertEquals(title, "Free CRM software for any business with sales, support and customer relationship management");
			TestBase.logger.log(Status.PASS, "Title Of Page Successfully Validated as : "+ title);
			
		}
		else {
			TestBase.logger.log(Status.FAIL, "Title Of Page Not Validated as : "+ title);
			
		}
	}
	
	@Test(priority=2)
	public void crmLogoImageTest() throws InterruptedException{
		System.out.println("#################### LoginPage Test : Test 2 executing ################## ");
		
		boolean flag = loginPage.validateCRMImage();
		System.out.println(flag);
		if (flag)
		{
		Assert.assertTrue(flag);
		TestBase.logger.log(Status.PASS, "HomePage CRM Logo validated successfully.");
		}
		else {
		TestBase.logger.log(Status.FAIL, "HomePage CRM Logo not validated successfully.");
		}
	}
	
	@Test(priority=3)
	public void navigatetoLoginPage() throws InterruptedException{
		System.out.println("#################### LoginPage Test : Test 3 executing ################## ");
		
		if(loginPage.navigateToLoginPage()) {
			TestBase.logger.log(Status.PASS, "Successfully navigated to Login Page.");
		}
		else {
			TestBase.logger.log(Status.FAIL, "Unable to navigated to Login Page.");
		}
	}
	
	@Test(priority=4)
	public void loginTest() throws InterruptedException{
		System.out.println("#################### LoginPage Test : Test 4 executing ################## ");
		//loginPage = new LoginPage();
		
		boolean flag = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		if (flag)
		{
		TestBase.logger.log(Status.PASS, "UserName and Password entered successfully and login is completed.");
		}
		else {
			TestBase.logger.log(Status.FAIL, "UserName and Password not entered successfully and login is incomplete");	
		}
	}
	

	
	
	
	

}
