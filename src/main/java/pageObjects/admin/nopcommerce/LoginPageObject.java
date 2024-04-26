package pageObjects.admin.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.nopcommerce.LoginPageUI;

public class LoginPageObject extends BasePage{
	WebDriver drvier;
	public LoginPageObject(WebDriver driver) {
		this.drvier = driver;
	}
	public void enterToEmailTextbox(String email) {
		waitForElementVisible(drvier, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(drvier, LoginPageUI.EMAIL_TEXTBOX, email);
	}
	
	public void enterToPaswordTextbox(String password) {
		waitForElementVisible(drvier, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(drvier, LoginPageUI.PASSWORD_TEXTBOX, password);

	}
	public DashboardPageObject clickToLoginButton() {
		waitForElementClickable(drvier, LoginPageUI.LOGIN_BUTTON);
		clickToElement(drvier, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getDashboardPage(drvier);
	}
	
}
