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
	public void verifypushNotificationAlert()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		pushnotificationpage=new PushNotificationPage(driver);
		pushnotificationpage.clickOnPushNotifiication();
		Assert.assertTrue(pushnotificationpage.clickOnSend_Key("Job", "Sales"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
