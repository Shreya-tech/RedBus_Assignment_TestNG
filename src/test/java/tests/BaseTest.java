package tests;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.Connections;
import Base.DockerClass;
import Utils.ConfigReader;
import Utils.ExcelReader;
import Utils.Screenshots;

public class BaseTest {

	// Creating Logs for BaseTest
	public final static Logger log = Logger.getLogger(BaseTest.class);

	// creating extent variables.
	public static ExtentReports extent;
	public static ExtentTest extentTest;

	// Excel File Test Data Reader
	public static ExcelReader reader = null;
	static {
		// Exception Handling for Excel File
		try {

			reader = new ExcelReader(
					System.getProperty("user.dir") + ConfigReader.prop.getProperty("WorkbookLocation"));

		} catch (Exception e) {

			log.error(e.getMessage());
		}
	}

	// creating a variable driver to use across tests
	public static WebDriver driver;

	// Method for implicit wait (globally)
	public long Implicit_Wait() {
		String implicitlyWait = ConfigReader.prop.getProperty("ImplicitWait");
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the config.prop file.");
	}

	// setting driver
	@BeforeMethod
	public void DriverSetUp() throws MalformedURLException {

		log.info("================= Setting Driver =================");
		String headlessOption = ConfigReader.prop.getProperty("HeadlessOption");
		String browserType = ConfigReader.prop.getProperty("type");

		if (ConfigReader.prop.getProperty("DockerMode").equalsIgnoreCase("yes")) {
			log.info("Running with Doker with Headless mode: " + headlessOption + "\tBrowser Type: " + browserType);
			driver = DockerClass.runInDocker();

		} else {
			log.info("Running without Doker with Headless mode: " + headlessOption + "\tBrowser Type: " + browserType);
			driver = Connections.intializeWebdriver();
		}

		// driver = Connections.intializeWebdriver();
		// driver = DokerClass.runInDocker();
		log.info("== opening url");
		// Connections.openBrowser();
		driver.get(ConfigReader.prop.getProperty("url"));
	}

	@BeforeSuite
	public void setExtent() {
		extent = new ExtentReports(".\\Reports\\ExtentReport.html");
		extent.addSystemInfo("UserNameAutomation", "Shreya");
	}

	@AfterMethod
	public void attachScreenshot(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			log.info("**Taking ScreenShot");
			String screenshotPath = Screenshots.takeScreenShot(driver, result.getName());
			log.info("ScreenShot path is: " + screenshotPath);
			log.info("Screenshot taken");
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test case passed successfully");
		}
		extent.endTest(extentTest);
	}

	@AfterMethod(dependsOnMethods = "attachScreenshot")
	public void CloseDriver() {
		log.info("================= Closing Driver =================");
		if (ConfigReader.prop.getProperty("DockerMode").equalsIgnoreCase("yes")) {
			DockerClass.closeDocker();
		} else {
			Connections.closeBrowser();
		}

		// Connections.closeBrowser();
		// DokerClass.closeDocker();
		log.info("== closed!");
	}

	@AfterSuite
	public void endExtent() {
		extent.flush();
		extent.close();
	}
}
