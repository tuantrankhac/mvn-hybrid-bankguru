package org.magento.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.magento.HomePageObject;
import pageObjects.magento.LoginPageObject;
import pageObjects.magento.MyDashboardPageObject;

public class Level_04_Register_Login_Multiple_Browser extends BaseTest{
	WebDriver driver;
	
	String emailAddress;
	
	@Parameters ({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		emailAddress = "test" + generateEmail();
	}

	@Test
	public void TC_01_Login_Empty() {	
		homePage = new HomePageObject(driver);
		homePage.clickToMyAccountLink();
		
		loginPage = new LoginPageObject(driver);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageEmptyEmail(), "This is a required field.");
		Assert.assertEquals(loginPage.getErrorMessageEmptyPassword(), "This is a required field.");
	}
	
	@Test 
	public void TC_02_Login_Invalid_Email() {
		loginPage.refreshCurrentPage(driver);
				
		loginPage.loginToSystem("123@456.789", "123456");
		Assert.assertEquals(loginPage.getErrorMessageInvalidEmail(), "Please enter a valid email address. For example johndoe@domain.com.");
		
	}

	@Test(description = "Password less than 6 chars")
	public void TC_03_Login_Invalid_Password() {
		loginPage.refreshCurrentPage(driver);
		
		loginPage.loginToSystem("test3343@qa.team", "123");
		Assert.assertEquals(loginPage.getErrorMessageInvalidPassword(), "Please enter 6 or more characters without leading or trailing spaces.");
		
	}
	
	@Test
	public void TC_04_Login_Incorrect_Email() {
		loginPage.refreshCurrentPage(driver);
		
		loginPage.loginToSystem("test3355@qa.team", "123456");
		Assert.assertEquals(loginPage.getErrorMessageIncorrectEmail(), "Invalid login or password.");
	}
	
	@Test
	public void TC_05_Login_Incorrect_Password() {		
		loginPage.refreshCurrentPage(driver);
		
		loginPage.loginToSystem("test3343@qa.team", "123321");
		Assert.assertEquals(loginPage.getErrorMessageIncorrectPassword(), "Invalid login or password.");

	}
	
	@Test
	public void TC_06_Login_Valid_Email_Password() {
		loginPage.refreshCurrentPage(driver);
		
		loginPage.loginToSystem("test3343@qa.team", "123456");
		
		myDashboardPage = new MyDashboardPageObject(driver);
		Assert.assertTrue(myDashboardPage.isDashboardDisplayed());

	}
	
	
	public String generateEmail() {
		Random rand = new Random();
		return rand.nextInt(9999) + "@qa.team";
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboardPage;
}
