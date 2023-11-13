package pageObjects;

import org.openqa.selenium.WebDriver;

import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;

public class PageGeneratorManage {

	// user

	public static HomePageObject getHomePage(WebDriver driver) {

		return new HomePageObject(driver);
	}

	public static LoginPageObject getLoginPage(WebDriver driver) {

		return new LoginPageObject(driver);
	}

	public static RegisterPageObject getRegisterPage(WebDriver driver) {

		return new RegisterPageObject(driver);
	}

	public static CustomerPageObject getCustomerPage(WebDriver driver) {

		return new CustomerPageObject(driver);
	}

	public static DownloadableProductPageObject getDownloadableProductPage(WebDriver driver) {

		return new DownloadableProductPageObject(driver);
	}

	public static AddressesPageObject getAddressesPage(WebDriver driver) {

		return new AddressesPageObject(driver);
	}

	public static RewardPointPageObject getRewardPointsPage(WebDriver driver) {

		return new RewardPointPageObject(driver);
	}

	// Admin

	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);

	}
	
	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);

	}


}
