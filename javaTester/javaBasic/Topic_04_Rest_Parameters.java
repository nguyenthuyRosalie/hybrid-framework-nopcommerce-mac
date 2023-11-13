package javaBasic;

import org.testng.annotations.Test;

public class Topic_04_Rest_Parameters {

	String addressLink = "//div[@class='side-2']//a[text()='Addresses']";
	String orderLink = "//div[@class='side-2']//a[text()='Orders']";
	String dynamicSidebarLink = "//div[@class='side-2']//a[text()='%s']";

	@Test	
	public void TC_01_Rest_Param() {

		clickToElement(addressLink);

		clickToElement(orderLink);

		clickToElement(dynamicSidebarLink, "Addresses");
		clickToElement(dynamicSidebarLink, "Orders");
	}
	
	// click vao ham co locator co dinh
	public void clickToElement(String locatorValue) {
		System.out.println("Click to: " + locatorValue);
	}

	// click vao ham co locator ko co dinh vs 1 tham so
	public void clickToElement(String locatorValue, String pageName) {
		locatorValue = String.format(locatorValue, pageName);
		System.out.println("Click to: " + locatorValue);
	}
	
	// click vao ham co locator ko co dinh vs any tham so
	public void clickToElement(String locatorValue, String...values) {// mang String
		locatorValue = String.format(locatorValue, (Object[])values); // casting to Object
		System.out.println("Click to: " + locatorValue);
	}


}
