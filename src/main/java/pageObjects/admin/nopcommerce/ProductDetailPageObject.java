package pageObjects.admin.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.nopcommerce.ProductDetailPageUI;
import pageUIs.admin.nopcommerce.ProductSearchPageUI;

public class ProductDetailPageObject extends BasePage{
	WebDriver drvier;
	public ProductDetailPageObject(WebDriver driver) {
		this.drvier = driver;
	}
	public void clickToExpandPanelByName(String panelName) {
		//1 - get tag div attribute
		//2 - if not contains (collapsed-card) -> không lmj 
		//3 - if contains -> click
		waitForElementVisible(drvier, ProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME, panelName);
		String toogleIconStatus = getElementAttribute(drvier, ProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME, "class", panelName);
		if(toogleIconStatus.contains("collapsed-card")) {
			waitForElementClickable(drvier, ProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME, panelName);
			clickToElement(drvier, ProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME, panelName);
		}
		
		
	}
	public boolean isPictureUploadedSuccessByFileName(String string) {
		// TODO Auto-generated method stub
		return false;
	}
	public void enterToAltTextbox(String altValue) {
		waitForElementVisible(drvier, ProductDetailPageUI.ALT_TEXTBOX);
		sendkeyToElement(drvier, ProductDetailPageUI.ALT_TEXTBOX, altValue);
	}
	public void enterToTitleTextbox(String titleValue) {
		waitForElementVisible(drvier, ProductDetailPageUI.TITLE_TEXTBOX);
		sendkeyToElement(drvier, ProductDetailPageUI.TITLE_TEXTBOX, titleValue);
		
	}
	public void enterToDisplayOrderTextbox(String displayOrderValue) {
		waitForElementVisible(drvier, ProductDetailPageUI.DISPLAY_ORDER_TEXTBOX);
		sendkeyToElement(drvier, ProductDetailPageUI.DISPLAY_ORDER_TEXTBOX, displayOrderValue);

	}
	
	public boolean isPictureImageDisplayed(String imageName, String displayOrder, String imageAlt, String imageTitle) {
		imageName = imageName.replace(" ", "-").toLowerCase();
		waitForElementVisible(drvier, ProductDetailPageUI.PICTURE_TABLE_BY_IMAGE_INFO, imageName, displayOrder, imageAlt, imageTitle);
		return isElementDisplayed(drvier, ProductDetailPageUI.PICTURE_TABLE_BY_IMAGE_INFO, imageName, displayOrder, imageAlt, imageTitle);
	}
	public ProductSearchPageObject clickToSaveButtonByFormName() {
		waitForElementClickable(drvier, ProductDetailPageUI.SAVE_BUTTON);
		clickToElement(drvier, ProductDetailPageUI.SAVE_BUTTON);
		return PageGeneratorManager.getProductSeachPage(drvier);
	}
	public boolean isPictureImageUpdated(String productImageName, String productName) {
		productImageName = productImageName.replace(" ", "-").toLowerCase();
		waitForElementVisible(drvier, ProductSearchPageUI.PRODUCT_IMAGE_BY_PRODUCT_NAME, productName, productImageName);
		return isElementDisplayed(drvier, ProductSearchPageUI.PRODUCT_IMAGE_BY_PRODUCT_NAME, productName, productImageName);
	}
	public void clickToDeleteButtonAtPictureName(String productTitle) {
		waitForElementClickable(drvier, ProductDetailPageUI.DELETE_BUTTON_BY_IMAGE_TITLE, productTitle);
		clickToElement(drvier, ProductDetailPageUI.DELETE_BUTTON_BY_IMAGE_TITLE, productTitle);
		
		acceptAlert(drvier);
	}

	public void clickToEditButton() {
		waitForElementClickable(drvier, ProductDetailPageUI.EDIT_BUTTON_AT_PICTURE);
		clickToElement(drvier, ProductDetailPageUI.EDIT_BUTTON_AT_PICTURE);
	}
	public void clickToUpdateButton(String titlevalue) {
		waitForElementClickable(drvier, ProductDetailPageUI.UPDATE_BUTTON, titlevalue);
		clickToElement(drvier, ProductDetailPageUI.UPDATE_BUTTON, titlevalue);
	}
	
}
