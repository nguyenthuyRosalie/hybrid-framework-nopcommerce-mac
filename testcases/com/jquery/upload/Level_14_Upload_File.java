package com.jquery.upload;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.PageGeneratorManage;
import pageObjects.jquery.UploadDemoObject;

public class Level_14_Upload_File extends BaseTest {

	WebDriver driver;
	UploadDemoObject uploadPage;
	String chibiImage = "chibiImage.jpeg";
	String doremonImage = "doremonImage.jpeg";
	String funnyImage = "funnyImage.jpeg";

	String[] fileNames = { chibiImage, doremonImage, funnyImage };

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		uploadPage = PageGeneratorManage.getUploadDemoObject(driver);

	}

	//@Test
	public void TC_01_Upload_Single_File() {
		uploadPage.uploadMultipleFiles(driver, chibiImage);
		uploadPage.sleepInSecond(2);

		uploadPage.uploadMultipleFiles(driver, doremonImage);
		uploadPage.sleepInSecond(2);

		uploadPage.uploadMultipleFiles(driver, funnyImage);
		uploadPage.sleepInSecond(2);

		Assert.assertTrue(uploadPage.isFileLoadedSucess(chibiImage));
		Assert.assertTrue(uploadPage.isFileLoadedSucess(doremonImage));
		Assert.assertTrue(uploadPage.isFileLoadedSucess(funnyImage));

		uploadPage.clickToStartButtonOnEachFile();

		Assert.assertTrue(uploadPage.isFileUpLoadedSucess(chibiImage));
		Assert.assertTrue(uploadPage.isFileUpLoadedSucess(doremonImage));
		Assert.assertTrue(uploadPage.isFileUpLoadedSucess(funnyImage));

	}

	//@Test
	public void TC_02_Upload_Multiple_File() {
		uploadPage.refreshCurrentPage(driver);
		uploadPage.uploadMultipleFiles(driver, fileNames);
		Assert.assertTrue(uploadPage.isFileLoadedSucess(chibiImage));
		Assert.assertTrue(uploadPage.isFileLoadedSucess(doremonImage));
		Assert.assertTrue(uploadPage.isFileLoadedSucess(funnyImage));

		uploadPage.clickToStartButtonOnEachFile();

		Assert.assertTrue(uploadPage.isFileUpLoadedSucess(chibiImage));
		Assert.assertTrue(uploadPage.isFileUpLoadedSucess(doremonImage));
		Assert.assertTrue(uploadPage.isFileUpLoadedSucess(funnyImage));

	}
	
	@Test
	public void TC_03_Upload_GoFile() {
		uploadPage.openUrl(driver, "https://gofile.io/uploadFiles");
		
		Assert.assertTrue(uploadPage.isLoadingIconAtMainDashboardDisappear());
		
		uploadPage.uploadMultipleFiles(driver, fileNames);
		
		Assert.assertTrue(uploadPage.isLoadingIconAtMainUploadDisappear());
		
		Assert.assertTrue(uploadPage.ismultipleProgressBarIconDisappear());	
		
		Assert.assertTrue(uploadPage.isSuccessMessageDisplayed("Your files have been successfully uploaded"));
		
		uploadPage.clickToSuccessLink();
			
		Assert.assertTrue(uploadPage.isContentTableDisplayed());
		
		Assert.assertTrue(uploadPage.isDownloadButtonDisplayed(chibiImage));
		
		Assert.assertTrue(uploadPage.isDownloadButtonDisplayed(doremonImage));
		
		Assert.assertTrue(uploadPage.isDownloadButtonDisplayed(funnyImage));
		
		
		Assert.assertTrue(uploadPage.isPlayButtonDisplayed(chibiImage));
		
		Assert.assertTrue(uploadPage.isPlayButtonDisplayed(doremonImage));
		
		Assert.assertTrue(uploadPage.isPlayButtonDisplayed(funnyImage));
	}

	@AfterClass
	public void afterlass() {
		driver.quit();
	}

}
