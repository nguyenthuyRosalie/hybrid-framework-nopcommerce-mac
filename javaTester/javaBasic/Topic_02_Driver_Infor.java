package javaBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

public class Topic_02_Driver_Infor {

	public static void main(String[] args) {

		// Chrome

		WebDriver driver = new ChromeDriver();
		SessionId sessionId = ((RemoteWebDriver) driver).getSessionId();
		System.out.println("Session ID = " + sessionId);
		System.out.println("Driver ID = " + driver.toString());
		driver.quit();

//		Session ID = 25f66c47e4080f6b2fbab2bd82cf60b8
//		Driver ID = ChromeDriver: chrome on mac (25f66c47e4080f6b2fbab2bd82cf60b8)

		// Firefox

		driver = new FirefoxDriver();
		SessionId sessionID = ((RemoteWebDriver) driver).getSessionId();
		System.out.println("Session ID = " + sessionID);
		System.out.println("Driver ID = " + driver.toString());
		driver.quit();

//		Session ID = ca59ac7c-3d0a-43d2-974f-1ffbe1ee2b72
//		Driver ID = FirefoxDriver: firefox on mac (ca59ac7c-3d0a-43d2-974f-1ffbe1ee2b72)
	}

}
