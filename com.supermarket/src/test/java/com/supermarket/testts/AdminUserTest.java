package com.supermarket.testts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.DataProviders;
import com.supermarket.pages.AdminUserPage;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageUsersPage;
import com.supermarket.utilities.GeneralUtilities;

public class AdminUserTest extends Base{

	//WebDriver Driver;
	LoginPage loginpage;
	AdminUserPage adminUserPage;
	GeneralUtilities generalutilities;
	
	@Test(groups="smoke")
public void verifyAdminUserIsClickable() {
	loginpage=new LoginPage(driver);
	loginpage.login();
	adminUserPage=new AdminUserPage(driver);
	adminUserPage.clickOnAdminUser();
}	
	@Test(groups="sanity")
	public void verifyPasswordis_Displayed()
	{
		loginpage= new LoginPage(driver);
		loginpage.login();
		adminUserPage=new AdminUserPage(driver);
		adminUserPage.clickOnAdminUser();
		adminUserPage.clickOnPasswordOption();
		
		/*String expectedText="Pwd_999";
		adminUserPage.getPasswordText("nana.mcclure");
		Assert.assertEquals(actualText, expectedText);&*/
		
	}
	
@Test (dataProvider = "userCredentials",dataProviderClass=DataProviders.class)
public void verify_newUserCreation(String userName, String password, String userType)
{
	loginpage= new LoginPage(driver);
	adminUserPage=new AdminUserPage(driver);
	loginpage.login();
	String user_Name=userName+GeneralUtilities.getTimeStamp();
	adminUserPage.create_NewUser(user_Name,password,userType);
	//Assert.assertTrue(adminUserPage.create_NewUser(user_Name,password,userType));
	
	
}
	
	
	
	
	
}
