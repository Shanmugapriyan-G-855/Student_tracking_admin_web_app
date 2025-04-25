package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.Employees_Page;

public class Employee_Teacher_Positive_Test extends BaseClass{

	@Test(priority=0, dataProvider="createTeacherData")
	public void create_teacher(String imagePath, String idNumber, String name,String countryCode,String mobileNumber,String bloodGroup, String teacherPassword,String mobileNoInList) {
		
		perform_valid_login();
		
		Employees_Page create = new Employees_Page(BaseClass.getDriver());
		
		create.click_teacher_header();
		create.click_AddNew_Button();
		create.file_Upload(imagePath);
		create.enter_id_number(idNumber);
		create.enter_teacher_name(name);
		create.select_country_code(countryCode);
		create.enter_om_number(mobileNumber);
		create.select_blood_group(bloodGroup);
		create.enter_password(teacherPassword);
		create.click_save_button();
		create.validate_teacher_create_success_msg();
		create.verify_teacher_created(idNumber, mobileNoInList);
		
	}
	
	@Test(priority = 1, dataProvider = "udpateTeacherData")
	public void update_driver(String updateImagePath, String updateName, String updateMobileNumber)
			throws InterruptedException {

		Employees_Page update = new Employees_Page(BaseClass.getDriver());

		search_teacher();

		update.click_edit_button();
		update.file_Upload(updateImagePath);
		update.enter_teacher_name(updateName);
		update.enter_om_number(updateMobileNumber);
		update.click_save_button();
		update.validate_teacher_update_success_message();
		Thread.sleep(3000);
	}
	
	@Test(priority = 2)
	public void download_teacher_qr_code() throws InterruptedException {

		Employees_Page qr = new Employees_Page(BaseClass.getDriver());

		search_teacher();

		qr.click_qr_button();
		Thread.sleep(1000);
		qr.click_download_as_png_button();
		Thread.sleep(3000);
		qr.click_download_qr_close_button();
		qr.verify_teacher_qr_file_is_downloaded();
	}
	
	@Test(priority = 3)
	public void delete_teacher() throws InterruptedException {

		Employees_Page delete = new Employees_Page(BaseClass.getDriver());

		search_teacher();

		delete.click_delete_button();
		Thread.sleep(1000);
		delete.click_confirm_delete_button();
		delete.validate_teacher_delete_success_message();

	}

	
	public void search_teacher() throws InterruptedException {

		String employeeId = "T01";

		Employees_Page search = new Employees_Page(BaseClass.getDriver());

		search.select_search_option("Employee ID");
		search.enter_id_in_search_input(employeeId);
		search.search_result(employeeId);
		Thread.sleep(3000);

	}
	
	@DataProvider(name = "createTeacherData")
	public Object[][] getGateKeeperData() {
		return new Object[][] { { "C:\\Users\\DELL\\Downloads\\download (1).jpeg", "T01", "Mason", "OM (+968)",
				"87878787", "B+ve", "12345678", "+968 87878787" } };
	}

	@DataProvider(name = "udpateTeacherData")
	public Object[][] putGateKeeperData() {
		return new Object[][] { { "C:\\Users\\DELL\\Downloads\\download (2).jpeg", "Smith", "98989898" } };
	}
	
}
