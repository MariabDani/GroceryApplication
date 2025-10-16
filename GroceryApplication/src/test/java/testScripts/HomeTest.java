package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends BaseClass {
	HomePage home;
	
	@Test(priority = 1, description = "User is trying to logout")
	public void verifyLogoutUponClickingLogout() throws IOException
	{
		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUsernameOnUsernameField(userNameValue).enterPasswordOnPasswordField(passwordValue);
		home=login.loginBtnClick();
		home.adminIconClick();
		login=home.logoutBtnClick();
		String expected= "https://groceryapp.uniqassosiates.com/admin/login";
		String actual= login.actualURL();
		System.out.println(actual);
		Assert.assertEquals(actual, expected, Constant.LogOutError);
	}

}
