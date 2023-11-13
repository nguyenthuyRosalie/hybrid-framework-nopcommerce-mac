package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.CustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGeneratorManage;
import pageObjects.RegisterPageObject;

public class Topic_15_Assert_Verify extends BaseTest {
	 

		WebDriver driver;

		String emailAddress = getEmailAddress();

		HomePageObject homePage;
		RegisterPageObject registerPage;
		LoginPageObject loginPage;
		CustomerPageObject customerPage;

		@Parameters("browser")
		@BeforeClass
		public void beforeClass(String browserName) {
			driver = getBrowserDriver(browserName);
			homePage = PageGeneratorManage.getHomePage(driver);

		}

		@Test
		public void TC_01_Rigister_Success() {
			
			verifyTrue(homePage.isRegisterLinkDisplayed());
			
			registerPage =homePage.clickToRegisterLink();

			registerPage = new RegisterPageObject(driver);
			registerPage.enterToFirstNameTextbox("John");
			registerPage.enterToLastNameTextbox("Wick");
			registerPage.enterEmailTextbox(emailAddress);
			registerPage.enterToPasswordTextbox("123456");
			registerPage.enterToConfirmPasswordTextbox("123456");

			registerPage.clickToRegisterButton();

			verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed.");

			registerPage.clickToHomePageLogo();
			homePage = new HomePageObject(driver);

			homePage.clickToLoginLink();

			loginPage = new LoginPageObject(driver);

			loginPage.enterToEmailTextBox(emailAddress);
			loginPage.enterToPasswordTextBox("123456");
			loginPage.clickToLoginButton();

			homePage = new HomePageObject(driver);
			homePage.clickToMyAccountLink();

			customerPage = new CustomerPageObject(driver);
			Assert.assertEquals(customerPage.getFirstNameAttributeValue(), "John");
			Assert.assertEquals(customerPage.getLastNameAttributeValue(), "Wick");
			Assert.assertEquals(customerPage.getEmailAttributeValue(), emailAddress);
		}

		@AfterClass
		public void afterlass() {
			quitBrowserDriver();
		}
}
