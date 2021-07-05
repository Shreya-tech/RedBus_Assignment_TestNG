package Utils;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.NavbarPage;
import Pages.SearchPage;
import tests.BaseTest;

public class CommonFunctions extends BaseTest {

	// Creating Logs for CommonUtils
	public final static Logger log = Logger.getLogger(CommonFunctions.class);

	// Excel File Test Data Reader
	public static ExcelReader reader = null;

	// function toCheckExecutionRequired
	public static void toCheckExecutionRequired(String exe_Required) {

		// if execution required field is no
		if (exe_Required.equals("no")) {

			extentTest.log(LogStatus.WARNING, "Execution Required : " + exe_Required.toUpperCase());
			log.info("Execution required is no , skipping the test");
			throw new SkipException("Skipping this exception");
		}

		// if execution required field is empty
		if (exe_Required.equals("")) {

			extentTest.log(LogStatus.WARNING, "Execution Required : " + exe_Required.toUpperCase());
			log.info("Execution required is empty , skipping the test");
			throw new SkipException("Skipping this exception");
		}
	}

	// Search method
	public static void search(ExtentTest extentTest, String From, String To, String Date) {
		NavbarPage nav = new NavbarPage(driver);
		SearchPage search = new SearchPage(driver);

		nav.clickOnBusTicketsLink();
		log.info("Bus Ticket Link was clicked!");
		extentTest.log(LogStatus.INFO, "Bus Ticket Link was clicked!");

		search.WriteFromLocation(From);
		log.info("From Location was entered");
		extentTest.log(LogStatus.INFO, "From Location was entered");

		search.WriteToLocation(To);
		log.info("To Location was entered");
		extentTest.log(LogStatus.INFO, "To Location was entered");

		search.SelectDate(Date);
		log.info("Date is selected");
		extentTest.log(LogStatus.INFO, "Date is selected");

		search.ClickOnSearchButton();
		log.info("Search Button is clicked");
		extentTest.log(LogStatus.INFO, "Search Button is clicked");

	}
}
