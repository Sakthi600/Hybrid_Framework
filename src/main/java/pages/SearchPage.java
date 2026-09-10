package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class SearchPage extends ElementUtils {

	WebDriver driver;

	public SearchPage(WebDriver driver) {

		super(driver);

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

// ==========================
// SEARCH
// ==========================

	@FindBy(name = "search")
	private WebElement searchBox;

	@FindBy(css = "#search button")
	private WebElement headerSearchButton;

	@FindBy(xpath = "(//input[@id='input-search'])[1]")
	private WebElement searchPageButton;

	@FindBy(id = "input-search")
	private WebElement searchInput;

	@FindBy(xpath = "(//input[@id='button-search'])[1]")
	private WebElement searchCriteria;

	@FindBy(css = "#content h1")
	private WebElement searchPageHeading;

// ==========================
// PRODUCTS
// ==========================

	@FindBy(xpath = "//div[contains(@class,'product-thumb')]//h4/a")
	private List<WebElement> productNames;

	@FindBy(css = ".product-thumb")
	private List<WebElement> products;

// ==========================
// SEARCH OPTIONS
// ==========================

	@FindBy(id = "input-category")
	private WebElement category;

	@FindBy(id = "description")
	private WebElement descriptionCheckbox;

	@FindBy(id = "sub_category")
	private WebElement subCategoryCheckbox;

// ==========================
// LIST / GRID
// ==========================

	@FindBy(id = "list-view")
	private WebElement listView;

	@FindBy(id = "grid-view")
	private WebElement gridView;

// ==========================
// SORT / SHOW
// ==========================

	@FindBy(id = "input-sort")
	private WebElement sortDropdown;

	@FindBy(id = "input-limit")
	private WebElement showDropdown;

// ==========================
// COMPARE
// ==========================

	@FindBy(id = "compare-total")
	private WebElement compareLink;

// ==========================
// SEARCH METHODS
// ==========================

	public void enterSearch(String text) {

		type(searchBox, text);
	}

	public void enterSearchCriteria(String text) {
		type(searchCriteria, text);
	}

	public void clickSearch() {

		click(headerSearchButton);
	}

	public void clickSearchPageButton() {
		click(searchPageButton);
	}

	public void search(String text) {

		enterSearch(text);

		clickSearch();
	}

// ==========================
// PRODUCT VALIDATION
// ==========================

	public boolean isProductDisplayed(String product) {

		wait.until(driver -> !productNames.isEmpty());

		for (WebElement productElement : productNames) {

			String actualProduct = productElement.getText().trim();

			System.out.println("Product found: [" + actualProduct + "]");

			if (actualProduct.toLowerCase().contains(product.toLowerCase())) {

				return true;
			}
		}

		return false;
	}

	public boolean isNoProductMessageDisplayed() {

		String pageText = driver.getPageSource();

		return pageText.contains("There is no product that matches");
	}

	public int getProductCount() {

		return products.size();
	}

// ==========================
// CATEGORY
// ==========================

	public void selectCategory(String value) {

		selectByVisibleText(category, value);
	}

// ==========================
// DESCRIPTION
// ==========================

	public void selectSearchInDescription() {

		checkCheckbox(descriptionCheckbox);
	}

// ==========================
// SUB CATEGORY
// ==========================

	public void selectSearchInSubcategories() {

		checkCheckbox(subCategoryCheckbox);
	}

// ==========================
// LIST / GRID
// ==========================

	public void clickListView() {

		click(listView);
	}

	public void clickGridView() {

		click(gridView);
	}

	public boolean isListViewDisplayed() {

		return isDisplayed(listView);
	}

	public boolean isGridViewDisplayed() {

		return isDisplayed(gridView);
	}

// ==========================
// SORT
// ==========================

	public void selectSort(String value) {

		selectByVisibleText(sortDropdown, value);
	}

// ==========================
// SHOW
// ==========================

	public void selectShow(String value) {

		selectByVisibleText(showDropdown, value);
	}

// ==========================
// COMPARE
// ==========================

	public void clickCompare() {

		click(compareLink);
	}

// ==========================
// PAGE DETAILS
// ==========================

	public String getHeading() {

		return getText(searchPageHeading);
	}

	public String getPageTitle() {

		return driver.getTitle();
	}

	public String getCurrentUrl() {

		return driver.getCurrentUrl();
	}

// ==========================
// SEARCH UI
// ==========================

	public boolean isSearchBoxDisplayed() {

		return isDisplayed(searchBox);
	}

	public boolean isSearchButtonDisplayed() {

		return isDisplayed(headerSearchButton);
	}

// ==========================
// KEYBOARD
// ==========================

	public void searchUsingEnter(String text) {

		type(searchBox, text);

		pressEnter(searchBox);
	}
}