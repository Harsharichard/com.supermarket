package com.supermarket.testts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManagePaymentMethodsPage;
import com.supermarket.utilities.ExcelRead;
import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtilities;

public class ManagePaymentMethodTest extends Base{
	LoginPage loginpage;
	ManagePaymentMethodsPage managepaymentmethodspage;
	GeneralUtilities generalutilities;
	PageUtilities pageutilities;
	ExcelRead excelread;
@Test
public void verifyManagePaymentMethod_PageisDisplayed()
{
	loginpage=new LoginPage(driver);
	loginpage.login();
	managepaymentmethodspage=new ManagePaymentMethodsPage(driver);
	managepaymentmethodspage.clickOnManagePayementMethod();
	Assert.assertTrue(managepaymentmethodspage.clickOnManagePayementMethod());
}
@Test
public void verifyManagePaymentMethod_DetailsIsDisplayed()
{
	loginpage=new LoginPage(driver);
	loginpage.login();
	managepaymentmethodspage=new ManagePaymentMethodsPage(driver);
	managepaymentmethodspage.clickOnManagePayementMethod();	
	managepaymentmethodspage.displaying_AllPaymentDetails();
	Assert.assertTrue(managepaymentmethodspage.displaying_AllPaymentDetails());	
}
@Test
public void verify_PaymentUpdate()
{
	excelread=new ExcelRead();
	loginpage=new LoginPage(driver);
	loginpage.login();
	managepaymentmethodspage=new ManagePaymentMethodsPage(driver);
	managepaymentmethodspage.clickOnManagePayementMethod();	
	managepaymentmethodspage.clickOnEditPaymentDetails();
	managepaymentmethodspage.clearDatasOnPaymentDetails();
	excelread.setExcelFiles("PaymentDetails", "Sheet1");
	String title=excelread.getCellData(0,0);
	String payment=excelread.getCellData(0,1);
	managepaymentmethodspage.editPaymentDetailMethod(title, payment);  	 
	String actualText=managepaymentmethodspage.clickOnUpdateButton();
	System.out.println(actualText);
	String expectedText="Alert!";
	Assert.assertEquals(actualText, expectedText);
}	
}
