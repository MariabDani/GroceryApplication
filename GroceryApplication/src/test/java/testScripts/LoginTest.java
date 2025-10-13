package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends BaseClass{
	@Test(priority = 1, description = "verifying login with valid credentials", groups = {"smoke"})
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
	
	@Test(priority = 2, description = "verifying login with invalid credentials", groups = {"smoke"})
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
	
	@Test(priority = 3, description = "verifying login with valid username and invalid password")
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
	
	@Test(priority = 4, description = "verifying login with valid username and invalid password")
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
