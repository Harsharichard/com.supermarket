package com.supermarket.testts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageUsersPage;
import com.supermarket.utilities.ExcelRead;

public class ManageUsersTest extends Base{
	//WebDriver driver;
	ManageUsersPage manageuserspage;
	LoginPage loginpage;
	
	@Test
	public void verifyManageUserIsClickable()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageuserspage= new ManageUsersPage(driver);
		manageuserspage.clickOnManageUsers();
		
	}
	@Test
	public void verify_ListUsersActivation()
	{
		manageuserspage= new ManageUsersPage(driver);
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageuserspage.clickOnManageUsers();
		manageuserspage.deactive_User("Sadfg Ddf");
	}

	

}
