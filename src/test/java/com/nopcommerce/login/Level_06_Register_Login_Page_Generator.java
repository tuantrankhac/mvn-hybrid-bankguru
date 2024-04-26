package com.nopcommerce.login;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.user.nopcommerce.HomePageObject;
import pageObjects.user.nopcommerce.LoginPageObject;
import pageObjects.user.nopcommerce.PageGeneratorManager;
import pageObjects.user.nopcommerce.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_06_Register_Login_Page_Generator extends BaseTest{
	WebDriver driver;
	
	String emailAddress;
	
	@Parameters ({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		emailAddress = "test" + generateEmail();
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		homePage = PageGeneratorManager.getHomePage(driver);
		
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToRegisterButton();
		
		Assert.assertTrue(registerPage.isMessageErrorFirstnameDisplayed());
		Assert.assertTrue(registerPage.isMessageErrorLastnameDisplayed());
		Assert.assertTrue(registerPage.isMessageErrorEmailDisplayed());
		Assert.assertTrue(registerPage.isMessageErrorPasswordDisplayed());
		Assert.assertTrue(registerPage.isMessageErrorConfirmPasswordDisplayed());
	
	}
	
	@Test
	public void TC_02_Register_Invalid_Email() {
		registerPage.clickToGenderMaleRadioButton();
		
		registerPage.enterToFirstnameTextbox("Lio");
		
		registerPage.enterToLastnameTextbox("Mio");
		
		registerPage.enterToEmailTextbox("123@123#");
		
		registerPage.enterToPasswordTextbox("123456");
		
		registerPage.enterToCfPasswordTextbox("123456");
		
		registerPage.clickToRegisterButton();
		
		Assert.assertTrue(registerPage.isMessageWrongEmailDisplayed());
	}

	@Test
	public void TC_03_Register_Success() {
		registerPage.refreshPage();
		
		registerPage.clickToGenderMaleRadioButton();
		
		registerPage.enterToFirstnameTextbox("Lio");
		
		registerPage.enterToLastnameTextbox("Mio");
		
		registerPage.enterToEmailTextbox(emailAddress);
		
		registerPage.enterToPasswordTextbox("123456");
		
		registerPage.enterToCfPasswordTextbox("123456");
		
		registerPage.clickToRegisterButton();
		
		Assert.assertTrue(registerPage.isMessageSuccessRegisterDisplayed());
		
		homePage = registerPage.clickToContinueButton();
	}
	
	@Test
	public void TC_04_Register_Existing_Email() {
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.enterToFirstnameTextbox("Lio");
		
		registerPage.enterToLastnameTextbox("Mio");
		
		registerPage.enterToEmailTextbox(emailAddress);
		
		registerPage.enterToPasswordTextbox("123456");
		
		registerPage.enterToCfPasswordTextbox("123456");
		
		registerPage.clickToRegisterButton();
		
		Assert.assertTrue(registerPage.isMessageExistEmailDisplayed());
		
	}
	
	@Test
	public void TC_05_Login_Account_With_Invalid_Password() {		
		loginPage = registerPage.clickToLoginLink();		
		
		loginPage.enterToEmailTextbox(emailAddress);
		
		loginPage.enterToPasswordTextbox("123321");
		
		loginPage.clickToLoginButton();
		
		Assert.assertTrue(loginPage.isMessageInvalidPasswordDisplayed());
		
	}
	
	@Test
	public void TC_06_Login_Account_Success() {
		loginPage.refreshPage();
		
		loginPage.enterToEmailTextbox(emailAddress);
		
		loginPage.enterToPasswordTextbox("123456");
		
		loginPage.clickToLoginButton();
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
}
