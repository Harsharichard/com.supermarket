package com.supermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtilities;

public class AdminUserPage {
WebDriver driver;
GeneralUtilities generalutilities;
PageUtilities pageutilities;

@FindBy(xpath = "(//a[@class=' nav-link'])[13]")
private WebElement adminUser;

@FindBy(xpath="(//i[@class='fa fa-angle-double-down'])[1]")
private WebElement passwordOption;

@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
private WebElement NewElement;

@FindBy(id ="username")
private WebElement userName ;

@FindBy(id ="password")
private WebElement password ;

@FindBy(id ="user_type")
private WebElement userType ;
@FindBy(xpath = "(//a[@class='btn btn-sm btn btn-success btncss'])[2]")
private WebElement lockSecondAdminUser;
@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//h5")
private WebElement alertOfLockButton; 

public AdminUserPage(WebDriver driver)            
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
public Boolean clickOnAdminUser() {
	generalutilities= new GeneralUtilities(driver);
	adminUser.click();
	return generalutilities.is_Displayed(adminUser);
}

public Boolean clickOnPasswordOption()
{
	generalutilities= new GeneralUtilities(driver);
	passwordOption.click();
	return generalutilities.is_Displayed(passwordOption);	
}
public Boolean create_NewUser( String userName, String password, String userType)
{
	generalutilities=new GeneralUtilities(driver);
	NewElement.click();
	return generalutilities.is_Displayed(NewElement);
}
public void lockingTheSecondAdminUser()
{
	lockSecondAdminUser.click();
}
public String textOfAlertInTheLockButton()
{
	generalutilities=new GeneralUtilities(driver);
	alertOfLockButton.click();
	return generalutilities.get_TextOfElement(NewElement);
}



}
