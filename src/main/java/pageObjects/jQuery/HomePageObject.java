package pageObjects.jQuery;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;


public class HomePageObject extends BasePage{
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageByNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGING_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGING_BY_NUMBER, pageNumber);
	}

	public boolean isPageActivedByNumber(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGING_BY_NUMBER_ACTIVE, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGING_BY_NUMBER_ACTIVE, pageNumber);
	}

	public void inputToHeaderTextboxByName(String headerName, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_HEADER_TEXTBOX_BY_NAME, headerName);
		sendkeyToElement(driver, HomePageUI.HEADER_HEADER_TEXTBOX_BY_NAME, value, headerName);
		pressKeyToElement(driver, HomePageUI.HEADER_HEADER_TEXTBOX_BY_NAME, Keys.ENTER, headerName);
	}

	public void clickToIconByCountryName(String countryName, String iconAction) {
		waitForElementClickable(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName, iconAction);
		clickToElement(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName, iconAction);
	}

	public boolean isRowValueDisplayed(String female, String country, String male, String total) {
		waitForElementVisible(driver, HomePageUI.ROW_VALUE_BY_NAME, female, country, male, total);
		
		return isElementDisplayed(driver, HomePageUI.ROW_VALUE_BY_NAME, female, country, male, total);
	}

	public void inputToTextboxByRowNumber(String headerName, String rowIndex, String value) {
		int columIndex = getElementSize(driver, HomePageUI.HEADER_NAME_INDEX, headerName) + 1;
				
		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_ROW_INDEX, rowIndex, String.valueOf(columIndex));
		sendkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_ROW_INDEX, value, rowIndex, String.valueOf(columIndex));
	}

	public void clickToIconByRowNumber(String indexRow, String iconAction) {
		waitForElementClickable(driver, HomePageUI.ACTION_BUTTON_BY_ROW_INDEX, indexRow, iconAction);
		clickToElement(driver, HomePageUI.ACTION_BUTTON_BY_ROW_INDEX, indexRow, iconAction);
	}
	
}