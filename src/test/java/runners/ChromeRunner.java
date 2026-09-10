package runners;

import base.BrowserManager;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.BeforeClass;

@CucumberOptions(features = "src/test/resources/features", glue = { "stepdefinitions", "hooks" }, plugin = { "pretty",
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" }, monochrome = false)
public class ChromeRunner extends AbstractTestNGCucumberTests {

	@BeforeClass(alwaysRun = true)
	public void setChrome() {

		BrowserManager.setBrowser("chrome");

		System.out.println("================================");

		System.out.println("Browser selected: CHROME");

		System.out.println("Thread ID: " + Thread.currentThread().getId());

		System.out.println("================================");
	}
}