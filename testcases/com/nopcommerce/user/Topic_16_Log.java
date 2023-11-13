package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.SinglePass;
import pageObjects.CustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGeneratorManage;
import pageObjects.RegisterPageObject;

public class Topic_16_Log extends BaseTest {
	 

		WebDriver driver;

		String emailAddress = getEmailAddress();

		HomePageObject homePage;
		RegisterPageObject registerPage;
		LoginPageObject loginPage;
		CustomerPageObject customerPage;
		String firstName = "John";
		String lastName = "Wick";
		String password = "123456";
		
		@Parameters("browser")
		@BeforeClass
		public void beforeClass(String browserName) {
			driver = getBrowserDriver(browserName);
			homePage = PageGeneratorManage.getHomePage(driver);

		}

		@Test
		public void TC_01_Register_Success() {
			
			log.info("TC_01_Step 01: Verify Register Link is Display");
			verifyTrue(homePage.isRegisterLinkDisplayed());
			
			log.info("TC_01_Step 02: Click on Register Link ");
			registerPage =homePage.clickToRegisterLink();

			log.info("TC_01_Step 03: Enter to  first name textbox with value is " + firstName);
			registerPage.enterToFirstNameTextbox(firstName);
			
			log.info("TC_01_Step 04: Enter to  last name textbox with value is " + lastName);
			registerPage.enterToLastNameTextbox(lastName);
			
			log.info("TC_01_Step 05: Enter to  email Address textbox with value is " + emailAddress);
			registerPage.enterEmailTextbox(emailAddress);
			
			log.info("TC_01_Step 06: Enter to  password  textbox with value is " + password);
			registerPage.enterToPasswordTextbox(password);
			
			log.info("TC_01_Step 07: Enter to confirmation password textbox with value is " + password);
			registerPage.enterToConfirmPasswordTextbox(password);

			log.info("TC_01_Step 08: Click on Register Button");
			registerPage.clickToRegisterButton();
			
			log.info("TC_01_Step 09: Verify the Register Success Message is 'Your registration completed' ");
			verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed.");

			log.info("TC_01_Step 10: Click on Homepage Logo");
			homePage = registerPage.clickToHomePageLogo();
			
			log.info("TC_01_Step 11: Click on Login Link");
			loginPage = homePage.clickToLoginLink();

			log.info("TC_01_Step 12: Enter Email Address on Login page with a value is " +emailAddress);
			loginPage.enterToEmailTextBox(emailAddress);
			
			log.info("TC_01_Step 13: Enter password on Login page with a value is " + password);
			loginPage.enterToPasswordTextBox(password);
			
			log.info("TC_01_Step 14: Click on Login Button on the login page");
			homePage =loginPage.clickToLoginButton();

			log.info("TC_01_Step 15: Click on My Account Link the homepage");
			customerPage = homePage.clickToMyAccountLink();
			
			log.info("TC_01_Step 16: Verify first name value");
			Assert.assertEquals(customerPage.getFirstNameAttributeValue(), "John");
			
			log.info("TC_01_Step 17: Verify last name value");
			verifyEquals(customerPage.getLastNameAttributeValue(), "Wick");
			
			log.info("TC_01_Step 18: Verify email address value");
			verifyEquals(customerPage.getEmailAttributeValue(), emailAddress);
		}

		@AfterClass
		public void afterlass() {
			quitBrowserDriver();
		}
}
