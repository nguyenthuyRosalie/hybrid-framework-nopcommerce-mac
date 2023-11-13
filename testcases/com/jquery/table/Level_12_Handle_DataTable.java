package com.jquery.table;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManage;

public class Level_12_Handle_DataTable extends BaseTest {

	WebDriver driver;
	HomePageObject homepage;
	List<String> allValueUI = new ArrayList<String>();

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homepage = PageGeneratorManage.getHomePageObject(driver);

	}

	//@Test
	public void TC_01_Search() {
		homepage.inputToColumnTextboxByName("Females","624");
		homepage.sleepInSecond(2);
		
		homepage.inputToColumnTextboxByName("Country","Seychelles");
		homepage.sleepInSecond(2);

		homepage.inputToColumnTextboxByName("Males","651");
		homepage.sleepInSecond(2);

		homepage.inputToColumnTextboxByName("Total","1270");
		homepage.sleepInSecond(2);

	}

	// @Test
	public void TC_02_Pagination() {

		homepage.clickToPageByNumber("3");
		homepage.sleepInSecond(0);
		Assert.assertTrue(homepage.isPageActiveByNumber("3"));

		homepage.clickToPageByNumber("1");
		homepage.sleepInSecond(0);
		Assert.assertTrue(homepage.isPageActiveByNumber("1"));

		homepage.clickToPageByNumber("23");
		homepage.sleepInSecond(0);
		Assert.assertTrue(homepage.isPageActiveByNumber("23"));

		homepage.clickToPageByNumber("24");
		homepage.sleepInSecond(0);
		Assert.assertTrue(homepage.isPageActiveByNumber("24"));
	}

	// @Test
	public void TC_03_ByRow() {
		Assert.assertTrue(homepage.isRowValueDisplayed("384187", "Afghanistan", "407124", "791312"));
	}

//	@Test
	public void TC_04_Icon_Button_Checkbox() {
		homepage.clickToRowActionByCountryName("AFRICA", "remove");
		homepage.refreshCurrentPage(driver);

		homepage.clickToRowActionByCountryName("AFRICA", "edit");
		homepage.sleepInSecond(2);
	}

	//@Test
	public void TC_05_Get_All_Column_Values() {

		allValueUI = homepage.getALLColumnValuesByColumnName("Country");
		allValueUI = homepage.getALLColumnValuesByColumnName("Females");
		allValueUI = homepage.getALLColumnValuesByColumnName("Males");
		allValueUI = homepage.getALLColumnValuesByColumnName("Total");
	}
	
	@Test
	public void TC_06_Action_By_Index() {
		
		homepage.openUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		
		homepage.enterToTextboxByColumnNameAndRowIndex("Contact Person", "2", "Taylor Nguyen");
		
		homepage.selectDropdownCountryByColumnNameAndRowIndex("Country", "2", "Japan");
		
		homepage.checkToCheckBoxNPOByColumnIndexAndRowIndex("NPO?", "2");
		homepage.checkToCheckBoxNPOByColumnIndexAndRowIndex("NPO?", "3");
		homepage.checkToCheckBoxNPOByColumnIndexAndRowIndex("NPO?", "1");
		
	}


	@AfterClass
	public void afterlass() {
	driver.quit();
	}

}
