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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
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

	public By getByXpath(String xpathExpression) {
		return By.xpath(xpathExpression);
	}

	public WebElement getElement(WebDriver driver, String xpathExpression) {
		return driver.findElement(getByXpath(xpathExpression));
	}

	public List<WebElement> getListElement(WebDriver driver, String xpathExpression) {
		return driver.findElements(getByXpath(xpathExpression));
	}

	public void clickToElement(WebDriver driver, String xpathExpression) {
		getElement(driver, xpathExpression).click();
	}

	public void sendkeyToElement(WebDriver driver, String xpathExpression, String valueToSend) {
		getElement(driver, xpathExpression).clear();
		getElement(driver, xpathExpression).sendKeys(valueToSend);
	}

	public String getElementText(WebDriver driver, String xpathExpression) {
		return getElement(driver, xpathExpression).getText();
	}

	public void selectDropdown(WebDriver driver, String xpathExpression, String itemText) {
		new Select(getElement(driver, xpathExpression)).selectByVisibleText(itemText);
	}

	public String getFirstSelectedOption(WebDriver driver, String xpathExpression) {
		return new Select(getElement(driver, xpathExpression)).getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String xpathExpression) {
		return new Select(getElement(driver, xpathExpression)).isMultiple();
	}

	public void selectItemCustomDropDown(WebDriver driver, String xpathExpression, String xpathParent,
			String xpathChild, String expectedText) {
		getElement(driver, xpathExpression).click();
		sleepInSecond(1);
		new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(xpathChild)));

		List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(xpathChild)));

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

	public void checkToCheckboxRadio(WebDriver driver, String xpathExpression) {
		if (!getElement(driver, xpathExpression).isSelected()) {
			getElement(driver, xpathExpression).click();
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

	public void waitForElementVisible(WebDriver driver, String xpathExpression) {
		new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathExpression)));
	}

	public void waitForListElementVisible(WebDriver driver, String xpathExpression) {
		new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathExpression)));
	}

	public void waitForElementClickable(WebDriver driver, String xpathExpression) {
		new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathExpression)));
	}

	public void waitForListElementInvisible(WebDriver driver, String xpathExpression) {
		new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathExpression)));
	}

}
