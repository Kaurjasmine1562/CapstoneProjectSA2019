package Scenario2;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPageOrangeHRM{

	WebDriver driver;


	//Locators for admin page
	By menuItems = By.xpath("//ul[@class='oxd-main-menu']/li");
	By adminTab  = By.xpath("//li[@class='oxd-main-menu-item-wrapper'][1]");
	By usernameField = By.xpath("//input[contains(@class,'oxd-input')]");
	By searchButton = By.xpath("//button[@type='submit']");
	By totalRecords = By.xpath("//span[contains(@class,'oxd-text')]");
	By userRole = By.xpath("//div[@class='oxd-select-text--after']");
	By selectadmin = By.xpath("//div[@role='option'][2]");
	By status = By.cssSelector("div.oxd-layout div.oxd-layout-container div.oxd-layout-context div.orangehrm-background-container div.oxd-table-filter:nth-child(1) div.oxd-table-filter-area form.oxd-form div.oxd-form-row div.oxd-grid-4.orangehrm-full-width-grid div.oxd-grid-item.oxd-grid-item--gutters:nth-child(4) div.oxd-input-group.oxd-input-field-bottom-space div:nth-child(2) div.oxd-select-wrapper div.oxd-select-text.oxd-select-text--active > div.oxd-select-text--after");
	By enabled = By.xpath("//div[@class='oxd-select-option'][2]");
	

	// Constructor
	public AdminPageOrangeHRM(WebDriver driver) {
		this.driver = driver;
	}


	// Page Actions
	public int getMenuItemsCount() {
		List<WebElement> items = driver.findElements(menuItems);
		return items.size();

	}

	public void clickAdminTab() {
		driver.findElement(adminTab).click();
		driver.findElement(searchButton).click();
	}

	public void searchByUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
		driver.findElement(searchButton).click();

	}

	public void searchByUserrole() {
		driver.findElement(userRole).click();
		driver.findElement(selectadmin).click();
		driver.findElement(searchButton).click();

	}

	public void searchByUserstatus() {
		driver.findElement(status).click();
		driver.findElement(enabled).click();

	}

	public int getTotalRecords() {
		return driver.findElements(totalRecords).size();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void printSideMenuOptions() {
		List<WebElement> options = driver.findElements(menuItems);
		for (WebElement option : options) {
			System.out.println(option.getText());
		}
	}







}



















