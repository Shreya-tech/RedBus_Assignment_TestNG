package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RedBusCarePage {

	public WebDriver driver;

	// constructor initializing driver.
	public RedBusCarePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/*
	 * ---------------------- All elements
	 */

	// Element of Source location
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'2000')]")
	private WebElement a200;

	// Element to Enter Amount
	@FindBy(how = How.CLASS_NAME, using = "rupee")
	private WebElement amount;

	// Element to click radio button
	@FindBy(how = How.XPATH, using = "//body/div[@id='reactContentMount']/div[1]/div[2]/div[2]/div[6]/ul[1]/li[2]/span[1]/ul[1]/li[1]/span[1]/input[1]")
	private WebElement radio;

	// Element to click Donate button
	@FindBy(how = How.CLASS_NAME, using = "donateBtn")
	private WebElement donate;

	// Element to for Assertions
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Select a payment option')]")
	private WebElement p_options;

	/*
	 * ---------------------- All Methods with respect to elements
	 */

	public void clickOn200AmountButton() {
		a200.click();
	}

	public String findAmount() {
		return amount.getAttribute("value");

	}

	public void enterAmount(String amt) {
		amount.sendKeys(amt);
	}

	public void clickOnDonateAnonymouslyButton() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", radio);
		//radio.click();
	}

	public boolean checkOnDonateAnonymouslyButton() {
		return radio.isSelected();
	}

	public void clickOnDonateButton() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", donate);
		//donate.click();
	}
	
	public String getTextForAssertion() {
		return p_options.getText();
	}
}
