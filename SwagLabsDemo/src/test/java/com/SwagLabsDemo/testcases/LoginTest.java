package com.SwagLabsDemo.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SwagLabsDemo.pageObjects.LoginPage;

public class LoginTest extends BaseClass{
	LoginPage lp; 		
	
	@Test
	public void validLoginCheck() {		
		lp = new LoginPage(driver);
		lp.validLogin(validUsername, validPassword);
		Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));		
		logger.info("Login test passed");
	}
	@Test
	public void blankCredentialCheck() throws IOException
	{
		lp = new LoginPage(driver);
		lp.blankCredentials();
		Assert.assertTrue(driver.getPageSource().contains("Epic sadface"));
		captureScreen(driver,"blankCredentials");
		logger.info("Login test failed due to blank credentials");
	}
	
	@Test
	public void invalidCredentialsCheck() throws IOException
	{
		lp = new LoginPage(driver);
		lp.invalidCredentials(invalidUsername, invalidPassword);
		captureScreen(driver,"invalidCredentials");
		Assert.assertTrue(driver.getPageSource().contains("Username and password do not match any user in this service"));
		logger.info("Login test failed due to invalid credentials");
	}
	
	
}
