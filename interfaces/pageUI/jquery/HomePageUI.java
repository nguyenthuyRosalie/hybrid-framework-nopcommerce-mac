package pageUI.jquery;

public class HomePageUI {
	public static final String COLUMN_TEXTBOX_BY_NAME = "xpath=//div[text()='%s']/parent::div/following-sibling::input";
	public static final String PAGE_BY_NUMBER = "xpath=//a[@class='qgrd-pagination-page-link' and text()='%s']";
	public static final String PAGE_ACTIVE_BY_NUMBER = "xpath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";

	public static final String DYNAMIC_ROW_VAUES = "xpath=//td[@data-key='females' and text()='%s']"
			+ "//following-sibling::td[@data-key='country' and text()='%s']//following-sibling::td[@data-key='males' and text()='%s']"
			+ "//following-sibling::td[@data-key='total' and text()='%s']";

	public static final String DYNAMIC_BUTTON = "xpath=//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[contains(@class, '%s')]";

	public static final String ALL_PAGE_LINKS = "xpath=//a[contains(@class,'qgrd-pagination-page-link')]";
	public static final String COLUMN_INDEX_BY_COLUMN_NAME = "xpath=//div[text()='%s']/ancestor::th//preceding-sibling::th";
	public static final String ALL_VALUE_BY_COLUMN_INDEX = "xpath=//tr/td[%s]";

	public static final String DEMO_2_DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME = "xpath=//th[text()='%s']/preceding-sibling::th";

	public static final String DEMO_2_DYNAMIC_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tr[%s]/td[%s]/input";
	
	public static final String DEMO_2_DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tr[%s]/td[%s]//select";
	
	public static final String DEMO_2_DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tr[%s]//td[%s]/label/input";

}
