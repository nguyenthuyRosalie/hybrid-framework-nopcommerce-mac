package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class AddressesPageObject extends SideBarMyAccountPageObject {

	WebDriver driver;

	public AddressesPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
