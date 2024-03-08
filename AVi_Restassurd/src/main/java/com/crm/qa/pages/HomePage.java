package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Satadip Mukherjee')]")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "//i[contains(@class,'users icon')]")
	WebElement contactsIcon;
	
	@FindBy(xpath = "//span[text()='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

    @FindBy(xpath = "//a/i[@class='home icon']")
    WebElement homeIcon;
	
	@FindBy(xpath = "//span[@class='user-display']")
	WebElement userName;
	
	@FindBy(xpath = "//div[@class='ui loader']/parent::div")
	WebElement contactsWbe;
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public String verifyCorrectUserName(){
		
		
		String Uname = userName.getText();
		return Uname;
	}
	
	public ContactsPage clickOnContactsLink(){
		contactsIcon.click();
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}
	
	public boolean verifyhomeIcon() {
		
		return homeIcon.isDisplayed();
	}
	
	public boolean verifyContactsPage() {
		if (contactsWbe.getText().contains("Contacts"))
			return true;
		else 
			return false;
	}
	
	
	
	

}
