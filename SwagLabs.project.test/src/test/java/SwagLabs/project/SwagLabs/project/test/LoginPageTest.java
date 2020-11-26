package SwagLabs.project.SwagLabs.project.test;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest 
{
	String baseUrl = "https://www.saucedemo.com/";
    @Test
    public void validLoginCheck() throws InterruptedException
    {
    	System.setProperty("webdriver.chrome.driver","D:\\Software\\chromedriver_win32\\chromedriver.exe"); 	
    	ChromeDriver driver = new ChromeDriver();
    	driver.get(baseUrl);
    	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    	 driver.findElement(By.id("user-name")).sendKeys("standard_user");
    	 driver.findElement(By.id("password")).sendKeys("secret_sauce");
    	 driver.findElement(By.className("btn_action")).click();
    	 Boolean currentURL= driver.getCurrentUrl().contains("inventory");
    	 Assert.assertTrue(currentURL);
    }
}
