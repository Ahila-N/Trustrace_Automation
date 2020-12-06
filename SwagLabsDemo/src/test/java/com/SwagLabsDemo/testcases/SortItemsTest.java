package com.SwagLabsDemo.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SwagLabsDemo.pageObjects.HomePage;
import com.SwagLabsDemo.pageObjects.LoginPage;

public class SortItemsTest extends BaseClass {

LoginPage lp; 
HomePage hm;
	
	@Test
	public void sortItems() throws IOException {		
		lp = new LoginPage(driver);
		hm = new HomePage(driver);
		lp.validLogin(validUsername, validPassword);
		
		if(driver.getCurrentUrl().contains("inventory"))
		{
			Assert.assertTrue(true);		
			logger.info("Login test passed");	
		}
		else
		{
			captureScreen(driver,"blankCredentials");
			Assert.assertTrue(false);		
			logger.info("Login test passed");	
		}
		
//		hm.sortOperation();	
		hm.getProductPrice();
		
	}
}
