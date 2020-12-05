package com.SwagLabsDemo.testcases;

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
	public void blankCredentialCheck()
	{
		lp = new LoginPage(driver);
		lp.blankCredentials();
		Assert.assertTrue(driver.getPageSource().contains("Epic sadface"));
		logger.info("Login test failed due to blank credentials");
	}
	
	@Test
	public void invalidCredentialsCheck()
	{
		lp = new LoginPage(driver);
		lp.invalidCredentials(invalidUsername, invalidPassword);
		Assert.assertTrue(driver.getPageSource().contains("Username and password do not match any user in this service"));
		logger.info("Login test failed due to invalid credentials");
	}
	
	
}
