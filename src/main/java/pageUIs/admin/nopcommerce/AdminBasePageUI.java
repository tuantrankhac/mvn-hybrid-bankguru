package pageUIs.admin.nopcommerce;

public class AdminBasePageUI {
	public static final String MENU_LINK_BY_NAME = "//ul[@role='menu']/li/a/p[contains(text(),'%s')]";
	public static final String SUB_MENU_LINK_BY_NAME = "//ul[@class='nav nav-treeview' and @style]//p[contains(text(),'%s')]";
	public static final String UPLOAD_FILE_BY_CARD_NAME = "//div[@id='product-%s']//input[@type='file']";
	public static final String NO_DATA_MESSAGE_IN_TABLE = "//table[@id='%s-grid']//td[@class='dataTables_empty' and text()='No data available in table']";

}
