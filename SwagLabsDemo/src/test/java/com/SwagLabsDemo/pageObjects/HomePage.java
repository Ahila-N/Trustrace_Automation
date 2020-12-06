package com.SwagLabsDemo.pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	
WebDriver ldriver;
	
	public HomePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how=How.XPATH, using ="//*[@class=\"product_sort_container\"]")
	@CacheLookup
	WebElement sortCombo;
	
	@FindBy(how=How.XPATH, using ="//*[@class=\"inventory_item_name\"]")
	@CacheLookup
	List<WebElement> productNameList;
	
	@FindBy(how=How.XPATH, using ="//*[@class=\"inventory_item_price\"]")
	@CacheLookup
	List<WebElement> productPriceList;
	
	public List<String> getProductList()
	{		
		Iterator<WebElement> itr = productNameList.iterator();
		List<String> productName = new ArrayList<String>();
		while(itr.hasNext()) {			
			productName.add(itr.next().getText().toString());			 
		}
		return productName;		
	}
	
	public List<String> getProductPrice()
	{		
		Iterator<WebElement> itr = productPriceList.iterator();
		List<String> productPrice = new ArrayList<String>();
		while(itr.hasNext()) {			
//			productPrice.add(itr.next().getText());	
			System.out.println(itr.next().getText());
		}
		return productPrice;		
	}
	
	
	
	public void sortOperation()
	{		
//		sortCombo.click();
		Select comboValue = new Select(sortCombo);
		comboValue.selectByVisibleText("Name (Z to A)");
		List<String> originalProducts = getProductList();
		List<Object> cloneProductName = new ArrayList<Object>();
		Boolean checkSort = true;
		cloneProductName.addAll(originalProducts);
		cloneProductName = cloneProductName.stream().sorted().collect(Collectors.toList());
//		cloneProductName.stream().sorted(Collections.reverseOrder()).collect((Collectors.toList()));
		for(int item =0;item<originalProducts.size();item++) {
			if(!(originalProducts.get(item).equals(cloneProductName.get(item)))) {
				checkSort = false;
				break;
			}
		}
		if(checkSort == true) {
			System.out.println("sorted");
		} else {
			System.out.println("Unsorted");
		}
		
	}
	
}
