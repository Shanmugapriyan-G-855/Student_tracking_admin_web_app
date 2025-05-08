package employees.driver;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.BaseClass;
import pages.EmployeesPage;

public class DriverUpdationTest extends BaseClass {
	
	@Test(priority = 0)
	public void Login() {

		perform_valid_login();

	}
	
	@Test(priority = 1, dataProvider = "udpateDriverData")
	public void update_driver(String updateImagePath, String updateName, String updateMobileNumber)
			throws InterruptedException {

		EmployeesPage update = new EmployeesPage(BaseClass.getDriver());
		
		update.click_driver_header();
		update.search_employee("DRIVER01");
		update.click_edit_button();
		update.file_Upload(updateImagePath);
		update.enter_driver_name(updateName);
		update.enter_om_number(updateMobileNumber);
		update.click_save_button();
		update.validate_driver_update_success_message();
		Thread.sleep(3000);
	}
	
	@DataProvider(name = "udpateDriverData")
	public Object[][] putDriverData() {
		return new Object[][] { { "C:\\Users\\DELL\\Downloads\\images (4).jpeg", "Smith", "98989898" } };
	}

	
}
