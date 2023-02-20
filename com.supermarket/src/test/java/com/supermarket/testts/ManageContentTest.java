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
@Test
public void verify_AlertText()
{
	String contentTitle="Make a Trip"+GeneralUtilities.getTimeStamp();
	
	loginpage= new LoginPage(driver);
	loginpage.login();
	managecontentpage=new ManageContentPage(driver);
	managecontentpage.clickOnManageContent();
	//Assert.assertTrue(managecontentpage.create_Newcontent(contentTitle,"Travel Destination"+GeneralUtilities.getTimeStamp(),"Travel"));
}

@Test
public void verify_ManageFooterText_isDisplayed()
{
	loginpage= new LoginPage(driver);
	loginpage.login();
	managecontentpage=new ManageContentPage(driver);
	managecontentpage.clickOnManageContent();
	managecontentpage.clickOnManageFooterText();
}
@Test
public void create_Newcontent()
{
	loginpage= new LoginPage(driver);
	managecontentpage=new ManageContentPage(driver);
	loginpage.login();
	managecontentpage.clickOnManageContent();
	managecontentpage.clickOnManagePage();
	managecontentpage.create_Newcontent("Tour", "Ponmudi", "1");
	
}




}
