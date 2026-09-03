package stepdefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import base.DriverFactory;

import io.cucumber.java.en.*;

import pages.LoginPage;
import pages.SearchPage;

import utils.ConfigReader;

public class SearchSteps {

	SearchPage searchPage;

	LoginPage loginPage;

	@Given("User opens the Application")
	public void useropensapplication() {
		searchPage = new SearchPage(DriverFactory.getDriver());
	}

	@When("User enters {string} in the Search field")
	public void userenterssearch(String product) {

		searchPage.enterSearch(product);
	}

	@When("User clicks the Search button")
	public void userclickssearch() {

		searchPage.clickSearch();
	}

	@When("User enters {string} in the Search Criteria field")
	public void userEntersInTheSearchCriteriaField(String string) {
		searchPage.enterSearchCriteria(string);
	}

	@Then("{string} should be displayed in the search results")
	public void productshouldbedisplayed(String product) {

		Assert.assertTrue(searchPage.isProductDisplayed(product), product + " is not displayed in search results");
	}

	@When("User clicks the Search Criteria button")
	public void userClicksTheSearchCriteriaButton() {
		searchPage.clickSearchPageButton();
	}

	@Then("no matching product message should be displayed")
	public void noproductmessage() {

		Assert.assertTrue(searchPage.isNoProductMessageDisplayed(), "No product message is not displayed");
	}

	@When("User leaves the Search field empty")
	public void leavesearchempty() {

// Intentionally empty
	}

	@When("User logs into the Application")
	public void userlogsintoapplication() {

		loginPage = new LoginPage(DriverFactory.getDriver());

		loginPage.openLoginPage();

		loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

		searchPage = new SearchPage(DriverFactory.getDriver());
	}

	@Then("more than one product should be displayed")
	public void multipleproducts() {

		int count = searchPage.getProductCount();

		Assert.assertTrue(count > 1, "Expected more than one product. " + "Actual count: " + count);
	}

	@When("User enables search in product descriptions")
	public void enabledescription() {

		searchPage.selectSearchInDescription();
	}

	@When("User selects category {string}")
	public void selectcategory(String category) {

		searchPage.selectCategory(category);
	}

	@When("User enables search in subcategories")
	public void enablesubcategory() {

		searchPage.selectSearchInSubcategories();
	}

	@When("User selects List view")
	public void selectlistview() {

		searchPage.clickListView();
	}

	@Then("List view should be displayed")
	public void verifylistview() {

		Assert.assertTrue(searchPage.isListViewDisplayed(), "List view is not displayed");
	}

	@When("User selects Grid view")
	public void selectgridview() {

		searchPage.clickGridView();
	}

	@Then("Grid view should be displayed")
	public void verifygridview() {

		Assert.assertTrue(searchPage.isGridViewDisplayed(), "Grid view is not displayed");
	}

	@When("User selects Sort By option {string}")
	public void selectsort(String option) {

		searchPage.selectSort(option);
	}

	@When("User clicks Product Compare")
	public void clickproductcompare() {

		searchPage.clickCompare();
	}

	@Then("Product Compare page should be displayed")
	public void verifycomparepage() {

		String url = DriverFactory.getDriver().getCurrentUrl();

		Assert.assertTrue(url.toLowerCase().contains("compare"), "Product Compare page is not displayed");
	}

	@When("User selects Show option {string}")
	public void selectshow(String value) {

		searchPage.selectShow(value);
	}

	@Then("Search field should be displayed")
	public void searchfielddisplayed() {

		Assert.assertTrue(searchPage.isSearchBoxDisplayed(), "Search field is not displayed");
	}

	@Then("Search button should be displayed")
	public void searchbuttondisplayed() {

		Assert.assertTrue(searchPage.isSearchButtonDisplayed(), "Search button is not displayed");
	}

	@When("User navigates to Search page")
	public void navigatetosearchpage() {

		/*
		 * Add your actual Site Map navigation here.
		 *
		 * Example:
		 *
		 * SiteMapPage siteMap = new SiteMapPage(driver);
		 *
		 * siteMap.openSearchPage();
		 */
	}

	@Then("Search breadcrumb should be displayed")
	public void searchbreadcrumb() {

		boolean displayed = DriverFactory.getDriver().findElements(By.xpath("//ul[contains(@class,'breadcrumb')]"))
				.size() > 0;

		Assert.assertTrue(displayed, "Search breadcrumb is not displayed");
	}

	@When("User performs search using keyboard")
	public void keyboardsearch() {

		searchPage.searchUsingEnter("iMac");
	}

	@Then("Search page heading should be displayed")
	public void searchheading() {

		Assert.assertTrue(searchPage.getHeading().toLowerCase().contains("search"), "Search heading is incorrect");
	}

	@Then("Search page title should be displayed")
	public void searchtitle() {

		String title = searchPage.getPageTitle();

		Assert.assertTrue(title != null && !title.trim().isEmpty(), "Page title is empty");
	}

	@Then("Search page URL should be displayed")
	public void searchurl() {

		String url = searchPage.getCurrentUrl();

		Assert.assertTrue(url != null && !url.trim().isEmpty(), "Page URL is empty");
	}

	@Then("Search UI should be displayed correctly")
	public void searchui() {

		Assert.assertTrue(searchPage.isSearchBoxDisplayed(), "Search textbox is not displayed");

		Assert.assertTrue(searchPage.isSearchButtonDisplayed(), "Search button is not displayed");
	}
}