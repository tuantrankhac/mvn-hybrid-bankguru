package com.hrm.employee;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.hrm.AddEmployeePO;
import pageObjects.hrm.DashboardPO;
import pageObjects.hrm.EmployeeListPO;
import pageObjects.hrm.LoginPO;
import pageObjects.hrm.PageGenerator;
import pageObjects.hrm.MyInfoPO;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Level_16_Live_Coding extends BaseTest {
	WebDriver driver;
	LoginPO loginPage;
	AddEmployeePO addEmployeePage;
	DashboardPO dashboardPage;
	EmployeeListPO employeeListPage;
	MyInfoPO myInfoPage;

	String employeeID, statusValue;
	String adminUser, adminPassword, empFirstName, empLastName, empUserName, empFullName, empPassword;
	String editEmpFirstName, editEmpLastName, editEmpGender, editEmpMaritalStatus, editEmpNationality;

	String avatarFilePath = GlobalConstants.UPLOAD_FILE_FOLDER + "picture_1.jpg";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition - Step 01: Open browser " + browserName + " and url " + appUrl);
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGenerator.getLoginPage(driver);

		statusValue = "Enabled";
		adminUser = "Admin";
		adminPassword = "admin123";
		empFirstName = "Lio";
		empLastName = "Mio";
		empFullName = empFirstName + " " + empLastName;
		empUserName = "lio" + generateNumber();
		empPassword = "Lio123456";

		editEmpFirstName = "Shi";
		editEmpLastName = "Ba";
		editEmpGender = "Male";
		editEmpMaritalStatus = "Single";
		editEmpNationality = "Vietnamese";

		log.info("Pre-Condition - Step 02: Login with Admin role");
		dashboardPage = loginPage.loginToSystem(driver, "username", "password", adminUser, adminPassword);
	}

	@Test
	public void Employee_01_Add_New_Employee() {
		log.info("Add_New - Step 01: Open 'Employee List' page");
		dashboardPage.openSingleSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage = PageGenerator.getEmployeeListPage(driver);

		log.info("Add_New - Step 02: Click to 'Add' button");
		addEmployeePage = employeeListPage.clickToAddButton();

		log.info("Add_New - Step 03: Enter valid info to 'First Name' textbox");
		addEmployeePage.enterEmployeeTextboxByName(driver, "firstName", empFirstName);

		log.info("Add_New - Step 04: Enter valid info to 'Last Name' textbox");
		addEmployeePage.enterEmployeeTextboxByName(driver, "lastName", empLastName);

		log.info("Add_New - Step 05: Click to 'Create Login Details' checkbox");
		addEmployeePage.clickToCreateLoginDetailButton();

		log.info("Add_New - Step 06: Enter valid info to 'User Name' textbox");
		addEmployeePage.enterCreateLoginDetailsTextboxByText(driver, "Username", empUserName);

		log.info("Add_New - Step 07: Enter valid info to 'Password' textbox");
		addEmployeePage.enterCreateLoginDetailsTextboxByText(driver, "Password", empPassword);

		log.info("Add_New - Step 08: Enter valid info to 'Confirm Password' textbox");
		addEmployeePage.enterCreateLoginDetailsTextboxByText(driver, "Confirm Password", empPassword);

		log.info("Add_New - Step 09: Select " + statusValue + " value in 'Status'");
		addEmployeePage.selectRadioButtonByValue(driver, statusValue);

		log.info("Add_New - Step 10: Click to 'Save' button");
		addEmployeePage.clickToSaveButtonByFormName(driver, "Add Employee");
		myInfoPage = PageGenerator.getInfoPage(driver);

		log.info("Add_New - Step 11: Open 'Employee List' page");
		myInfoPage.openSingleSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage = PageGenerator.getEmployeeListPage(driver);

		log.info("Add_New - Step 12: Enter valid info to 'Employee Name' textbox");
		employeeListPage.enterSeachTextboxByFieldName(driver, "Employee Name", empFullName);

		log.info("Add_New - Step 13: Click to 'Search' button");
		employeeListPage.clickToSearchButton();

//		log.info("Add_New - Step 14: Verify Employee infomation displayed at 'Result Table'");
//		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "Last Name", "1"), "Lio");
//		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "First (& Middle) Name", "1"), empFirstName);
	}

	@Test
	public void Employee_02_Upload_Avatar() {
		log.info("Upload_Avatar - Step 01: Click to 'Search' button");
		loginPage = employeeListPage.logoutToSystem(driver);
		dashboardPage = loginPage.loginToSystem(driver, "username", "password", empUserName, empPassword);

		log.info("Upload_Avatar - Step 02: Open Personal Detail page");
		dashboardPage.openMenuPage(driver, "My Info");
		myInfoPage = PageGenerator.getInfoPage(driver);

		log.info("Upload_Avatar - Step 03: Click to Change Photo image");
		myInfoPage.clickToChangePhotoImage();

		log.info("Upload_Avatar - Step 04: Upload new Avater image");
		myInfoPage.uploadImage(driver, avatarFilePath);

		log.info("Upload_Avatar - Step 05: Click to Save button");
		myInfoPage.clickToSaveButtonByFormName(driver, "Change Profile Picture");

		log.info("Upload_Avatar - Step 06: Verify succsess message is displayed");
		verifyTrue(myInfoPage.isSuccessMessageDisplayed(driver, "Successfully Updated"));

	}

	@Test
	public void Employee_03_Personal_Details() {
		log.info("Personal_Details - Step 01: Open 'Personal Details' tab at Side bar");
		myInfoPage.openTabAtSideBarByName("Personal Details");

		log.info("Personal_Details - Step 02: Verify 'Employee Id' textbox is disabled");
		myInfoPage.isFieldEnabledByLabel(driver, "Employee Id");

		log.info("Personal_Details - Step 03: Verify 'Driver's License Number' textbox is disabled");
		myInfoPage.isFieldEnabledByLabel(driver, "License Number");

		log.info("Personal_Details - Step 04: Verify 'Date of Birth' textbox is disabled");
		myInfoPage.isFieldEnabledByLabel(driver, "Date of Birth");

		log.info("Personal_Details - Step 05: Enter new value to 'First Name' textbox");
		myInfoPage.enterEmployeeTextboxByName(driver, "firstName", editEmpFirstName);
		
		log.info("Personal_Details - Step 06: Enter new value to 'Last Name' textbox");
		myInfoPage.enterEmployeeTextboxByName(driver, "lastName", editEmpLastName);
		
		log.info("Personal_Details - Step 07: Select new value to 'Gender' radio button");
		myInfoPage.selectRadioButtonByValue(driver, editEmpGender);

		log.info("Personal_Details - Step 08:  Click to 'Save' button at 'Personal Details' form");
		myInfoPage.clickToSaveButtonByFormName(driver, "Personal Details");

		log.info("Personal_Details - Step 09:  Verify success message is displayed");
		myInfoPage.isSuccessMessageDisplayed(driver, "Successfully Updated");

		log.info("Personal_Details - Step 10:  Verify 'First Name' textbox is updated success");
		verifyEquals(myInfoPage.getTextboxValueByName(driver, "firstName"), editEmpFirstName);

		log.info("Personal_Details - Step 11:  Verify 'Last Name' textbox is updated success");
		verifyEquals(myInfoPage.getTextboxValueByName(driver, "lastName"), editEmpLastName);

		log.info("Personal_Details - Step 12:  Verify 'Gender' textbox is updated success");
		verifyTrue(myInfoPage.isRadioButtonSelectedByValue(driver, editEmpGender));

	}
	
	@Test
	public void Employee_04_Contact_Details() {

	}

	@Test
	public void Employee_05_Emergency_Details() {

	}

	@Test
	public void Employee_06_Assigned_Dependents() {

	}

	@Test
	public void Employee_07_Edit_View_Job() {

	}

	@Test
	public void Employee_08_Edit_View_Salary() {

	}

	@Test
	public void Employee_09_Edit_View_Tax() {

	}

	@Test
	public void Employee_10_Qualifications() {

	}

	@Test
	public void Employee_11_Search_Employee() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		cleanBrowserAndDriver();
	}
}
