package employees.driver;

import org.testng.annotations.Test;

import utils.BaseClass;
import pages.Employees_Page;

public class DriverDeletionTest extends BaseClass {

	@Test(priority = 0)
	public void Login() {

		perform_valid_login();

	}
	
	@Test(priority = 1)
	public void delete_driver() throws InterruptedException {

		Employees_Page delete = new Employees_Page(BaseClass.getDriver());
		
		delete.click_driver_header();
		delete.search_employee("DRIVER01");
		delete.click_delete_button();
		delete.click_confirm_delete_button();
		delete.validate_driver_delete_success_message();

	}

}
