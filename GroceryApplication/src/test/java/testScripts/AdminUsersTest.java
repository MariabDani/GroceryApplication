package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends BaseClass {
	
	@Test
	public void verifyUserIsAbleToAddNewUser() throws IOException
	{
		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUsernameOnUsernameField(userNameValue);
		login.enterPasswordOnPasswordField(passwordValue);
		login.loginBtnClick();
		HomePage home= new HomePage(driver);
		home.moreInfoLinkClick();
		AdminUsersPage admin= new AdminUsersPage(driver);
		RandomDataUtility random= new RandomDataUtility();
		String userNameVal = random.createRandomUserName();
		String passwordVal = random.createRandomPassword();
		String typeVal=ExcelUtility.getStringData(0, 2, "AdminUserPage");
		admin.newBtnClick();
		admin.enterUsernameOnUsernameField(userNameVal);
		admin.enterPasswordOnPasswordField(passwordVal);
		admin.selectDrpDwn(typeVal);
		admin.saveBtnClick();
		//String expected= "×\r\n"+ "Alert!\r\n"+ "User Created Successfully";
		String actual= admin.AlertDisplayed();
		//System.out.println(admin.AlertDisplayed());
		Assert.assertTrue(actual.contains("User Created Successfully"),"User not added successfully");
		
	}
	@Test
	public void verifyUserIsAbleToSearchUser() throws IOException
	{
		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUsernameOnUsernameField(userNameValue);
		login.enterPasswordOnPasswordField(passwordValue);
		login.loginBtnClick();
		HomePage home= new HomePage(driver);
		home.moreInfoLinkClick();
		String userNameVal = ExcelUtility.getStringData(0, 0, "AdminUserPage");
		//String passwordVal = ExcelUtility.getStringData(0, 1, "AdminUserPage");
		String typeVal=ExcelUtility.getStringData(0, 2, "AdminUserPage");
		AdminUsersPage admin= new AdminUsersPage(driver);
		admin.searchBtnClick();
		admin.enterUsernameOnSearchUsernameField(userNameVal);
		admin.searchDrpDwn(typeVal);
		admin.searchUserBtnClick();
		String expected=userNameVal;
		String actual= admin.searchTable();
		System.out.println(actual);
		//boolean val= actual.contains("Search=sr");
		//System.out.println(val);
		Assert.assertEquals(actual,expected, "search not done successfully");
	}
	@Test
	public void verifyUserIsAbleToReset() throws IOException
	{
		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUsernameOnUsernameField(userNameValue);
		login.enterPasswordOnPasswordField(passwordValue);
		login.loginBtnClick();
		HomePage home= new HomePage(driver);
		home.moreInfoLinkClick();
		AdminUsersPage admin= new AdminUsersPage(driver);
		admin.searchBtnClick();
		admin.enterUsernameOnSearchUsernameField("abcd");
		admin.resetBtnClick();
		Boolean resetHappened= admin.IsresetHappen();
		System.out.println(resetHappened);
		Assert.assertFalse(resetHappened,"reset has not happened");
	}

}
