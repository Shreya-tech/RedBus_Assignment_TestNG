package Base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.SkipException;

import Utils.ConfigReader;

public class DockerClass {

	// Creating Logs for BaseTest
	public final static Logger log = Logger.getLogger(DockerClass.class);

	public static RemoteWebDriver rdriver = null;
	static String sysPath = System.getProperty("user.dir");

	public static RemoteWebDriver runInDocker() throws MalformedURLException {

		URL url = new URL("http://localhost:4444/wd/hub");

		String bType = ConfigReader.prop.getProperty("type");

		switch (bType) {

		case "chrome":

			// for headless option
			String c_options = ConfigReader.prop.getProperty("HeadlessOption");
			Boolean c_opt = Boolean.parseBoolean(c_options.toLowerCase());

			ChromeOptions chromeoption = new ChromeOptions();

			chromeoption.setHeadless(c_opt);
			chromeoption.addArguments("--headless");
			chromeoption.addArguments("--disable-gpu");
			chromeoption.addArguments("--disable-dev-shm-usage");
			chromeoption.addArguments("--no-sandbox");
			chromeoption.addArguments("--allow-insecure-localhost");
			chromeoption.addArguments("user-agent=Chrome/91.0.4472.124");

			rdriver = new RemoteWebDriver(url, chromeoption);
			break;

		case "firefox":
			// for headless option
			String f_options = ConfigReader.prop.getProperty("HeadlessOption");
			Boolean f_opt = Boolean.parseBoolean(f_options.toLowerCase());

			FirefoxOptions firefoxoption = new FirefoxOptions();
			firefoxoption.setHeadless(f_opt);

			rdriver = new RemoteWebDriver(url, firefoxoption);
			break;

		default:
			log.info("Browser Not Supported or Wrong Input!, Skipping tests!");
			throw new SkipException("Skipping this exception");
		}

		rdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return rdriver;

	}

	public static void closeDocker() {
		rdriver.quit();
	}

}
