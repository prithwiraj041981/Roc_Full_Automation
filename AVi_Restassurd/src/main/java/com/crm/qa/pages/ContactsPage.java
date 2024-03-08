package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//div[contains(@class,'ui header') and text()='Contacts']")
	WebElement contactsLabel;

	@FindBy(xpath="//button[contains(text(),'Create')]")
	WebElement createContactButton;

	@FindBy(name="first_name")
	WebElement firstName;

	@FindBy(name="last_name")
	WebElement lastName;

	@FindBy(xpath="//div[@name='company']/input")
	WebElement company;

	@FindBy(xpath = "//button[@class='ui linkedin button' and text()='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath = "//i[contains(@class,'users icon')]")
	WebElement contactsIcon;
	
	@FindBy(xpath = "//span[text()='Contacts']")
	WebElement contactsLink;

	// Initializing the Page Objects:
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}

	public void hoverOverLabel(){
		Actions action = new Actions(driver);
		action.moveToElement(createContactButton).build().perform();
	}
	
	public void clickOnCreateButton(){
		Actions action = new Actions(driver);
		action.click(createContactButton).build().perform();
	}

	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}

	public void selectContactsByName(String name)
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td//div[contains(@class,'checkbox')]")).click();
	}

	public void createNewContact(String ftName, String ltName, String comp)
	{
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
	}
	
	public void clickOnContactsLink(){
		contactsIcon.click();
		contactsLink.click();
	}
}
