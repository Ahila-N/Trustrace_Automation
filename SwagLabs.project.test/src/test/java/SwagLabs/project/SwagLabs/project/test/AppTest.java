package SwagLabs.project.SwagLabs.project.test;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     * @throws InterruptedException 
     */
    @Test
    public void shouldAnswerWithTrue() throws InterruptedException
    {
    	System.setProperty("webdriver.chrome.driver","D:\\Software\\chromedriver_win32\\chromedriver.exe");
    	ChromeDriver driver = new ChromeDriver();
    	String baseUrl = "https://www.saucedemo.com/";
    	driver.get(baseUrl);
    	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    	driver.quit();
    }
}
