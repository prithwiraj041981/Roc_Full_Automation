package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Page Factory - OR:
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement loginLink;
	
	@FindBy(name="email")
	WebElement useremail;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	//@FindBy(xpath="//a[@title='free crm home']//*[local-name()='image' and @src='/images/cogtiny1.jpg']")
	//WebElement crmLogo;
	
	@FindBy(xpath="//a/img[@alt='free crm logo']")
	WebElement freeCRMLogo;

	
	@FindBy(xpath="//a[contains(.,'Home')]")
	WebElement homeIcon;
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		return freeCRMLogo.isDisplayed();
	}
	
	public boolean navigateToLoginPage()
	{
		try {
		loginLink.click();
		//Declaring a Explicit Wait to synchronize between pages
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(useremail));
	    return useremail.isDisplayed();
		
		}
		catch ( Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean login(String un, String pwd) {
		try {
			
		useremail.sendKeys(un);
		Thread.sleep(2000);
		password.sendKeys(pwd);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginBtn);
		
		    	
		//return new HomePage();
		Thread.sleep(2000);
		
		if(homeIcon.isDisplayed())
			
			return true;
		
		else
			
			return false; 

		}
	
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		    	
		    	
	}
		
	
}
