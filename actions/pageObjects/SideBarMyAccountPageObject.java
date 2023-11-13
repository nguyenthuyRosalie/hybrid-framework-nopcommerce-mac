package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.user.SideBarMyAccountPageUI;

public class SideBarMyAccountPageObject extends BasePage {

	WebDriver driver;

	public SideBarMyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public DownloadableProductPageObject openDownloadableProductPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.DOWNLOADABLE_PRODUCT_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.DOWNLOADABLE_PRODUCT_LINK);

		return PageGeneratorManage.getDownloadableProductPage(driver);
	}

	public RewardPointPageObject openRewardPointPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.REWARD_POINT_PAGE_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.REWARD_POINT_PAGE_LINK);
		return PageGeneratorManage.getRewardPointsPage(driver);
	}

	public AddressesPageObject openAddressesPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.ADDRESSES_PAGE_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.ADDRESSES_PAGE_LINK);

		return PageGeneratorManage.getAddressesPage(driver);
	}

	public CustomerPageObject openCustomerInforPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.CUSTOMER_INFOR_PAGE_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.CUSTOMER_INFOR_PAGE_LINK);
		return PageGeneratorManage.getCustomerPage(driver);
	}

	public SideBarMyAccountPageObject openDynamicSidebarPage(String pageName) {
		waitForElementClickable(driver, SideBarMyAccountPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
		clickToElement(driver, SideBarMyAccountPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);

		switch (pageName) {
		case "Customer info":

			return PageGeneratorManage.getCustomerPage(driver);

		case "Addresses":

			return PageGeneratorManage.getAddressesPage(driver);

		case "Reward points":

			return PageGeneratorManage.getRewardPointsPage(driver);
		case "Downloadable products":

			return PageGeneratorManage.getDownloadableProductPage(driver);

		default:
			new RuntimeException("Sidebar page name is incorrect.");
			return null;
		}

	}

	public void openDynamicSidebarPageByName(String pageName) {
		waitForElementClickable(driver, SideBarMyAccountPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
		clickToElement(driver, SideBarMyAccountPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
	}

}
