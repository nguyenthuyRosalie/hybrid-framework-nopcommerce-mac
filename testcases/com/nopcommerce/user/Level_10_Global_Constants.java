package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.AddressesPageObject;
import pageObjects.CustomerPageObject;
import pageObjects.DownloadableProductPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGeneratorManage;
import pageObjects.RegisterPageObject;
import pageObjects.RewardPointPageObject;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;

public class Level_10_Global_Constants extends BaseTest {

	WebDriver driver;

	String emailAddress = getEmailAddress();

	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	CustomerPageObject customerPage;
	DownloadableProductPageObject downloadableProductPage;
	AddressesPageObject addressesPage;
	RewardPointPageObject rewardPointPage;

	AdminLoginPageObject adminLoginPage;
	AdminDashboardPageObject adminDashboardPage;

	private String userUrl = GlobalConstants.DEV_USER_URL;
	private String adminUrl = GlobalConstants.DEV_ADMIN_URL;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, userUrl);
		homePage = PageGeneratorManage.getHomePage(driver);

	}

	@Test
	public void User_01_Sucess() {

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
	public void User_02_Swith_Url() {
		homePage = customerPage.clickToUserLogOutLink(driver);
		homePage.openUrl(driver, adminUrl);
		adminLoginPage = PageGeneratorManage.getAdminLoginPage(driver);

		/* Login successfully */
		adminDashboardPage = adminLoginPage.loginAsAdmin(GlobalConstants.DEV_ADMIN_USERNAME, GlobalConstants.DEV_ADMIN_PASSWORD);
		Assert.assertTrue(adminDashboardPage.isPageLoadedSuccess(driver));
		adminLoginPage = adminDashboardPage.clickToAdminLogOutLink(driver);

		adminLoginPage.openUrl(driver, userUrl);
		homePage = PageGeneratorManage.getHomePage(driver);

		loginPage = homePage.clickToLoginLink();
		homePage = loginPage.loginAsUser(emailAddress, "123456");

	}

	// @AfterClass
	public void afterlass() {
		quitBrowserDriver();
	}

}
