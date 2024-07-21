package DebugTest;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Debug1 {
	WebDriver driver;
	
  @Test
  public void gettingURL() 

  {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	  driver.get("https://www.facebook.com/login");
	  System.out.println("URl opened");
	  Assert.assertTrue(driver.getCurrentUrl().contains("Facebook"));
	  
  }
  
  public void closingBrowser() 
  {
	  driver.quit();
  }
}
