package utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	protected WebDriver driver;
	protected WebDriverWait wait;


	public ElementUtils(WebDriver driver) {

		this.driver = driver;

		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}



	public void click(WebElement element) {

		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}



	public void type(WebElement element, String text) {

		WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));

		webElement.clear();

		if (text != null) {
			webElement.sendKeys(text);
		}
	}



	public String getText(WebElement element) {

		return wait.until(ExpectedConditions.visibilityOf(element)).getText();
	}



	public boolean isDisplayed(WebElement element) {

		try {

			return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();

		} catch (Exception e) {

			return false;
		}
	}



	public boolean isEnabled(WebElement element) {

		try {

			return wait.until(ExpectedConditions.visibilityOf(element)).isEnabled();

		} catch (Exception e) {

			return false;
		}
	}



	public boolean isSelected(WebElement element) {

		return element.isSelected();
	}



	public void checkCheckbox(WebElement element) {

		wait.until(ExpectedConditions.elementToBeClickable(element));

		if (!element.isSelected()) {

			element.click();
		}
	}



	public void uncheckCheckbox(WebElement element) {

		wait.until(ExpectedConditions.elementToBeClickable(element));

		if (element.isSelected()) {

			element.click();
		}
	}



	public void selectByVisibleText(WebElement element, String value) {

		wait.until(ExpectedConditions.visibilityOf(element));

		Select select = new Select(element);

		select.selectByVisibleText(value);
	}



	public void selectByValue(WebElement element, String value) {

		wait.until(ExpectedConditions.visibilityOf(element));

		Select select = new Select(element);

		select.selectByValue(value);
	}



	public void selectByIndex(WebElement element, int index) {

		wait.until(ExpectedConditions.visibilityOf(element));

		Select select = new Select(element);

		select.selectByIndex(index);
	}



	public String getAttribute(WebElement element, String attribute) {

		return element.getAttribute(attribute);
	}



	public void clear(WebElement element) {

		wait.until(ExpectedConditions.visibilityOf(element)).clear();
	}



	public int getElementCount(List<WebElement> elements) {

		return elements.size();
	}

	public void pressEnter(WebElement element) {
		element.sendKeys(Keys.ENTER);
	}


	public void scrollToElement(WebElement element) {

		((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}



	public void javaScriptClick(WebElement element) {

		((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public void sendKeys(WebElement element, org.openqa.selenium.Keys key) {

		wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(key);
	}
}
