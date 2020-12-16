package com.SwagLabsDemo.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SwagLabsDemo.pageObjects.CheckoutPage;
import com.SwagLabsDemo.pageObjects.FinishPage;
import com.SwagLabsDemo.pageObjects.HomePage;
import com.SwagLabsDemo.pageObjects.LoginPage;
import com.SwagLabsDemo.pageObjects.YourCartPage;

public class ShoppingCartTest extends BaseClass {
	
	HomePage hp;
	LoginPage lp;
	YourCartPage yourCartPage;
	CheckoutPage checkoutPage;
	FinishPage finishPage;
	
	@Test
	public void addToCartCheck() throws IOException {
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		yourCartPage = new YourCartPage(driver);
		checkoutPage = new CheckoutPage(driver);
		finishPage = new FinishPage(driver);
		
		lp.validLogin(validUsername, validPassword);		
//		hp.getaddedProductList();
		hp.addToCart();
		yourCart();
		checkoutInformation();
		checkoutVerify();
		finishOrder();
		
	}
	
	private void checkoutVerify() throws IOException {
		if(driver.getCurrentUrl().contains("step-two.html"))
		{
			finishPage.finish();
			
		}
		else
		{
			captureScreen(driver,"checkoutVerify");
			logger.info("checkoutVerify test failed");
			Assert.assertTrue(false);				
		}
		
	}

	private void yourCart() throws IOException {
		
		if(driver.getCurrentUrl().contains("cart.html"))
		{
			yourCartPage.checkout();
			
		}
		else
		{
			captureScreen(driver,"ShopingCart");
			logger.info("addToCart test failed");
			Assert.assertTrue(false);				
		}
	}

	 void checkoutInformation() throws IOException {
		if(driver.getCurrentUrl().contains("checkout-step-one.html")) {
			
			checkoutPage.checkoutInformation("abdc", "bagc", "45709");
		}
		else {
			captureScreen(driver,"CheckoutInformation");
			logger.info("checkoutInformation test failed");
			Assert.assertTrue(false);
		}
	}
	 
	 void finishOrder() throws IOException {
			if(driver.getCurrentUrl().contains("checkout-complete.html")) {			
				logger.info("Finish Order test passed");	
				Assert.assertTrue(true);		
			}
			else {
				captureScreen(driver,"finishOrder");
				logger.info("finishOrder test failed");
				Assert.assertTrue(false);
			}
		}

}
