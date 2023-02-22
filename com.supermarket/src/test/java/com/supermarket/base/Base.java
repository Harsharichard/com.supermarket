package com.supermarket.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.supermarket.constants.Constants;
import com.supermarket.utilities.ScreenShots;
import com.supermarket.utilities.WaitUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;
	Properties prop = new Properties();
	FileInputStream ip;
	ScreenShots screenshot= new ScreenShots();

	public Base() {
		try {
			ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			prop.load(ip);
		} catch (Exception e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		}
	}

	public void initialize(String browser, String url) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));

	}
	// change to false when crossbrowser testing is take place
@BeforeMethod(enabled = true,alwaysRun = true)
	public void setUpBrowser()
	{
		String url=prop.getProperty("url");
		String browser=prop.getProperty("browser");
		initialize(browser,url);	
	}

// change to true when crossbrowser takeplace enabled=true
@Parameters("browser")	
@BeforeMethod(enabled = false,alwaysRun = true)
public void setUpCrossBrowser(String browser)// browser is coming from cong.proper
{
	String url=prop.getProperty("url");
	initialize(browser,url);
}
@AfterMethod(alwaysRun = true)
public void tearDown(ITestResult itestresult)
{
	if(itestresult.getStatus()==ITestResult.FAILURE)
	{
		String testCaseName=itestresult.getName();
		screenshot.takeScreenshots(driver, testCaseName);
	}
	driver.quit();
	}


}
