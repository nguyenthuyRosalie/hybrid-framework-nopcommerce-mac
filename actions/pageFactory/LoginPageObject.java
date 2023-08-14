package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends BasePageFactory {

	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Email")
	WebElement emailTextBox;

	@FindBy(id = "Password")
	WebElement passwordTextBox;

	@FindBy(css = "button.login-button")
	WebElement loginButton;

	public void enterToEmailTextBox(String emailAddress) {
		waitForElementVisible(driver, emailTextBox);
		sendkeyToElement(driver, emailTextBox, emailAddress);
	}

	public void enterToPasswordTextBox(String password) {
		waitForElementVisible(driver, passwordTextBox);
		sendkeyToElement(driver, passwordTextBox, password);
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
	}

}
