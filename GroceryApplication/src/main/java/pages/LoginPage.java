package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class LoginPage {

	public WebDriver driver;
	PageUtility page;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.page = new PageUtility();
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	WebElement username;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(tagName = "button")
	WebElement signInBtn;
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashBoard;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertbox;
	@FindBy(id = "remember")
	WebElement rememberMe;

	public LoginPage enterUsernameOnUsernameField(String userNameValue) {
		username.sendKeys(userNameValue);
		return this;
	}

	public LoginPage enterPasswordOnPasswordField(String passwordValue) {
		password.sendKeys(passwordValue);
		return this;
	}

	public HomePage loginBtnClick() {
		signInBtn.click();
		return new HomePage(driver);
	}

	public boolean isDashBoardDisplayed() {
		return dashBoard.isDisplayed();
	}

	public boolean isAlertboxDisplayed() {
		return alertbox.isDisplayed();
	}

	public String actualURL() {
		return driver.getCurrentUrl();
	}

	public void checkBoxClick() {
		page.selectCheckBox(rememberMe);
	}
}
