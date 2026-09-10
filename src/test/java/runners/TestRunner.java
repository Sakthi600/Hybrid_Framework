package runners;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;

import base.BrowserManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(features = "src/test/resources/features", glue = { "stepdefinitions", "hooks" }, plugin = { "pretty",
		"html:target/cucumber-report.html", "json:target/cucumber.json",
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" },
		// tags = "@TC_SF_007",
		dryRun = true, snippets = SnippetType.CAMELCASE, monochrome = false, publish = false)
public class TestRunner extends AbstractTestNGCucumberTests {

	@BeforeClass(alwaysRun = true)
	public void setBrowser(ITestContext context) {

		String browser = context.getCurrentXmlTest().getParameter("browser");

		if (browser == null || browser.isEmpty()) {
			browser = "chrome";
		}

		System.out.println("Browser selected: " + browser);

		System.out.println("Thread ID: " + Thread.currentThread().getId());

		BrowserManager.setBrowser(browser);
	}
}
