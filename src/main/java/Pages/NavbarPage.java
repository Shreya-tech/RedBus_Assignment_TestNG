package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NavbarPage {

	public WebDriver driver;

	// constructor initializing driver.
	public NavbarPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/*
	 * ---------------------- All element locators
	 */

	@FindBy(how = How.XPATH, using = "//*[@class = \"redbus-logo home-redirect\"]")
	private WebElement redBusLogo;

	@FindBy(how = How.ID, using = "redBus")
	private WebElement busTicketsLink;

	@FindBy(how = How.ID, using = "cars")
	private WebElement rPoolLink;

	@FindBy(how = How.ID, using = "redBus Bus Hire")
	private WebElement busHireLink;

	@FindBy(how = How.LINK_TEXT, using = "Help")
	private WebElement helpLink;
	
	@FindBy(how = How.XPATH, using = "//*[text() = 'Print/SMS Ticket']")
	private WebElement printTicketButton;
	
	@FindBy(how = How.XPATH, using = "//*[text() = 'Cancel Ticket']")
	private WebElement cancelTicketButton;

	
	/*
	 * ---------- All Functions related to elements
	 */

	public void clickOnRedBusLogo() {

		redBusLogo.click();
	}

	public void clickOnBusTicketsLink() {

		busTicketsLink.click();
	}

	public void clickOnBusHireLink() {

		busHireLink.click();
	}

	public void clickOnRPoolLink() {

		rPoolLink.click();
	}

	// --------- recheck.
	public void clickOnHelpLink() {

		helpLink.click();
	}
	
	// ----- recheck
	public void clickOnPrintTicketLink() {
		
		printTicketButton.click();
	}
	
	public void clickOnCancelTicketButton() {
		
		cancelTicketButton.click();
	}
	


}
