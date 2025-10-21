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

public class ManagenewsTest extends BaseClass {
	HomePage home;
	ManageNewsPage news;

	@Test(priority = 2, description = "Trying to Add a News")
	public void verifyWhetherUserIsAbleCreateNewNews() throws IOException {
		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userNameValue).enterPasswordOnPasswordField(passwordValue);
		home = login.loginBtnClick();
		news = home.manageNewsMoreInfoClick();
		String newsText = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		news.newBtnClick().enterNews(newsText).saveBtnClick();
		String actual = news.AlertDisplayed();
		Assert.assertTrue(actual.contains("News Created Successfully"), Constant.UnabletoAddNewsError);

	}

	@Test(priority = 2, description = "Trying to search a News")
	public void verifyWhetherUserIsAbleSearchNews() throws IOException {
		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userNameValue).enterPasswordOnPasswordField(passwordValue);
		home = login.loginBtnClick();
		news = home.manageNewsMoreInfoClick();
		String searchText = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		System.out.println(searchText);
		news.searchBtnClick().searchTitle(searchText).searchNewsClick();
		String expected = searchText;
		String actual = news.searchTable();
		System.out.println(actual);
		Assert.assertEquals(actual, expected, Constant.UnabletoSearchNewsError);
	}
}
