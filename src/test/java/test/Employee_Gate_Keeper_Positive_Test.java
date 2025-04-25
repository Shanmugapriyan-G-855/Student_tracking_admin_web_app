package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.Employees_Page;

public class Employee_Gate_Keeper_Positive_Test extends BaseClass {

	@Test(priority = 0, dataProvider = "createGateKeeperData")
	public void create_gate_keeper(String imagePath, String idNumber, String name, String countryCode, String mobileNo,
			String bloogGroup, String gkPassword, String mobileNoInList) {

		perform_valid_login();

		Employees_Page create = new Employees_Page(BaseClass.getDriver());

		create.click_gate_keeper_header();
		create.click_AddNew_Button();
		create.file_Upload(imagePath);
		create.enter_id_number(idNumber);
		create.enter_gate_keeper_name(name);
		create.select_country_code(countryCode);
		create.enter_uae_number(mobileNo);
		create.select_blood_group(bloogGroup);
		create.enter_password(gkPassword);
		create.click_save_button();
		create.validate_gate_keeper_create_success_msg();
		create.verify_gate_keeper_created(idNumber, mobileNoInList);

	}

	@Test(priority = 1, dataProvider = "udpateGateKeeperData")
	public void update_driver(String updateImagePath, String updateName, String updateMobileNumber)
			throws InterruptedException {

		Employees_Page update = new Employees_Page(BaseClass.getDriver());

		search_gate_Keeper();

		update.click_edit_button();
		update.file_Upload(updateImagePath);
		update.enter_gate_keeper_name(updateName);
		update.enter_uae_number(updateMobileNumber);
		update.click_save_button();
		update.validate_gate_keeper_update_success_message();
		Thread.sleep(3000);
	}
	

	@Test(priority = 2)
	public void download_gate_keeper_qr_code() throws InterruptedException {

		Employees_Page qr = new Employees_Page(BaseClass.getDriver());

		search_gate_Keeper();

		qr.click_qr_button();
		Thread.sleep(1000);
		qr.click_download_as_png_button();
		Thread.sleep(3000);
		qr.click_download_qr_close_button();
		qr.verify_gate_keeper_qr_file_is_downloaded();
	}
	
	@Test(priority = 3)
	public void delete_gate_keeper() throws InterruptedException {

		Employees_Page delete = new Employees_Page(BaseClass.getDriver());

		search_gate_Keeper();

		delete.click_delete_button();
		Thread.sleep(1000);
		delete.click_confirm_delete_button();
		delete.validate_gate_keeper_delete_success_message();

	}


	public void search_gate_Keeper() throws InterruptedException {

		String employeeId = "GK01";

		Employees_Page search = new Employees_Page(BaseClass.getDriver());

		search.select_search_option("Employee ID");
		search.enter_id_in_search_input(employeeId);
		search.search_result(employeeId);
		Thread.sleep(3000);

	}

	@DataProvider(name = "createGateKeeperData")
	public Object[][] getGateKeeperData() {
		return new Object[][] { { "C:\\Users\\DELL\\Downloads\\download (1).jpeg", "GK01", "Mason", "UAE (+971)",
				"878787878", "A-ve", "12345678", "+971 878787878" } };
	}

	@DataProvider(name = "udpateGateKeeperData")
	public Object[][] putGateKeeperData() {
		return new Object[][] { { "C:\\Users\\DELL\\Downloads\\images (4).jpeg", "Smith", "989898989" } };
	}

}
