package com.SwagLabsDemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how=How.ID, using ="user-name")
	@CacheLookup
	WebElement UN;
	
	@FindBy(how=How.ID, using="password")
	@CacheLookup
	WebElement PW;
	
	@FindBy(how=How.CLASS_NAME, using="btn_action")
	@CacheLookup
	WebElement loginButton;
	
	public void validLogin(String uName, String pwd)
	{
		UN.sendKeys(uName);
		PW.sendKeys(pwd);
		loginButton.click();
	}	

}
