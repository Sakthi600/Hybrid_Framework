package runners;

import base.BrowserManager;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.BeforeClass;

@CucumberOptions(features = "src/test/resources/features", glue = { "stepdefinitions", "hooks" }, plugin = { "pretty",
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" }, monochrome = true)
public class FirefoxRunner extends AbstractTestNGCucumberTests {

	@BeforeClass(alwaysRun = true)
	public void setFirefox() {

		BrowserManager.setBrowser("firefox");

		System.out.println("Browser: FIREFOX");

		System.out.println("Thread: " + Thread.currentThread().getId());
	}
}