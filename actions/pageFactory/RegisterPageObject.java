package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends BasePageFactory {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "button#register-button")
	WebElement registerButton;

	@FindBy(css = "span#FirstName-error")
	WebElement firstNameErrorMsg;

	@FindBy(css = "span#LastName-error")
	WebElement lastNameErrorMsg;

	@FindBy(css = "span#Email-error")
	WebElement emailErrorMsg;

	@FindBy(css = "span#Password-error")
	WebElement passwordErrorMsg;

	@FindBy(css = "span#ConfirmPassword-error")
	WebElement confirmPasswordErrorMsg;

	@FindBy(css = "div.result")
	WebElement registerSuccessMsg;

	@FindBy(css = "input#FirstName")
	WebElement firstNameTextBox;

	@FindBy(css = "input#LastName")
	WebElement lastnameTextBox;

	@FindBy(css = "input#Email")
	WebElement emailTextBox;

	@FindBy(css = "input#Password")
	WebElement passwordTextbox;

	@FindBy(css = "input#ConfirmPassword")
	WebElement confirmPasswordTextBox;

	@FindBy(xpath = "//div[@class='header-logo']//img")
	WebElement homePageLogoImage;

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public String getFirstNameErrorMessage() {
		waitForElementVisible(driver, firstNameErrorMsg);
		return getElementText(driver, firstNameErrorMsg);
	}

	public String getLastNameErrorMessage() {
		waitForElementVisible(driver, lastNameErrorMsg);
		return getElementText(driver, lastNameErrorMsg);
	}

	public String getEmailErrorMessage() {
		waitForElementVisible(driver, emailErrorMsg);
		return getElementText(driver, emailErrorMsg);
	}

	public String getConfirmPasswordErrorMessage() {
		waitForElementVisible(driver, confirmPasswordErrorMsg);
		return getElementText(driver, confirmPasswordErrorMsg);
	}

	public String getPasswordErrorMessage() {
		waitForElementVisible(driver, passwordErrorMsg);
		return getElementText(driver, passwordErrorMsg);
	}

	public void clickToHomePageLogo() {
		waitForElementClickable(driver, homePageLogoImage);
		clickToElement(driver, homePageLogoImage);
	}

	public void enterToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextBox);
		sendkeyToElement(driver, firstNameTextBox, firstName);
	}

	public void enterToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, lastnameTextBox);
		sendkeyToElement(driver, lastnameTextBox, lastName);
	}

	public void enterEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextBox);
		sendkeyToElement(driver, emailTextBox, email);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
	}

	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextBox);
		sendkeyToElement(driver, confirmPasswordTextBox, confirmPassword);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registerSuccessMsg);
		return getElementText(driver, registerSuccessMsg);
	}

}
