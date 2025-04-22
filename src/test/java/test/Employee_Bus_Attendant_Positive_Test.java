package test;

import java.util.concurrent.TimeoutException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.Employee_Bus_Attendant_Page;

public class Employee_Bus_Attendant_Positive_Test extends BaseClass {

	@Test(priority = 0, dataProvider = "busAttendantData")
	public void create_bus_attendant(String imagePath, String idNumber, String name, String countryCode,
			String mobileNumber, String bloodGroup, String password, String expectedMobileInList)
			throws TimeoutException {

		perform_valid_login();

		Employee_Bus_Attendant_Page create = new Employee_Bus_Attendant_Page(driver);

		create.click_AddNew_Button();
		create.file_Upload(imagePath);
		create.enter_id_number(idNumber);
		create.enter_name(name);
		create.select_country_code(countryCode);
		create.enter_mobile_number(mobileNumber);
		create.select_blood_group(bloodGroup);
		create.enter_password(password);
		create.click_save_button();
		create.validate_create_success_message();
		create.verify_bus_attendant_created(idNumber, expectedMobileInList);
	}

	@Test(priority = 1)
	public void search_bus_attendant() throws InterruptedException {

		Employee_Bus_Attendant_Page search = new Employee_Bus_Attendant_Page(driver);

		search.select_search_option("Employee ID");
		search.enter_id_in_search_input("BA300");
		search.search_result("BA300");
		Thread.sleep(3000);

	}

	@Test(priority = 2, dataProvider = "updateBusAttendantData")
	public void update_bus_attendant(String updateImagePath, String updateName, String updateMobileNumber)
			throws InterruptedException {

		Employee_Bus_Attendant_Page update = new Employee_Bus_Attendant_Page(driver);

		search_bus_attendant();

		update.click_edit_button();
		update.file_Upload(updateImagePath);
		update.enter_name(updateName);
		update.enter_mobile_number(updateMobileNumber);
		update.click_save_button();
		update.validate_update_success_message();
		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void download_bus_attendant_qr_code() throws InterruptedException {

		Employee_Bus_Attendant_Page qr = new Employee_Bus_Attendant_Page(driver);

		search_bus_attendant();

		qr.click_qr_button();
		Thread.sleep(1000);
		qr.click_download_as_png_button();
		Thread.sleep(3000);
		qr.click_download_qr_close_button();
		qr.verify_qr_file_is_downloaded();
	}

	@Test(priority = 4)
	public void delete_bus_attendant() throws InterruptedException {
		Employee_Bus_Attendant_Page delete = new Employee_Bus_Attendant_Page(driver);

		search_bus_attendant();

		delete.click_delete_button();
		Thread.sleep(1000);
		delete.click_confirm_delete_button();
		delete.validate_delete_success_message();

	}

	@DataProvider(name = "busAttendantData")
	public Object[][] getBusAttendantData() {
		return new Object[][] { { "C:\\Users\\DELL\\Pictures\\Screenshots\\Screenshot 2025-03-20 122344.png", "BA300",
				"Ganesh", "IND (+91)", "1122334455", "A+ve", "securePass123", "+91 1122334455" } };
	}

	@DataProvider(name = "updateBusAttendantData")
	public Object[][] putBusAttendantData() {
		return new Object[][] { { "C:\\Users\\DELL\\Pictures\\Screenshots\\Screenshot 2024-06-30 202523.png",
				"Ganesh Kumar", "9988776655" } };
	}

}
