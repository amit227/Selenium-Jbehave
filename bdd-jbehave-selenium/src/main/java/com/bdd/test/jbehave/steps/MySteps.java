package com.bdd.test.jbehave.steps;

import java.io.File;
import java.util.List;
import java.util.Map.Entry;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.ScenarioType;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.bdd.test.jbehave.io.ExtentReportTest;
import com.bdd.test.jbehave.io.LoginCredentials;
import com.bdd.test.jbehave.io.ReportParams;
import com.bdd.test.jbehave.pageRepository.AbhiBusPage;
import com.bdd.test.jbehave.pageRepository.GenericPage;

public class MySteps {
	public static WebDriver driver = null;
	static Boolean reportingFlag;
	static FirefoxBinary firefoxBinary;
	static FirefoxProfile firefoxProfile;
	GenericPage genericPage = null;

	@BeforeScenario(uponType = ScenarioType.EXAMPLE)
	public void clearAndIntialize() {
		reportingFlag = null;
		ReportParams.clearAndInitializeParams();
		/*firefoxBinary = new FirefoxBinary(new File("C:\\Users\\amit.a.rai\\Firefox33.0\\firefox.exe"));*/
		/*firefoxProfile = new FirefoxProfile();
		driver = new FirefoxDriver(firefoxBinary, firefoxProfile);*/
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		genericPage = new GenericPage(driver);
	}

	@Given("Launch the site")
	public void fn1() {

		reportingFlag = genericPage.open(genericPage.urlValidation());
		GenericPage.delayTimer(4000);
		String screenShotPath = genericPage.captureScreenShot("Launch the site");

		if (reportingFlag == null) {

			ReportParams.reportChildParams("Launch the site", "Unknown error, Review required!", ReportParams.UNKNOWN,
					screenShotPath);

		} else {
			if (reportingFlag.equals(Boolean.TRUE)) {

				ReportParams.reportChildParams("Launch the site", "Site is launched ", ReportParams.PASS,
						screenShotPath);
			}
			if (reportingFlag.equals(Boolean.FALSE)) {

				ReportParams.reportChildParams("Launch the site", "Site dint launch", ReportParams.FAIL,
						screenShotPath);
			}
		}

	}

	@Given("Read User Name and Password from Excel <filePath> <testCaseName> and do login")
	public void fn2(@Named("filePath") String filePath, @Named("testCaseName") String testCaseName) {

		LoginCredentials loginCredentials = new LoginCredentials(filePath, testCaseName);
		String[] credentials = loginCredentials.readLoginCredentialsFromExcel();
		AbhiBusPage abhiBusPage = new AbhiBusPage(driver);
		reportingFlag = abhiBusPage.login(credentials[0], credentials[1]);

		String screenShotPath = genericPage.captureScreenShot("Read User Name and Password from Excel and do login");

		if (reportingFlag == null) {

			ReportParams.reportChildParams(
					"Read User Name and Password from Excel <filePath> <testCaseName> and do login",
					"Unknown error, Review required!", ReportParams.UNKNOWN, screenShotPath);
		} else {
			if (reportingFlag.equals(Boolean.TRUE)) {

				ReportParams.reportChildParams(
						"Read User Name and Password from Excel <filePath> <testCaseName> and do login",
						"read and login was successful", ReportParams.PASS, screenShotPath);
			}
			if (reportingFlag.equals(Boolean.FALSE)) {

				ReportParams.reportChildParams(
						"Read User Name and Password from Excel <filePath> <testCaseName> and do login",
						"login was not successful", ReportParams.FAIL, screenShotPath);
			}
		}

	}

	@Given("Verify page lables")
	public void fn3() {

		AbhiBusPage abhiBusPage = new AbhiBusPage(driver);
		reportingFlag = abhiBusPage.verifyHomePageLables();

		String screenShotPath = genericPage.captureScreenShot("Verify page lables");

		if (reportingFlag == null) {

			ReportParams.reportChildParams("Verify page lables", "Unknown error, Review required!",
					ReportParams.UNKNOWN, screenShotPath);
		} else {
			if (reportingFlag.equals(Boolean.TRUE)) {

				ReportParams.reportChildParams("Verify page lables", "Verified", ReportParams.PASS, screenShotPath);
			}
			if (reportingFlag.equals(Boolean.FALSE)) {

				ReportParams.reportChildParams("Verify page lables", "not matched", ReportParams.FAIL, screenShotPath);
			}
		}

	}

	@Then("create Customized report <testCaseName>")

	public void createReport(@Named("testCaseName") String test) {
		System.out.println("childnode status  list ");
		for (String status : ReportParams.childNodesStatusList) {
			System.out.println(status);
		}
		for (String description : ReportParams.childNodesDescriptionList) {
			System.out.println(description);
		}
		int i = 0;
		// childInfoMap.put(childNodesDescriptionList.get(childNodesDescriptionList.size()-1),
		// childNodesStatusList.get(childNodesStatusList.size()-1));
		for (Entry<String, List<String>> childinfo : ReportParams.childInfoMap.entrySet()) {

			String key = childinfo.getKey().toString();
			List<String> value = childinfo.getValue();
			System.out.println("<KEY>: " + key + " <VALUE DESCRIPTION> : " + value.get(i) + " <VALUE STATUS> : "
					+ value.get(i + 1));
			System.out.println("ScreenshotPath " + value.get(i + 2));
			i = i + 3;

		}
		ExtentReportTest extentReportTest = new ExtentReportTest(test, ReportParams.childInfoMap);
		extentReportTest.extentReport();
	}

	@Given("enquire for seat availabilty")
	public void searchSeatAvailability() {
		AbhiBusPage abhiBusPage = new AbhiBusPage(driver);
		reportingFlag = abhiBusPage.searchForSeats();

		String screenShotPath = genericPage.captureScreenShot("enquire for seat availabilty");

		if (reportingFlag == null) {

			ReportParams.reportChildParams("enquire for seat availabilty", "Unknown error, Review required!",
					ReportParams.UNKNOWN, screenShotPath);
		} else {
			if (reportingFlag.equals(Boolean.TRUE)) {

				ReportParams.reportChildParams("enquire for seat availabilty", "Enquired", ReportParams.PASS,
						screenShotPath);
			}
			if (reportingFlag.equals(Boolean.FALSE)) {

				ReportParams.reportChildParams("enquire for seat availabilty", "Problem while enquiry",
						ReportParams.FAIL, screenShotPath);
			}
		}

	}

	@When("check whether it is going to search result page")
	public void checkSearchResultUI() {
		AbhiBusPage abhiBusPage = new AbhiBusPage(driver);
		reportingFlag = abhiBusPage.checkSearchResultPage();

		String screenShotPath = genericPage.captureScreenShot("check whether it is going to search result page");

		if (reportingFlag == null) {

			ReportParams.reportChildParams("check whether it is going to search result page",
					"Unknown error, Review required!", ReportParams.UNKNOWN, screenShotPath);
		} else {
			if (reportingFlag.equals(Boolean.TRUE)) {

				ReportParams.reportChildParams("check whether it is going to search result page",
						"Yes this is search result page", ReportParams.PASS, screenShotPath);
			}
			if (reportingFlag.equals(Boolean.FALSE)) {

				ReportParams.reportChildParams("check whether it is going to search result page",
						"This is not the search result page", ReportParams.FAIL, screenShotPath);
			}
		}

	}

	@When("Verify page title")
	public void getAndVerifyPageTitle() {
		AbhiBusPage abhiBusPage = new AbhiBusPage(driver);
		reportingFlag = abhiBusPage.verifyPageTile();

		String screenShotPath = genericPage.captureScreenShot("Verify page title");

		if (reportingFlag == null) {

			ReportParams.reportChildParams("Verify page title", "Unknown error, Review required!", ReportParams.UNKNOWN,
					screenShotPath);
		} else {
			if (reportingFlag.equals(Boolean.TRUE)) {

				ReportParams.reportChildParams("Verify page title", "Page titles matched", ReportParams.PASS,
						screenShotPath);
			}
			if (reportingFlag.equals(Boolean.FALSE)) {

				ReportParams.reportChildParams("Verify page title",
						"Actual page title din't match with expected page title", ReportParams.FAIL, screenShotPath);
			}
		}

	}
	
	@AfterScenario(uponType=ScenarioType.EXAMPLE)
	public void closeOperation()
	{
		driver.close();
		
		
		
	}

}
