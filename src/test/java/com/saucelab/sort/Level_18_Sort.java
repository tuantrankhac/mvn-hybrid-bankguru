package com.saucelab.sort;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.saucelab.InventoryPageObject;
import pageObjects.saucelab.LoginPageObject;
import pageObjects.saucelab.PageGenerator;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Level_18_Sort extends BaseTest{
	WebDriver driver;
	LoginPageObject loginPage;
	InventoryPageObject inventoryPage;
	String username, password;
	
	@Parameters ({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition: Open browser " + browserName + " and url " + appUrl);
		driver = getBrowserDriver(browserName, appUrl);
		
		username = "standard_user";
		password = "secret_sauce";
		
		loginPage = PageGenerator.getLoginPage(driver);
		loginPage.enterToUsernameTextbox(username);
		loginPage.enterToPasswordTextbox(password);
		inventoryPage = loginPage.clickToLoginButton();
	}
	
	@Test
	public void Sort_01_Name() {
		inventoryPage.selectItemInSortDropdown("Name (A to Z)");
		verifyTrue(inventoryPage.isProductNameSortAsc());
		
		inventoryPage.selectItemInSortDropdown("Name (Z to A)");
		verifyTrue(inventoryPage.isProductNameSortDesc());
	}

	@Test
	public void Sort_02_Price() {
		inventoryPage.selectItemInSortDropdown("Price (low to high)");
		verifyTrue(inventoryPage.isProductPriceSortAsc());
		
		inventoryPage.selectItemInSortDropdown("Price (high to low)");
		verifyTrue(inventoryPage.isProductPriceSortDesc());
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		cleanBrowserAndDriver();
	}
}
