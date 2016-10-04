package com.bdd.test.jbehave.pageRepository;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.relevantcodes.extentreports.ExtentReports;
import com.sun.jna.platform.FileUtils;

public class GenericPage {
	WebDriver driverGenericPage = null;

	public GenericPage(WebDriver driver) {
		driverGenericPage = driver;
	}

	public static void delayTimer(int milliseconds) {
		try {
			System.out.println("Pausing for " + milliseconds + " milliseconds");
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String urlValidation() throws IllegalArgumentException {
		String baseURL = System.getProperty("Base_Url");

		if (baseURL == null) {
			baseURL = "https://www.abhibus.com/";
		}

		else {
			if (!baseURL.contains("http")) {
				throw new IllegalArgumentException(
						"Please specify http/https prefix! Url was given without prefix: " + baseURL);
			}
			if (!baseURL.substring(baseURL.length() - 1).equals("/")) {
				baseURL = baseURL + "/";
			}
		}

		return baseURL;
	}

	public Boolean open(String baseURL) {

		driverGenericPage.get(baseURL);
		// it will always return True because URL will be already verified by
		// urlValidation() method
		// if URL is not valid then default URL will be launched
		return Boolean.TRUE;

	}

	public String captureScreenShot(String screenShotName) {
		File sourcefile, destinationFile;
		String destinationPath =null;;
		String destinationSupportedPath=null;
		/*
		static String  fileName = new SimpleDateFormat("yyyy-MM-dd'_'HH-mm-ss'.html'").format(new Date());
		 static  ExtentReports extent = new ExtentReports("src/main/resources/AutomationTestReport_" +fileName , true);
*/
		
		 String  timeStamp = new SimpleDateFormat("yyyy-MM-dd'_'HH-mm-ss'.html'").format(new Date());
		
		try {
			sourcefile = ((TakesScreenshot) driverGenericPage).getScreenshotAs(OutputType.FILE);
			destinationPath = "src\\main\\resources\\reports\\screenshots\\" + screenShotName + "_" + timeStamp+".png";
			destinationSupportedPath = "screenshots/" + screenShotName + "_" + timeStamp+".png";
			destinationFile = new File(destinationPath);
			org.apache.commons.io.FileUtils.copyFile(sourcefile, destinationFile);

			System.out.println("Screenshot taken " + screenShotName + ".png");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return destinationSupportedPath;
	}

}
