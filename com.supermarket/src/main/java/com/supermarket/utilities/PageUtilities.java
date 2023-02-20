package com.supermarket.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.supermarket.constants.Constants;

public class PageUtilities {
WebDriver driver;

public PageUtilities(WebDriver driver)
{
	this.driver=driver;
}
public void select_By_Index(int index,WebElement element)
{
	Select select=new Select(element);
	select.selectByIndex(index);
}
public void select_By_Value(String value,WebElement element)
{
	Select select=new Select(element);
	select.selectByValue(value);
}	
public void select_By_visibility(String visibility,WebElement element) {
	Select select=new Select(element);
	select.selectByVisibleText(visibility);
}
public void doubleClick(WebElement element) {
	Actions action=new Actions(driver);
	action.doubleClick(element).build().perform();
}
public void scrollIntoView(WebElement element)
{
JavascriptExecutor js=(JavascriptExecutor)driver;	
js.executeScript("argument[0].scrollIntoView();", element);
js.executeScript("window.scrollBy(0,300)");

}
public String getText()
{
	String s=driver.switchTo().alert().getText();	
	return s;
}
public void acceptAlert() 
{
	driver.switchTo().alert().accept();
}	
public void dismissAlert() 
{
	driver.switchTo().alert().dismiss();	
}	
public void upload_File(WebElement element, String fileName)
{
	String path=Constants.IMAGES_FILE_PATH+fileName+"jpg";
	element.sendKeys(path);
}
public void scrollAndclick(WebElement save) {
	// TODO Auto-generated method stub
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("argument[0].scrollIntoClick();");
	js.executeScript("window.scrollBy(0,200)");
}
	
	
	
}
