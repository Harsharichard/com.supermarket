package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
    //COMPLETED
public class PushNotificationPage {
	
WebDriver driver;
GeneralUtilities generalutilities;

@FindBy (xpath = "//i[@class='nav-icon fas fa-fas fa-bell']")
private WebElement pushNotificationElement;

@FindBy (xpath = "//input[@id='title']")
private WebElement title;

@FindBy (xpath = "//input[@id='description']")
private WebElement description;

@FindBy (xpath = "//button[@type='submit']")
private WebElement sendButton;

@FindBy (xpath = "//a[@class='btn btn-default btn-fix']")
private WebElement resetButton;

@FindBy (xpath = "//a[text()='Home']")
private WebElement homeLink;

@FindBy (xpath = "//div[@class='alert alert-success alert-dismissible']")
private WebElement alert;

public PushNotificationPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
public void clickOnPushNotifiication()
{
	
	pushNotificationElement.click();
}


public boolean clickOnSend_Key(String ti, String des)
{	
	generalutilities =new GeneralUtilities(driver);
	title.sendKeys(ti);description.sendKeys(des);sendButton.click();
	return generalutilities.is_Displayed(alert);
}

public void clickOnResetButton()
{
	resetButton.click();
}

public void clickOnHomeLink()
{
	homeLink.click();
}



}
