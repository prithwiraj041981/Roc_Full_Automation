package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;
import com.google.common.collect.ImmutableList;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class TestBase {

	public static WebDriver driver;
	public EventFiringWebDriver e_driver;
	public static Properties prop;
	public static WebEventListener eventListener;
	public static String URL;

	public static int PAGE_LOAD_TIMEOUT = 30;
	public static int IMPLICIT_WAIT = 30;

	static ArrayList<String> TestCases = new ArrayList<String>();
	static ArrayList<Integer> Res = new ArrayList<Integer>();
	static int Time=0;

	/************************************************************************************************************************
	 * Method Name: Test Base Class
	 * Last Modified By: Ericsson India Pvt LTD.
	 ************************************************************************************************************************/

	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/crm"
					+ "/qa/config/config.properties");
			//FileInputStream datap = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/crm" + "/qa/config/Data.properties");
			prop.load(ip);
			//prop.load(datap);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeSuite
	public void CreateDir(){
	String filepath = System.getProperty("user.dir") + "\\Reports";
	File directory = new File(filepath);
	if (! directory.exists()){
	directory.mkdir();
	}
	}
	
	@Parameters({"environment","browser","browser_version","os","os_version"})
	@BeforeClass(alwaysRun = true)
	public void initialization(@Optional("")String executionPlatform, @Optional("")String browserName, @Optional("")String browser_version, @Optional("")String os , @Optional("")String os_version) throws MalformedURLException
	{
		System.out.println("#################### Before Class Browser Setup executing ################## ");

		if(executionPlatform.isEmpty())
			executionPlatform = prop.getProperty("exec_platform");
		if(browserName.isEmpty())
			browserName = prop.getProperty("browser");

		System.out.println("Execution Platform : "+executionPlatform);
		System.out.println("Browser Name : "+browserName);
		System.out.println("Browser Version : "+browser_version);
		System.out.println("OS : "+os);
		System.out.println("OS Version : "+os_version);

		if(executionPlatform.equalsIgnoreCase("local") && browserName.equalsIgnoreCase("chrome")){

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
		}
		else if(executionPlatform.equalsIgnoreCase("local") && browserName.equalsIgnoreCase("firefox")){

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); 
		}
		else if(executionPlatform.equalsIgnoreCase("local") && browserName.equalsIgnoreCase("edge")){

		
			DesiredCapabilities dc = new DesiredCapabilities();
			Map<String, Object> edgeOptions = new HashMap<>();
			edgeOptions.put("args", ImmutableList.of("-inprivate"));
			dc.setCapability("ms:edgeOptions", edgeOptions);
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(dc);
		}
		else if(executionPlatform.equalsIgnoreCase("browserstackmobile")){
			Calendar d1 = Calendar.getInstance();
			String testName = "BrowserStack Mobile Test Automation Test_Date_"+ d1.getTime();
			URL = "https://" + prop.getProperty("browserstackusername") + ":" + prop.getProperty("automate_key") + "@hub-cloud.browserstack.com/wd/hub";

			DesiredCapabilities caps = new DesiredCapabilities();

			//Website to Generate Capabilities : https://www.browserstack.com/automate/capabilities
			//App specification
			caps.setCapability("app", prop.getProperty("bs_mobile_appurl"));

			//Device Settings
			caps.setCapability("device", prop.getProperty("bs_mobile_device"));
			caps.setCapability("os_version", prop.getProperty("bs_mobile_osversion"));
			caps.setCapability("browserstack.acceptInsecureCerts", "true");

			//Test Organization
			caps.setCapability("project", "BrowserStackMobileAutomation");
			caps.setCapability("build", "Build_1");
			caps.setCapability("name", testName);

			// ######### Logging Types
			//Network logs
			//caps.setCapability("browserstack.networkLogs", "true");
			//Device logs
			//caps.setCapability("browserstack.deviceLogs", "false");
			//Appium logs
			//caps.setCapability("browserstack.appiumLogs", "false");
			//Visual logs
			//caps.setCapability("browserstack.debug", "true");
			//Video Recording
			//caps.setCapability("browserstack.video", "true");

			//WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
			AndroidDriver<AndroidElement> androiddriver = new AndroidDriver<AndroidElement>(new URL(URL), caps);
			driver = androiddriver;
			System.out.println("BrowserStack Mobile Driver Initialization Completed."); 
		}

		else if(executionPlatform.equalsIgnoreCase("browserstack")){
			Calendar d1 = Calendar.getInstance();
			String testName = "BrowserStack Windows Test Automation Test_Date_"+ d1.getTime();
			URL = "https://" + prop.getProperty("browserstackusername") + ":" + prop.getProperty("automate_key") + "@hub-cloud.browserstack.com/wd/hub";

			DesiredCapabilities caps = new DesiredCapabilities();

			//Website to Generate Capabilities : https://www.browserstack.com/automate/capabilities
			caps.setCapability("os", os);
			caps.setCapability("os_version", os_version);
			caps.setCapability("browser", browserName);
			caps.setCapability("browser_version", browser_version);
			caps.setCapability("resolution", "1920x1080");
			caps.setCapability("browserstack.local", "false");
			caps.setCapability("browserstack.selenium_version", "3.141.59");

			//Test Organization
			caps.setCapability("project", "BrowserStackWindowsAutomation");
			caps.setCapability("build", "Build_1");
			caps.setCapability("name", testName);



			//WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
			driver = new RemoteWebDriver(new URL(URL), caps);
			System.out.println("BrowserStack Windows Driver Initialization Completed."); 
		}


		e_driver = new EventFiringWebDriver(driver);
		//Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		System.out.println("Driver Initialization completed.");
		System.out.println("Test Base Hashcode : "+driver.hashCode());

		driver.get(prop.getProperty("url"));

		TestUtil testUtil = new TestUtil(driver);
		testUtil.waitForPageLoaded(driver);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);	
	}

	/************************************************************************************************************************
	 * Method Name: Generate Report 
	 * Last Modified By: Ericsson India Pvt LTD.
	 ************************************************************************************************************************/

	/* Configure Report*/

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports reports;
	public static ExtentTest logger;
	String className = "";

	/**
	 * Purpose: Set up the Report
	 */

	@BeforeClass()
	public void setupReport() throws Exception
	{   
		System.out.println("Before Class Setup Report Executing >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		className = this.getClass().getName();
		System.out.println("######### Starting Class Name Being Executed : "+ className );


		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd hh-mm-ss");		
//		htmlReporter= new ExtentSparkReporter(new File(System.getProperty("user.dir") +"/Reports/"+className+"-"+dateFormat.format(new Date())+".html"));
		htmlReporter= new ExtentHtmlReporter(new File(System.getProperty("user.dir") +"/Reports/"+className+"-"+dateFormat.format(new Date())+".html"));
		htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir") +"/extent-config.xml"));
		
		reports=new ExtentReports();
		reports.setSystemInfo("Environment", "Drupal 8 Test Demo Env");
		reports.setSystemInfo("Machine", 	"Windows 10" + "64 Bit");
		reports.setSystemInfo("Selenium", "3.4.0");
		reports.setSystemInfo("Maven", "4.0.0");
		reports.setSystemInfo("User Name", System.getProperty("user.name"));
		reports.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		reports.setSystemInfo("Java Version : ", System.getProperty("java.version"));
		reports.setSystemInfo("OS : ", System.getProperty("os.name"));
		reports.setSystemInfo("Browser : ", ""+prop.getProperty("browser")+"");
		reports.setSystemInfo("Class Name : ", className );
		reports.attachReporter(htmlReporter);
	}  
	
	/************************************************************************************************************************
	 * Method Name: Generate Report : Register the Method name to be published on the report
	 * Last Modified By: Ericsson India Pvt LTD.
	 ************************************************************************************************************************/

	@BeforeMethod()
	public void register(Method method)
	{
		System.out.println("Before Method Executing >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		String testname=method.getName();
		System.out.println("Current Test Name Being Executed is : "+ testname);
		logger=reports.createTest(testname);
	}
	
	/************************************************************************************************************************
	 * Method Name: Flush Result to Extent Report after each Method is Executed
	 * Last Modified By: Ericsson India Pvt LTD.
	 ************************************************************************************************************************/

	@AfterMethod()
	public void getResult(ITestResult result) throws Exception
	{
		System.out.println("#################### After Method executing ################## ");
		
		Res.add(result.getStatus());
		
		System.out.println(">>>>>>>>" + Res);
		System.out.println(">>>>>>>> Status Code for Sucess : " + ITestResult.SUCCESS);
		System.out.println(">>>>>>>> Status Code for Failure : " + ITestResult.FAILURE);
		System.out.println(">>>>>>>> Status Code for Skip : " + ITestResult.SKIP);

		if (result.getStatus() == ITestResult.FAILURE)
		{
			String screenShotPath = TestBase.getScreenShot(driver, "FailedTestcaseScreenshot");            
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
			logger.fail(result.getThrowable());
			logger.fail("Test case FAILED due to below issues,Please find Snapshot as below: " + logger.addScreenCaptureFromPath(screenShotPath));
			TestCases.add(result.getName());
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
			TestCases.add(result.getName());
		}
		else
		{
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
			logger.skip(result.getThrowable());
			TestCases.add(result.getName());

		}
		reports.flush();

	}
	
	/************************************************************************************************************************
	 * Method Name: Quit Driver after Execution is completed for Each Class
	 * Last Modified By: Ericsson India Pvt LTD.
	 ************************************************************************************************************************/

	@AfterClass
	public void tearDown(){
		System.out.println("#################### After Class executing ################## ");
		if(driver!=null)
		{
			System.out.println("Closing All Tabs for the Browser.");
			
			driver.close();
			driver.quit();
		}
	}
   /****************
    * Method Name: Captures screenshot
    * @param driver
    * @param screenshotName
    * @return
    * @throws Exception
    */
	public static String getScreenShot(WebDriver driver, String screenshotName) throws Exception {

		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd hh-mm-ss");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		//after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateFormat.format(new Date())+".png";

		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);

		return destination;
	}



}
