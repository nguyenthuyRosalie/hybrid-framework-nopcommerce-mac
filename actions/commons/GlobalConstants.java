package commons;

import java.io.File;

import org.openqa.selenium.support.FindBy;

public class GlobalConstants {
	// server Url: Dev/Testing/ Staging/prod
	// Database: Ip/ Port , and follow each corresponding server
	// timeout: Short/long
	// Username/ pass
	// 3rd party: Sabbox paypal
	// download/ upload folder
	// Relative Project path
	// OS name
	// CLoud testing: browserstack; sourcelab, crossbrowsertesting (Access token/ID)
	
	public static final String DEV_USER_URL = "https://demo.nopcommerce.com/";
	public static final String DEV_ADMIN_URL = "https://admin-demo.nopcommerce.com/	";
	
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 40;
	
	public static final String DEV_ADMIN_USERNAME = "admin@yourstore.com";
	public static final String DEV_ADMIN_PASSWORD = "admin";
	
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String RELATIVE_PROJECT_PATH = System.getProperty("user.dir");
	
	public static final String UPLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator  + "downloadFiles" + File.separator;
	
}
