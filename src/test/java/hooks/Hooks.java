package hooks;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

import base.BrowserManager;
import base.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	@Before
	public void setUp() {

		String browser = BrowserManager.getBrowser();

		if (browser == null || browser.isEmpty()) {
			browser = "chrome";
		}

		System.out.println("Starting Browser: " + browser);

		System.out.println("Thread ID: " + Thread.currentThread().getId());

		DriverFactory.initDriver(browser);
	}

	@After
	public void tearDown(Scenario scenario) {

		WebDriver driver = DriverFactory.getDriver();
		try {
			if (scenario.isFailed() && driver != null) {

				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

				scenario.attach(screenshot, "image/png", "Failed Screenshot");
			}

		} finally {
			DriverFactory.quitDriver();
		}

	}

}
