//package com.nopcommerce.login;
//
//import org.testng.annotations.Test;
//
//import com.relevantcodes.extentreports.LogStatus;
//
//import commons.BaseTest;
//import pageObjects.user.nopcommerce.HomePageObject;
//import pageObjects.user.nopcommerce.LoginPageObject;
//import pageObjects.user.nopcommerce.MyAccountPageObject;
//import pageObjects.user.nopcommerce.OrderPageObject;
//import pageObjects.user.nopcommerce.PageGeneratorManager;
//import pageObjects.user.nopcommerce.RegisterPageObject;
//import pageObjects.user.nopcommerce.SearchPageObject;
//import reportConfig.ExtentManager;
//import takeScreenshot.TestListener;
//
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Listeners;
//import org.testng.annotations.Parameters;
//
//import java.lang.reflect.Method;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterClass;
//
//public class Level_13_Register_Login_Log_ExtentReport_V2 extends BaseTest{
//	WebDriver driver;
//	String emailAddress;
//	String password;
//	
//	@Parameters ({"browser", "url"})
//	@BeforeClass
//	public void beforeClass(String browserName, String appUrl) {
//		driver = getBrowserDriver(browserName, appUrl);
//		emailAddress = "test" + generateEmail();
//		password = "123456";
//	}
//
//	@Test
//	public void TC_01_Register_Empty_Data(Method method) {
//		ExtentManager.startTest(method.getName(), "TC_01_Register_Empty_Data");
//		ExtentManager.getTest().log(LogStatus.INFO, "Register 01 - Step 01: Click to Register link");
//		
//		homePage = PageGeneratorManager.getHomePage(driver);
//		
//		registerPage = homePage.clickToRegisterLink();
//		registerPage.clickToRegisterButton();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register 01 - Step 02: Verify error message at Firstname textbox");
//		verifyTrue(registerPage.isMessageErrorFirstnameDisplayed());
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register 01 - Step 03: Verify error message at Lastname textbox");
//		verifyTrue(registerPage.isMessageErrorLastnameDisplayed());
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register 01 - Step 04: Verify error message at Email textbox");
//		verifyTrue(registerPage.isMessageErrorEmailDisplayed());
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register 01 - Step 05: Verify error message at Password textbox");
//		verifyTrue(registerPage.isMessageErrorPasswordDisplayed());
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register 01 - Step 06: Verify error message at Confirm password textbox");
//		verifyTrue(registerPage.isMessageErrorConfirmPasswordDisplayed());
//	
//		ExtentManager.endTest();
//	}
//	
//	@Test
//	public void TC_02_Register_Success(Method method) {
//		ExtentManager.getTest().log(LogStatus.INFO, "Register 02 - Step 01: Click to Male radio button");
//		registerPage.clickToGenderMaleRadioButton();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register 02 - Step 02: Enter to Firstname textbox");
//		registerPage.enterToFirstnameTextbox("Lio");
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register 02 - Step 03: Enter to Lasttname textbox");
//		registerPage.enterToLastnameTextbox("Mio");
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register 02 - Step 04: Enter to Email textbox with value " + emailAddress);
//		registerPage.enterToEmailTextbox(emailAddress);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register 02 - Step 05: Enter to Password textbox with value " + password);
//		registerPage.enterToPasswordTextbox(password);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register 02 - Step 06: Enter to Confirm password textbox with value " + password);
//		registerPage.enterToCfPasswordTextbox(password);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register 02 - Step 07: Click to Register button");
//		registerPage.clickToRegisterButton();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register 02 - Step 08: Verify success message is displayed");	
//		verifyFalse(registerPage.isMessageSuccessRegisterDisplayed());
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register 02 - Step 09: Click to Continue button");	
//		homePage = registerPage.clickToContinueButton();
//		ExtentManager.endTest();
//	}
//
//	@Test
//	public void TC_03_Login(Method method) {
//		ExtentManager.getTest().log(LogStatus.INFO, "Login 01 - Step 01: Click to Login link");
//		loginPage = homePage.clickToLoginLink();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Login 01 - Step 02: Enter to Email textbox with value " + emailAddress);
//		loginPage.enterToEmailTextbox(emailAddress);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Login 01 - Step 03: Enter to Password textbox with value " + password);
//		loginPage.enterToPasswordTextbox(password);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Login 01 - Step 04: Click to Login button");
//		loginPage.clickToLoginButton();
//
//		ExtentManager.endTest();
//	}
//	
//	@AfterClass
//	public void afterClass() {
//		driver.quit();
//	}
//	
//	HomePageObject homePage;
//	LoginPageObject loginPage;
//	RegisterPageObject registerPage;
//	SearchPageObject searchPage;
//	MyAccountPageObject myAccountPage;
//	OrderPageObject orderPage;
//
//}
