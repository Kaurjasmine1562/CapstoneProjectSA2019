package Scenario2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminTestOrangeHRM extends BaseClassOrangeHRM{

	@Test
	public void countElements() {
		LoginPageOrangeHRM Loginpg = new LoginPageOrangeHRM(driver);
		Loginpg.login("Admin", "admin123");

		AdminPageOrangeHRM Adminpg = new AdminPageOrangeHRM(driver);

		//getting the element count
		int menucount = Adminpg.getMenuItemsCount();
		System.out.println("Total number of elements are" + " " + menucount);
		Assert.assertEquals(menucount, 12);

		//printing the element count
		Adminpg.printSideMenuOptions();

		//click on admin tab
		AdminPageOrangeHRM adminPage = new AdminPageOrangeHRM(driver);
		adminPage.clickAdminTab();
		System.out.println("Clicked on Admin Tab");
		Assert.assertFalse(driver.getCurrentUrl().contains("dashboard"));

		//message for confirmation
		System.out.println("First test case completed!");
	} 

	@Test
	public void SearchByUsername() throws InterruptedException {
		//Login
		LoginPageOrangeHRM Loginpg = new LoginPageOrangeHRM(driver);
		Loginpg.login("Admin", "admin123");
		System.out.println("Logged in successfully!");

		AdminPageOrangeHRM Adminpg = new AdminPageOrangeHRM(driver);

		//click on admin tab
		Adminpg.clickAdminTab();
		System.out.println("Clicked on Admin Tab");
		Assert.assertFalse(driver.getCurrentUrl().contains("dashboard"));

		Thread.sleep(1000);

		//searching for existing employee
		Adminpg.searchByUsername("Admin");
		int totalRecords = Adminpg.getTotalRecords();
		System.out.println("Total records found: " + totalRecords);

		// Assert that records are found
		Assert.assertTrue(totalRecords > 0, "No records found for username 'Admin'");

		// Refresh the page
		Adminpg.refreshPage();

		//message for confirmation
		System.out.println("Second test case completed!");
	}

	@Test
	public void searchByUserRole() throws InterruptedException {

		//Login
		LoginPageOrangeHRM Loginpg = new LoginPageOrangeHRM(driver);
		Loginpg.login("Admin", "admin123");
		System.out.println("Logged in successfully!");

		AdminPageOrangeHRM Adminpg = new AdminPageOrangeHRM(driver);

		//click on admin tab
		Adminpg.clickAdminTab();
		System.out.println("Clicked on Admin Tab");
		Assert.assertFalse(driver.getCurrentUrl().contains("dashboard"));

		Thread.sleep(1000);

		//searching for admin in user role
		Adminpg.searchByUserrole();
		
		//number of records found
        int totalRecords = Adminpg.getTotalRecords();
		System.out.println("Total records found: " + totalRecords);

		// Assert that records are found
		Assert.assertTrue(totalRecords > 0, "No records found for username 'Admin'");

		// Refresh the page
		Adminpg.refreshPage();

		//message for confirmation
		System.out.println("Third test case completed!");

	}

	@Test
	public void searchByUserStatus() throws InterruptedException {

		//Login
		LoginPageOrangeHRM Loginpg = new LoginPageOrangeHRM(driver);
		Loginpg.login("Admin", "admin123");
		System.out.println("Logged in successfully!");

		AdminPageOrangeHRM Adminpg = new AdminPageOrangeHRM(driver);

		//click on admin tab
		Adminpg.clickAdminTab();
		System.out.println("Clicked on Admin Tab");
		Assert.assertFalse(driver.getCurrentUrl().contains("dashboard"));

		Thread.sleep(1000);
		
		//searching by status
		Adminpg.searchByUserstatus();
		System.out.println("clicked on status tab");
		
		//number of records found
        int totalRecords = Adminpg.getTotalRecords();
		System.out.println("Total records found: " + totalRecords);

		// Assert that records are found
		Assert.assertTrue(totalRecords > 0, "No records found for enabled");
		
		//message for confirmation
		System.out.println("Fourth test case completed successfully!");
		
		
		
		
	}
}









