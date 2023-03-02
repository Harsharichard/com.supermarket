package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtilities;

public class ManagePaymentMethodsPage {
	WebDriver driver;
	GeneralUtilities generalutilities;
	PageUtilities pageutilities;
	
@FindBy(xpath = "(//li[@class=\"nav-item\"])[23]")
private WebElement managePaymentMethodElement;
@FindBy(xpath = "// table[@class='table table-bordered table-hover table-sm']//tbody//tr")
private WebElement managePaymentDetail;
@FindBy(xpath = "(//a[@class='btn btn-sm btn btn-primary btncss'])[1]")
private WebElement editPaymentDetail;
@FindBy(id = "name")
private WebElement title;
@FindBy(id ="limit")
private WebElement payLimit;
@FindBy(xpath="(//button[@type='submit'])[2]")
private WebElement updateButton;
@FindBy(xpath="//h5[text()=' Alert!']") 
private WebElement updateAlert;
	
public ManagePaymentMethodsPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
public void clearDatasOnPaymentDetails()
{
	title.clear();
	payLimit.clear();
}
public boolean clickOnManagePayementMethod()
{
	generalutilities=new GeneralUtilities(driver);
	managePaymentMethodElement.click();
	return generalutilities.is_Displayed(managePaymentMethodElement);
}	
public boolean displaying_AllPaymentDetails()
{
	generalutilities=new GeneralUtilities(driver);
	 return generalutilities.is_Displayed(managePaymentDetail);		 
}
public void clickOnEditPaymentDetails()
{
	editPaymentDetail.click();
}
public void editPaymentDetailMethod(String cardTitle, String limit)
{
	title.sendKeys(cardTitle);
	payLimit.sendKeys(limit);
	
}
public String clickOnUpdateButton()
{
	generalutilities=new GeneralUtilities(driver);
	updateButton.click();
	 return generalutilities.get_TextOfElement(updateAlert);	
}
}
