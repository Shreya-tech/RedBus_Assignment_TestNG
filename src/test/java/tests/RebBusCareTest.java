package tests;

import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.HomePage;
import Pages.RedBusCarePage;
import Utils.CommonFunctions;

/*
 * Search Test page includes following scenarios:
 * 1.	Valid scenario : Click on Red Bus Care Link on Home page
 * 2.	Valid scenario : Click on 2000 Amount button and check Functionality
 * 3.	Valid scenario : Click on Donate Anonymously button and check Functionality
 * 4.	Valid scenario : Enter Amount and click on Donate
 * 5.	In-Valid scenario : Clicking on Donate button without entering amount
 * 
 */

public class RebBusCareTest extends BaseTest {

	String testname;
	String sheetname = "RebBusCarePageScenarios";

	// All Valid Test Cases --
	@Test
	public void ClickOnRedbusCare() {

		testname = "Valid scenario : Click on Red Bus Care Link on Home page";
		log.info("----- " + testname);
		extentTest = extent.startTest(testname);

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetname, testname);

		String expectedData = testData.get("Expected Data");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// if execution required field is no
		CommonFunctions.toCheckExecutionRequired(executionRequired);

		// ----- Test Start
		HomePage home = new HomePage(driver);

		home.clickOnRedbusCareCard();
		log.info("Clicked on Red Bus Care Card Link");
		extentTest.log(LogStatus.INFO, "Clicked on Red Bus Care Card Link");

		// Holding all window handles in array list
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		// switch to new tab
		driver.switchTo().window(tabs.get(1));

		// Assertion
		String Actual = driver.getTitle();
		Assert.assertEquals(Actual, expectedData);
		log.info("User is on Red Bus Care Page");
		extentTest.log(LogStatus.INFO, "User is on Red Bus Care Page");

		log.info("----- Successfully completed " + testname);
	}

	@Test
	public void clickOn200Amount() {

		testname = "Valid scenario : Click on 2000 Amount button and check Functionality";
		log.info("----- " + testname);
		extentTest = extent.startTest(testname);

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetname, testname);

		String expectedData = testData.get("Expected Data");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// if execution required field is no
		CommonFunctions.toCheckExecutionRequired(executionRequired);

		// ----- Test Start
		HomePage home = new HomePage(driver);
		RedBusCarePage care = new RedBusCarePage(driver);

		home.clickOnRedbusCareCard();
		log.info("Clicked on Red Bus Care Card Link");
		extentTest.log(LogStatus.INFO, "Clicked on Red Bus Care Card Link");

		// Holding all window handles in array list
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		// switch to new tab
		driver.switchTo().window(tabs.get(1));

		// Assertion
		String Actual = driver.getTitle();
		String Expected = "redBus Cares - Supporting Bus drivers and helpers";
		Assert.assertEquals(Actual, Expected);
		log.info("User is on Red Bus Care Page");
		extentTest.log(LogStatus.INFO, "User is on Red Bus Care Page");

		care.clickOn200AmountButton();
		log.info("Clicked on Red Bus Care Card Link");
		extentTest.log(LogStatus.INFO, "Clicked on Red Bus Care Card Link");

		// Assertion
		Actual = care.findAmount();
		Assert.assertEquals(Actual, expectedData);
		log.info("Click on 2000 Amount Button is working.");
		extentTest.log(LogStatus.INFO, "Click on 2000 Amount Button is working.");

		log.info("----- Successfully completed " + testname);
	}

	@Test
	public void ClickOnDonateAnonymously() {

		testname = "Valid scenario : Click on Donate Anonymously button and check Functionality";
		log.info("----- " + testname);
		extentTest = extent.startTest(testname);

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetname, testname);

		String executionRequired = testData.get("Execution Required").toLowerCase();

		// if execution required field is no
		CommonFunctions.toCheckExecutionRequired(executionRequired);

		// ----- Test Start
		HomePage home = new HomePage(driver);
		RedBusCarePage care = new RedBusCarePage(driver);

		home.clickOnRedbusCareCard();
		log.info("Clicked on Red Bus Care Card Link");
		extentTest.log(LogStatus.INFO, "Clicked on Red Bus Care Card Link");

		// Holding all window handles in array list
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		// switch to new tab
		driver.switchTo().window(tabs.get(1));

		// Assertion
		String Actual = driver.getTitle();
		String Expected = "redBus Cares - Supporting Bus drivers and helpers";
		Assert.assertEquals(Actual, Expected);
		log.info("User is on Red Bus Care Page");
		extentTest.log(LogStatus.INFO, "User is on Red Bus Care Page");

		care.clickOnDonateAnonymouslyButton();
		log.info("Clicked on Donate Anonymously Button");
		extentTest.log(LogStatus.INFO, "Clicked on Donate Anonymously Button");

		// Assertion
		Assert.assertTrue(care.checkOnDonateAnonymouslyButton());
		log.info("Click on Donate Anonymously Button is working.");
		extentTest.log(LogStatus.INFO, "Click on Donate Anonymously Button is working.");

		log.info("----- Successfully completed " + testname);
	}

	@Test
	public void DonateAmount() {

		testname = "Valid scenario : Enter Amount and click on Donate";
		log.info("----- " + testname);
		extentTest = extent.startTest(testname);

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetname, testname);

		String amount = testData.get("Enter Amount");
		String expectedData = testData.get("Expected Data");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// if execution required field is no
		CommonFunctions.toCheckExecutionRequired(executionRequired);

		// ----- Test Start
		HomePage home = new HomePage(driver);
		RedBusCarePage care = new RedBusCarePage(driver);

		home.clickOnRedbusCareCard();
		log.info("Clicked on Red Bus Care Card Link");
		extentTest.log(LogStatus.INFO, "Clicked on Red Bus Care Card Link");

		// Holding all window handles in array list
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		// switch to new tab
		driver.switchTo().window(tabs.get(1));

		// Assertion
		String Actual = driver.getTitle();
		String Expected = "redBus Cares - Supporting Bus drivers and helpers";
		Assert.assertEquals(Actual, Expected);
		log.info("User is on Red Bus Care Page");
		extentTest.log(LogStatus.INFO, "User is on Red Bus Care Page");

		care.enterAmount(amount);
		log.info("Amount was entered");
		extentTest.log(LogStatus.INFO, "Amount was entered");

		care.clickOnDonateAnonymouslyButton();
		log.info("Clicked on Donate Anonymously Button");
		extentTest.log(LogStatus.INFO, "Clicked on Donate Anonymously Button");

		care.clickOnDonateButton();
		log.info("Clicked on Donate Button");
		extentTest.log(LogStatus.INFO, "Clicked on Donate Button");

		// Assertion
		Actual = care.getTextForAssertion();
		Assert.assertEquals(Actual, expectedData);
		log.info("Click on 200 Amount Button is working.");
		extentTest.log(LogStatus.INFO, "Click on 200 Amount Button is working.");

		log.info("----- Successfully completed " + testname);
	}

	// All In-Valid Test Cases --
	@Test
	public void ClickOnDonateInvalid() {

		testname = "In-Valid scenario : Clicking on Donate button without entering amount";
		log.info("----- " + testname);
		extentTest = extent.startTest(testname);

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetname, testname);

		String expectedData = testData.get("Expected Data");
		String executionRequired = testData.get("Execution Required").toLowerCase();
		
		// if execution required field is no
		CommonFunctions.toCheckExecutionRequired(executionRequired);
		
		// ----- Test Start
		HomePage home = new HomePage(driver);
		RedBusCarePage care = new RedBusCarePage(driver);

		home.clickOnRedbusCareCard();
		log.info("Clicked on Red Bus Care Card Link");
		extentTest.log(LogStatus.INFO, "Clicked on Red Bus Care Card Link");

		// Holding all window handles in array list
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		// switch to new tab
		driver.switchTo().window(tabs.get(1));

		// Assertion
		String Actual = driver.getTitle();
		String Expected = "redBus Cares - Supporting Bus drivers and helpers";
		Assert.assertEquals(Actual, Expected);
		log.info("User is on Red Bus Care Page");
		extentTest.log(LogStatus.INFO, "User is on Red Bus Care Page");

		care.clickOnDonateAnonymouslyButton();
		log.info("Clicked on Donate Anonymously Button");
		extentTest.log(LogStatus.INFO, "Clicked on Donate Anonymously Button");

		care.clickOnDonateButton();
		log.info("Clicked on Donate Button");
		extentTest.log(LogStatus.INFO, "Clicked on Donate Button");

		Alert alert = driver.switchTo().alert(); // switch to alert

		// Assertion
		Actual = driver.switchTo().alert().getText();
		Assert.assertEquals(Actual, expectedData);
		log.info("Click on 200 Amount Button is working.");
		extentTest.log(LogStatus.INFO, "Click on 200 Amount Button is working.");

		alert.accept();

		log.info("----- Successfully completed " + testname);
	}
}
