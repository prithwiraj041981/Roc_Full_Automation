package com.crm.qa.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.crm.qa.base.TestBase;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

public class TestUtil extends TestBase {

	//WebDriver driver;
	JavascriptExecutor js;

	public TestUtil(WebDriver superdriver)
	{
		driver=superdriver;
		js = (JavascriptExecutor) driver;
		System.out.println("Test Util Hashcode : "+driver.hashCode());
	}

	public void switchToFrame(String fname) {
		driver.switchTo().frame(fname);
	}

	public void takeScreenshot(String Name) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + Name+ "_Time_"+ System.currentTimeMillis() + ".png"));
	}

	public static void waitForPageLoaded(WebDriver driver) 
	{
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() 
		{
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};

		WebDriverWait wait = new WebDriverWait(driver, 60);
		try 
		{
			wait.until(expectation);
		} 
		catch (Throwable e) 
		{
			System.out.println("Exception Occured in Waiting for page to load.");
			e.printStackTrace();
		}
	}

	public void VisualRegressionBaselineScreenshot(WebElement element, String Name) throws IOException {
		try
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

			Thread.sleep(5000);
			String currentDir = System.getProperty("user.dir");
			Screenshot logoImageScreenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver, element);
			File screenshotFile = new File(currentDir + "/VisualRegression_Screenshots/" +Name+ ".png");
			screenshotFile.getParentFile().mkdirs();
			screenshotFile.createNewFile();

			ImageIO.write(logoImageScreenshot.getImage(),"png",screenshotFile);
			Thread.sleep(5000);

			File test = new File(currentDir + "/VisualRegression_Screenshots/" +Name+ ".png");
			if(test.exists())
			{
				System.out.println("Baseline Visual Regression Image File Captured for Element : "+ Name);
			}
			else
			{
				System.out.println("Failed to Capture Baseline Screenshot for Element : "+ Name);
			}
		}
		catch (Exception e) 
		{
			System.out.println("Exception Occured while capturing Baseline Screenshot for Element : "+ Name);
			e.printStackTrace();
		}
	}

	public void VisualRegressionComparison(WebElement element, String ExpectedScreenshot, int deviation) throws IOException 
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy");  
		Date date = new Date(); 
		BufferedImage expectedImage = null;
		BufferedImage actualImage = null;
		ImageDiffer imgDiff = null;
		ImageDiff diff = null;
		int imgWidth, imgHeight, ignorePixels;
		long pixels;
		ignorePixels = 0;
		System.out.println("Current Date for Folder Creation : "+formatter.format(date));  

		String currentDir = System.getProperty("user.dir");
		String expectedScreenshotPath = currentDir + "/VisualRegression_Screenshots/" +ExpectedScreenshot+ ".png";
		String actualScreenshotName = ExpectedScreenshot + "_Time_"+ System.currentTimeMillis();
		String actualScreenshotPath = currentDir + "/VisualRegression_Screenshots/"+formatter.format(date)+"/"+actualScreenshotName+ ".png";

		try
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(5000);

			//Checking if Baseline Screenshot Exists
			File test = new File(expectedScreenshotPath);
			if(test.exists())
			{
				TestBase.logger.log(Status.PASS,"Baseline Visual Regression Image File present for Element : "+ ExpectedScreenshot);
				expectedImage = ImageIO.read(test);
				imgWidth = expectedImage.getWidth();
				imgHeight = expectedImage.getHeight();
				pixels = imgWidth * imgHeight;
				ignorePixels = (int) (pixels*deviation/100.00);
				TestBase.logger.log(Status.INFO,"Number of Pixels difference which will be ignored is : " + ignorePixels + 
						" as per user Input of acceptable difference % of : "+ deviation);
			}
			else
			{
				TestBase.logger.log(Status.FAIL,"Failed to locate Baseline Screenshot for Element : "+ ExpectedScreenshot);
				expectedImage = null;
			}

			//Capturing current Screenshot and Saving to new Directory
			Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, element);
			actualImage = logoImageScreenshot.getImage();
			File screenshotFile = new File(actualScreenshotPath);
			screenshotFile.getParentFile().mkdirs();
			screenshotFile.createNewFile();
			ImageIO.write(actualImage,"png",screenshotFile);

			//Verifying if Screenshot has been captured successfully
			File testActual = new File(actualScreenshotPath);
			if(testActual.exists())
			{
				TestBase.logger.log(Status.PASS,"Execution Visual Regression Image File Captured for Element : "+ ExpectedScreenshot);
			}
			else
			{
				TestBase.logger.log(Status.FAIL,"Failed to Capture Execution Comparison Screenshot for Element : "+ ExpectedScreenshot);
				Assert.fail();
			}
		}
		catch (Exception e) 
		{
			System.out.println("Exception Occured while capturing and setting up Visual Regression for Element : "+ ExpectedScreenshot);
			e.printStackTrace();
			Assert.fail();
		}

		try
		{
			TestBase.logger.log(Status.INFO," ###### Starting Visual Regression for Element : "+ExpectedScreenshot+ " #####");

			imgDiff = new ImageDiffer();
			diff = imgDiff.makeDiff(actualImage, expectedImage).withDiffSizeTrigger(ignorePixels);

			if(diff.hasDiff()==true)
			{
				TestBase.logger.log(Status.FAIL,"MISMATCH !! Error while validating Visual Regression for Element : "+ExpectedScreenshot);
				Assert.fail();
			}
			else 
			{
				TestBase.logger.log(Status.PASS,"MATCHING !! Successfully validated Visual Regression for Element : "+ExpectedScreenshot);
			}
		}
		catch (Exception e) 
		{
			System.out.println("Exception Occured while validating Visual Regression for Element : "+ ExpectedScreenshot);
			e.printStackTrace();
			Assert.fail();
		}
	}
}
