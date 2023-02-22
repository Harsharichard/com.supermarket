package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtilities;

public class ManageExpensePage {

	WebDriver driver;
	GeneralUtilities generalutilities;
	PageUtilities pageutilities;
	
	@FindBy(xpath = "//i[@class=\"nav-icon fas fa-money-bill-alt\"]")
	private WebElement manageExpense;
	
	@FindBy(xpath = "//i[@class=\"far fa-circle nav-icon\"]")
	private WebElement expenseCategoryRadioButton;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	
	@FindBy(id = "name")
	private WebElement newTitle;
	
	@FindBy(name = "Create")
	private WebElement newSave;
	
	@FindBy(xpath = "(//a[@type='button'])[2]")
	private WebElement newReset;
	
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	
	@FindBy(id = "un")
	private WebElement searchTitle;
	
	@FindBy(name = "Search")
	private WebElement searchSearch;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	private WebElement resetButton;
	
	@FindBy(xpath = "(//a[@class=\"btn btn-sm btn btn-primary btncss\"])[1]")
	private WebElement editButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	private WebElement textOf1stRow;
	
public ManageExpensePage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
public void clickOnManageExpense()
{
	manageExpense.click();
}
public void clickOnExpenseCategory()
{
	expenseCategoryRadioButton.click();
}
public void clickOnNewButton(String title)
{
	newButton.click();
	newTitle.sendKeys(title);
	newSave.click();
}
public void clickOnNewButtonReset(String title)
{
	newButton.click();
	newTitle.sendKeys(title);
	newReset.click();
}	
public void clickOnSearchButton(String title)
{
	searchButton.click();
	searchTitle.sendKeys(title);
	searchSearch.click();
}
public String SearchItemsTextOfElement()
{
	generalutilities= new GeneralUtilities(driver);
	return generalutilities.get_TextOfElement(textOf1stRow);
}
}
