package tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.NavbarPage;
import Utils.CommonFunctions;

/*
 * Search Test page includes following scenarios:
 * 1.	Valid Scenario : Click on Red Bus Logo
 * 2.	Valid Scenario : Click on Bus Tickets Link
 * 3.	Valid Scenario : Click on Bus Hire Link
 * 4.	Valid Scenario : Click on rPool Link
 * 5.	Valid Scenario : Click on Cancel Ticket Link
 * 
 */

public class NavbarTest extends BaseTest {

	// initializing variable for test name.
	String testname;
	String sheetname = "NavbarPageScenarios";

	NavbarPage nav = new NavbarPage(driver);

	@Test
	public void ClickOnLogo() {

		testname = "Valid Scenario : Click on Red Bus Logo";
		log.info(testname);
		extentTest = extent.startTest(testname, testname + " started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetname, testname);

		String expectedData = testData.get("Expected Data");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// if execution required field is no
		CommonFunctions.toCheckExecutionRequired(executionRequired);

		// ----- Test Start
		NavbarPage nav = new NavbarPage(driver);

		nav.clickOnRedBusLogo();
		log.info("RedBusLogo was clicked");
		extentTest.log(LogStatus.INFO, "RedBusLogo was clicked");

		// assertion
		String Actual = driver.getTitle();
		Assert.assertEquals(Actual, expectedData);
		log.info("User is on Home page");
		extentTest.log(LogStatus.INFO, "User is on Home page");

	}

	@Test
	public void ClickOnBusTickets() {

		testname = "Valid Scenario : Click on Bus Tickets Link";
		log.info(testname);
		extentTest = extent.startTest(testname, testname + " started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetname, testname);

		String expectedData = testData.get("Expected Data");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// if execution required field is no
		CommonFunctions.toCheckExecutionRequired(executionRequired);

		// ----- Test Start
		NavbarPage nav = new NavbarPage(driver);

		nav.clickOnBusTicketsLink();
		log.info("Bus Tickets Link was clicked");
		extentTest.log(LogStatus.INFO, "Bus Tickets was clicked");

		// assertion
		String Actual = driver.getTitle();
		Assert.assertEquals(Actual, expectedData);
		log.info("User is on Bus Tickets page");
		extentTest.log(LogStatus.INFO, "User is on Bus Tickets page");

	}

	@Test
	public void ClickOnBusHire() {

		testname = "Valid Scenario : Click on Bus Hire Link";
		log.info(testname);
		extentTest = extent.startTest(testname, testname + " started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetname, testname);

		String expectedData = testData.get("Expected Data");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// if execution required field is no
		CommonFunctions.toCheckExecutionRequired(executionRequired);

		// ----- Test Start
		NavbarPage nav = new NavbarPage(driver);

		nav.clickOnBusHireLink();
		log.info("Bus Hire Link was clicked");
		extentTest.log(LogStatus.INFO, "Bus Hire was clicked");

		// assertion
		String Actual = driver.getTitle();
		Assert.assertEquals(Actual, expectedData);
		log.info("User is on Bus Hire page");
		extentTest.log(LogStatus.INFO, "User is on Bus Hire page");

	}

	@Test
	public void ClickOnRPool() {

		testname = "Valid Scenario : Click on rPool Link";
		log.info(testname);
		extentTest = extent.startTest(testname, testname + " started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetname, testname);

		String expectedData = testData.get("Expected Data");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// if execution required field is no
		CommonFunctions.toCheckExecutionRequired(executionRequired);

		// ----- Test Start
		NavbarPage nav = new NavbarPage(driver);

		nav.clickOnRPoolLink();
		log.info("rPool Link was clicked");
		extentTest.log(LogStatus.INFO, "rPool was clicked");

		// assertion
		String Actual = driver.getTitle();
		Assert.assertEquals(Actual, expectedData);
		log.info("User is on rPool page");
		extentTest.log(LogStatus.INFO, "User is on rPool page");

	}

	@Test
	public void clickOnCancelTicket() {

		testname = "Valid Scenario : Click on Cancel Ticket Link";
		log.info(testname);
		extentTest = extent.startTest(testname, testname + " started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetname, testname);

		String expectedData = testData.get("Expected Data");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// if execution required field is no
		CommonFunctions.toCheckExecutionRequired(executionRequired);

		// ----- Test Start
		NavbarPage nav = new NavbarPage(driver);

		nav.clickOnBusTicketsLink();
		log.info("Bus Tickets Link was clicked");
		extentTest.log(LogStatus.INFO, "Bus Tickets was clicked");

		nav.clickOnCancelTicketButton();
		log.info("Cancel Ticket Link was clicked");
		extentTest.log(LogStatus.INFO, "Cancel Ticket was clicked");

		// assertion
		String Actual = driver.getTitle();
		Assert.assertEquals(Actual, expectedData);
		log.info("User is on Cancel Ticket page");
		extentTest.log(LogStatus.INFO, "User is on Cancel Ticket page");

	}

}
