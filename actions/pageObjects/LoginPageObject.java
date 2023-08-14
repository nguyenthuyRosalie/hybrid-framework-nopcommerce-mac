package pageObjects;

import org.openqa.selenium.WebDriver;

import PageUIs.LoginPageUI;
import commons.BasePage;

public class LoginPageObject extends BasePage {

	WebDriver driver;
	

	public LoginPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void enterToEmailTextBox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void enterToPasswordTextBox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

}
