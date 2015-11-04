package com.medibank.interview.pageObjects;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.pagefactory.Annotations;
import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.internal.seleniumemulation.GetAlert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.google.common.base.Function;

//import com.mebank.resources.Utilities;

public class PageObject {

	public final static int THREE_SECONDS = 3;
	public final static int THREE_SECONDS_IN_MS = 3000;
	public final static int FIVE_SECONDS = 5;
	public final static int FIVE_SECONDS_IN_MS = 5000;
	public final static int TEN_SECONDS = 10;
	public final static int TEN_SECONDS_IN_MS = 10000;
	public final static int FIFTEEN_SECONDS = 15;
	public final static int FIFTEEN_SECONDS_IN_MS = 15000;
	public final static int THIRTY_SECONDS = 100;
	public final static int THIRTY_SECONDS_IN_MS = 30000;
	public final static int FORTYFIVE_SECONDS = 45;
	public final static int FORTYFIVE_SECONDS_IN_MS = 45000;
	public final static int SIXTY_SECONDS = 60;
	public final static int SIXTY_SECONDS_IN_MS = 60000;

	public void waitForFrameAndSwitchToIt(WebDriver driver, String frameName) {
		WebDriverWait wait = new WebDriverWait(driver, THIRTY_SECONDS);
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(frameName));
		System.out.println("switched into frame " + frameName);
	}

	public void waitForFrameAndSwitchToIt(WebDriver driver, By selector) {
		WebDriverWait wait = new WebDriverWait(driver, THIRTY_SECONDS);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(selector));
		System.out.println("switched into frame " + selector.toString());
	}

	public void waitForFrameAndSwitchToIt(WebDriver driver, By selector,
			int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(selector));
		System.out.println("switched into frame " + selector.toString());
	}

	public void waitUntilLoadedAndElementClickable(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, THIRTY_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		/*
		 * try { wait.until(ExpectedConditions.elementToBeClickable(locator)); }
		 * catch (TimeoutException toe) {
		 * System.out.println(locator.toString()); }
		 */}

	public void waitUntilLoadedAndElementVisible(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, THIRTY_SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitUntilLoadedAndTextPresentInElement(WebDriver driver,
			By locator, String text) {
		WebDriverWait wait = new WebDriverWait(driver, THIRTY_SECONDS);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(locator,
				text));
	}

	public void waitUntilLoadedAndPageTitleContains(WebDriver driver,
			String pageTitle) {
		WebDriverWait wait = new WebDriverWait(driver, THIRTY_SECONDS, 1000);
		wait.until(ExpectedConditions.titleContains(pageTitle));
	}

	public WebElement waitAndGetElement(final By locator, WebDriver driver) {
		waitForElement(locator, driver);
		return driver.findElement(locator);
	}

	// TODO need a configurable timeout as 30 seconds might be too slow
	public void waitForElement(final By locator, WebDriver driver) {
		new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(3, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class)
				.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(locator);
					}
				});
	}

	




	public static void waitUntilElementClickable(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, THIRTY_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static boolean isElementPresent(WebDriver driver, By by) {
		System.out.println("isElementPresent " + by);

		if (by == null)
			System.out.println("by is null - null pointer exception coming ");
		try {
			driver.findElement(by);
			return true; // Success!
		} catch (NoSuchElementException ignored) {
			return false;
		}
		// catch (NullPointerException ignored) {
		// return false;
		// }
	}

	public static boolean isAvailable(WebDriver driver, By selector)
			throws Error {
		return isAvailable(driver, FIFTEEN_SECONDS_IN_MS, selector);
	}

	public static boolean isAvailable(WebDriver driver, int timeout, By selector)
			throws Error {
		System.out.println("isAvailable " + selector);

		long startTime = System.currentTimeMillis();
		Long failAt = System.currentTimeMillis() + timeout;
		boolean available = false;
		Outer: do {
			if (isElementPresent(driver, selector)) {
				available = true;
				break Outer;
			}
		} while (System.currentTimeMillis() < failAt);

		if (available) {
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			System.out.println("whenAvailable " + selector.toString()
					+ "time to run method : " + elapsedTime);
			return available;
		}
		System.out.println("Could not find element " + selector + " after "
				+ timeout / 1000 + " seconds");
		throw new junit.framework.AssertionFailedError(
				"Could not find element " + selector + " after " + timeout
						/ 1000 + " seconds");
	}

	public static boolean isPresent(WebDriver driver, By selector) throws Error {
		return isPresent(driver, FIFTEEN_SECONDS_IN_MS, selector);
	}

	public static boolean isPresent(WebDriver driver, int timeout, By selector)
			throws Error {
		System.out.println("isPresent " + selector);

		long startTime = System.currentTimeMillis();
		Long failAt = System.currentTimeMillis() + timeout;
		boolean available = false;
		Outer: do {
			if (isElementPresent(driver, selector)) {
				available = true;
				break Outer;
			}
		} while (System.currentTimeMillis() < failAt);

		if (available) {
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			System.out.println("whenAvailable " + selector.toString()
					+ " time to run method : " + elapsedTime);
			return available;
		} else {
			System.out.println("Could not find element " + selector + " after "
					+ timeout / 1000 + " seconds");
			return available;
		}
	}

	public static void waitForPageToLoad(WebDriver driver, int timeOutInSeconds) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String command = "return document.readyState";

		// Check the readyState before doing any waits
		if (js.executeScript(command).toString().equals("complete")) {
			System.out.println("waitForPageToLoad() - JS document state "
					+ js.executeScript(command).toString());
			return;
		}

		for (int i = 0; i < timeOutInSeconds; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}

			if (js.executeScript(command).toString().equals("complete")) {
				System.out
						.println("waitForPageToLoad() - JS document state after "
								+ timeOutInSeconds
								+ " secs:"
								+ js.executeScript(command).toString());
				break;
			}
		}
	}

	// =============================================================END OF WAIT
	// METHODS=============================================================

	public List<String> getWindowHandles(WebDriver driver) {
		List<String> windowHandles = new ArrayList<String>(
				driver.getWindowHandles());

		for (int i = 0; i < windowHandles.size(); i++) {
			System.out.println("getWindowHandles() - browser window handle "
					+ i + " : " + windowHandles.get(i));
		}

		return windowHandles;

	}



	public WebDriver switchToChildWindow(WebDriver driver) {
		String parentWindow = driver.getWindowHandle();// active or current
														// window
		Set<String> handles = driver.getWindowHandles(); // any other window
															// other than
															// active. this is
															// only seeing
															// window in IE.

		/*
		 * for(int i=0; i < 3; i++) { Set<String>
		 * availableWindows=driver.getWindowHandles();
		 * System.out.println("how many windows?" +
		 * Integer.toString(availableWindows.size()));
		 * if(availableWindows.size()==2) break; System.out.println("sleeping");
		 * sleep(5000); }
		 */

		int i = 0;
		for (String windowHandle : handles) {
			i = i + 1;
			System.out.println("i" + Integer.toString(i));
			if (!windowHandle.equals(parentWindow)) {

				driver = driver.switchTo().window(windowHandle);
				System.out.println(driver.getTitle());

				// driver.close(); //closing child window
				// driver.switchTo().window(parentWindow); //cntrl to parent
				// window
			}
		}
		return driver;
	}

	public void switchToChildWindow(WebDriver driver,
			List<String> windowHandles, String childWH, String pageTitle) {
		Reporter.log("switchToChildBrowser() - switching to child browser: "
				+ childWH, true);

		boolean pageTitleFlag = false;

		System.out.println("!!!!!!   PAGE TITLE Before Switch !!!!!! "
				+ driver.getTitle());
		driver.switchTo().window(childWH);
		new WebDriverWait(driver, THIRTY_SECONDS, 1000)
				.until(ExpectedConditions.titleContains(pageTitle));
		pageTitleFlag = driver.getTitle().startsWith(pageTitle);

		System.out.println("!!!!!!   PAGE TITLE After Switch !!!!!! "
				+ driver.getTitle());

		if (pageTitleFlag) {
			System.out
					.println("switchToChildBrowser() - switched to child browser");
		} else {
			Reporter.log(
					"switchToChildBrowser() - failed to switch to the right Child Browser not found. Expected Page Title: '"
							+ pageTitle
							+ "'"
							+ " Found Page Title: '"
							+ driver.getTitle() + "'", true);

			Assert.assertTrue(
					"switchToChildBrowser() - failed to switch to the right Child Browser not found. Expected Page Title: '"
							+ pageTitle
							+ "'"
							+ " Found Page Title: '"
							+ driver.getTitle() + "'", false);
		}
	}

	public void goBackToParentPage(WebDriver driver, String windowHandle) {
		closeChildWindow(driver);
		switchBackToParentWindow(driver, windowHandle);
	}

	public void switchBackToParentWindow(WebDriver driver, String parentWH) {
		driver.switchTo().window(parentWH);
	}

	public void closeChildWindow(WebDriver driver) {
		driver.close();
	}

	// ================================================ END OF SWITCHING WINDOW
	// METHODS =============================================================

	public void clickAndHoldAndRelease(WebDriver driver, WebElement element) {
		Actions builder = new Actions(driver);
		builder.clickAndHold(element).release().build().perform();
	}

	public static void clickHoldRelease(WebDriver driver, WebElement element) {
		Actions builder = new Actions(driver);
		builder.clickAndHold(element).release().build().perform();
	}

	// for testing max character
	


	

	public static void highlightElement(WebDriver driver, WebElement element) {
		for (int i = 0; i < 10; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);",
					element, "color: red; border: 2px solid red;");
			js.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);",
					element, "");
		}
	}

	public static void sleep(int sleepTime) {
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}
	}

	// TODO. this is not working when switch into frame ?
	public static void savePageSource(WebDriver driver, String filename) {
		// TODO if file

		File file = new File("C:\\1Ravee\\WorkSpace_T24\\T24App\\" + filename
				+ ".html");
		FileWriter writer;
		PrintWriter printer = null;
		try {
			writer = new FileWriter(file, true);
			// writer = new FileWriter(file);
			printer = new PrintWriter(writer);
			printer.append(driver.getPageSource());
			printer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (printer != null)
				printer.close();
		}
	}

	public static void listAllElementsOnPage(WebDriver driver) {
		List<WebElement> e = driver.findElements(By.xpath("//*"));
		for (WebElement el : e) {
			System.out.println(el.getTagName());
		}

	}

	public static void listAllElementsOnPage(WebDriver driver, By locator) {
		List<WebElement> e = driver.findElements(locator);
		for (WebElement el : e) {
			System.out.println(el.getTagName());
			System.out.println(el.getAttribute("longdesc"));
		}

	}

	public void setCheckbox(WebElement checkBox, boolean checkRequired) {
		System.out.println("is the checkbox selected ? "
				+ Boolean.toString(checkBox.isSelected()));
		// if true and not selected then select ( check )
		// if false and selected then select ( i.e. uncheck )
		if ((checkRequired && !checkBox.isSelected())
				|| (!checkRequired && checkBox.isSelected())) {
			checkBox.click();
		}
	}

	public By getBy(String fieldName) {
		try {
			return new Annotations(this.getClass().getDeclaredField(fieldName))
					.buildBy();
		} catch (NoSuchFieldException e) {
			return null;
		}
	}

	public void clickOkOnConfirm(WebDriver driver) {

		Alert alert = switchToAlert(driver); // this should take care of
												// checking for the null
		if (alert == null)
			Assert.assertTrue("click on confirm alert was null", false);
		if (alert.getText() == null)
			Assert.assertTrue(
					"confirm alert was present but the dialog did not display any text",
					false);
		System.out.println(alert.getText());
		alert.accept();
	}

	public Alert switchToAlert(WebDriver driver) {
		Long failAt = System.currentTimeMillis() + Integer.parseInt("10000");
		do {
			try {
				sleep(1000);
				System.out.println("trying to switch to alert");
				return driver.switchTo().alert();
			} catch (org.openqa.selenium.NoAlertPresentException exception) {
				System.out.println("no alert present exception?");
				System.out.println(exception.getMessage());
				// We ignore this execption, as it means there is no alert
				// present...yet.
				return null;
			}
			// TODO do we need to catch a null ?
			// Other exceptions will be ignored and up the stack
		} while (System.currentTimeMillis() < failAt);
	}

	// scroll to the top of the page
	public static void scrollUp(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(250,0);");
	}

	// Click the element if the previous click failed
	public static boolean confirmClickTab(WebElement tabParentElement)
			throws Error {
		return confirmClickTab(tabParentElement, THIRTY_SECONDS_IN_MS);
	}

	public static boolean confirmClickTab(WebElement tabParentElement,
			WebElement msgTimeOutErrorMessageElement) throws Error {
		return confirmClickTab(tabParentElement, msgTimeOutErrorMessageElement,
				THIRTY_SECONDS_IN_MS);
	}

	public static boolean confirmClickTab(WebElement tabParentElement,
			int timeout) {
		boolean clicked = false;
		int retryCounter = 0;
		Reporter.log(
				"confirmClickTab() - class: "
						+ tabParentElement.getAttribute("class"), true);

		long startTime = System.currentTimeMillis();
		Long failAt = System.currentTimeMillis() + timeout;

		boolean tabFlag = tabParentElement.getAttribute("class").startsWith(
				"nonactive");
		Reporter.log("confirmClickTab() - tab not clicked: " + tabFlag, true);

		if (!tabFlag) {
			clicked = true;
		}

		while (tabFlag && System.currentTimeMillis() < failAt) {
			retryCounter++;
			tabParentElement.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			Reporter.log(
					"confirmClickTab() - After " + retryCounter
							+ " retries- class: "
							+ tabParentElement.getAttribute("class"), true);

			tabFlag = tabParentElement.getAttribute("class").startsWith(
					"nonactive");
			Reporter.log("confirmClickTab() - After " + retryCounter
					+ "  retries- tab not clicked: " + tabFlag, true);
			if (!tabFlag) {
				clicked = true;
				break;
			}
		}

		if (clicked) {
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			System.out.println("confirmClickTab() - " + tabParentElement
					+ "time to run method : " + elapsedTime);
			return clicked;
		}
		System.out.println("confirmClickTab() - Could not find element "
				+ tabParentElement + " after " + timeout / 1000 + " seconds");
		throw new junit.framework.AssertionFailedError(
				"confirmClickTab() - Could not find element "
						+ tabParentElement + " after " + timeout / 1000
						+ " seconds");
	}

	public static boolean confirmClickTab(WebElement tabParentElement,
			WebElement timeOutErrorMessageElement, int timeout) {
		boolean clicked = false;
		boolean timeOutErrorFlag;
		boolean tabFlag;
		int retryCounter = 0;

		Reporter.log(
				"confirmClickTab() - class: "
						+ tabParentElement.getAttribute("class"), true);

		long startTime = System.currentTimeMillis();
		Long failAt = System.currentTimeMillis() + timeout;

		tabFlag = tabParentElement.getAttribute("class")
				.startsWith("nonactive");

		try {
			timeOutErrorFlag = timeOutErrorMessageElement.isDisplayed();
		} catch (NoSuchElementException e) {
			timeOutErrorFlag = false;
		}

		Reporter.log("confirmClickTab() - tab not clicked: " + tabFlag, true);
		Reporter.log("confirmClickTab() - timeout error on tab click: "
				+ timeOutErrorFlag, true);

		if (!tabFlag && !timeOutErrorFlag) {
			clicked = true;
		}

		while ((tabFlag || timeOutErrorFlag)
				&& System.currentTimeMillis() < failAt) {
			retryCounter++;
			tabParentElement.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			Reporter.log(
					"confirmClickTab() - After " + retryCounter
							+ " retries- class: "
							+ tabParentElement.getAttribute("class"), true);

			tabFlag = tabParentElement.getAttribute("class").startsWith(
					"nonactive");

			try {
				timeOutErrorFlag = timeOutErrorMessageElement.isDisplayed();
			} catch (NoSuchElementException e) {
				timeOutErrorFlag = false;
			}

			Reporter.log("confirmClickTab() - After " + retryCounter
					+ "  retries- tab not clicked: " + tabFlag, true);
			Reporter.log("confirmClickTab() - After " + retryCounter
					+ " retries- timeout error on tab click: "
					+ timeOutErrorFlag, true);

			if (!tabFlag && !timeOutErrorFlag) {
				clicked = true;
				break;
			}
		}

		if (clicked) {
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			System.out.println("confirmClickTab() - whenAvailable "
					+ tabParentElement + "time to run method : " + elapsedTime);
			return clicked;
		}
		System.out.println("confirmClickTab() - Could not find element "
				+ tabParentElement + " after " + timeout / 1000 + " seconds");
		throw new junit.framework.AssertionFailedError(
				"confirmClickTab() - Could not find element "
						+ tabParentElement + " after " + timeout / 1000
						+ " seconds");
	}

	// ============================================================================================================================

	public boolean confirmClickToSwitchWindow(WebDriver driver,
			int expectedNumberOfWindowHandles, WebElement btnToClick) {
		boolean childBrowserStatus = false;
		boolean retryClick = false;
		long startTime = System.currentTimeMillis();
		long midTime = System.currentTimeMillis() + FORTYFIVE_SECONDS_IN_MS / 2;
		Long failAt = System.currentTimeMillis() + FORTYFIVE_SECONDS_IN_MS;

		Outer: do {
			List<String> windowHandles = getWindowHandles(driver);

			if (windowHandles.size() == expectedNumberOfWindowHandles) {
				Reporter.log(
						"confirmClickToSwitchWindow() - Number of windows found: "
								+ windowHandles.size(), true);
				childBrowserStatus = true;
				break Outer;
			}

			if (!retryClick && System.currentTimeMillis() > midTime) {
				clickAndHoldAndRelease(driver, btnToClick);
				// btnToClick.click();
				retryClick = true;
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
				}
				System.out
						.println("confirmClickToSwitchWindow() - clicked during retry");
			}

		} while (!childBrowserStatus && System.currentTimeMillis() < failAt);

		if (childBrowserStatus) {
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			System.out
					.println("confirmClickToSwitchWindow() - time to run method : "
							+ elapsedTime);
		}
		return childBrowserStatus;
	}

	// ============================================================================================================================

}
