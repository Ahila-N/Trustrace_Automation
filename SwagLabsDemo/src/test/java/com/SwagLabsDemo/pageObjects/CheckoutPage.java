package com.SwagLabsDemo.pageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
WebDriver ldriver;
	
	public CheckoutPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how=How.ID, using ="first-name")
	WebElement firstName;
	
	@FindBy(how=How.ID, using ="last-name")
	WebElement lastName;
	
	@FindBy(how=How.ID, using ="postal-code")
	WebElement postalCode;
	
	@FindBy(how=How.XPATH, using ="//*[@class=\"btn_primary cart_button\"]")
	WebElement submitButton;
	
	@FindBy(how=How.XPATH, using ="//*[@class=\"cart_cancel_link btn_secondary\"]")
	WebElement checkoutCancelButton;
	
	public void checkoutInformation(String firstNM, String lastNM, String pinCode) {
		firstName.sendKeys(firstNM);
		lastName.sendKeys(lastNM);
		postalCode.sendKeys(pinCode);
		submitButton.click();
	}
	
	
}
