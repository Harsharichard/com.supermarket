package com.supermarket.testts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.DataProviders;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageUsersPage;
import com.supermarket.utilities.ExcelRead;

public class ManageUsersTest extends Base{
	ManageUsersPage manageuserspage;
	LoginPage loginpage;
	
@Test
public void verifyManageUserIsClickable()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageuserspage= new ManageUsersPage(driver);
		manageuserspage.clickOnManageUsers();
		String actualText=manageuserspage.manageUseris_Displayed();
		System.out.println(actualText);
		String expectedText="List Users";
		Assert.assertEquals(actualText,expectedText);
		
	}

@Test
public void verifyWhetherUsersNameCanSearch()
 {
	manageuserspage= new ManageUsersPage(driver);
	loginpage=new LoginPage(driver);
	loginpage.login();
	manageuserspage.clickOnManageUsers();
	String actualText=manageuserspage.clickOnSearch("namisha");
	System.out.println(actualText);
	String expectedText=".........RESULT NOT FOUND.......";
	Assert.assertEquals(actualText,expectedText);
 }

}
