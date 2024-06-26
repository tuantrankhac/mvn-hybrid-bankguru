package reportConfig;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import commons.BaseTest;

public class ReportNGListener implements ITestListener{
		String projectPath = System.getProperty("user.dir") + "/screenshotReportNG/";
		
		@Override
		public void onTestFailure(ITestResult result) {
			try {
				System.setProperty("org.uncommons.reportng.escape-output", "false");

				Object testClass = result.getInstance();
				WebDriver webDriver = ((BaseTest) testClass).getWebDriver();

				String screenshotPath = captureScreenshot(webDriver, result.getName());
				Reporter.getCurrentTestResult();
				Reporter.log("<br><a target=\"_blank\" href=\"file:///" + screenshotPath + "\">" + "<img src=\"file:///" + screenshotPath + "\" " + "height='100' width='150'/> " + "</a></br>");
				Reporter.setCurrentTestResult(null);
			} catch (NoSuchSessionException e) {
				e.printStackTrace();
			}
		}
		
		public String captureScreenshot(WebDriver driver, String screenshotName) {
			try {
				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
				File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				String screenPath = projectPath + screenshotName + "_" + formater.format(calendar.getTime()) + ".png";
				FileUtils.copyFile(source, new File(screenPath));
				return screenPath;
			} catch (IOException e) {
				System.out.println("Exception while taking screenshot: " + e.getMessage());
				return e.getMessage();
			}
		}

		@Override
		public void onTestStart(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub
			
		}
		
}
