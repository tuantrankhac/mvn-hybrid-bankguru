package pageObjects.admin.nopcommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	private static LoginPageObject loginPage;
	private static DashboardPageObject dashboardPage;
	private static ProductSearchPageObject productSeachPage;
	private static ProductDetailPageObject productDetailPage;
	
	private PageGeneratorManager() {
		
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		if(loginPage == null) {
			loginPage = new LoginPageObject(driver);
		}
		return loginPage;
	}
	
	public static DashboardPageObject getDashboardPage(WebDriver driver) {
		if(dashboardPage == null) {
			dashboardPage = new DashboardPageObject(driver);
		}
		return dashboardPage;
	}
	
	public static ProductSearchPageObject getProductSeachPage(WebDriver driver) {
		if(productSeachPage == null) {
			productSeachPage = new ProductSearchPageObject(driver);
		}
		return productSeachPage;
	}
	
	public static ProductDetailPageObject getProductDetailPage(WebDriver driver) {
		if(productDetailPage == null) {
			productDetailPage = new ProductDetailPageObject(driver);
		}
		return productDetailPage;
	}
	
}
	
	
