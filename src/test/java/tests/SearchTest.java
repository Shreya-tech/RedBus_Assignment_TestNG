package tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.SearchPage;
import Utils.CommonFunctions;

/*
 * Search Test page includes following scenarios:
 * 1.	Valid Scenario: Search Busses
 * 2.	Valid scenario : Search Modification by changing date (clicking next)
 * 3.	Valid scenario : Search Modification by changing destination location
 * 4.	Valid scenario : Search Modification by swiping location
 * 5.	In-Valid scenario : Search Busses when destination input is invalid
 * 6.	In-Valid scenario : Search Busses when source location input is invalid
 * 7.	In-Valid scenario : Search Busses when date input is empty
 * 
 */

public class SearchTest extends BaseTest {

	String testname;
	String sheetname = "SearchPageScenarios";

	// All Valid Test Cases --
	@Test
	public void SearchBusses() {

		testname = "Valid scenario : Search Busses";
		log.info("----- " + testname);
		extentTest = extent.startTest(testname);

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetname, testname);

		String fromLocation = testData.get("From");
		String toLocation = testData.get("To");
		String dateVal = testData.get("Date");
		String expectedData = testData.get("Expected Data");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// if execution required field is no
		CommonFunctions.toCheckExecutionRequired(executionRequired);

		// ----- Test Start
		CommonFunctions.search(extentTest, fromLocation, toLocation, dateVal); // calling search function.

		// assertion
		String Actual = driver.getTitle();
		Assert.assertEquals(Actual, expectedData);
		log.info("User is on search page");
		extentTest.log(LogStatus.INFO, "User is on search page");

		log.info("----- Successfully completed " + testname);
	}

	@Test
	public void SearchModifyByDate() {

		testname = "Valid scenario : Search Modification by changing date (clicking next)";
		log.info("----- " + testname);
		extentTest = extent.startTest(testname);

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetname, testname);

		String fromLocation = testData.get("From");
		String toLocation = testData.get("To");
		String dateVal = testData.get("Date");
		String expectedData = testData.get("Expected Data");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// if execution required field is no
		CommonFunctions.toCheckExecutionRequired(executionRequired);

		// ----- Before Start
		CommonFunctions.search(extentTest, fromLocation, toLocation, dateVal); // calling search function.

		// ----- Test Start
		SearchPage search = new SearchPage(driver);

		search.ClickNextToModifyDate();
		log.info("Clicked on next date to modify date");
		extentTest.log(LogStatus.INFO, "Clicked on next date to modify date");

		// assertion
		String Actual = driver.getTitle();
		Assert.assertEquals(Actual, expectedData);
		log.info("User is on search page");
		extentTest.log(LogStatus.INFO, "User is on search page");

		log.info("----- Successfully completed " + testname);

	}

	@Test
	public void SearchModifyByLocation() {

		testname = "Valid scenario : Search Modification by changing destination location";
		log.info("----- " + testname);
		extentTest = extent.startTest(testname);

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetname, testname);

		String fromLocation = testData.get("From");
		String toLocation = testData.get("To");
		String dateVal = testData.get("Date");
		String expectedData = testData.get("Expected Data");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// if execution required field is no
		CommonFunctions.toCheckExecutionRequired(executionRequired);

		// ----- Before Start
		CommonFunctions.search(extentTest, fromLocation, toLocation, dateVal); // calling search function.

		// ----- Test Start
		SearchPage search = new SearchPage(driver);

		search.ClickOnModifyButton();
		log.info("Clicked on modify button");
		extentTest.log(LogStatus.INFO, "Clicked on modify button");

		search.ChangeDestinationLocation("Meerut");
		log.info("Destination location changed");
		extentTest.log(LogStatus.INFO, "Destination location changed");

		search.ClickOnSearchButtonToModify();
		log.info("Search Button is clicked");
		extentTest.log(LogStatus.INFO, "Search Button is clicked");

		// assertion
		String Actual = driver.getTitle();
		Assert.assertEquals(Actual, expectedData);
		log.info("User is on search page");
		extentTest.log(LogStatus.INFO, "User is on search page");

		log.info("----- Successfully completed " + testname);

	}

	@Test
	public void SearchModifyBySwipingLocation() {

		testname = "Valid scenario : Search Modification by swiping location";
		log.info("----- " + testname);
		extentTest = extent.startTest(testname);

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetname, testname);

		String fromLocation = testData.get("From");
		String toLocation = testData.get("To");
		String dateVal = testData.get("Date");
		String expectedData = testData.get("Expected Data");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// if execution required field is no
		CommonFunctions.toCheckExecutionRequired(executionRequired);

		// ----- Before Start
		CommonFunctions.search(extentTest, fromLocation, toLocation, dateVal); // calling search function.

		// ----- Test Start
		SearchPage search = new SearchPage(driver);

		search.ClickOnModifyButton();
		log.info("Clicked on modify button");
		extentTest.log(LogStatus.INFO, "Clicked on modify button");

		search.ClickOnSwipeButton();
		log.info("Swipe button is clicked");
		extentTest.log(LogStatus.INFO, "Swipe button is clicked");

		search.ClickOnSearchButtonToModify();
		log.info("Search Button is clicked");
		extentTest.log(LogStatus.INFO, "Search Button is clicked");

		// assertion
		String Actual = driver.getTitle();
		Assert.assertEquals(Actual, expectedData);
		log.info("User is on search page");
		extentTest.log(LogStatus.INFO, "User is on search page");

		log.info("----- Successfully completed " + testname);

	}

	// All In-Valid Test Cases
	@Test
	public void SearchBusseswithInvalidDestination() {

		testname = "In-Valid scenario : Search Busses when destination input is invalid";
		log.info("----- " + testname);
		extentTest = extent.startTest(testname);

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetname, testname);

		String fromLocation = testData.get("From");
		String toLocation = testData.get("To");
		String dateVal = testData.get("Date");
		String expectedData = testData.get("Expected Data");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// if execution required field is no
		CommonFunctions.toCheckExecutionRequired(executionRequired);

		// ----- Test Start
		CommonFunctions.search(extentTest, fromLocation, toLocation, dateVal); // calling search function.

		// assertion
		String Actual = driver.getTitle();
		Assert.assertEquals(Actual, expectedData);
		log.info("User is on search page");
		extentTest.log(LogStatus.INFO, "User is on search page");

		log.info("----- Successfully completed " + testname);
	}

	@Test
	public void SearchBusseswithInvalidSourceLocation() {

		testname = "In-Valid scenario : Search Busses when source location input is invalid";
		log.info("----- " + testname);
		extentTest = extent.startTest(testname);

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetname, testname);

		String fromLocation = testData.get("From");
		String toLocation = testData.get("To");
		String dateVal = testData.get("Date");
		String expectedData = testData.get("Expected Data");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// if execution required field is no
		CommonFunctions.toCheckExecutionRequired(executionRequired);

		// ----- Test Start
		CommonFunctions.search(extentTest, fromLocation, toLocation, dateVal); // calling search function.

		// assertion
		String Actual = driver.getTitle();
		Assert.assertEquals(Actual, expectedData);
		log.info("User is on search page");
		extentTest.log(LogStatus.INFO, "User is on search page");

		log.info("----- Successfully completed " + testname);
	}

	@Test
	public void SearchBusseswithInvalidDate() {

		testname = "In-Valid scenario : Search Busses when date input is empty";
		log.info("----- " + testname);
		extentTest = extent.startTest(testname);

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetname, testname);

		String fromLocation = testData.get("From");
		String toLocation = testData.get("To");
		String dateVal = testData.get("Date");
		String expectedData = testData.get("Expected Data");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// if execution required field is no
		CommonFunctions.toCheckExecutionRequired(executionRequired);

		// ----- Test Start
		CommonFunctions.search(extentTest, fromLocation, toLocation, dateVal); // calling search function.

		// assertion
		String Actual = driver.getTitle();
		Assert.assertEquals(Actual, expectedData);
		log.info("User is on search page");
		extentTest.log(LogStatus.INFO, "User is on search page");

		log.info("----- Successfully completed " + testname);
	}

}
