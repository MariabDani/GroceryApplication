package testScripts;

import java.io.IOException;

import org.testng.Assert;
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
		boolean dashBoardDisplayed= login.isDashBoardDisplayed();
		Assert.assertTrue(dashBoardDisplayed, "user unable to login with valid credentials");
	}
	
	@Test
	public void verifyLoginWithInvalidCredentials() throws IOException {
		
		String userNameValue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUsernameOnUsernameField(userNameValue);
		login.enterPasswordOnPasswordField(passwordValue);
		login.loginBtnClick();
		boolean alertBoxDisplayed=login.isAlertboxDisplayed();
		System.out.println(alertBoxDisplayed);
		Assert.assertFalse(!alertBoxDisplayed, "user is able to login with invalid credentials");
		
	}
	
	@Test
	public void verifyLoginValidUserNameInvalidPassword() throws IOException {
		
		String userNameValue = ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUsernameOnUsernameField(userNameValue);
		login.enterPasswordOnPasswordField(passwordValue);
		login.loginBtnClick();
		boolean alertBoxDisplayed= login.isAlertboxDisplayed();
		Assert.assertTrue(alertBoxDisplayed, "user is able to login with invalid credentials");
		
	}
	
	@Test
	public void verifyLoginInvalidUserNameValidPassword() throws IOException {
		
		String userNameValue = ExcelUtility.getStringData(3, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUsernameOnUsernameField(userNameValue);
		login.enterPasswordOnPasswordField(passwordValue);
		login.loginBtnClick();
		String expected= "https://groceryapp.uniqassosiates.com/admin/login";
		String actual= login.actualURL();
		System.out.println(actual);
		Assert.assertEquals(actual, expected, "user is able to login with invalid credentials");
	}

}
