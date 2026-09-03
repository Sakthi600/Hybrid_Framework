package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static WebDriver driver;

	public WebDriver initDriver(String browser) {

		if (browser.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("Firefox")) {

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
		}

		else if (browser.equalsIgnoreCase("Edge")) {

			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();
		}

		else {

			throw new IllegalArgumentException("Unexpected browser: " + browser);
		}

		configBrowser();

		return getDriver();
	}

	public static void configBrowser() {

		getDriver().manage().window().maximize();

		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}

	public static WebDriver getDriver() {

		return driver;
	}

	public static void quitDriver() {

		if (driver != null) {

			driver.quit();

			driver = null;
		}
	}
}
