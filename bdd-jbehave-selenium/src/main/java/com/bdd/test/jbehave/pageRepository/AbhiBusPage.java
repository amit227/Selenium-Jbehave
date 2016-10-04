package com.bdd.test.jbehave.pageRepository;

import java.util.NoSuchElementException;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbhiBusPage {
	WebDriver driverAbhiBusPage = null;
	Boolean reportingFlag = null;

	public AbhiBusPage(WebDriver driver) {
		driverAbhiBusPage = driver;

	}

	public Boolean login(String userName, String password)

	{
		reportingFlag = null;

		try {
			driverAbhiBusPage.findElement(By.xpath(".//*[@id='AccLogin']/span/a")).click();
			GenericPage.delayTimer(2000);

			driverAbhiBusPage.findElement(By.id("EmailID")).sendKeys(userName);
			driverAbhiBusPage.findElement(By.id("LoginPassword")).sendKeys(password);
			driverAbhiBusPage.findElement(By.id("SignINAjx")).click();
			GenericPage.delayTimer(2000);

			reportingFlag = Boolean.TRUE;
		} catch (Exception e) {
			// TODO Auto-generated catch block

			reportingFlag = null;
			e.printStackTrace();

		}
		return reportingFlag;

	}

	public Boolean verifyHomePageLables() {
		reportingFlag = null;

		try {
			String homeLinkText = driverAbhiBusPage.findElement(By.linkText("Home")).getText();
			String printTicketText = driverAbhiBusPage.findElement(By.linkText("Print Ticket")).getText();
			String cancelTicketText = driverAbhiBusPage.findElement(By.linkText("Cancel Ticket")).getText();

			if (StringUtils.containsIgnoreCase(homeLinkText, "Home")
					&& StringUtils.containsIgnoreCase(printTicketText, "Print Ticket")
					&& StringUtils.containsIgnoreCase(cancelTicketText, "Cancel Ticket")) {

				System.out.println("verified");
				reportingFlag = Boolean.TRUE;
			} else {
				System.out.println("one or more  lable from top header not matched");
				reportingFlag = Boolean.FALSE;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			reportingFlag = null;
			e.printStackTrace();
		}

		return reportingFlag;

	}

	public Boolean searchForSeats() {

		reportingFlag = null;
		try {
			driverAbhiBusPage.findElement(By.id("source")).sendKeys("Pune");
			GenericPage.delayTimer(1000);
			driverAbhiBusPage.findElement(By.xpath(".//ul[@id='ui-id-1']/li[contains(., 'Pune')]")).click();

			driverAbhiBusPage.findElement(By.id("destination")).sendKeys("Nagpur");
			GenericPage.delayTimer(1000);
			driverAbhiBusPage.findElement(By.xpath(".//ul[@id='ui-id-2']/li[contains(., 'Nagpur')]")).click();

			driverAbhiBusPage.findElement(By.id("datepicker1")).click();
			GenericPage.delayTimer(1000);
			driverAbhiBusPage.findElement(By.linkText("29")).click();
			GenericPage.delayTimer(1000);
			driverAbhiBusPage.findElement(By.linkText("Search")).click();

			reportingFlag = Boolean.TRUE;

		} catch (NoSuchElementException nse) {

			nse.printStackTrace();
			reportingFlag = Boolean.FALSE;
		}

		catch (Exception e) {

			e.printStackTrace();
		}

		return reportingFlag;
	}

	public Boolean checkSearchResultPage() {

		reportingFlag = null;
		String expectedPageTitle = "Pune to Nagpur Bus Tickets at Abhibus.com";
		String actualPageTitle = null;

		try {
			actualPageTitle = driverAbhiBusPage.getTitle();

			if (StringUtils.containsIgnoreCase(expectedPageTitle, actualPageTitle)) {
				reportingFlag = Boolean.TRUE;
				System.out.println("expectedPageTitle" + expectedPageTitle);
				System.out.println("actualPageTitle" + actualPageTitle);
				System.out.println("yes search result page titles matched");

			} else {
				reportingFlag = Boolean.FALSE;
				System.out.println(" search result page titles din't match");

			}
		} catch (Exception nse) {

			nse.printStackTrace();
			reportingFlag = Boolean.FALSE;
		}

		System.out.println("expectedPageTitle" + expectedPageTitle);
		System.out.println("actualPageTitle" + actualPageTitle);

		return reportingFlag;
	}

	public Boolean verifyPageTile() {
		String expectedPageTitile = "Some wrong page titile";
		String actualPageTitle = driverAbhiBusPage.getTitle();

		try {
			if (StringUtils.containsIgnoreCase(actualPageTitle, expectedPageTitile)) {
				reportingFlag = Boolean.TRUE;
				System.out.println("Page Titles  matched");
			} else {
				reportingFlag = Boolean.FALSE;
				System.out.println("Page Titles not matched");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			reportingFlag = null;
			e.printStackTrace();
		}

		return reportingFlag;
	}
}
