package pageObjects;

import org.openqa.selenium.WebDriver;

public class DownloadableProductPageObject extends SideBarMyAccountPageObject {

	WebDriver driver;

	public DownloadableProductPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	
}
