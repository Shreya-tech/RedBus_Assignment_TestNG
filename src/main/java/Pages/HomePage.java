package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	// constructor initializing driver.
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/*
	 * ---------------------- All elements
	 */

	// Element of Source location
	@FindBy(how = How.XPATH, using = "//input[@id='src']")
	public WebElement fromLoc;

	// Element of destination
	@FindBy(how = How.XPATH, using = "//input[@id='dest']")
	public WebElement toLoc;

	// Element of calendar to dates
	@FindBy(how = How.XPATH, using = "//input[@id='onward_cal']")
	public WebElement Show_Date;

	// Element of calendar
	@FindBy(how = How.XPATH, using = "//tbody/tr[1]/td[3]")
	// @FindBy(how =How.CSS, using = "div.rb-calendar:nth-child(22)
	// table.rb-monthTable.first.last tbody:nth-child(1)
	// tr.rb-monthHeader:nth-child(1) td.next > button:nth-child(1)")
	public WebElement Swipe;

	// Element of calendar date
	@FindBy(how = How.XPATH, using = "//td[contains(text(),'16')]")
	public WebElement Date;

	// Element of search button
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/section[1]/div[2]/main[1]/section[1]/div[1]/div[2]/section[1]/div[1]/button[1]")
	public WebElement btn;

	// Element to click on Redbus care.
	@FindBy(how = How.XPATH, using = "//*[@id=\"offer_container\"]/li[2]")
	public WebElement care;

	/*
	 * ---------------------- All Methods with respect to elements
	 */

	public void writeFromLocation(String loc) {
		fromLoc.clear();
		fromLoc.sendKeys(loc);
		fromLoc.sendKeys(Keys.ENTER);
	}

	public void writeToLocation(String loc) {
		toLoc.clear();
		toLoc.sendKeys(loc);
		toLoc.sendKeys(Keys.ENTER);
	}

	public void selectDate() {
		Show_Date.click();
		Swipe.click();
		Date.click();
	}

	public void clickSearch() {
		btn.click();
	}

	public void clickOnRedbusCareCard() {
		care.click();

	}
}
