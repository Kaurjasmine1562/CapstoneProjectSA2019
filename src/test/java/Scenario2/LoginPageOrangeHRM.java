package Scenario2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageOrangeHRM {
	
	WebDriver driver;

	
	//Locators
	By username = By.name("username");
	By password = By.name("password");
	By LoginButton = By.xpath("//button[@type='submit']");
	
	
	//constructor
	public LoginPageOrangeHRM(WebDriver driver) {
	  this.driver = driver;
  }
	
	
	//Methods
	public void setUserName(String user) {
		driver.findElement(username).sendKeys(user);
		}
	
	public void setPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	
	public void clickLoginButton() {
		driver.findElement(LoginButton).click();
	}

       //Login Method
	public void login(String user, String pass) {
		setUserName(user);
		setPassword(pass);
		clickLoginButton();
		
	}
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
