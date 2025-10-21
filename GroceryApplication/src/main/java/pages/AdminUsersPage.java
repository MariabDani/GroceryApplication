package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUsersPage {

	public WebDriver driver;
	WaitUtility wait;
	PageUtility page;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WaitUtility();
		this.page = new PageUtility();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newBtn;
	@FindBy(id = "username")
	WebElement username;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "user_type")
	WebElement userTypeDrpDwn;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveBtn;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchBtn;
	@FindBy(id = "un")
	WebElement searchUserName;
	@FindBy(id = "ut")
	WebElement searchDrpDwn;
	@FindBy(xpath = "//button[@value='sr']")
	WebElement srchBtn;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]")
	WebElement searchUser;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-sync-alt']")
	WebElement resetBtn;
	@FindBy(xpath = "//div[contains(@class,'alert') and contains(@class,'alert-dismissible')]")
	WebElement alert;

	public AdminUsersPage newBtnClick() {
		newBtn.click();
		return this;
	}

	public AdminUsersPage enterUsernameOnUsernameField(String usernameVal) {
		username.sendKeys(usernameVal);
		return this;
	}

	public AdminUsersPage enterPasswordOnPasswordField(String pass) {
		password.sendKeys(pass);
		return this;
	}

	public AdminUsersPage selectDrpDwn(String drpdwnVal) {
		page.selectDropdownWithValue(userTypeDrpDwn, drpdwnVal);
		return this;
	}

	public AdminUsersPage saveBtnClick() {
		saveBtn.click();
		return this;
	}

	public String AlertDisplayed() {
		wait.waitUntilElementIsVisible(driver, alert);
		return alert.getText();
	}

	public AdminUsersPage searchBtnClick() {
		searchBtn.click();
		return this;
	}

	public AdminUsersPage enterUsernameOnSearchUsernameField(String usernameVal) {
		searchUserName.sendKeys(usernameVal);
		return this;
	}

	public AdminUsersPage searchDrpDwn(String drpdwnVal) {
		page.selectDropdownWithValue(searchDrpDwn, drpdwnVal);
		return this;
	}

	public AdminUsersPage searchUserBtnClick() {
		srchBtn.click();
		return this;
	}

	public String searchTable() {
		//wait.waitUntilElementIsVisible(driver, searchUser);
		return searchUser.getText();
	}

	public AdminUsersPage resetBtnClick() {
		resetBtn.click();
		return this;
	}

	public boolean IsresetHappen() {
		wait.waitUntilElementIsInvisible(driver, searchUserName);
		return searchUserName.isDisplayed();
	}

}
