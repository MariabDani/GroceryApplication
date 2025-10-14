package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManagenewsTest extends BaseClass{
	
	@Test
	public void verifyUserIsAbleCreateNewNews() throws IOException {
		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUsernameOnUsernameField(userNameValue);
		login.enterPasswordOnPasswordField(passwordValue);
		login.loginBtnClick();
		HomePage home= new HomePage(driver);
		home.manageNewsMoreInfoClick();
		ManageNewsPage news= new ManageNewsPage(driver);
		news.newBtnClick();
		String newsText= ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		news.enterNews(newsText);
		news.saveBtnClick();
		String actual= news.AlertDisplayed();
		//System.out.println(admin.AlertDisplayed());
		Assert.assertTrue(actual.contains("News Created Successfully"),Constant.UnabletoAddNewsError);
		
		
	}

	@Test
	public void verifyUserIsAbleSearchNews() throws IOException {
		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUsernameOnUsernameField(userNameValue);
		login.enterPasswordOnPasswordField(passwordValue);
		login.loginBtnClick();
		HomePage home= new HomePage(driver);
		home.manageNewsMoreInfoClick();
		ManageNewsPage news= new ManageNewsPage(driver);
		news.searchBtnClick();
		String searchText= ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		System.out.println(searchText);
		news.searchTitle(searchText);
		news.searchNewsClick();
		String expected= searchText;
		String actual = news.searchTable();
		System.out.println(actual);
		Assert.assertEquals(actual,expected, Constant.UnabletoSearchNewsError);
	}
}
