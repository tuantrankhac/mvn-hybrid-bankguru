package pageObjects.user.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.nopcommerce.SearchPageUI;

public class SearchPageObject extends BasePage{
	private WebDriver driver;
	
	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}


}
