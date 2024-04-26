package pageUIs.user.nopcommerce;

public class UserBasePageUI {
	public static final String MY_ACCOUNT_LINK =  "//a[text()='My account']";
	public static final String ORDER_LINK =  "//div[@class='footer']//a[text()='Orders']";
	public static final String SEARCH_LINK =  "//a[text()='Search']";
	
	public static final String DYNAMIC_PAGE_FOOTER = "//div[@class='footer']//a[text()='%s']";
	public static final String DYNAMIC_PAGE_HEADER = "//div[@class='header']//a[text()='%s']";
	public static final String DYNAMIC_RADIO_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "//select[@name='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "//button[text()='%s']";
	
}
