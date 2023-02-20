package com.supermarket.testts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LoginPage;
import com.supermarket.utilities.ExcelRead;
import com.supermarket.utilities.ScreenShots;

public class LoginTest extends Base{
	LoginPage loginpage;
	ExcelRead excelread=new ExcelRead();
	
	
	
@Test(groups="smoke")
public void verifyLogin()
{
	loginpage=new LoginPage(driver);
	loginpage.login();
	//excelread.setExcelFiles("InvalidLogin", "inValidCredential");
	excelread.setExcelFiles("Testing", "demo");
	String data=excelread.getCellData(0, 0);
	
}
@Test(groups = "smoke")
public void verrify_InvalidCredentialErrorMessage()
{
	loginpage=new LoginPage(driver);
	loginpage.login("Harshaa","harsha");
	String actualTextMessage=loginpage.get_ErrorMessage();
	System.out.println(actualTextMessage);
	String expectedErrorMessage=Constants.expectedErrorMessage;
	System.out.println(expectedErrorMessage);
	Assert.assertEquals(actualTextMessage,expectedErrorMessage,"Error message is not displayed");
}
@Test(groups= {"smoke","sanity"})
public void verify7rMartSuperMarketLogois_Displayed()
{
	loginpage=new LoginPage(driver);
	loginpage.isLogoDisplayed();
	String expectedText="7rmart supermarket";
	String actualText=loginpage.get_LogoText();
	System.out.println(actualText);
	Assert.assertEquals(actualText, expectedText);
}
@Test
public void verifyrememberMeCheckBox()
{
	loginpage=new LoginPage(driver);
	loginpage.clickOnRememberMeCheckBox();	
	//String expectedText="";
	
}
@Test
public void verifyTextOfSignInButton()
{
	loginpage=new LoginPage(driver);
	loginpage.get_TextOfSignInButton();
	String expectedText="Sign In";
	String actualText=loginpage.get_TextOfSignInButton();
	System.out.println(actualText);
	Assert.assertEquals(actualText, expectedText);
	
	
}
@Test
public void verifyProfileNameTextisDisplayed()
{
	loginpage=new LoginPage(driver);
	loginpage.login();
	String expectedText="Aadmin";
	String actualText=loginpage.profileNameText();
	Assert.assertEquals(actualText, expectedText);
	//ScreenShots screenshot=new ScreenShots();
	//screenshot.takeScreenshots(driver,"screenshot");
	
	
}
@Test
public void verifyManagePagesIsClickable()
{
	loginpage=new LoginPage(driver);
	loginpage.login();
	loginpage.clickOnManagePages();
}

@Test
public void verifyAdmin()
{
	loginpage=new LoginPage(driver);
	loginpage.login();
	loginpage.clickAdmin();
}
@Test
public void verifyLogOutOption()
{
	loginpage=new LoginPage(driver);
	loginpage.login();
	loginpage.clickAdmin();
	loginpage.clickOnLogOut();
	
}
}






