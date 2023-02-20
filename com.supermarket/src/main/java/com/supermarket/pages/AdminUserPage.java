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

@FindBy(xpath = "(//a[@class='small-box-footer'])[2]")
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

public AdminUserPage(WebDriver driver)            //constructor
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
public void clickOnAdminUser() {
	//generalUtilities= new GeneralUtilities(driver);
	adminUser.click();
}

public void clickOnPasswordOption()
{
	generalutilities= new GeneralUtilities(driver);
	passwordOption.click();
	
}
/*public void getPasswordText(String pass_word)
{
	//generalUtilities= new GeneralUtilities(driver);
	//return generalUtilities.get_TextOfElement(passwordOption);
	pageutilities=new PageUtilities(driver);
	int i;
	
	generalutilities= new GeneralUtilities(driver);
	passwordOption.click();
	List<String>passwords=new ArrayList<String>();
	passwords=generalutilities.get_TextOfElements("//table[@class='table table-bordered table-hover table-sm']");
	for(i=0;i<passwords.size();i++)
	{
		if(pass_word.equals(passwords.get(i)))
		{
			i++;
			break;
		}
	}
	WebElement statusChangeButton=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']"));
	pageutilities.scrollIntoView(statusChangeButton);
}
*/
public String create_NewUser( String userName, String password, String userType)
{
	generalutilities=new GeneralUtilities(driver);
	NewElement.click();
	return generalutilities.get_TextOfElement(NewElement);
	
	
}






}
