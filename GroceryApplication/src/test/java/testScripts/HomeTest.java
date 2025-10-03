package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends BaseClass {
	
	@Test
	public void verifyLogoutUponClickingLogout() throws IOException
	{
		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUsernameOnUsernameField(userNameValue);
		login.enterPasswordOnPasswordField(passwordValue);
		login.loginBtnClick();
		HomePage home= new HomePage(driver);
		home.adminIconClick();
		home.logoutBtnClick();
	}

}
