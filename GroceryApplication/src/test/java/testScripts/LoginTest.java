package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.BaseClass;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends BaseClass{
	@Test
	public void verifyLoginWithValidCredentials() throws IOException
	{

		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUsernameOnUsernameField(userNameValue);
		login.enterPasswordOnPasswordField(passwordValue);
		login.loginBtnClick();
	}
	
	@Test
	public void verifyLoginWithInvalidCredentials() throws IOException {
		
		String userNameValue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUsernameOnUsernameField(userNameValue);
		login.enterPasswordOnPasswordField(passwordValue);
		login.loginBtnClick();
		
	}
	
	@Test
	public void verifyLoginValidUserNameInvalidPassword() throws IOException {
		
		String userNameValue = ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUsernameOnUsernameField(userNameValue);
		login.enterPasswordOnPasswordField(passwordValue);
		login.loginBtnClick();
		
	}
	
	@Test
	public void verifyLoginInvalidUserNameValidPassword() throws IOException {
		
		String userNameValue = ExcelUtility.getStringData(3, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUsernameOnUsernameField(userNameValue);
		login.enterPasswordOnPasswordField(passwordValue);
		login.loginBtnClick();
	}

}
