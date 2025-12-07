package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.Prelogin_Page;

public class TC001_Logout_Application extends BaseClass{

	
	@BeforeTest
	public void setData()
	{
		dataFile = "Test Data";
		testCaseName = "TC001_Logout";
	}
	
	@Test(dataProvider="getData")
	public void logoutApplication(String username , String password) throws InterruptedException
	{
		Prelogin_Page pl = new Prelogin_Page(driver);
		pl.enterUsername(username)
		.enterPassword(password)
		.clickLoginButton()
		.clickLogOutButton()
		.getPageTitle();
	}
	
}
