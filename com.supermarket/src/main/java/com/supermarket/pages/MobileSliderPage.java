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
	
@FindBy(xpath = "(//a[@role='button'])[1]")
private WebElement activeButton ;
	
@FindBy(xpath="//h5[text()=' Alert!']")
private WebElement alertElement;

//div[@class='alert alert-success alert-dismissible']
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
	
	public void deleteAnItem()
	{
		generalutilities=new GeneralUtilities(driver);
		deleteAnItem.click();
	}
	
	public String deactivatingAnItem()
	{
		generalutilities=new GeneralUtilities(driver);
		activeButton.click();
		return generalutilities.get_TextOfElement(alertElement);
	}
	
	
	
	
	
	
	
	

}
