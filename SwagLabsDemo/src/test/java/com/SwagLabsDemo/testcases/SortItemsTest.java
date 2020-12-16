package com.SwagLabsDemo.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
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
			List<String> comboOptionValues = hm.comboTextValues();
			 
			 for(int comboOption =0 ; comboOption < comboOptionValues.size() ;comboOption++) {
			 String selectedOption = comboOptionValues.get(comboOption);
			 hm.getSelectedOption(selectedOption);
			 if(selectedOption.equals("Name (A to Z)")) {
				 itemSortOperation(true);
				 logger.info("Ascending with Item Order Sort test passed");
			 }  
			 else if(selectedOption.equals("Name (Z to A)")) {
				 itemSortOperation(false);
				 logger.info("Descending with Item Order Sort test passed");
			 } 
			 else if(selectedOption.equals("Price (low to high)")) {
				 priceSortOperation(true);
				 logger.info("Ascending with Price Order Sort test passed");
			 }else if(selectedOption.equals("Price (high to low)")) {
				 priceSortOperation(false);
				 logger.info("Descending with Order Sort test passed");
			 }		 
			 }
		}
		else
		{
			captureScreen(driver,"invalidCredentials");
			Assert.assertTrue(false);		
			logger.info("Login test failed");	
		}	 
		
	}
	public void itemSortOperation(Boolean isAscending) throws IOException {
		List<String> originalProducts = hm.getProductList();		
		List<Object> cloneProductName = new ArrayList<Object>();
		int productSize = originalProducts.size();
		cloneProductName.addAll(originalProducts);
		if(isAscending == true)
			cloneProductName = cloneProductName.stream().sorted().collect(Collectors.toList());
		else
			cloneProductName = cloneProductName.stream().sorted(Collections.reverseOrder()).collect((Collectors.toList()));		
		for(int item =0;item<productSize;item++) {
			if(!(originalProducts.get(item).equals(cloneProductName.get(item))) && isAscending) {
				captureScreen(driver,"ascendingItemSortOperation");
				logger.info("Ascending with Order Sort test failed");
				Assert.assertTrue(false);				
				break; 
			} else if(!(originalProducts.get(item).equals(cloneProductName.get(item))) && !isAscending) {			
				captureScreen(driver,"descendingItemSortOperation");
				logger.info("Descending with price Order Sort test failed");
				Assert.assertTrue(false);
				break; 
			}else if(item == productSize-1) {
				Assert.assertTrue(true);
			}
		}
	}	
	
	public void priceSortOperation(Boolean isAscending) throws IOException {
		List<Double> originalPrices = hm.getProductPrice();
		int priceSize = originalPrices.size();
		List<Object> cloneProductPrice = new ArrayList<Object>();
		cloneProductPrice.addAll(originalPrices);
		if(isAscending == true)
			cloneProductPrice = cloneProductPrice.stream().sorted().collect(Collectors.toList());
		else
			cloneProductPrice = cloneProductPrice.stream().sorted(Collections.reverseOrder()).collect((Collectors.toList()));
		for(int item =0;item<priceSize;item++) {
			if(!(originalPrices.get(item).equals(cloneProductPrice.get(item))) && isAscending) {
				logger.info("Ascending with Order Sort test failed");
				captureScreen(driver,"ascendingPriceSortOperation");
				Assert.assertTrue(false);
				break; 
			} else if(!(originalPrices.get(item).equals(cloneProductPrice.get(item))) && !isAscending) {
				logger.info("Descending with Order Sort test failed");
				captureScreen(driver,"descendingPriceSortOperation");
				Assert.assertTrue(false);
				break; 
			}else if(item == priceSize-1) {
				Assert.assertTrue(true);
			}
		}
	}	
}
