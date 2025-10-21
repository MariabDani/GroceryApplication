package utilities;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	public void selectDropdownWithValue(WebElement element, String value) {

		Select object = new Select(element);
		object.selectByValue(value);

	}

	public void selectDropdownWithIndex(WebElement element, int index) {

		Select object = new Select(element);
		object.selectByIndex(index);

	}

	public void selectDropdownWithVisibleText(WebElement element, String value) {

		Select object = new Select(element);
		object.selectByVisibleText(value);

	}

	public void selectCheckBox(WebElement element) {
		element.click();
	}

	public void selectRadioButton(WebElement element) {
		element.click();
	}

	public void rightClick(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).build().perform();
	}

	public void mouseHover(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement drag, WebElement drop) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(drag, drop).build().perform();
	}

	public void alertAcceptConfirmation(WebDriver driver) {
		Alert al = driver.switchTo().alert();
		al.accept();

	}

	public void alertDismissConfirmation(WebDriver driver) {
		Alert al = driver.switchTo().alert();
		al.dismiss();

	}

	public void alertPromptAcceptConfirmation(WebDriver driver, String promptText) {

		Alert al = driver.switchTo().alert();
		al.sendKeys(promptText);
		al.accept();

	}

	public void clickElementJavaScript(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver; // casting the control of driver
		js.executeScript("arguments[0].click();", element); // to execute an action and
															// arguments[0].click()-->predefined method if normal
															// click() is not worked

	}

	public void scrollWindow(WebDriver driver, int x_axis, int y_axis) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0,350)", "");
		String script = String.format("window.scrollBy(%d, %d);", x_axis, y_axis);
		js.executeScript(script);
	}

	public void scrollToElement(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "arguments[0].scrollIntoView(true);"; // The argument[0] refers to the WebElement passed as the
																// second argument to executeScript
		js.executeScript(script, element);
	}

	public void swithToWindow(WebDriver driver, String parentWindowID) {

		Set<String> handleIds = driver.getWindowHandles();
		Iterator<String> it = handleIds.iterator();
		while (it.hasNext()) {
			String currentId = it.next();
			if (!currentId.equals(parentWindowID)) {
				driver.switchTo().window(currentId);
			}
		}
	}

	public void switchToFrame(WebDriver driver, WebElement frameElement) {

		driver.switchTo().frame(frameElement);
	}

}
