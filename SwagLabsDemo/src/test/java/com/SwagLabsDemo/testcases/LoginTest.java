package com.SwagLabsDemo.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SwagLabsDemo.pageObjects.LoginPage;

public class LoginTest extends BaseClass{
	LoginPage lp; 		
	
	@Test
	public void validLoginCheck() throws IOException {		
		lp = new LoginPage(driver);
		lp.validLogin(validUsername, validPassword);
		if(driver.getCurrentUrl().contains("inventory"))
		{
			logger.info("Login test passed");	
			Assert.assertTrue(true);					
		}
		else
		{
			captureScreen(driver,"invalidCredentials");
			logger.info("Login test failed");	
			Assert.assertTrue(false);				
		}
	}
	
//	@Test
//	public void blankCredentialCheck() throws IOException
//	{
//		lp = new LoginPage(driver);
//		lp.blankCredentials();
//		captureScreen(driver,"blankCredentials");
//		logger.info("Login test failed due to blank credentials");
//	    Assert.assertTrue(driver.getPageSource().contains("Epic sadface"));
//	}
//	
//	@Test
//	public void invalidCredentialsCheck() throws IOException
//	{
//		lp = new LoginPage(driver);
//		lp.invalidCredentials(invalidUsername, invalidPassword);
//		captureScreen(driver,"invalidCredentials");
//	    logger.info("Login test failed due to invalid credentials");
//		Assert.assertTrue(driver.getPageSource().contains("Username and password do not match any user in this service"));
//	}
	
	
}
