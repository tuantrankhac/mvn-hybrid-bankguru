package pageObjects.magento;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.magento.MyDashboardPageUI;

public class MyDashboardPageObject extends BasePage {
	private WebDriver driver;

	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDashboardDisplayed() {
		waitForElementVisible(driver, MyDashboardPageUI.HEADER_TEXT_MY_DASHBOARD);
		return isElementDisplayed(driver, MyDashboardPageUI.HEADER_TEXT_MY_DASHBOARD);
	}
	
}
