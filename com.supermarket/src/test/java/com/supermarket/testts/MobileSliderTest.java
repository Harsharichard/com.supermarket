package com.supermarket.testts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.MobileSliderPage;

public class MobileSliderTest extends Base{
MobileSliderPage mobilesliderpage;
LoginPage loginpage;	
	
@Test
public void verifyMobileSliderPageis_Displayed()
{
	loginpage=new LoginPage(driver);
	loginpage.login();
	mobilesliderpage=new MobileSliderPage(driver);
	mobilesliderpage.clickOnMobileSliderPage();
	String actualText=mobilesliderpage.MobileSliderPageis_Displayable();
	System.out.println(actualText);
	String expectedText="List Mobile Sliders";
	Assert.assertEquals(actualText, expectedText);
}	
@Test
public void verifyAnItemCanBeDeleted()
{
	loginpage=new LoginPage(driver);
	loginpage.login();
	mobilesliderpage=new MobileSliderPage(driver);
	mobilesliderpage.clickOnMobileSliderPage();
	mobilesliderpage.deleteAnItem();
}	
@Test
public void verifyWhetherAnItemCanBeDeactivated()
{
	loginpage=new LoginPage(driver);
	loginpage.login();
	mobilesliderpage=new MobileSliderPage(driver);
	mobilesliderpage.clickOnMobileSliderPage();
	mobilesliderpage.deactivatingAnItem();
	String actualText=mobilesliderpage.deactivatingAnItem();
	System.out.println(actualText);
	String expectedText="Alert!";
	Assert.assertEquals(actualText, expectedText);
}	
}
