package com.supermarket.testts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageContentPage;
import com.supermarket.utilities.GeneralUtilities;

public class ManageContentTest extends Base {
ManageContentPage managecontentpage;
LoginPage loginpage;
GeneralUtilities generalutilities;

@Test
public void verify_ManagePageis_Displayed()
{	
	loginpage= new LoginPage(driver);
	managecontentpage=new ManageContentPage(driver);
	loginpage.login();
	managecontentpage.clickOnManageContent();
	managecontentpage.clickOnManagePage();
	Assert.assertTrue(managecontentpage.clickOnManagePage());
}
@Test
public void verify_ManageFooterText_isDisplayed()
{
	loginpage= new LoginPage(driver);
	loginpage.login();
	managecontentpage=new ManageContentPage(driver);
	managecontentpage.clickOnManageContent();
	managecontentpage.clickOnManageFooterText();
	managecontentpage.editManageFooterText();
	Assert.assertTrue(managecontentpage.editManageFooterText());
}
@Test
public void create_Newcontent()
{
	String contentTitle="Make a Trip"+GeneralUtilities.getTimeStamp();
	loginpage= new LoginPage(driver);
	managecontentpage=new ManageContentPage(driver);
	loginpage.login();
	managecontentpage.clickOnManageContent();
	managecontentpage.clickOnManagePage();
	managecontentpage.create_Newcontent("Tour", "Ponmudi", "1");
	Assert.assertTrue(managecontentpage.create_Newcontent(contentTitle,"Travel Destination"+GeneralUtilities.getTimeStamp(),"travelImage"));
}
@Test
public void verifyWhetherUserIsAbleToSearchContentInListPage()
{
	loginpage= new LoginPage(driver);
	managecontentpage=new ManageContentPage(driver);
	loginpage.login();
	managecontentpage.clickOnManageContent();
	managecontentpage.clickOnManagePage();
	managecontentpage.searchContentOnListPage("food items");
	String actualText=managecontentpage.displayingTheContentSearched();
	System.out.println(actualText);
	String expectedText="food items";
	Assert.assertEquals(actualText,expectedText);
}

}
