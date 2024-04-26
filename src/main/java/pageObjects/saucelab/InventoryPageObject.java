package pageObjects.saucelab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.saucelab.InventoryPageUI;

public class InventoryPageObject extends BasePage {
	WebDriver driver;

	public InventoryPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public void selectItemInSortDropdown(String itemText) {
		waitForElementClickable(driver, InventoryPageUI.SORT_DROPDOWN);
		selectDropdownByText(driver, InventoryPageUI.SORT_DROPDOWN, itemText);
	}

	public boolean isProductNameSortAsc() {
		List<WebElement> productNameElements = getListWebElement(driver, InventoryPageUI.PRODUCT_NAME_TEXT);
		
		List<String> productNameText = new ArrayList<String>();
		for (WebElement productName : productNameElements) {
			productNameText.add(productName.getText());
		}
		
		List<String> productNameTextClone = new ArrayList<String>(productNameText);
		Collections.sort(productNameTextClone);
		
		return productNameText.equals(productNameTextClone);
	}

	public boolean isProductNameSortDesc() {
		List<WebElement> productNameElements = getListWebElement(driver, InventoryPageUI.PRODUCT_NAME_TEXT);
		
		List<String> productNameText = new ArrayList<String>();
		for (WebElement productName : productNameElements) {
			productNameText.add(productName.getText());
		}
		
		List<String> productNameTextClone = new ArrayList<String>(productNameText);
		Collections.sort(productNameTextClone);
		Collections.reverse(productNameTextClone);
		
		return productNameText.equals(productNameTextClone);
	}

	public boolean isProductPriceSortAsc() {
		List<WebElement> productPriceElements = getListWebElement(driver, InventoryPageUI.PRODUCT_PRICE_TEXT);
		
		List<Float> productPriceValue = new ArrayList<Float>();
		for (WebElement productPrice : productPriceElements) {
			productPriceValue.add(Float.parseFloat(productPrice.getText().replace("$","")));
		}
		
		List<Float> productPriceValueClone = new ArrayList<Float>(productPriceValue);
		Collections.sort(productPriceValueClone);
		
		return productPriceValue.equals(productPriceValueClone);
	}

	public boolean isProductPriceSortDesc() {
		List<WebElement> productPriceElements = getListWebElement(driver, InventoryPageUI.PRODUCT_PRICE_TEXT);
		
		List<Float> productPriceValue = new ArrayList<Float>();
		for (WebElement productPrice : productPriceElements) {
			productPriceValue.add(Float.parseFloat(productPrice.getText().replace("$","")));
		}
		
		List<Float> productPriceValueClone = new ArrayList<Float>(productPriceValue);
		Collections.sort(productPriceValueClone);
		Collections.reverse(productPriceValueClone);
		
		return productPriceValue.equals(productPriceValueClone);
	
	}
}	
