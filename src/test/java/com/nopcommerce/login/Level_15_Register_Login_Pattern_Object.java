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


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Level_15_Register_Login_Pattern_Object extends BaseTest{
	WebDriver driver;
	String emailAddress, password, date, month, year;
	
	@Parameters ({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition: Open browser " + browserName + " and url " + appUrl);
		driver = getBrowserDriver(browserName, appUrl);
		emailAddress = "test" + generateEmail();
		password = "123456";
		date = "20";
		month = "July";
		year = "1999";
	}
	
	@Test
	public void TC_01_Register_Success() {
		log.info("Register 01 - Step 01: Click to Register link");
		
		homePage = PageGeneratorManager.getHomePage(driver);
		
		homePage.openHeaderPageByName(driver, "Register");
		
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		log.info("Register 02 - Step 01: Click to Male radio button");
		
		registerPage.clickToRadioButtonByID(driver, "gender-male");
		
		log.info("Register 02 - Step 02: Select item in date/month/year dropdown");
		registerPage.selectDropdownByName(driver, "DateOfBirthDay", date);
		registerPage.selectDropdownByName(driver, "DateOfBirthMonth", month);
		registerPage.selectDropdownByName(driver, "DateOfBirthYear", year);
		
		log.info("Register 02 - Step 03: Enter to Firstname textbox");		
		registerPage.enterToTextboxByID(driver,"FirstName", "Lio");
		
		log.info("Register 02 - Step 04: Enter to Lasttname textbox");
		registerPage.enterToTextboxByID(driver, "LastName", "Mio");
		
		log.info("Register 02 - Step 05: Enter to Email textbox with value " + emailAddress);
		registerPage.enterToTextboxByID(driver, "Email", emailAddress);
		
		log.info("Register 02 - Step 06: Enter to Password textbox with value " + password);
		registerPage.enterToTextboxByID(driver, "Password", password);
		
		log.info("Register 02 - Step 07: Enter to Confirm password textbox with value " + password);
		registerPage.enterToTextboxByID(driver, "ConfirmPassword", password);

		log.info("Register 02 - Step 08: Click to Register button");
		registerPage.clickToButtonByText(driver, "Register");
		
		log.info("Register 02 - Step 09: Verify success message is displayed");	
		verifyTrue(registerPage.isMessageSuccessRegisterDisplayed());
		
		log.info("Register 02 - Step 10: Click to Continue button");	
		homePage = registerPage.clickToContinueButton();
	}

	@Test
	public void TC_02_Login() {
		log.info("Login 01 - Step 01: Click to Login link");
		homePage.openHeaderPageByName(driver, "Log in");
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("Login 01 - Step 02: Enter to Email textbox with value " + emailAddress);
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToTextboxByID(driver, "Email", emailAddress);
		
		log.info("Login 01 - Step 03: Enter to Password textbox with value " + password);
		loginPage.enterToTextboxByID(driver, "Password", password);
		
		log.info("Login 01 - Step 04: Click to Login button");
		loginPage.clickToButtonByText(driver, "Log in");

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
