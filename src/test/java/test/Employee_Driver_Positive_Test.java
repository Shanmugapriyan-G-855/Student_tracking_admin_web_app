package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.Employees_Page;

public class Employee_Driver_Positive_Test extends BaseClass {

	@Test(priority = 0, dataProvider = "createDriverData")
	public void create_driver(String imagePath, String driverId, String driverName, String countryCode,
			String driverMobileNo, String bloodGroup, String driverPassword, String expectedMobileNoInList) {

		perform_valid_login();

		Employees_Page create = new Employees_Page(driver);

		create.click_driver_header();
		create.click_AddNew_Button();
		create.file_Upload(imagePath);
		create.enter_id_number(driverId);
		create.enter_driver_name(driverName);
		create.select_country_code(countryCode);
		create.enter_om_number(driverMobileNo);
		create.select_blood_group(bloodGroup);
		create.enter_password(driverPassword);
		create.click_save_button();
		create.validate_driver_create_success_message();
		create.verify_driver_created(driverId, expectedMobileNoInList);
	}

	@Test(priority = 1, dataProvider = "udpateDriverData")
	public void update_driver(String updateImagePath, String updateName, String updateMobileNumber)
			throws InterruptedException {

		Employees_Page update = new Employees_Page(driver);

		search_driver();

		update.click_edit_button();
		update.file_Upload(updateImagePath);
		update.enter_driver_name(updateName);
		update.enter_om_number(updateMobileNumber);
		update.click_save_button();
		update.validate_driver_update_success_message();
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void download_driver_qr_code() throws InterruptedException {

		Employees_Page qr = new Employees_Page(driver);

		search_driver();

		qr.click_qr_button();
		Thread.sleep(1000);
		qr.click_download_as_png_button();
		Thread.sleep(3000);
		qr.click_download_qr_close_button_driver();
		qr.verify_driver_qr_file_is_downloaded();
	}

	@Test(priority = 3)
	public void delete_driver() throws InterruptedException {

		Employees_Page delete = new Employees_Page(driver);

		search_driver();

		delete.click_delete_button();
		Thread.sleep(1000);
		delete.click_confirm_delete_button();
		delete.validate_driver_delete_success_message();

	}

	public void search_driver() throws InterruptedException {

		Employees_Page search = new Employees_Page(driver);

		search.select_search_option("Employee ID");
		search.enter_id_in_search_input("DRIVER01");
		search.search_result("DRIVER01");
		Thread.sleep(3000);

	}

	@DataProvider(name = "createDriverData")
	public Object[][] getDriverData() {
		return new Object[][] { { "C:\\Users\\DELL\\Downloads\\images (3).jpeg", "DRIVER01", "Henry", "OM (+968)",
				"87878787", "A-ve", "12345678", "+968 87878787" } };
	}

	@DataProvider(name = "udpateDriverData")
	public Object[][] putDriverData() {
		return new Object[][] { { "C:\\Users\\DELL\\Downloads\\images (4).jpeg", "Smith", "98989898" } };
	}
}
