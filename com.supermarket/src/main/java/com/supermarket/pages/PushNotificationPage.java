package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.WaitUtility;
    
public class PushNotificationPage {
	
WebDriver driver;
GeneralUtilities generalutilities;
WaitUtility waitutility;

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
@FindBy(xpath = "//a[text()=' Admin']")
private WebElement adminTextInHomePage;

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
	waitutility =new WaitUtility(driver);
	waitutility.wait_ForElementToBeVisible(alert);
	return generalutilities.is_Displayed(alert);
}

public Boolean clickOnResetButton()
{
	generalutilities= new GeneralUtilities(driver);
	resetButton.click();
	return generalutilities.is_Enabled(resetButton);
}

public String clickOnHomeLink()
{
	generalutilities= new GeneralUtilities(driver);
	homeLink.click();
	return generalutilities.get_TextOfElement(adminTextInHomePage);
}

}
