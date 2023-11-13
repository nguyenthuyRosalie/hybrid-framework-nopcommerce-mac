package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.user.LoginPageUI;

public class LoginPageObject extends BasePage {

	WebDriver driver;
	

	public LoginPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public HomePageObject loginAsUser(String emailAddress, String password) {
		enterToEmailTextBox(emailAddress);
		enterToPasswordTextBox(password);
		clickToLoginButton();
		return PageGeneratorManage.getHomePage(driver);
	}

	public void enterToEmailTextBox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void enterToPasswordTextBox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManage.getHomePage(driver);
	}

}
