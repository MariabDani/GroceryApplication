package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends BaseClass {
	HomePage home;

	@Test(priority = 1, description = "verifying login with valid credentials", groups = { "smoke" })
	public void verifyUserIsAbleToLoginWithValidCredentials() throws IOException {

		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userNameValue).enterPasswordOnPasswordField(passwordValue);
		home = login.loginBtnClick();
		boolean dashBoardDisplayed = login.isDashBoardDisplayed();
		Assert.assertTrue(dashBoardDisplayed, Constant.ValidCredentialError);
	}

	@Test(priority = 2, description = "verifying login with invalid credentials", groups = { "smoke" })
	public void verifyUserIsAbleToLoginWithInvalidCredentials() throws IOException {

		String userNameValue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userNameValue).enterPasswordOnPasswordField(passwordValue).loginBtnClick();
		boolean alertBoxDisplayed = login.isAlertboxDisplayed();
		System.out.println(alertBoxDisplayed);
		Assert.assertFalse(!alertBoxDisplayed, Constant.InValidCredentialError);

	}

	@Test(priority = 3, description = "verifying login with valid username and invalid password", retryAnalyzer = retry.Retry.class)
	public void verifyUserIsAbleToLoginValidUserNameInvalidPassword() throws IOException {

		String userNameValue = ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userNameValue).enterPasswordOnPasswordField(passwordValue).loginBtnClick();
		boolean alertBoxDisplayed = login.isAlertboxDisplayed();
		Assert.assertTrue(alertBoxDisplayed, Constant.InValidPasswordError);

	}

	@Test(priority = 4, description = "verifying login with valid username and invalid password", dataProvider = "loginProvider")
	public void verifyUserIsAbleToLoginInvalidUserNameValidPassword(String userNameValue, String passwordValue)
			throws IOException {

		// String userNameValue = ExcelUtility.getStringData(3, 0, "LoginPage");
		// String passwordValue = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userNameValue).enterPasswordOnPasswordField(passwordValue).loginBtnClick();
		String expected = "https://groceryapp.uniqassosiates.com/admin/login";
		String actual = login.actualURL();
		System.out.println(actual);
		Assert.assertEquals(actual, expected, Constant.InValidUsernameError);
	}

	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
				// new Object[] {ExcelUtility.getStringData(3,
				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
	}

}
