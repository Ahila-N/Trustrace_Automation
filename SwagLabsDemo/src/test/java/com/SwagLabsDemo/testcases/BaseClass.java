package com.SwagLabsDemo.testcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.SwagLabsDemo.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	public WebDriver driver;
	public String baseURL=readconfig.getApplicationURL();
	public String validUsername=readconfig.getValidUsername();
	public String validPassword=readconfig.getValidPassword();
	public String invalidUsername=readconfig.getInvalidUsername();
	public String invalidPassword=readconfig.getInvalidPassword();	
	public static Logger logger;
	
	@BeforeMethod
	public void setup()
	{
		logger = Logger.getLogger("SwagLabsDemo");
		PropertyConfigurator.configure("Log4j.properties");		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\nahil\\eclipse-workspace\\SwagLabsDemo\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();	
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		logger.info("URL is opened");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
