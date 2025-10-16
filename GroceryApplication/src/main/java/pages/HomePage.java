package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//a[@data-toggle='dropdown']") WebElement adminIcon;
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']") WebElement logoutBtn;
	@FindBy(xpath="//p[text()='Admin Users']/ancestor::div[@class='small-box bg-info']/a") WebElement moreInfolink;
	@FindBy(xpath="//p[text()='Manage News']/ancestor::div[@class='small-box bg-info']/a") WebElement manageNewMoreInfo;
	public HomePage adminIconClick()
	{
		adminIcon.click();
		return this;
	}
	
	public LoginPage logoutBtnClick()
	{
		logoutBtn.click();
		return new LoginPage(driver);
	}
	
	public String actualURL()
	{
		return driver.getCurrentUrl();
	}
	
	public AdminUsersPage moreInfoLinkClick()
	{
		moreInfolink.click();
		return new AdminUsersPage(driver);
	}

	public ManageNewsPage manageNewsMoreInfoClick()
	{
		manageNewMoreInfo.click();
		return new ManageNewsPage(driver);
	}
}
