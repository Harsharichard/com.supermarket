package com.supermarket.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShots {
	
	TakesScreenshot screenshot;
	public void takeScreenshots(WebDriver driver, String imageName)
	{ 
		try {
			screenshot=(TakesScreenshot) driver;
			File file=screenshot.getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
			String destination=System.getProperty("user.dir")+"//Screenshots//"+imageName + timeStamp+".png";
			File finalDestination= new File(destination);
			FileHandler.copy(file, finalDestination);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
}
