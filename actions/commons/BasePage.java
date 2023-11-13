package commons;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.HomePageObject;
import pageObjects.PageGeneratorManage;
import pageObjects.admin.AdminLoginPageObject;
import pageUI.user.BasePageUI;

public class BasePage {

	public static BasePage getBasePage() {
		return new BasePage();
	}

	public void openUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void acceptToAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	public void cancelToAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void sendkeyToAlert(WebDriver driver, String valueToSendkey) {
		driver.switchTo().alert().sendKeys(valueToSendkey);
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		return new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.alertIsPresent());
	}

	public void switchToWindowByID(WebDriver driver, String WindowID) {
		Set<String> allIDs = driver.getWindowHandles();
		for (String tempID : allIDs) {
			if (tempID != WindowID) {
				driver.switchTo().window(tempID);
				break;
			}

		}
	}

	public void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
		Set<String> allIDs = driver.getWindowHandles();
		for (String tempID : allIDs) {
			driver.switchTo().window(tempID);
			String actualTitle = driver.getTitle();
			if (actualTitle == expectedTitle) {
				break;
			}
		}
	}

	public void closeAllWindowWithoutParent(WebDriver driver, String parentID) {
		Set<String> allIDs = driver.getWindowHandles();
		for (String tempID : allIDs) {
			if (tempID != parentID) {
				driver.switchTo().window(tempID);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	public void sleepInSecond(long timeoutInSeconds) {
		try {
			Thread.sleep(timeoutInSeconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public By getByLocator(String locatorValue) {
		By by = null;
		if (locatorValue.startsWith("xpath=") || locatorValue.startsWith("XPath=") || locatorValue.startsWith("XPATH=")
				|| locatorValue.startsWith("xPath=") || locatorValue.startsWith("Xpath")) {
			by = By.xpath(locatorValue.substring(6));
		} else if (locatorValue.startsWith("css=") || locatorValue.startsWith("CSS=") || locatorValue.startsWith("Css=")
				|| locatorValue.startsWith("cSS=")) {
			by = By.cssSelector(locatorValue.substring(4));
		} else if (locatorValue.startsWith("Id=") || locatorValue.startsWith("ID=") || locatorValue.startsWith("id=")) {
			by = By.id(locatorValue.substring(3));
		} else if (locatorValue.startsWith("name=") || locatorValue.startsWith("NAME=")
				|| locatorValue.startsWith("Name=")) {
			by = By.name(locatorValue.substring(5));
		} else if (locatorValue.startsWith("class=") || locatorValue.startsWith("Class=")
				|| locatorValue.startsWith("ClASS=")) {
			by = By.className(locatorValue.substring(6));
		} else if (locatorValue.startsWith("tagname=") || locatorValue.startsWith("Tagname=")
				|| locatorValue.startsWith("TAGNAME=")) {
			by = By.tagName(locatorValue.substring(8));
		}

		else {
			throw new RuntimeException("Locator is invalid");

		}

		return by;

	}

	public By getByXpath(String xpathExpression) {
		return By.xpath(xpathExpression);
	}

	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByLocator(locator));
	}

	public List<WebElement> getListElement(WebDriver driver, String locator) {
		return driver.findElements(getByLocator(locator));
	}

	public List<WebElement> getListElement(WebDriver driver, String locator, String... restParams) {
		return driver.findElements(getByLocator(getDynamicLocator(locator, restParams)));
	}

	public String getDynamicLocator(String locator, String... restParams) {
		return String.format(locator, (Object[]) restParams);

	}

	public void clickToElement(WebDriver driver, String locator) {
		getElement(driver, locator).click();
	}

	public void clickToElement(WebDriver driver, String locator, String... restParams) {
		getElement(driver, getDynamicLocator(locator, restParams)).click();
	}

	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}

	public void sendkeyToElement(WebDriver driver, String locator, String valueToSend) {
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(valueToSend);
	}

	public void sendkeyToElement(WebDriver driver, String locator, String valueToSend, String... restParams) {
		getElement(driver, getDynamicLocator(locator, restParams)).clear();
		getElement(driver, getDynamicLocator(locator, restParams)).sendKeys(valueToSend);
	}

	public String getElementText(WebDriver driver, String locator) {
		return getElement(driver, locator).getText();
	}

	public String getElementText(WebDriver driver, String locator, String... restParams) {
		return getElement(driver, getDynamicLocator(locator, restParams)).getText();
	}

	public void selectDropdown(WebDriver driver, String locator, String itemText) {
		new Select(getElement(driver, locator)).selectByVisibleText(itemText);
	}

	public void selectDropdown(WebDriver driver, String locator, String itemText, String... restParams) {
		new Select(getElement(driver, getDynamicLocator(locator, restParams))).selectByVisibleText(itemText);
	}

	public String getFirstSelectedOption(WebDriver driver, String locator) {
		return new Select(getElement(driver, locator)).getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		return new Select(getElement(driver, locator)).isMultiple();
	}

	public void selectItemCustomDropDown(WebDriver driver, String xpathExpression, String xpathParent,
			String xpathChild, String expectedText) {
		getElement(driver, xpathExpression).click();
		sleepInSecond(1);
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(xpathChild)));

		List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(xpathChild)));

		for (

		WebElement tempElement : allItems) {
			if (tempElement.getText().equals(expectedText)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tempElement);
				sleepInSecond(2);
				tempElement.click();
				break;

			}
		}

	}

	public String getElementAttribute(WebDriver driver, String xpathExpression, String attributeName,
			String... restParams) {
		return getElement(driver, getDynamicLocator(xpathExpression, restParams)).getAttribute(attributeName);
	}

	public String getElementAttribute(WebDriver driver, String xpathExpression, String attributeName) {
		return getElement(driver, xpathExpression).getAttribute(attributeName);
	}

	public String getElementCssValue(WebDriver driver, String xpathExpression, String PropertyName) {
		return getElement(driver, xpathExpression).getCssValue(PropertyName);
	}

	public String getHexaColorByRGBA(String rgbaColor) {
		return Color.fromString(rgbaColor).asHex().toUpperCase();
	}

	public int getListElementSize(WebDriver driver, String xpathExpression) {
		return getListElement(driver, xpathExpression).size();
	}

	public int getListElementSize(WebDriver driver, String xpathExpression, String... restParams) {
		return getListElement(driver, getDynamicLocator(xpathExpression, restParams)).size();
	}

	public void checkToCheckboxRadio(WebDriver driver, String xpathExpression) {
		if (!getElement(driver, xpathExpression).isSelected()) {
			getElement(driver, xpathExpression).click();
		}
	}

	public void checkToCheckboxRadio(WebDriver driver, String xpathExpression, String... restParams) {
		if (!getElement(driver, getDynamicLocator(xpathExpression, restParams)).isSelected()) {
			getElement(driver, getDynamicLocator(xpathExpression, restParams)).click();
		}
	}

	public void unCheckToCheckbox(WebDriver driver, String xpathExpression) {
		if (getElement(driver, xpathExpression).isSelected()) {
			getElement(driver, xpathExpression).click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String xpathExpression) {
		return getElement(driver, xpathExpression).isDisplayed();
	}

	public boolean isElementDisplayed(WebDriver driver, String xpathExpression, String... restParams) {
		return getElement(driver, getDynamicLocator(xpathExpression, restParams)).isDisplayed();
	}

	public boolean isElementSelected(WebDriver driver, String xpathExpression) {
		return getElement(driver, xpathExpression).isSelected();
	}

	public boolean isElementEnabled(WebDriver driver, String xpathExpression) {
		return getElement(driver, xpathExpression).isEnabled();
	}

	public void switchToFrame(WebDriver driver, String xpathExpression) {
		driver.switchTo().frame(getElement(driver, xpathExpression));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverToElement(WebDriver driver, String xpathExpression) {
		new Actions(driver).moveToElement(getElement(driver, xpathExpression)).perform();
	}

	public void doubleClickToElement(WebDriver driver, String xpathExpression) {
		new Actions(driver).doubleClick(getElement(driver, xpathExpression)).perform();
	}

	public void rightClickToElement(WebDriver driver, String xpathExpression) {
		new Actions(driver).contextClick(getElement(driver, xpathExpression)).perform();
	}

	public void dragAndDropToElement(WebDriver driver, String xpathSource, String xpathTarget) {
		new Actions(driver).dragAndDrop(getElement(driver, xpathSource), getElement(driver, xpathTarget)).perform();
	}

	public void sendKeyBoardToElement(WebDriver driver, String xpathExpression, Keys key) {
		new Actions(driver).sendKeys(getElement(driver, xpathExpression), key).perform();
	}

	public Object executeForBrowser(WebDriver driver, String xpathExpression) {
		return ((JavascriptExecutor) driver).executeScript(xpathExpression);
	}

	public String getInnerText(WebDriver driver) {
		return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		String textActual = (String) ((JavascriptExecutor) driver)
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
		sleepInSecond(3);
	}

	public void hightlightElement(WebDriver driver, String xpathExpression) {
		WebElement element = getElement(driver, xpathExpression);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element,
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(2);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element,
				originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String xpathExpression) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, xpathExpression));
		sleepInSecond(3);
	}

	public void scrollToElementOnTop(WebDriver driver, String xpathExpression) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				getElement(driver, xpathExpression));
	}

	public void scrollToElementOnDown(WebDriver driver, String xpathExpression) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);",
				getElement(driver, xpathExpression));
	}

	public void setAttributeInDOM(WebDriver driver, String xpathExpression, String attributeName,
			String attributeValue) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');",
				getElement(driver, xpathExpression));
	}

	public void removeAttributeInDOM(WebDriver driver, String xpathExpression, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getElement(driver, xpathExpression));
	}

	public void sendkeyToElementByJS(WebDriver driver, String xpathExpression, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')",
				getElement(driver, xpathExpression));
	}

	public String getAttributeInDOM(WebDriver driver, String xpathExpression, String attributeName) {
		return (String) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].getAttribute('" + attributeName + "');", getElement(driver, xpathExpression));
	}

	public String getElementValidationMessage(WebDriver driver, String xpathExpression) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;",
				getElement(driver, xpathExpression));
	}

	public boolean isImageLoaded(WebDriver driver, String xpathExpression) {
		return (boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getElement(driver, xpathExpression));

	}

	public boolean isPageLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};
		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
		String filePath = GlobalConstants.UPLOAD_PATH;
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getElement(driver, BasePageUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);

	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
	}

	public void waitForElementVisible(WebDriver driver, String locator, String... restParams) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(
				ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicLocator(locator, restParams))));
	}

	public void waitForListElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
	}

	public void waitForElementClickable(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementClickable(WebDriver driver, String locator, String... restParams) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicLocator(locator, restParams))));
	}

	public boolean waitForElementInvisible(WebDriver driver, String locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
	}

	public boolean waitForListElementInvisible(WebDriver driver, String locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.invisibilityOfAllElements(getListElement(driver, locator)));
	}

	public HomePageObject clickToUserLogOutLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.USER_LOGOUT_LINK);
		clickToElement(driver, BasePageUI.USER_LOGOUT_LINK);
		return PageGeneratorManage.getHomePage(driver);
	}

	public AdminLoginPageObject clickToAdminLogOutLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.ADMIN_LOGOUT_LINK);
		clickToElement(driver, BasePageUI.ADMIN_LOGOUT_LINK);
		return PageGeneratorManage.getAdminLoginPage(driver);
	}

	private long longTimeout = GlobalConstants.LONG_TIMEOUT;
	private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;
}
