package com.facebook.register;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.PageGeneratorManager;
import pageObjects.facebook.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Level_12_Register_Login_Assert_Verify extends BaseTest{
	WebDriver driver;
	String emailAddress, password;
	
	RegisterPageObject registerPage;
	
	@Parameters ({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		registerPage = PageGeneratorManager.getRegisterPage(driver);
	}
	
	@Test
	public void Register_01_Assert() {
		registerPage.clickToCreatNewAccountButton();
		
		verifyTrue(registerPage.isEmailTextboxDisplayed());
		
		registerPage.enterToEmailTextbox("test2307@qa.team");
		registerPage.sleepInSecond(2);
		
		verifyTrue(registerPage.isConfirmEmailTextboxDisplayed());
		
		registerPage.enterToEmailTextbox("");
		registerPage.sleepInSecond(2);
		
		verifyFalse(registerPage.isConfirmEmailTextboxDisplayed());
		
		registerPage.clickToClosePopup();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
