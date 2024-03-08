/*
 * @author
 * 
 */

package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.ExcelUtils;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	ExcelUtils excelutils;

	String sheetName = "contacts";

	public ContactsPageTest(){
		super();

	}

	/*
	 * @BeforeClass public void setUp() throws InterruptedException {
	 * 
	 * System.out.
	 * println("#################### ContactsPage Test : Before Class executing ################## "
	 * );
	 * 
	 * initialization(); testUtil = new TestUtil(); contactsPage = new
	 * ContactsPage(); loginPage = new LoginPage();
	 * 
	 * loginPage.navigateToLoginPage(); homePage =
	 * loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	 * TestUtil.runTimeInfo("info",
	 * "Login and navigation to CRM HomePage Completed.");
	 * 
	 * contactsPage = homePage.clickOnContactsLink(); TestUtil.runTimeInfo("info",
	 * "Contacts Link clicked successfully."); }
	 */
	@Test(priority=1)
	public void verifyContactsPageLabel() throws InterruptedException{
		System.out.println("#################### ContactsPage Test : Test 1 executing ################## ");
		contactsPage.hoverOverLabel();
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Error : Contacts Header label is missing on the page");
		TestBase.logger.log(Status.PASS, "Contact Page Header validation completed.");
	}

	@Test(priority=2)
	public void selectSingleContactsTest() throws InterruptedException{
		System.out.println("#################### ContactsPage Test : Test 2 executing ################## ");
		contactsPage.selectContactsByName("Test1 Contact1");
		TestBase.logger.log(Status.PASS, "Test1 Contact1 Selected successfully.");
	}

	@Test(priority=3)
	public void selectMultipleContactsTest() throws InterruptedException{
		System.out.println("#################### ContactsPage Test : Test 3 executing ################## ");
		contactsPage.selectContactsByName("Test1 Contact1");
		contactsPage.selectContactsByName("Test2 Contact2");
		contactsPage.selectContactsByName("Test3 Contact3");
		TestBase.logger.log(Status.PASS, "Contact 2 and 3 Selected successfully.");
	}

	
	  @DataProvider public Object[][] getCRMTestData()
	  { 
		  System.out.println("#################### ContactsPage Test : DataProvider executing ################## " );
		  Object data[][] = excelutils.getTestData();//TestUtil.getTestData(sheetName); 
		  return data; 
	  
	  }
	 

	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String firstName, String lastName, String company) throws InterruptedException{
		System.out.println("#################### ContactsPage Test : Test 4 executing ################## ");
		contactsPage.clickOnCreateButton();
		contactsPage.createNewContact(firstName, lastName, company);
		Thread.sleep(3000);
		contactsPage.clickOnContactsLink();
		Thread.sleep(2000);
	}

	/*
	 * @AfterClass public void tearDown(){ System.out.
	 * println("#################### ContactsPage Test : After Class executing ################## "
	 * ); driver.close(); }
	 */
}
