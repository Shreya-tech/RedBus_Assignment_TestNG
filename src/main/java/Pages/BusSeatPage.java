package Pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BusSeatPage {

	public WebDriver driver;

	// constructor initializing driver.
	public BusSeatPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/*
	 * ---------------------- All elements
	 */

	// Element of view seat button
	@FindBy(how = How.XPATH, using = "//*[@class=\"clearfix m-top-16\"]//*[text()=\"View Seats\"]")
	private WebElement viewSeats;

	// Element of view seat button
	@FindBy(how = How.XPATH, using = "//*[@class=\"clearfix m-top-16\"]//*[text()=\"HIDE SEATS\"]")
	private WebElement hideSeats;

	// Element for Assertion
	@FindBy(how = How.XPATH, using = "//*[@id=\"rt_16729044\"]/div/div/div/div[1]/div/h3")
	private WebElement checktext;

	// Element for seat selection
	@FindBy(how = How.TAG_NAME, using = "canvas")
	private WebElement seat;

	/*
	 * ---------------------- All Methods with respect to elements
	 */

	public void clickOnViewSeatsButton() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", viewSeats);
//		viewSeats.click();
	}

	public String getTextForViewSeat() {
		return hideSeats.getText();
	}

	public void clickOnHideSeatsButton() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", hideSeats);
//		hideSeats.click();
	}

	public String getTextForHideSeat() {
		return viewSeats.getText();
	}

	public boolean isCanvas() {
		return seat.isDisplayed();
	}
	
}
