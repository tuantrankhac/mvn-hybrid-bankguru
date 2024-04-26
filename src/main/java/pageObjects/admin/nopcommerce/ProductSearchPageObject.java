package pageObjects.admin.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.nopcommerce.ProductSearchPageUI;

public class ProductSearchPageObject extends BasePage{
	WebDriver drvier;
	public ProductSearchPageObject(WebDriver driver) {
		this.drvier = driver;
	}
	public void enterToProductNameTextbox(String productName) {
		waitForElementVisible(drvier, ProductSearchPageUI.PRODUCT_NAME_TEXTBOX);
		sendkeyToElement(drvier, ProductSearchPageUI.PRODUCT_NAME_TEXTBOX, productName);
	}
	public void clickToSearchButton() {
		waitForElementClickable(drvier, ProductSearchPageUI.SEARCH__BUTTON);
		clickToElement(drvier, ProductSearchPageUI.SEARCH__BUTTON);
	}
	public ProductDetailPageObject clickToEditButtonByProductName(String productName) {
		waitForElementClickable(drvier, ProductSearchPageUI.EDIT_BUTTON_BY_PRODUCT_NAME, productName);
		clickToElement(drvier, ProductSearchPageUI.EDIT_BUTTON_BY_PRODUCT_NAME, productName);
		return PageGeneratorManager.getProductDetailPage(drvier);
	}
	public boolean isSuccessMessageDisplayed(String messageName) {
		waitForElementVisible(drvier, ProductSearchPageUI.SUCCESS_MESSAGE_NAME, messageName);
		return isElementDisplayed(drvier, ProductSearchPageUI.SUCCESS_MESSAGE_NAME, messageName);
	}
	
}

