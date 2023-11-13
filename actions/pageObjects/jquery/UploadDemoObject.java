package pageObjects.jquery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.jquery.UploadPageUI;

public class UploadDemoObject extends BasePage {
	WebDriver driver;

	public UploadDemoObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileLoadedSucess(String fileName) {

		waitForElementVisible(driver, UploadPageUI.FILE_LOADED_BY_NAME, fileName);
		return isElementDisplayed(driver, UploadPageUI.FILE_LOADED_BY_NAME, fileName);
	}

	public void clickToStartButtonOnEachFile() {
		List<WebElement> startButtons = getListElement(driver, UploadPageUI.MULTIPLE_START_BUTTON);
		for (WebElement button : startButtons) {
			waitForElementClickable(driver, button);
			clickToElement(driver, button);
			sleepInSecond(3);
		}

	}

	public boolean isFileUpLoadedSucess(String fileName) {
		waitForElementVisible(driver, UploadPageUI.FILE_UPLOADED_BY_NAME, fileName);
		return isElementDisplayed(driver, UploadPageUI.FILE_UPLOADED_BY_NAME, fileName);

	}

	public boolean isLoadingIconAtMainDashboardDisappear() {
		return waitForElementInvisible(driver, UploadPageUI.SPIN_BORDER_ICON_AT_MAIN_DASHBOARD);
	}

	public boolean isLoadingIconAtMainUploadDisappear() {
		return waitForElementInvisible(driver, UploadPageUI.SPIN_BORDER_ICON_AT_MAIN_UPLOAD);
	}

	public boolean ismultipleProgressBarIconDisappear() {
		return waitForListElementInvisible(driver, UploadPageUI.MULTIPLE_PROGRESS_BAR_ICONS);
	}

	public boolean isSuccessMessageDisplayed(String successMessage) {
		waitForElementVisible(driver, UploadPageUI.UPLOADED_SUCCESS_MESSAGE, successMessage);
		return isElementDisplayed(driver, UploadPageUI.UPLOADED_SUCCESS_MESSAGE, successMessage);
	}

	public void clickToSuccessLink() {
		waitForElementClickable(driver, UploadPageUI.UPLOADED_SUCCESS_LINK);
		clickToElement(driver, UploadPageUI.UPLOADED_SUCCESS_LINK);
	}

	public boolean isContentTableDisplayed() {
		waitForElementVisible(driver, UploadPageUI.CONTENT_TABLE);
		return isElementDisplayed(driver, UploadPageUI.CONTENT_TABLE);
	}

	public boolean isDownloadButtonDisplayed(String fileName) {
		waitForElementVisible(driver, UploadPageUI.DOWNLOAD_BUTTON_BY_FILE_NAME, fileName);
		return isElementDisplayed(driver, UploadPageUI.DOWNLOAD_BUTTON_BY_FILE_NAME, fileName);
	}

	public boolean isPlayButtonDisplayed(String fileName) {
		waitForElementVisible(driver, UploadPageUI.PLAY_BUTTON_BY_FILE_NAME, fileName);
		return isElementDisplayed(driver, UploadPageUI.PLAY_BUTTON_BY_FILE_NAME, fileName);
	}

}
