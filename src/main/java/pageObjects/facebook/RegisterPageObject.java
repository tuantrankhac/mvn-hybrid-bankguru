package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.RegisterPageUI;


public class RegisterPageObject extends BasePage{
	WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isEmailTextboxDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		return isElementDisplayed(driver, RegisterPageUI.EMAIL_TEXTBOX);
	}
	
	public boolean isConfirmEmailTextboxDisplayed() {
		return isElementDisplayed(driver, RegisterPageUI.CONFIRM_EMAIL_TEXTBOX);
	}

	public void clickToCreatNewAccountButton() {
		waitForElementClickable(driver, RegisterPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, RegisterPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		
	}

	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public void clickToClosePopup() {
		waitForElementClickable(driver, RegisterPageUI.CLOSE_BUTTON);
		clickToElement(driver, RegisterPageUI.CLOSE_BUTTON);
	}

}