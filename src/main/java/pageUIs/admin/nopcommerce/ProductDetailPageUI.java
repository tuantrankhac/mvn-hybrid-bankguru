package pageUIs.admin.nopcommerce;

public class ProductDetailPageUI {
	public static final String TOOGLE_ICON_BY_CARD_NAME = "//div[@class='card-title' and contains(string(),'%s')]/parent::div/parent::div";
	public static final String EDIT_BUTTON_AT_PICTURE = "//a[contains(@id,'buttonEdit')]";
	
	public static final String ALT_TEXTBOX = "//td[@data-columnname='OverrideAltAttribute']/input";
	public static final String TITLE_TEXTBOX = "//td[@data-columnname='OverrideTitleAttribute']/input";
	public static final String DISPLAY_ORDER_TEXTBOX = "//td[@data-columnname='DisplayOrder']/input";
	public static final String UPDATE_BUTTON = "//a[@class='btn btn-default' and text()='Update']";
	public static final String PICTURE_TABLE_BY_IMAGE_INFO = "//a[contains(@href,'%s')]/parent::td/following-sibling::td[@data-columnname='DisplayOrder' and text()='%s']/following-sibling::td[@data-columnname='OverrideAltAttribute' and text()='%s']/following-sibling::td[@data-columnname='OverrideTitleAttribute' and text()='%s']";	
	
	public static final String SAVE_BUTTON = "//button[@name='save']";
	
	public static final String DELETE_BUTTON_BY_IMAGE_TITLE = "//td[text()='%s']/following-sibling::td/a[contains(string(),'Delete')]";
	
	
	
	
}
