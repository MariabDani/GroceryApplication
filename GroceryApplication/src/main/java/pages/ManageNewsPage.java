package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageNewsPage{
	
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newBtn;
	@FindBy(id="news") WebElement newsTextArea;
	@FindBy(xpath="//button[@name='create']") WebElement saveBtn;
	@FindBy(xpath="//a[@onclick='click_button(2)']") WebElement SearchBtn;
	@FindBy(xpath="//input[@name='un']") WebElement SearchTitleTxt;
	@FindBy(xpath="//button[@type='submit']") WebElement SearchNews;
	@FindBy(xpath="//a[@onclick='click_button(2)']") WebElement searchNews;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]") WebElement searchResult;
	public void newBtnClick()
	{
		newBtn.click();
	}
	
	public void enterNews( String news)
	{
		newsTextArea.sendKeys(news);
	}

	public void saveBtnClick()
	{
		saveBtn.click();
	}
	public String AlertDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		WebElement alertBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath("//div[contains(@class,'alert') and contains(@class,'alert-dismissible')]")
		));
		return alertBox.getText();
	}
	public void searchBtnClick()
	{
		SearchBtn.click();
	}
	
	public void searchTitle(String news)
	{
		SearchTitleTxt.sendKeys(news);
	}
	public void searchNewsClick()
	{
		searchNews.click();
	}
	public String searchTable()
	{
		return searchResult.getText();
	}
}
