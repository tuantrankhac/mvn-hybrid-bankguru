package org.magento.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.magento.HomePageObject;
import pageObjects.magento.LoginPageObject;
import pageObjects.magento.MyDashboardPageObject;

public class Level_03_Register_Login_Page_Object{
	WebDriver driver;
	
	String objectPath = System.getProperty("user.dir");
	String emailAddress;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", objectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		emailAddress = "test" + generateEmail();
		driver.get("http://live.techpanda.org/");
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
