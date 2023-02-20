package com.supermarket.testts;


import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.DashBoardPage;
import com.supermarket.pages.LoginPage;
import com.supermarket.utilities.GeneralUtilities;

public class DashBoardTest extends Base {

LoginPage loginpage;
GeneralUtilities generalutilities;
DashBoardPage dashboardpage;
	
@Test
public void verifyDashboardContents()
{
	loginpage=new LoginPage(driver);
	loginpage.login();
	dashboardpage= new DashBoardPage(driver);
	dashboardpage.clickOnDashBoard();
	
	List<String>names=new ArrayList<String>();
	names=dashboardpage.printNames("");
	//Assert.assertTrue(dashboardpage.printNames(names));
	System.out.println(names); 
}
	
	
	
	
	
	
	
	
}
