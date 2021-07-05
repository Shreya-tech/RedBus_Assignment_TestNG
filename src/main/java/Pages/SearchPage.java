package Pages;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	public WebDriver driver;
	

	// constructor initializing driver.
	public SearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/*
	 * ---------------------- All element locators
	 */

	@FindBy(how = How.ID, using = "txtSource")
	private WebElement fromLoc;

	@FindBy(how = How.ID, using = "txtDestination")
	private WebElement toLoc;

	@FindBy(how = How.XPATH, using = "//input[@id='txtOnwardCalendar']")
	private WebElement date;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Search Buses']")
	private WebElement btn;

//	@FindBy(how = How.CLASS_NAME, using = "title f-bold")
//	private WebElement filter;
//	
	@FindBy(how = How.CLASS_NAME, using = "next")
	private WebElement nxtDate;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Modify')]")
	private WebElement modbtn;

	@FindBy(how = How.ID, using = "dest")
	private WebElement modLoc;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'SEARCH')]")
	private WebElement searchbtn;

	@FindBy(how = How.XPATH, using = "//span[@id='switchButton']")
	private WebElement swipebtn;
	
	
	/*
	 * ---------- All Functions related to elements
	 */

	public void WriteFromLocation(String loc) {
		fromLoc.clear();
		fromLoc.sendKeys(loc);
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fromLoc.sendKeys(Keys.ENTER);
	}

	public void WriteToLocation(String loc) {
		toLoc.clear();
		toLoc.sendKeys(loc);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		toLoc.sendKeys(Keys.ENTER);
	}

	public void SelectDate(String d) {
		date.sendKeys(d);
	}

	public void ClickOnSearchButton() {
		btn.click();
	}

//	public String GetTextFilter() {
//		String asrt = filter.getText();
//		return asrt;
//	}

	public void ClickNextToModifyDate() {
		nxtDate.click();
	}

	public void ClickOnModifyButton() {
		modbtn.click();
	}

	public void ChangeDestinationLocation(String loc) {
		modLoc.clear();
		modLoc.sendKeys(loc);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modLoc.sendKeys(Keys.ENTER);
	}
	
	public void ClickOnSearchButtonToModify() {
		searchbtn.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ClickOnSwipeButton() {
		swipebtn.click();
	}
}
