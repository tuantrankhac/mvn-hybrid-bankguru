package com.jquery.datatable;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_09_DataTable extends BaseTest{
	WebDriver driver;
	
	@Parameters ({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	public void Table_01_Paging() {
		
		homePage.openPageByNumber("15");
		Assert.assertTrue(homePage.isPageActivedByNumber("15"));
		
		homePage.openPageByNumber("7");
		Assert.assertTrue(homePage.isPageActivedByNumber("7"));
		
		homePage.openPageByNumber("20");
		Assert.assertTrue(homePage.isPageActivedByNumber("20"));
	}
	

	public void Table_02_Input_To_Header_Textbox() {
		homePage.inputToHeaderTextboxByName("Females", "276880");
		homePage.sleepInSecond(2);
		
		homePage.inputToHeaderTextboxByName("Country", "Albania");
		homePage.sleepInSecond(2);
		
		homePage.inputToHeaderTextboxByName("Males", "349238");
		homePage.sleepInSecond(2);
		homePage.refreshCurrentPage(driver);
	}	
		
	public void Table_03_Click_Icon() {	
		homePage.clickToIconByCountryName("Afghanistan", "remove");
		homePage.sleepInSecond(2);
		
		homePage.clickToIconByCountryName("Aruba", "remove");
		homePage.sleepInSecond(2);
		
		homePage.clickToIconByCountryName("Angola", "edit");
		homePage.sleepInSecond(2);
		homePage.refreshCurrentPage(driver);
		}
	
	public void Table_04_Verify_Row_values() {		
		homePage.inputToHeaderTextboxByName("Country", "AFRICA");
		Assert.assertTrue(homePage.isRowValueDisplayed("12253515", "AFRICA", "12599691", "24853148"));
		homePage.sleepInSecond(2);
		homePage.refreshCurrentPage(driver);
		
	}
	
	public void Table_05_Input_To_Row_Textbox() {
		homePage.inputToTextboxByRowNumber("Contact Person", "3", "Deep John");
		homePage.sleepInSecond(2);
		
		homePage.inputToTextboxByRowNumber("Order Placed", "2", "48432 Jefferson Str");
		homePage.sleepInSecond(2);
		
	}

	@Test
	public void Table_06_Click_To_Icon_At_Row() {
		homePage.clickToIconByRowNumber("2", "Move Up");
		homePage.sleepInSecond(2);
		
		homePage.clickToIconByRowNumber("2", "Remove Current Row");
		homePage.sleepInSecond(2);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	HomePageObject homePage;
}
