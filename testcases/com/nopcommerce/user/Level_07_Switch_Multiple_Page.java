package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.AddressesPageObject;
import pageObjects.CustomerPageObject;
import pageObjects.DownloadableProductPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGeneratorManage;
import pageObjects.RegisterPageObject;
import pageObjects.RewardPointPageObject;

public class Level_07_Switch_Multiple_Page extends BaseTest {

	WebDriver driver;

	String emailAddress = getEmailAddress();

	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	CustomerPageObject customerPage;
	DownloadableProductPageObject downloadableProductPage;
	AddressesPageObject addressesPage;
	RewardPointPageObject rewardPointPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManage.getHomePage(driver);

	}

	@Test
	public void TC_01_Sucess() {

		registerPage = homePage.clickToRegisterLink();
		homePage = registerPage.clickToHomePageLogo();
		registerPage = homePage.clickToRegisterLink();

		registerPage.enterToFirstNameTextbox("John");
		registerPage.enterToLastNameTextbox("Wick");
		registerPage.enterEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToHomePageLogo();

		loginPage = homePage.clickToLoginLink();

		homePage = loginPage.loginAsUser(emailAddress, "123456");

		customerPage = homePage.clickToMyAccountLink();

		Assert.assertEquals(customerPage.getFirstNameAttributeValue(), "John");
		Assert.assertEquals(customerPage.getLastNameAttributeValue(), "Wick");
		Assert.assertEquals(customerPage.getEmailAttributeValue(), emailAddress);

	}

	@Test
	public void TC_02_Swith_Multiple_Page() {

		downloadableProductPage = customerPage.openDownloadableProductPage();

		addressesPage = downloadableProductPage.openAddressesPage();

		rewardPointPage = addressesPage.openRewardPointPage();

		customerPage = rewardPointPage.openCustomerInforPage();

		addressesPage = customerPage.openAddressesPage();

		downloadableProductPage = addressesPage.openDownloadableProductPage();
		

	}

	@AfterClass
	public void afterlass() {
		driver.quit();
	}

}
