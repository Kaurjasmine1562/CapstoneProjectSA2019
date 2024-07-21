package Scenario2;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class BaseClassOrangeHRM {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		this.driver = new ChromeDriver();
	//	WebDriver driver = new ChromeDriver();
		//	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	

  
}
