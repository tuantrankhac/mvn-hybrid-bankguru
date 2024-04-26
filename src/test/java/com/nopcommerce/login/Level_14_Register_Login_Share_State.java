package com.nopcommerce.login;

import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Login;

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

public class Level_14_Register_Login_Share_State extends BaseTest{
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
	public void TC_01_Login(Method method) {
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Login_01 - Step 02: Set login page cookie");
		homePage.setAllCookies(driver, Common_01_Login.loginPageCookie);
		homePage.sleepInSecond(5);
		homePage.refreshCurrentPage(driver);
		
		homePage.sleepInSecond(5);
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
