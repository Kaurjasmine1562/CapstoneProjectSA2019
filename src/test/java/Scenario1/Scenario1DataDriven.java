package Scenario1;

import java.io.IOException;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Scenario1DataDriven extends ExcelUtility {
	static ExtentTest test;
	static ExtentReports report;
	int i = 1;
	WebDriver driver;

	@BeforeClass
	public static void startTest() {
		report = new ExtentReports(System.getProperty("user.dir") + "/reports/ExtentReportResults.html", true);
		test = report.startTest("ExtentReport");
	}

	@Test(dataProvider = "excelfile", dataProviderClass = ExcelUtility.class)
    public void testcase(String username,String password) throws InterruptedException, IOException 
	{

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		if(username.equals("Admin") && password.equals("admin123")) 
		{
			test.log(LogStatus.PASS, "Valid Username and Password!");
		} 
		else 
		{
			test.log(LogStatus.FAIL, "Invalid Username and Password!");
		}

		Thread.sleep(4000);

		// Capture screenshot
		CaptureScreenshotUtility.capture(driver, "login_" + username + i);


		Thread.sleep(1000);

		System.out.println("Login_" + username+i);
		i = i + 1;

		Thread.sleep(1000);


		// Assertion for valid and invalid data sets
		if (username.equals("Admin") && password.equals("admin123")) 
		{
			// Valid login assertion
			Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
			test.log(LogStatus.PASS, "Login successful for user: " + username);
		}
		else
		{
			// Invalid login assertion
			Assert.assertTrue(driver.findElement(By.id("spanMessage")).getText().contains("Invalid credentials"));
			test.log(LogStatus.FAIL, "Login failed for user: " + username);

		}


		//page title check
		if(driver.getTitle().equals("OrangeHRM"))
		{
			test.log(LogStatus.PASS, "The page title is OrangeHRM");
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed for page title");
		}

		//Logout check
		if(username.equals("Admin") && password.equals("admin123"))
		{
			driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
			test.log(LogStatus.PASS, "Logout successfull!");
		}
		else
		{
			test.log(LogStatus.FAIL, "Logout unsuccessfull!");

		}

	}

	@AfterClass
	public static void endTest()
	{
		report.endTest(test);
		report.flush();
		report.close();

    }

}