package com.supermarket.testts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.PushNotificationPage;
import com.supermarket.utilities.GeneralUtilities;

public class PushNotificationTest extends Base{
	
	LoginPage loginpage;
	PushNotificationPage pushnotificationpage;
	GeneralUtilities generalutilities;	
	
	@Test
	public void verifyIfTheUserIsAbleToEnterPushNotificationInformation()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		pushnotificationpage=new PushNotificationPage(driver);
		pushnotificationpage.clickOnPushNotifiication();
		Assert.assertTrue(pushnotificationpage.clickOnSend_Key("Job", "Sales"));
	}
	@Test
	public void verifyIfUserIsAbleToResetInformationEnteredInTheTitleAndDescriptionColumn()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		pushnotificationpage=new PushNotificationPage(driver);
		pushnotificationpage.clickOnPushNotifiication();
		pushnotificationpage.clickOnSend_Key("Job", "Sales");
		Assert.assertTrue(pushnotificationpage.clickOnResetButton());
	}
	@Test
	public void verifyIftheHomeLinkInNotificationPageIsRedirectingToTheHomePage()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		pushnotificationpage=new PushNotificationPage(driver);
		pushnotificationpage.clickOnPushNotifiication();
		String actualText=pushnotificationpage.clickOnHomeLink();
		System.out.println(actualText);
		String expectedText="Admin";
		Assert.assertEquals(actualText, expectedText);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
