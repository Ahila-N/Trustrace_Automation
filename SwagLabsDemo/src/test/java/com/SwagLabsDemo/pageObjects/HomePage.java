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
	List<WebElement> productNameList;
	
	@FindBy(how=How.XPATH, using ="//*[@class=\"inventory_item_price\"]")
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
	
	public List<Double> getProductPrice()
	{		
		Iterator<WebElement> itr = productPriceList.iterator();
		List<Double> productPrice = new ArrayList<Double>();
		while(itr.hasNext()) {			
			productPrice.add(Double.parseDouble(itr.next().getText().substring(1))); 
		}
		return productPrice;		
	}
	
	
	
	public List<String> comboTextValues()
	{		
		Select comboValue = new Select(sortCombo);
		List<WebElement> optionValues=comboValue.getOptions();
		List<String> textValues = new ArrayList<String>();
		for(int index=0;index<optionValues.size();index++) {		
			textValues.add(optionValues.get(index).getText().toString());
		}
		return textValues;		
	}

	public void getSelectedOption(String selectedOption) {
		Select comboValue = new Select(sortCombo);
		comboValue.selectByVisibleText(selectedOption);	
	}
	
}
