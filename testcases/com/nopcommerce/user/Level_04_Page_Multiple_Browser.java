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
import pageObjects.RegisterPageObject;

public class Level_04_Page_Multiple_Browser extends BaseTest {

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

	}

	@Test
	public void TC_01_Empty_Data() {
		homePage = new HomePageObject(driver);

		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");

	}

	@Test
	public void TC_02_Invalid_Email() {
		registerPage.clickToHomePageLogo();

		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);
		registerPage.enterToFirstNameTextbox("John");
		registerPage.enterToLastNameTextbox("Wick");
		registerPage.enterEmailTextbox("john@wick@gmail.com");
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Wrong email");
	}

	@Test
	public void TC_03_Invalid_Password() {
		registerPage.clickToHomePageLogo();
		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);
		registerPage.enterToFirstNameTextbox("John");
		registerPage.enterToLastNameTextbox("Wick");
		registerPage.enterEmailTextbox("john@wick@gmail.com");
		registerPage.enterToPasswordTextbox("123");
		registerPage.enterToConfirmPasswordTextbox("123");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getPasswordErrorMessage(),
				"Password must meet the following rules:\n" + "must have at least 6 characters");

	}

	@Test
	public void TC_04_Incorrect_Confirm_Password() {
		registerPage.clickToHomePageLogo();
		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);
		registerPage.enterToFirstNameTextbox("John");
		registerPage.enterToLastNameTextbox("Wick");
		registerPage.enterEmailTextbox("john@wick@gmail.com");
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(),
				"The password and confirmation password do not match.");

	}

	@Test
	public void TC_05_Register_Success() {
		registerPage.clickToHomePageLogo();
		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);
		registerPage.enterToFirstNameTextbox("John");
		registerPage.enterToLastNameTextbox("Wick");
		registerPage.enterEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

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
	public void afterClass() {
		quitBrowserDriver();
	}

}
