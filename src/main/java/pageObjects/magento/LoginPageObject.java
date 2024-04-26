package pageObjects.magento;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.magento.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

	public void loginToSystem(String email, String password) {
		inputToEmailTextbox(email);
		inputToPasswordTextbox(password);
		clickToLoginButton();
	}
	
	public String getErrorMessageEmptyEmail() {
		waitForElementVisible(driver, LoginPageUI.MESSAGE_EMPTY_EMAIL);
		return getElementText(driver, LoginPageUI.MESSAGE_EMPTY_EMAIL);
	}

	public String getErrorMessageEmptyPassword() {
		waitForElementVisible(driver, LoginPageUI.MESSAGE_EMPTY_PASSWORD);
		return getElementText(driver, LoginPageUI.MESSAGE_EMPTY_PASSWORD);
	}

	public String getErrorMessageInvalidEmail() {
		waitForElementVisible(driver, LoginPageUI.MESSAGE_INVALID_EMAIL);
		return getElementText(driver, LoginPageUI.MESSAGE_INVALID_EMAIL);
	}


	public String getErrorMessageInvalidPassword() {
		waitForElementVisible(driver, LoginPageUI.MESSAGE_INVALID_PASSWORD);
		return getElementText(driver, LoginPageUI.MESSAGE_INVALID_PASSWORD);

	}

	public String getErrorMessageIncorrectEmail() {
		waitForElementVisible(driver, LoginPageUI.MESSAGE_INCORRECT_EMAIL);
		return getElementText(driver, LoginPageUI.MESSAGE_INCORRECT_EMAIL);

	}

	public String getErrorMessageIncorrectPassword() {
		waitForElementVisible(driver, LoginPageUI.MESSAGE_INCORRECT_PASSWORD);
		return getElementText(driver, LoginPageUI.MESSAGE_INCORRECT_PASSWORD);
	}
	
}
