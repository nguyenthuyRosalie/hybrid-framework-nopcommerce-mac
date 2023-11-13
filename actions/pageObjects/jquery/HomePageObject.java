package pageObjects.jquery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.jquery.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToColumnTextboxByName(String columnName, String valueToSend) {
		waitForElementVisible(driver, HomePageUI.COLUMN_TEXTBOX_BY_NAME, columnName);
		sendkeyToElement(driver, HomePageUI.COLUMN_TEXTBOX_BY_NAME, valueToSend, columnName);
	}

	public void clickToPageByNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGE_BY_NUMBER, pageNumber);
	}

	public boolean isPageActiveByNumber(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGE_ACTIVE_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGE_ACTIVE_BY_NUMBER, pageNumber);
	}

	public boolean isRowValueDisplayed(String female, String country, String male, String total) {
		waitForElementVisible(driver, HomePageUI.DYNAMIC_ROW_VAUES, female, country, male, total);
		return isElementDisplayed(driver, HomePageUI.DYNAMIC_ROW_VAUES, female, country, male, total);
	}

	public void clickToRowActionByCountryName(String countryName, String buttonName) {
		waitForElementClickable(driver, HomePageUI.DYNAMIC_BUTTON, countryName, buttonName);
		clickToElement(driver, HomePageUI.DYNAMIC_BUTTON, countryName, buttonName);
	}

	public List<String> getALLColumnValuesByColumnName(String columnName) {

		List<String> allValues = new ArrayList<String>();

		List<WebElement> allPageLinks = getListElement(driver, HomePageUI.ALL_PAGE_LINKS);

		int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;

		for (WebElement pageLink : allPageLinks) {
			pageLink.click();
			sleepInSecond(1);

			List<WebElement> allRowValues = getListElement(driver, HomePageUI.ALL_VALUE_BY_COLUMN_INDEX,
					String.valueOf(columnIndex));

			for (WebElement rowValue : allRowValues) {

				allValues.add(rowValue.getText());

			}

		}

		for (String singleValue : allValues) {
			System.out.println(singleValue);

		}
		return allValues;
	}

	public void enterToTextboxByColumnNameAndRowIndex(String columnName, String rowIndex, String valueToEnter) {
		int columnIndex = getListElementSize(driver, HomePageUI.DEMO_2_DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName)
				+ 1;
		waitForElementVisible(driver, HomePageUI.DEMO_2_DYNAMIC_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex,
				String.valueOf(columnIndex));

		sendkeyToElement(driver, HomePageUI.DEMO_2_DYNAMIC_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, valueToEnter,
				rowIndex, String.valueOf(columnIndex));
	}

	public void selectDropdownCountryByColumnNameAndRowIndex(String columnName, String rowIndex, String dropdownItem) {
		int columnIndex = getListElementSize(driver, HomePageUI.DEMO_2_DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName)
				+ 1;
		waitForElementClickable(driver, HomePageUI.DEMO_2_DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex,
				String.valueOf(columnIndex));

		selectDropdown(driver, HomePageUI.DEMO_2_DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, dropdownItem, rowIndex,
				String.valueOf(columnIndex));

	}

	public void checkToCheckBoxNPOByColumnIndexAndRowIndex(String columnName, String RowIndex) {
		int columnIndex = getListElementSize(driver, HomePageUI.DEMO_2_DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName)
				+ 1;
		waitForElementClickable(driver, HomePageUI.DEMO_2_DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, RowIndex,
				String.valueOf(columnIndex));
		checkToCheckboxRadio(driver, HomePageUI.DEMO_2_DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, RowIndex,
				String.valueOf(columnIndex));
	}

}
