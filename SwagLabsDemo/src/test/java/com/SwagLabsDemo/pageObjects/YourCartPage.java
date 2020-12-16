package com.SwagLabsDemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage {

WebDriver ldriver;
	
	public YourCartPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how=How.XPATH, using ="//*[@class=\"btn_secondary cart_button\"]")
	WebElement removeButtonInCart;
	
	@FindBy(how=How.XPATH, using ="//*[@class=\"btn_secondary\"]")
	WebElement continueShoppingButton;
	
	@FindBy(how=How.XPATH, using ="//*[@class=\"btn_action checkout_button\"]")
	WebElement checkoutButton;
	
	public void checkout() {
		checkoutButton.click();
	}
	
	
}
