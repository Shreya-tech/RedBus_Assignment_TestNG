package tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.BusSeatPage;
import Utils.CommonFunctions;

/*
 * Search Test page includes following scenarios:
 * 1.	Valid scenario : Check the functionality of ViewSeat Button.
 * 2.	Valid scenario : Check the functionality of HideSeat Button.
 * 3.	Valid scenario : Check whether seat selection canvas is present or not.  // UI Testing
 * 
 */

public class BusSeatTest extends BaseTest {

	String testname;
	String sheetname = "BusSeatPageScenarios";

	// All Valid Test Cases --
	@Test
	public void ClickOnViewSeat() {

		testname = "Valid scenario : Check the functionality of ViewSeat Button";
		log.info("----- " + testname);
		extentTest = extent.startTest(testname);

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetname, testname);

		String expectedData = testData.get("Expected Data");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// if execution required field is no
		CommonFunctions.toCheckExecutionRequired(executionRequired);

		// ----- Before Test
		CommonFunctions.search(extentTest, "Agra", "Delhi", "27-Jul-2021"); // calling search function.

		// assertion
		String Actual = driver.getTitle();
		String Expected = "Search Bus Tickets";
		Assert.assertEquals(Actual, Expected);
		log.info("User is on search page");
		extentTest.log(LogStatus.INFO, "User is on search page");

		// ----- Test Start
		BusSeatPage seat = new BusSeatPage(driver);

		seat.clickOnViewSeatsButton();
		log.info("User clicked on ViewSeat Button");
		extentTest.log(LogStatus.INFO, "User clicked on ViewSeat Button");

		// assertion
		Actual = seat.getTextForViewSeat();
		Assert.assertEquals(Actual, expectedData);
		log.info("Assertion Successful");
		extentTest.log(LogStatus.INFO, "Assertion Successful");

		log.info("----- Successfully completed " + testname);
	}

	@Test
	public void ClickOnHideSeat() {

		testname = "Valid scenario : Check the functionality of HideSeat Button";
		log.info("----- " + testname);
		extentTest = extent.startTest(testname);

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetname, testname);

		String expectedData = testData.get("Expected Data");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// if execution required field is no
		CommonFunctions.toCheckExecutionRequired(executionRequired);

		// ----- Before Test
		CommonFunctions.search(extentTest, "Agra", "Delhi", "27-Jul-2021"); // calling search function.

		// assertion
		String Actual = driver.getTitle();
		String Expected = "Search Bus Tickets";
		Assert.assertEquals(Actual, Expected);
		log.info("User is on search page");
		extentTest.log(LogStatus.INFO, "User is on search page");

		// ----- Test Start
		BusSeatPage seat = new BusSeatPage(driver);

		seat.clickOnViewSeatsButton();
		log.info("User clicked on ViewSeat Button");
		extentTest.log(LogStatus.INFO, "User clicked on ViewSeat Button");

		seat.clickOnHideSeatsButton();
		log.info("User clicked on HideSeat Button");
		extentTest.log(LogStatus.INFO, "User clicked on ViewSeat Button");

		// assertion
		Actual = seat.getTextForHideSeat();
		Assert.assertEquals(Actual, expectedData);
		log.info("Assertion Successful");
		extentTest.log(LogStatus.INFO, "Assertion Successful");

		log.info("----- Successfully completed " + testname);
	}

	@Test
	public void CheckUIforSeatSelection() {

		testname = "Valid scenario : Check whether seat selection canvas is present or not";
		log.info("----- " + testname);
		extentTest = extent.startTest(testname);

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetname, testname);

		String executionRequired = testData.get("Execution Required").toLowerCase();

		// if execution required field is no
		CommonFunctions.toCheckExecutionRequired(executionRequired);

		// ----- Before Test
		CommonFunctions.search(extentTest, "Agra", "Delhi", "27-Jul-2021"); // calling search function.

		// assertion
		String Actual = driver.getTitle();
		String Expected = "Search Bus Tickets";
		Assert.assertEquals(Actual, Expected);
		log.info("User is on search page");
		extentTest.log(LogStatus.INFO, "User is on search page");

		// ----- Test Start
		BusSeatPage seat = new BusSeatPage(driver);

		seat.clickOnViewSeatsButton();
		log.info("User clicked on ViewSeat Button");
		extentTest.log(LogStatus.INFO, "User clicked on ViewSeat Button");

		// assertion
		Assert.assertTrue(seat.isCanvas());
		log.info("Assertion Successful Canvas is Present");
		extentTest.log(LogStatus.INFO, "Assertion Successful Canvas is Present");

		log.info("----- Successfully completed " + testname);
	}
}
