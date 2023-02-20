package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtilities;

public class ManageContentPage {
LoginPage loginpage;
WebDriver driver;
PageUtilities pageutilities;
GeneralUtilities generalutilities;

@FindBy(xpath = "(//a[@class='nav-link'])[9]")
private WebElement manageContentelement ;
//a[@class='nav-link active']

@FindBy(xpath = "//a[@class='active nav-link']")
private WebElement managePageElement ;

@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")    //a[@class='btn btn-rounded btn-danger']
private WebElement newContent;

@FindBy(id="title")
private WebElement title ;

@FindBy(id = "//div[@class='note-editable card-block']")
private WebElement description ;

@FindBy(id = "page")
private WebElement page ;

@FindBy(xpath = "//input[@id='main_img']")
private WebElement choose ;

@FindBy(xpath="//button[text()='Save']")
private WebElement save;


@FindBy(xpath="//a[@class='active nav-link']")
private WebElement manageFooterTextElement;

public ManageContentPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	
public void clickOnManageContent()
{
	manageContentelement.click();
}
public void clickOnManagePage()
{
	managePageElement.click();
}
public void create_Newcontent(String Title,String des,String imageName)
{
	generalutilities= new GeneralUtilities(driver);
	pageutilities= new PageUtilities(driver);
	newContent.click();
	title.sendKeys(Title);
	page.sendKeys(des);
	
	
//pageutilities.upload_File(choose, imageName);
//pageutilities.scrollAndclick(save);
//return generalutilities.is_Displayed(alert);
}	
	


public void clickOnManageFooterText()
{
	manageFooterTextElement.click();
}






}
