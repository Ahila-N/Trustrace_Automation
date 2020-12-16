package com.SwagLabsDemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FinishPage {

WebDriver ldriver;
	
	public FinishPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how=How.XPATH, using ="//*[@class=\"btn_action cart_button\"]")
	WebElement finishButton;
	
	@FindBy(how=How.XPATH, using ="//*[@class=\"cart_cancel_link btn_secondary\"]")
	WebElement cancelButton;
	
	public void finish() {
		finishButton.click();
	}
}
