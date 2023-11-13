package javaBasic;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_03_By {

	String locatorValue;

	@Test
	public void TC_01_Xpath() {
		locatorValue = "Xpath=//input[@id='name']";
		System.out.println(locatorValue.substring(6));
		Assert.assertEquals(getByLocator(locatorValue), By.xpath("//input[@id='name']"));
	}
	
	@Test
	public void TC_02_CSS() {
		locatorValue = "css=input[id='name']";
		System.out.println(locatorValue.substring(4));
		Assert.assertEquals(getByLocator(locatorValue), By.cssSelector("input[id='name']"));
	}
	
	@Test
	public void TC_03_Id() {
		locatorValue = "id=name";
		System.out.println(locatorValue.substring(3));
		Assert.assertEquals(getByLocator(locatorValue), By.id("name"));
	}
	
	@Test
	public void TC_04_Name() {
		locatorValue = "name=name";
		System.out.println(locatorValue.substring(5));
		Assert.assertEquals(getByLocator(locatorValue), By.name("name"));
	}


//	@Test
	public void TC_02_Invalid_Case() {
		String locatorValue = "css=[id='name']";
		Assert.assertEquals(getByLocator(locatorValue), null);
	}

	public By getByLocator(String locatorValue) {
		By by = null;
		if (locatorValue.startsWith("xpath=") || locatorValue.startsWith("XPath=") || locatorValue.startsWith("XPATH=")
				|| locatorValue.startsWith("xPath=") || locatorValue.startsWith("Xpath")) {
			by = By.xpath(locatorValue.substring(6));
		}
		else if (locatorValue.startsWith("css=") || locatorValue.startsWith("CSS=") || locatorValue.startsWith("Css=") ||locatorValue.startsWith("cSS=")) {
			by = By.cssSelector(locatorValue.substring(4));
		}
		else if (locatorValue.startsWith("Id=") || locatorValue.startsWith("ID=") || locatorValue.startsWith("id=")) {
			by = By.id(locatorValue.substring(3));
		}
		else if (locatorValue.startsWith("name=") || locatorValue.startsWith("NAME=") || locatorValue.startsWith("Name=")) {
			by = By.name(locatorValue.substring(5));
		}
		else if (locatorValue.startsWith("class=") || locatorValue.startsWith("Class=")
				|| locatorValue.startsWith("ClASS=")) {
			by = By.className(locatorValue.substring(6));
		}
		else if (locatorValue.startsWith("tagname=") || locatorValue.startsWith("Tagname=")
				|| locatorValue.startsWith("TAGNAME=")) {
			by = By.tagName(locatorValue.substring(8));
		}

		else {
			throw new RuntimeException("Locator is invalid");

		}

		return by;

	}

}
