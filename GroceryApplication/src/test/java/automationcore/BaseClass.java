package automationcore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public WebDriver driver;

	@BeforeMethod
	public void initializeBrowser()
	{
		driver= new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();

	}
	
	@AfterMethod
	public void driverClose()
	{
		//driver.close();
		//driver.quit();
	}
}
