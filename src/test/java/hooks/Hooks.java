package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import utils.ConfigReader;

public class Hooks {

	DriverFactory DF;

	@Before(order = 0)
	public void setUp() {

		DF = new DriverFactory();

		DF.initDriver(ConfigReader.getProperty("browser"));

		DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
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

