package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Utils.ConfigReader;

public class Connections {

	// creating a web-driver
	public static WebDriver driver;
	static Properties prop = ConfigReader.prop;
	static String sysPath = System.getProperty("user.dir");

	public static WebDriver intializeWebdriver() {

		String bType = prop.getProperty("type");

		switch (bType) {

		case "chrome":
			// for headless option
			String c_options = prop.getProperty("HeadlessOption");
			Boolean c_opt = Boolean.parseBoolean(c_options.toLowerCase());

			// initializing chrome driver
			System.setProperty("webdriver.chrome.driver", sysPath + prop.getProperty("chrome"));
			ChromeOptions chromeoption = new ChromeOptions();

			chromeoption.setHeadless(c_opt);
		    chromeoption.addArguments("user-agent=whatever you want");
		    
		    driver = new ChromeDriver(chromeoption); // driver to open Chrome
			break;

		case "firefox":
			// initializing firefox driver
			System.setProperty("webdriver.gecko.driver", sysPath + prop.getProperty("firefox"));
			// for headless option
			String f_options = prop.getProperty("HeadlessOption");
			Boolean f_opt = Boolean.parseBoolean(f_options.toLowerCase());
			FirefoxOptions foxoption = new FirefoxOptions();
			foxoption.setHeadless(f_opt);
			driver = new FirefoxDriver(foxoption); // driver to open firefox
			break;

		case "edge":
			// initializing edge driver
			System.setProperty("webdriver.edge.driver", sysPath + prop.getProperty("edge"));

			driver = new EdgeDriver(); // driver to open edge
			break;

		case "ie":
			// initializing edge driver
			System.setProperty("webdriver.ie.driver", sysPath + prop.getProperty("ie"));

			driver = new InternetExplorerDriver(); // driver to open edge
			break;

		default:
			System.out.println("wrong input");
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;

	}

	public static void openBrowser() {
		driver.get(prop.getProperty("url"));
	}

	public static void closeBrowser() {
		driver.quit();
	}
}
