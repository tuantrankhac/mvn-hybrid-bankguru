package com.nopcommerce.login;

import org.testng.annotations.Test;


import commons.BaseTest;
import pageObjects.user.nopcommerce.HomePageObject;
import pageObjects.user.nopcommerce.LoginPageObject;
import pageObjects.user.nopcommerce.MyAccountPageObject;
import pageObjects.user.nopcommerce.OrderPageObject;
import pageObjects.user.nopcommerce.PageGeneratorManager;
import pageObjects.user.nopcommerce.RegisterPageObject;
import pageObjects.user.nopcommerce.SearchPageObject;
//import reportConfig.ExtentManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Level_13_Register_Login_Log_ReportNG extends BaseTest{
	WebDriver driver;
	String emailAddress;
	String password;
	
	@Parameters ({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition: Open browser " + browserName + " and url " + appUrl);
		driver = getBrowserDriver(browserName, appUrl);
		emailAddress = "test" + generateEmail();
		password = "123456";
	}

	@Test
	public void TC_01_Register_Empty_Data(Method method) {
		log.info("Register 01 - Step 01: Click to Register link");
		
		homePage = PageGeneratorManager.getHomePage(driver);
		
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		
		log.info("Register 01 - Step 02: Verify error message at Firstname textbox");
		verifyTrue(registerPage.isMessageErrorFirstnameDisplayed());
		
		log.info("Register 01 - Step 03: Verify error message at Lastname textbox");
		verifyTrue(registerPage.isMessageErrorLastnameDisplayed());
		
		log.info("Register 01 - Step 04: Verify error message at Email textbox");
		verifyTrue(registerPage.isMessageErrorEmailDisplayed());
		
		log.info("Register 01 - Step 05: Verify error message at Password textbox");
		verifyTrue(registerPage.isMessageErrorPasswordDisplayed());
		
		log.info("Register 01 - Step 06: Verify error message at Confirm password textbox");
		verifyTrue(registerPage.isMessageErrorConfirmPasswordDisplayed());
	
	}
	
	@Test
	public void TC_02_Register_Success(Method method) {
		log.info("Register 02 - Step 01: Click to Male radio button");
		registerPage.clickToGenderMaleRadioButton();
		
		log.info("Register 02 - Step 02: Enter to Firstname textbox");
		registerPage.enterToFirstnameTextbox("Lio");
		
		log.info("Register 02 - Step 03: Enter to Lasttname textbox");
		registerPage.enterToLastnameTextbox("Mio");
		
		log.info("Register 02 - Step 04: Enter to Email textbox with value " + emailAddress);
		registerPage.enterToEmailTextbox(emailAddress);
		
		log.info("Register 02 - Step 05: Enter to Password textbox with value " + password);
		registerPage.enterToPasswordTextbox(password);
		
		log.info("Register 02 - Step 06: Enter to Confirm password textbox with value " + password);
		registerPage.enterToCfPasswordTextbox(password);
		
		log.info("Register 02 - Step 07: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Register 02 - Step 08: Verify success message is displayed");	
		verifyFalse(registerPage.isMessageSuccessRegisterDisplayed());
		
		log.info("Register 02 - Step 09: Click to Continue button");	
		homePage = registerPage.clickToContinueButton();
	}

	@Test
	public void TC_03_Login(Method method) {
		log.info("Login 01 - Step 01: Click to Login link");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login 01 - Step 02: Enter to Email textbox with value " + emailAddress);
		loginPage.enterToEmailTextbox(emailAddress);
		
		log.info("Login 01 - Step 03: Enter to Password textbox with value " + password);
		loginPage.enterToPasswordTextbox(password);
		
		log.info("Login 01 - Step 04: Click to Login button");
		loginPage.clickToLoginButton();

	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		cleanBrowserAndDriver();
	}
	
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	SearchPageObject searchPage;
	MyAccountPageObject myAccountPage;
	OrderPageObject orderPage;

}
