package com.nopcommerce.common;

import org.testng.annotations.Test;


import commons.BaseTest;
import pageObjects.user.nopcommerce.HomePageObject;
import pageObjects.user.nopcommerce.LoginPageObject;
import pageObjects.user.nopcommerce.MyAccountPageObject;
import pageObjects.user.nopcommerce.OrderPageObject;
import pageObjects.user.nopcommerce.PageGeneratorManager;
import pageObjects.user.nopcommerce.RegisterPageObject;
import pageObjects.user.nopcommerce.SearchPageObject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class Common_01_Login extends BaseTest{
	WebDriver driver;
	String emailAddress;
	String password;
	public static Set<Cookie> loginPageCookie;
	
	@Parameters ({"browser", "url"})
	@BeforeTest
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition: Open browser '" + browserName + "' and url '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		emailAddress = "test" + generateEmail();
		password = "123456";

		log.info("Common_01 - Step 01: Click to Register link");
		
		homePage = PageGeneratorManager.getHomePage(driver);
		
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		
		log.info("Common_01 - Step 02: Verify error message at Firstname textbox");
		verifyTrue(registerPage.isMessageErrorFirstnameDisplayed());
		
		log.info("Common_01 - Step 03: Verify error message at Lastname textbox");
		verifyTrue(registerPage.isMessageErrorLastnameDisplayed());
		
		log.info("Common_01 - Step 04: Verify error message at Email textbox");
		verifyTrue(registerPage.isMessageErrorEmailDisplayed());
		
		log.info("Common_01 - Step 05: Verify error message at Password textbox");
		verifyTrue(registerPage.isMessageErrorPasswordDisplayed());
		
		log.info("Common_01 - Step 06: Verify error message at Confirm password textbox");
		verifyTrue(registerPage.isMessageErrorConfirmPasswordDisplayed());
	
		log.info("Common_01 - Step 07: Click to Male radio button");
		registerPage.clickToGenderMaleRadioButton();
		
		log.info("Common_01 - Step 08: Enter to Firstname textbox");
		registerPage.enterToFirstnameTextbox("Lio");
		
		log.info("Common_01 - Step 09: Enter to Lasttname textbox");
		registerPage.enterToLastnameTextbox("Mio");
		
		log.info("Common_01 - Step 10: Enter to Email textbox with value " + emailAddress);
		registerPage.enterToEmailTextbox(emailAddress);
		
		log.info("Common_01 - Step 11: Enter to Password textbox with value " + password);
		registerPage.enterToPasswordTextbox(password);
		
		log.info("Common_01 - Step 12: Enter to Confirm password textbox with value " + password);
		registerPage.enterToCfPasswordTextbox(password);
		
		log.info("Common_01 - Step 13: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Common_01 - Step 14: Verify success message is displayed");	
		verifyTrue(registerPage.isMessageSuccessRegisterDisplayed());
		
		log.info("Common_01 - Step 15: Click to Continue button");	
		homePage = registerPage.clickToContinueButton();

		log.info("Common_01 - Step 16: Click to Login link");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Common_01 - Step 17: Enter to Email textbox with value " + emailAddress);
		loginPage.enterToEmailTextbox(emailAddress);
		
		log.info("Common_01 - Step 18: Enter to Password textbox with value " + password);
		loginPage.enterToPasswordTextbox(password);
		
		log.info("Common_01 - Step 19: Click to Login button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Common_01 - Step 20: Get all login page cookies");
		loginPageCookie = homePage.getAllCookies(driver);
		
		cleanBrowserAndDriver();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	SearchPageObject searchPage;
	MyAccountPageObject myAccountPage;
	OrderPageObject orderPage;

}
