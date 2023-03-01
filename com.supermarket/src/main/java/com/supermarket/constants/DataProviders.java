package com.supermarket.constants;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="userCredentials")
	public Object[][] credentialsProvider()
	{
		return new Object[][] {{"userName1","password1","staff"},{"anu","abcd","staff"},{"bismi","xyz","staff"}};
	}
	
	@DataProvider(name="enterNameForSearch")
	public Object[][] searchName()
	{
		return new Object[][] {{"namisha"}};
	}
	
	
	
	
	
	
	
	
	
	
	
}
