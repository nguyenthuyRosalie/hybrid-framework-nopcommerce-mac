package pageObjects.jquery;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManage {

	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
		
	}
	
	public static UploadDemoObject getUploadDemoObject(WebDriver driver) {
		return new UploadDemoObject(driver);
		
	}

}
