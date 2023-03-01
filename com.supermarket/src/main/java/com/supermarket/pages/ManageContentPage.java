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

@FindBy(xpath = "(//li[@class='nav-item has-treeview'])[3]")
private WebElement manageContentelement ;
@FindBy(xpath = "(//a[@class='nav-link'])[10]")
private WebElement managePageElement ;
@FindBy(xpath = "//a[@onclick='click_button(1)']")   
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
@FindBy(xpath="//i[@class='icon fas fa-check']")
private WebElement alert;
@FindBy(xpath="//a[@class='active nav-link']")
private WebElement manageFooterTextElement;
@FindBy(xpath = "(//i[@class='fas fa-edit'])[1]")
private WebElement editManageFooterTextPage;
@FindBy(xpath="//a[@onclick=\"click_button(2)\"]")
private WebElement SearchButton;
@FindBy(xpath = "//input[@type='text']")
private WebElement titleSearch;
@FindBy (xpath = "//button[@type='submit']")
private WebElement searchInListPage;
@FindBy (xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
private WebElement searchTextElement;

public ManageContentPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	
public void clickOnManageContent()
{
	manageContentelement.click();
}
public boolean clickOnManagePage()
{
	generalutilities=new GeneralUtilities(driver);
	managePageElement.click();
	return generalutilities.is_Displayed(managePageElement);
}
public Boolean create_Newcontent(String Title,String des,String imageName)
{
	generalutilities= new GeneralUtilities(driver);
	pageutilities= new PageUtilities(driver);
	newContent.click();
	title.sendKeys(Title);
	page.sendKeys(des);
	return generalutilities.is_Displayed(manageContentelement);
	//pageutilities.upload_File(choose,imageName);
	//pageutilities.scrollAndclick(save);
	//return generalutilities.is_Displayed(alert);
}	
public void clickOnManageFooterText()
{
	manageFooterTextElement.click();
}
public Boolean editManageFooterText()
{
	generalutilities= new GeneralUtilities(driver);
	editManageFooterTextPage.click();
	return generalutilities.is_Displayed(editManageFooterTextPage);
}
public void searchContentOnListPage(String tit)
{
	generalutilities= new GeneralUtilities(driver);
	SearchButton.click();
	titleSearch.sendKeys(tit);
	searchInListPage.click();
}
public String displayingTheContentSearched()
{
	generalutilities= new GeneralUtilities(driver);
	return generalutilities.get_TextOfElement(searchTextElement);
}
}
