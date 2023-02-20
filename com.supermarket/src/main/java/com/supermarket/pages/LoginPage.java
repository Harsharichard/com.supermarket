package com.supermarket.pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.constants.Constants;
import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtilities;

public class LoginPage {
WebDriver driver;
GeneralUtilities generalutilities;
PageUtilities pageutilities;


@FindBy(xpath="//input[@name='username']")
private WebElement userNameField;  

@FindBy(xpath="//input[@name='password']")
private WebElement passwordField;

@FindBy(xpath="//button[@class='btn btn-dark btn-block']")
private WebElement signInButton;

@FindBy(xpath=" //h5[text()=' Alert!']")
private WebElement invalidMessage;

@FindBy(xpath = "//div[@class='login-logo']")
private WebElement logo;

@FindBy(xpath = "//div[@class='icheck-dark']")
private WebElement rememberMeCheckBox;

@FindBy(xpath = "//div[@class='user-panel mt-3 pb-3 mb-3 d-flex']")
private WebElement profileName;

@FindBy(xpath = "(//a[@class='small-box-footer'])[1]")
private WebElement managePages;

@FindBy(xpath = "(//a[@class='small-box-footer'])[10]")
private WebElement manageUsers;

@FindBy(xpath = "(//a[@class='small-box-footer'])[2]")
private WebElement adminUser;

@FindBy(xpath = "(//a[@class='nav-link'])[2]")
private WebElement adminElement;

@FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
private WebElement logoutoption;

Properties prop = new Properties();
FileInputStream ip;

	public LoginPage(WebDriver driver)            //constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		try {
			ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			prop.load(ip);
		} catch (Exception e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		}
	}
	
	public void enterUserName(String userName)
	{
		userNameField.sendKeys(userName);
	}
	public void enterPassword(String password)
	{
		passwordField.sendKeys(password);
	}
	public void clickOnSignInButton()
	{
		signInButton.click();
	}
	public void login(String userName,String password)
	{
		enterUserName(userName);
		enterPassword(password);
		clickOnSignInButton();
	}
	
	public void login()
	{
		String userName=prop.getProperty("username");
		String password=prop.getProperty("password");
		login(userName, password);
	}
	
	public String get_ErrorMessage()
	{
		generalutilities=new GeneralUtilities(driver);
		return generalutilities.get_TextOfElement(invalidMessage);
	}
	public String get_LogoText()
	{
		generalutilities=new GeneralUtilities(driver);
		return generalutilities.get_TextOfElement(logo);
	}
	public boolean isLogoDisplayed()
	{
		generalutilities=new GeneralUtilities(driver);
		return generalutilities.is_Displayed(logo);	
	}
	
	public boolean clickOnRememberMeCheckBox()
	{
		generalutilities=new GeneralUtilities(driver);
		rememberMeCheckBox.click();
		return generalutilities.is_Enabled(rememberMeCheckBox);	
	}
	
	public String get_TextOfSignInButton()
	{
		generalutilities=new GeneralUtilities(driver);
		return generalutilities.get_TextOfElement(signInButton);	
		
	}
	
	public String profileNameText()
	{
		generalutilities=new GeneralUtilities(driver);
		return generalutilities.get_TextOfElement(profileName);	

	}
	
	public boolean clickOnManagePages()
	{
		generalutilities=new GeneralUtilities(driver);
		managePages.click();
		return generalutilities.is_Enabled(managePages);
	}
	public void clickAdmin()  //logout
	{
		adminElement.click();
	}
	public void clickOnLogOut()
	{
		logoutoption.click();
	}
	
}
