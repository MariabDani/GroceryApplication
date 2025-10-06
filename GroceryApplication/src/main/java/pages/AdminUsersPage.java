package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminUsersPage {
	
	public WebDriver driver;
	public AdminUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newBtn;
	@FindBy(id="username") WebElement username;
	@FindBy(id="password") WebElement password;
	@FindBy(id="user_type") WebElement userTypeDrpDwn;
	@FindBy(xpath="//button[@name='Create']") WebElement saveBtn;
	//@FindBy(xpath="//div[contains(@class,'alert-success') and contains(text(),'User Created Successfully')]") WebElement alertmsg;
	
	@FindBy(xpath="//a[@onclick='click_button(2)']") WebElement searchBtn;
	@FindBy(id="un") WebElement searchUserName;
	@FindBy(id="ut") WebElement searchDrpDwn;
	@FindBy(xpath="//button[@value='sr']") WebElement srchBtn;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]") WebElement searchUser;
	@FindBy(xpath="//i[@class='ace-icon fa fa-sync-alt']") WebElement resetBtn;
	
	public void newBtnClick()
	{
		newBtn.click();
	}
	public void enterUsernameOnUsernameField(String usernameVal)
	{
		username.sendKeys(usernameVal);
	}
	public void enterPasswordOnPasswordField(String pass)
	{
		password.sendKeys(pass);
	}
	public void selectDrpDwn(String drpdwnVal)
	{
		Select select = new Select(userTypeDrpDwn);
		select.selectByValue(drpdwnVal);
	}
	public void saveBtnClick()
	{
		saveBtn.click();
	}
	public String AlertDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement alertBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath("//div[contains(@class,'alert') and contains(@class,'alert-dismissible')]")
		));
		return alertBox.getText();
	}
	
	public void searchBtnClick()
	{
		searchBtn.click();
	}
	public void enterUsernameOnSearchUsernameField(String usernameVal)
	{
		searchUserName.sendKeys(usernameVal);
	}
	public void searchDrpDwn(String drpdwnVal)
	{
		Select select = new Select(searchDrpDwn);
		select.selectByValue(drpdwnVal);
	}
	public void searchUserBtnClick()
	{
		srchBtn.click();
	}
	
	public String searchTable()
	{
		return searchUser.getText();
	}
	public void resetBtnClick()
	{
		resetBtn.click();
	}
	
	public boolean IsresetHappen() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(searchUserName));
		return searchUserName.isDisplayed();
	}

	public String actualURL()
	{
		return driver.getCurrentUrl();
	}
}
