package com.nopcommerce.admin;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.admin.nopcommerce.DashboardPageObject;
import pageObjects.admin.nopcommerce.LoginPageObject;
import pageObjects.admin.nopcommerce.PageGeneratorManager;
import pageObjects.admin.nopcommerce.ProductDetailPageObject;
import pageObjects.admin.nopcommerce.ProductSearchPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_10_Admin_Upload_File extends BaseTest{
	WebDriver driver;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	ProductSearchPageObject productSearchPage;
	ProductDetailPageObject productDetailPage;
	
	String productName = "Adobe Photoshop CS4";
	String productImg = "picture_1.jpg";
	String productAlt = "Adobe";
	String productTitle = "PTS4";
	String productOrder = "1";
	
	
	@Parameters ({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterToEmailTextbox("admin@yourstore.com");
		loginPage.enterToPaswordTextbox("admin");
		dashboardPage =  loginPage.clickToLoginButton();
		
		dashboardPage.openSubmenuPageByName(driver, "Catalog", "Products");
		
		productSearchPage = PageGeneratorManager.getProductSeachPage(driver);
		
		productSearchPage.enterToProductNameTextbox("Adobe Photoshop CS4");
		
		productSearchPage.clickToSearchButton();
		
		productDetailPage =  productSearchPage.clickToEditButtonByProductName("Adobe Photoshop CS4");
	}

	@Test
	public void Admin_01_Upload_File() {
		productDetailPage.clickToExpandPanelByName("Multimedia");
		
		productDetailPage.uploadFileAtCardName(driver, "multimedia", productImg);
		productDetailPage.sleepInSecond(3);
		
		productDetailPage.clickToEditButton();
		
		productDetailPage.enterToAltTextbox(productAlt);
		
		productDetailPage.enterToTitleTextbox(productTitle);
		
		productDetailPage.enterToDisplayOrderTextbox(productOrder);
		
		productDetailPage.clickToUpdateButton("Update");
				
		Assert.assertTrue(productDetailPage.isPictureImageDisplayed(productName, productOrder, productAlt, productTitle));
		
		productSearchPage = productDetailPage.clickToSaveButtonByFormName();
		
		Assert.assertTrue(productSearchPage.isSuccessMessageDisplayed("The product has been updated successfully."));
		
		productSearchPage.enterToProductNameTextbox(productName);
		
		productSearchPage.clickToSearchButton();
		
		Assert.assertTrue(productDetailPage.isPictureImageUpdated(productName, productName));
		
		productDetailPage =  productSearchPage.clickToEditButtonByProductName(productName);
		
		productDetailPage.clickToExpandPanelByName("Multimedia");
		
		productDetailPage.clickToDeleteButtonAtPictureName(productTitle); 
		
		Assert.assertTrue(productDetailPage.isMessageDisplayInEmptyTable(driver, "productpictures"));

		productSearchPage = productDetailPage.clickToSaveButtonByFormName();
		
		productSearchPage.enterToProductNameTextbox(productName);
		
		productSearchPage.clickToSearchButton();

		Assert.assertTrue(productDetailPage.isPictureImageUpdated("default-image", productName));
	}
	


	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
