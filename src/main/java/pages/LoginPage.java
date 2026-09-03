package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class LoginPage extends ElementUtils {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//span[normalize-space()='My Account'])[1]")
	private WebElement myAccount;
	@FindBy(xpath = "(//a[normalize-space()='Login'])[1]")
	private WebElement loginLink;
	@FindBy(xpath = "(//input[@id='input-email'])[1]")
	private WebElement email;
	@FindBy(xpath = "(//input[@id='input-password'])[1]")
	private WebElement password;
	@FindBy(xpath = "(//input[@value='Login'])[1]")
	private WebElement loginButton;
	
	public void openLoginPage() {
		click(myAccount);
		click(loginLink);
	}
	public void login(String username,String passwordvalue) {
		type(email, username);
		type(password, passwordvalue);
		click(loginButton);
	}
	
}
