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
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;

public class Level_09_Switch_Site_Url extends BaseTest {

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

	private String userUrl;
	private String adminUrl;

	@Parameters({ "browser", "userUrl", "adminUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String userUrl, String adminUrl) {
		driver = getBrowserDriver(browserName, userUrl);
		homePage = PageGeneratorManage.getHomePage(driver);

		this.userUrl = userUrl;
		this.adminUrl = adminUrl;

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
		adminDashboardPage = adminLoginPage.loginAsAdmin("admin@yourstore.com", "admin");
		Assert.assertTrue(adminDashboardPage.isPageLoadedSuccess(driver));
		adminLoginPage = adminDashboardPage.clickToAdminLogOutLink(driver);

		adminLoginPage.openUrl(driver, userUrl);
		homePage = PageGeneratorManage.getHomePage(driver);

		loginPage = homePage.clickToLoginLink();
		homePage = loginPage.loginAsUser(emailAddress, "123456");

	}

	//@AfterClass
	public void afterlass() {
		quitBrowserDriver();
	}

}
