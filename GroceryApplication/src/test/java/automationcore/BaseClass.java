package automationcore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenshotUtility;

public class BaseClass {
	Properties prop;
	FileInputStream fin;
	public WebDriver driver;

	@BeforeMethod(alwaysRun=true)
	@Parameters("browsers")
	public void initializeBrowser(String browsers) throws IOException
	{
		//System.out.println("Step 1: Starting browser initialization");
		prop= new Properties();
		fin = new FileInputStream(Constant.ConfigFile);
		prop.load(fin);
//		System.out.println(prop.getProperty("url"));
//		try {
//		    prop = new Properties();
//		    System.out.println("ConfigFile path: " + Constant.ConfigFile);
//		    fin = new FileInputStream(Constant.ConfigFile);    // likely failing here
//		    prop.load(fin);                                    // or here
//		    System.out.println("Loaded props. url=" + prop.getProperty("url"));
//		} catch (Exception e) {
//		    e.printStackTrace(); // this will finally show the stack trace in console
//		    throw e;             // rethrow so TestNG marks it properly
//		} finally {
//		    if (fin != null) fin.close();
//		}
		if (browsers.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browsers.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browsers.equalsIgnoreCase("Edge")) {

			WebDriverManager.edgedriver().clearResolutionCache().forceDownload().setup();
			driver = new EdgeDriver();
		}

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5) );
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.elementToBeClickable(showMessageBtn));

	}
	
	@AfterMethod(alwaysRun=true)
	public void driverQuit(ITestResult iTestResult) throws IOException {

		if (iTestResult.getStatus() == ITestResult.FAILURE) {

		ScreenshotUtility screenShot = new ScreenshotUtility();
		screenShot.getScreenshot(driver, iTestResult.getName());
		}
		//driver.quit();

		} 
}
