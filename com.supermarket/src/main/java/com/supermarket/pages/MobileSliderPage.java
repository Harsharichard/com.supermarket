package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtilities;

public class MobileSliderPage {

	WebDriver driver;
	LoginPage loginpage;
	GeneralUtilities generalutilities;
	PageUtilities pageutilities;
	
@FindBy(xpath = "(//a[@class=' nav-link'])[8]")
private WebElement mobileslider;	
@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
private WebElement newButton ;		
@FindBy(xpath = "(//a[@class='btn btn-sm btn btn-danger btncss'])[1]")
private WebElement deleteAnItem ;
@FindBy(xpath="(//i[@class='fas fa-trash-alt'])[1]")
private WebElement deleteFirstItem;
@FindBy(xpath = "(//a[@role='button'])[1]")
private WebElement activeButton ;	
@FindBy(xpath="//h5[text()=' Alert!']")
private WebElement alertElement;
@FindBy(xpath="//h1[@class='m-0 text-dark']")
private WebElement sliderpageAlert;
@FindBy(id = "cat_id")
private WebElement groceryCategory;

public MobileSliderPage(WebDriver driver)            
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
	
public boolean clickOnMobileSliderPage()
{
	generalutilities=new GeneralUtilities(driver);
	mobileslider.click();
	return generalutilities.is_Displayed(mobileslider);
	}
public String MobileSliderPageis_Displayable()
{
	generalutilities=new GeneralUtilities(driver);
	return generalutilities.get_TextOfElement(sliderpageAlert);
}
	
public String deleteAnItem()  
{
	generalutilities=new GeneralUtilities(driver);
	deleteFirstItem.click();
	return generalutilities.get_TextOfElement(deleteFirstItem);
}
public String deactivatingAnItem() // name the item
{
	generalutilities=new GeneralUtilities(driver);
	activeButton.click();
	return generalutilities.get_TextOfElement(alertElement);
}
public Boolean createNewContent(String categ, String imageName)
{
	generalutilities=new GeneralUtilities(driver);
	pageutilities=new PageUtilities(driver);
	groceryCategory.click();
	pageutilities.upload_File(null, imageName);
	return generalutilities.is_Displayed(mobileslider);
	
}
}
