package com.supermarket.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;

public class DashBoardPage {
WebDriver driver;
LoginPage loginpage;
GeneralUtilities generalutilities;

@FindBy(xpath = "//a[@class='active nav-link']")
WebElement tableLink;

public DashBoardPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void clickOnDashBoard()
{
	tableLink.click();
}
public List<String> printNames(String xpath)
{
	 generalutilities=new GeneralUtilities(driver);
	 return generalutilities.get_TextOfElements(xpath);

}










}
