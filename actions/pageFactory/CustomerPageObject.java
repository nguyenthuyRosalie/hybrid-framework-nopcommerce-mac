package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPageObject extends BasePageFactory {

	WebDriver driver;

	public CustomerPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "FirstName")
	WebElement fistNameTextBox;

	@FindBy(id = "LastName")
	WebElement lastNameTextBox;

	@FindBy(id = "Email")
	WebElement emailTextBox;

	public String getFirstNameAttributeValue() {
		waitForElementVisible(driver, fistNameTextBox);
		return getElementAttribute(driver, fistNameTextBox, "value");
	}

	public String getLastNameAttributeValue() {
		waitForElementVisible(driver, lastNameTextBox);
		return getElementAttribute(driver, lastNameTextBox, "value");
	}

	public String getEmailAttributeValue() {

		waitForElementVisible(driver, emailTextBox);
		return getElementAttribute(driver, emailTextBox, "value");
	}

}
