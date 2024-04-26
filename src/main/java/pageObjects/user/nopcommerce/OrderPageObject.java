package pageObjects.user.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.nopcommerce.MyAccountPageUI;
import pageUIs.user.nopcommerce.OrderPageUI;

public class OrderPageObject extends BasePage{
	private WebDriver driver;
	
	public OrderPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
