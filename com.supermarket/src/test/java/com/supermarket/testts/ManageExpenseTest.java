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
public void verifyWhetherAnUserIsAbleToOpenExpenseCategoryPage()
{
loginpage=new LoginPage(driver);
loginpage.login();
manageexpensepage= new ManageExpensePage(driver);
manageexpensepage.clickOnManageExpense();
manageexpensepage.clickOnExpenseCategory();
String actualText=manageexpensepage.textOfExpenseCategory();
System.out.println(actualText);
String expectedText="Expense Category";
Assert.assertEquals(actualText, expectedText);
}
@Test	
public void verifyWhetherAnUserCanEnterTheTitleOfTheExpenseAndSavetheExpense()
{
	loginpage=new LoginPage(driver);
	loginpage.login();
	manageexpensepage= new ManageExpensePage(driver);
	manageexpensepage.clickOnManageExpense();
	manageexpensepage.clickOnExpenseCategory();
	manageexpensepage.clickOnNewButton("TravelExpensesss");
	String actualText=manageexpensepage.alertTextAfterSavingTheExpense();
	System.out.println(actualText);
	String expectedText="Alert!";
	Assert.assertEquals(actualText, expectedText);
}
@Test
public void verifyWhetherUserIsAbleToResetTheExpenseEnteredInTheExpenseCategoryPage()
{
	loginpage=new LoginPage(driver);
	loginpage.login();
	manageexpensepage= new ManageExpensePage(driver);
	manageexpensepage.clickOnManageExpense();
	manageexpensepage.clickOnExpenseCategory();
	manageexpensepage.clickOnNewButtonReset("purchase");
	String actualText=manageexpensepage.textOfExpenseCategory();
	System.out.println(actualText);
	String expectedText="Expense Category";
	Assert.assertEquals(actualText, expectedText);
}
@Test	
public void verifyWhetherUserIsAbleToSearchAnItemOfTheExpenseEnterdInTheExpenseCategoryPage()
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
@Test
public void verifyWhetherAnExpeneCanBeDeleted()
{
	loginpage=new LoginPage(driver);
	loginpage.login();
	manageexpensepage= new ManageExpensePage(driver);
	manageexpensepage.clickOnManageExpense();
	manageexpensepage.clickOnExpenseCategory();
	manageexpensepage.deleteAnExpense();
	Assert.assertTrue(manageexpensepage.deleteAnExpense());
}
}
