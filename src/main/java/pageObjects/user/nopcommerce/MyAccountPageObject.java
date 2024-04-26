package pageObjects.user.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.nopcommerce.MyAccountPageUI;
import pageUIs.user.nopcommerce.SearchPageUI;

public class MyAccountPageObject extends BasePage{
	private WebDriver driver;
	
	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}


}
