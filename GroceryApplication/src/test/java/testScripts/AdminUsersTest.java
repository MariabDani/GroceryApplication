package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends BaseClass {
	
	HomePage home;
	AdminUsersPage admin;
	@Test
	public void verifyUserIsAbleToAddNewUser() throws IOException
	{
		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUsernameOnUsernameField(userNameValue).enterPasswordOnPasswordField(passwordValue);
		home=login.loginBtnClick();
		admin=home.moreInfoLinkClick();
		RandomDataUtility random= new RandomDataUtility();
		String userNameVal = random.createRandomUserName();
		String passwordVal = random.createRandomPassword();
		String typeVal=ExcelUtility.getStringData(0, 2, "AdminUserPage");
		admin.newBtnClick().enterUsernameOnUsernameField(userNameVal).enterPasswordOnPasswordField(passwordVal).selectDrpDwn(typeVal).saveBtnClick();
		String actual= admin.AlertDisplayed();
		Assert.assertTrue(actual.contains("User Created Successfully"),Constant.UserNotAddedError);
		
	}
	@Test
	public void verifyUserIsAbleToSearchUser() throws IOException
	{
		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUsernameOnUsernameField(userNameValue).enterPasswordOnPasswordField(passwordValue);
		home=login.loginBtnClick();
		admin=home.moreInfoLinkClick();
		String userNameVal = ExcelUtility.getStringData(0, 0, "AdminUserPage");
		String typeVal=ExcelUtility.getStringData(0, 2, "AdminUserPage");
		admin.searchBtnClick().enterUsernameOnSearchUsernameField(userNameVal).searchDrpDwn(typeVal).searchUserBtnClick();
		String expected=userNameVal;
		String actual= admin.searchTable();
		System.out.println(actual);
		Assert.assertEquals(actual,expected, Constant.UnabletoSearchError);
	}
	@Test
	public void verifyUserIsAbleToReset() throws IOException
	{
		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUsernameOnUsernameField(userNameValue).enterPasswordOnPasswordField(passwordValue);
		home=login.loginBtnClick();
		admin=home.moreInfoLinkClick();
		admin.searchBtnClick().enterUsernameOnSearchUsernameField("abcd").resetBtnClick();
		Boolean resetHappened= admin.IsresetHappen();
		System.out.println(resetHappened);
		Assert.assertFalse(resetHappened,Constant.UnAbletoResetError);
	}

}
