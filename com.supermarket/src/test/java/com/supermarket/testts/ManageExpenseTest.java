package com.supermarket.testts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageExpensePage;

public class ManageExpenseTest extends Base {

ManageExpensePage manageexpensepage;
LoginPage loginpage;
	
@Test
public void verifyManageExpense()
{
loginpage=new LoginPage(driver);
loginpage.login();
manageexpensepage= new ManageExpensePage(driver);
manageexpensepage.clickOnManageExpense();
}
	
@Test
public void verifyExpenseCategory()
{
loginpage=new LoginPage(driver);
loginpage.login();
manageexpensepage= new ManageExpensePage(driver);
manageexpensepage.clickOnManageExpense();
manageexpensepage.clickOnExpenseCategory();
}
@Test	
public void verifyNewButton()
{
	loginpage=new LoginPage(driver);
	loginpage.login();
	manageexpensepage= new ManageExpensePage(driver);
	manageexpensepage.clickOnManageExpense();
	manageexpensepage.clickOnExpenseCategory();
	manageexpensepage.clickOnNewButton("purchases");	
}
@Test
public void verifyNewButtonReset()
{
	loginpage=new LoginPage(driver);
	loginpage.login();
	manageexpensepage= new ManageExpensePage(driver);
	manageexpensepage.clickOnManageExpense();
	manageexpensepage.clickOnExpenseCategory();
	manageexpensepage.clickOnNewButtonReset("purchase");
}
@Test	
public void verifySearchButtonByEnteringAnItem()
{
	loginpage=new LoginPage(driver);
	loginpage.login();
	manageexpensepage= new ManageExpensePage(driver);
	manageexpensepage.clickOnManageExpense();
	manageexpensepage.clickOnExpenseCategory();
	manageexpensepage.clickOnSearchButton("purchases");  
	String actualText=manageexpensepage.SearchItemsTextOfElement();
	System.out.println(actualText);
	String expectedText="Sales";
	Assert.assertEquals(actualText, expectedText,"This TestCase has failed");
}	
}
