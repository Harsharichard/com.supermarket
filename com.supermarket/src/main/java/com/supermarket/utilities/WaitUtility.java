package com.supermarket.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
WebDriver driver;
WebDriverWait Wait;
public WaitUtility(WebDriver driver)
{
	this.driver=driver;
}
public static final long IMPLICIT_WAIT=10;
public static final long PAGE_LOAD_WAIT=20;
public static final long EXPLICIT_WAIT=10;
public void wait_ForElementToBeVisible(String xpath) {
	Wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
	Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("xpath")));
}










}
