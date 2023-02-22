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

public class ManageUsersPage 
{
WebDriver driver;
GeneralUtilities generalutilities;
PageUtilities pageutilities;

@FindBy(xpath = "(//a[@class='small-box-footer'])[10]")
private WebElement manageUsers;
@FindBy(xpath = "//h1[text()='List Users']")
private WebElement listUserText;
@FindBy(xpath = "//h1[@class='m-0 text-dark']")
private WebElement manageuserAlert;

public ManageUsersPage(WebDriver driver)            //constructor
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

public void clickOnManageUsers()
	{
		manageUsers.click();
	}
public String manageUseris_Displayed()
{
	generalutilities= new GeneralUtilities(driver);
	return generalutilities.get_TextOfElement(manageuserAlert);
}
public void deactive_User(String userName)  
	{
		pageutilities=new PageUtilities(driver);
		int i=0;
		generalutilities= new GeneralUtilities(driver);
		manageUsers.click();
		List<String>loggedUsersNames=new ArrayList<String>();
		loggedUsersNames=generalutilities.get_TextOfElements("//table[@class='table table-bordered table-hover table-sm']");
		for(i=0;i<loggedUsersNames.size();i++)
		{
			if(userName.equals(loggedUsersNames.get(i)))
			{
				i++;
				break;
			}
		}
		WebElement statusChangeButton=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']"));
		pageutilities.scrollIntoView(statusChangeButton);
	}
	
}

