package Pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;

public class Duplicateproperty extends TestBase{
	
 public static final long TIMEOUT = 30;
	 
		
		  
		 
	 
	 
 @FindBy(how=How.XPATH, using="//*[@id=\"root\"]/div/section/div/aside/div/ul/li[2]/span/a")
 WebElement property;
 
 @FindBy(how=How.XPATH, using="//*[@id=\"root\"]/div/section/main/div[3]/div[1]/div[2]/button")
 WebElement addproperty;
 
 @FindBy(how=How.ID, using="rc_select_6")
 WebElement propertylocation;
 
	/*
	 * @FindBy(how=How.CLASS_NAME, using="rc-virtual-list-holder-inner")
	 * List<WebElement> options;
	 */
 
 
 @FindBy(how=How.XPATH, using="//*[@id=\"root\"]/div/section/main/div[3]/div/form/div/div/div/div/div[2]/div[1]/ul/div/div/div[1]/div/img")
 WebElement typeofproperty;
 
  @FindBy(how=How.CLASS_NAME, using="form-select")
  WebElement  subtype1;
 
 @FindBy(how=How.NAME, using="numberOfBed")
 WebElement noofbed;
 
 @FindBy(how=How.NAME, using="numberOfBath")
 WebElement noofbath;
 
 @FindBy(how=How.NAME, using="numberOfReception")
 WebElement noofreception;
 
 @FindBy(how=How.NAME, using="sizeInSquareFeet")
 WebElement noofsize;
 
 
 @FindBy(how=How.XPATH, using="//*[@id=\"root\"]/div/section/main/div[3]/div/form/div/div/div/div/div[2]/div[2]/button[1]")
 WebElement btn_create_property;


		
		  @FindBy(how=How.XPATH, using="/html/body/div[4]/div/div[2]/div/div[2]/div/div/div[4]/button[1]")
		  WebElement  btn_returnto_property;
		  
		  @FindBy(how=How.XPATH, using="/html/body/div[4]/div/div[2]/div/div[2]/div/div/div[1]/div/p[2]/strong")
		  WebElement  frame_duplicate;
		  
			 @FindBy(how=How.XPATH, using="/html/body/div[4]/div/div[2]/div/div[2]/div/div/div[2]/button[2]/span")
			 WebElement duplicate;
		  
			 @FindBy(how=How.XPATH, using="/html/body/div[4]/div/div[2]/div/div[2]/div/div/div/div/div/div/div/table/thead/tr/th")
			 WebElement loweraddress;
			 @FindBy(how=How.XPATH, using="/html/body/div[4]/div/div[2]/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[1]/td/div/div[3]")
			 WebElement loweraddressselect;
		 
	 public Duplicateproperty(WebDriver driver) {
		 Duplicateproperty.driver = driver;
			  PageFactory.initElements(driver, this);
		  
		  }
	 
	 public void addduppropertyforlandlord() {
		 property.click();
		 driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		 addproperty.click();
		 driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		 propertylocation.sendKeys("aa");
		 driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		 //List<WebElement> options=driver.findElements(By.className("rc-virtual-list-holder-inner"));
		
		 
		 
			
			 
		 
		 //WebElement select = driver.findElement(By.className("ant-space ant-space-horizontal ant-space-align-basline"));

	       List<WebElement> options = driver.findElements(By.xpath("/html/body/div[3]/div/div/div/div[2]/div[1]/div/div/div[1]/div/div/div[1]/span"));
	       //System.out.println("prithvi="+options.size());
	       options.get(0).click();
			
			  if(frame_duplicate.getText().equalsIgnoreCase("Do you want to duplicate property?")) {
			  
			  duplicate.click();
			  driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS); }
			 
			/*
			 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
			 * 
			 * if(loweraddress.getText().equalsIgnoreCase("Select Your Address")) {
			 * 
			 * loweraddressselect.click();
			 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT)); }
			 */
	       
	       
			/*
			 * for (WebElement option1 : options) {
			 * 
			 * if("Xarlyn, 171 Winchester Road, Alton, GU34 5HY".equals(option1.getText().
			 * trim()))
			 * 
			 * option1.click(); }
			 */       
		/// System.out.println("prithvi="+options.size());
		// options.get(0).click();
			  driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		 typeofproperty.click();
		 driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        // List<WebElement> subtype=driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/section/main/div[3]/div/form/div/div/div/div/div[2]/div[1]/div[1]/select"));
		 
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,600)", "");
		 driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		 Select subtype = new Select(subtype1);
		 //subtype.selectByIndex(1);
		 subtype.selectByIndex(1);
		 //System.out.println("prithvi");
		 //subtype.size();
		 //System.out.println( subtype.size());
		 driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		 
		 noofbed.sendKeys("1");
		 driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		 noofbath.sendKeys("2");
		 driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		 noofreception.sendKeys("3");
		 driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		 noofsize.sendKeys("2222");
		 driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		 btn_create_property.click();
		 driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		 btn_returnto_property.click();
	 }


}
