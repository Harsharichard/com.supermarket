package com.supermarket.testts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.DataProviders;
import com.supermarket.pages.AdminUserPage;
import com.supermarket.pages.LoginPage;
import com.supermarket.utilities.GeneralUtilities;

public class AdminUserTest extends Base{
	LoginPage loginpage;
	AdminUserPage adminUserPage;
	GeneralUtilities generalutilities;
	
@Test(groups="smoke")
public void verifyAdminUserIsClickable() 
{
	loginpage=new LoginPage(driver);
	adminUserPage=new AdminUserPage(driver);
	loginpage.login();
	Assert.assertTrue(adminUserPage.clickOnAdminUser());
}	
@Test(groups="sanity")
public void verifyPasswordis_Displayed()
{
	loginpage= new LoginPage(driver);
	loginpage.login();
	adminUserPage=new AdminUserPage(driver);
	adminUserPage.clickOnAdminUser();
	adminUserPage.clickOnPasswordOption();
	Assert.assertTrue(adminUserPage.clickOnPasswordOption());
}	
@Test (dataProvider = "userCredentials",dataProviderClass=DataProviders.class)
public void verify_newUserCreation(String userName, String password, String userType)
{
	loginpage= new LoginPage(driver);
	adminUserPage=new AdminUserPage(driver);
	loginpage.login();
	adminUserPage.clickOnAdminUser();
	String user_Name=userName+GeneralUtilities.getTimeStamp();
	adminUserPage.create_NewUser("user1","user1","Staff");
}	
}
