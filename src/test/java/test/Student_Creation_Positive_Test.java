package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.Students_Page;

public class Student_Creation_Positive_Test extends BaseClass {

	@Test(priority = 0)
	public void Login() {
		perform_valid_login();
	}

	@Test(priority = 1, dataProvider = "createStudentData")
	public void student_creation(String imagePath, String idNumber, String name, String countryCode1,
			String mobileNumber1, String countryCode2, String mobileNumber2, String classNo, String bloodGroup,
			String dob, String gender, String email, String nationality, String address, String mode, String busStop)
			throws InterruptedException {

		Students_Page student = new Students_Page(BaseClass.getDriver());

		student.click_students_section();
		student.click_add_student_button();
		student.file_Upload(imagePath);
		student.enter_student_id_number(idNumber);
		student.enter_student_name(name);
		student.select_country_code_parent_number(countryCode1);
		student.enter_uae_parent_mobile_number(mobileNumber1);
		student.select_country_code_emergency_number(countryCode2);
		student.enter_ind_emergency_mobile_number(mobileNumber2);
		student.scroll_Down_01();
		student.select_student_class_No(classNo);
		student.select_student_blood_group(bloodGroup);
		student.enter_student_dob(dob);
		student.select_student_gender(gender);
		student.enter_parent_mail(email);
		student.select_student_nationality(nationality);
		student.enter_student_address(address);
		student.select_mode_of_transport(mode);
		student.scroll_Down_02();
		student.select_bus_stop(busStop);
		student.click_save_button();
		student.validate_student_create_success_message();

	}

	@Test(priority = 2, dataProvider = "updateStudentData")
	public void update_bus_attendant(String updateImagePath, String updateName, String countryCode,
			String updateMobileNumber, String busStop) throws InterruptedException {

		Students_Page update = new Students_Page(BaseClass.getDriver());

		search_student();

		update.click_edit_button();
		update.click_delete_student_image();
		update.file_Upload(updateImagePath);
		update.enter_student_name(updateName);
		update.select_country_code_parent_number(countryCode);
		update.enter_ind_parent_mobile_number(updateMobileNumber);
		update.scroll_Down_02();
		update.select_bus_stop(busStop);
		update.click_save_button();
		update.validate_student_update_success_message();
		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void download_bus_attendant_qr_code() throws InterruptedException {

		Students_Page qr = new Students_Page(BaseClass.getDriver());

		search_student();

		qr.click_qr_button();
		Thread.sleep(1000);
		qr.click_download_as_png_button();
		Thread.sleep(3000);
		qr.click_download_qr_close_button();
		qr.verify_student_qr_file_is_downloaded();
	}
	
	@Test(priority = 4)
	public void delete_bus_attendant() throws InterruptedException {
		Students_Page delete = new Students_Page(BaseClass.getDriver());

		search_student();

		delete.click_delete_button();
		Thread.sleep(1000);
		delete.click_confirm_delete_button();
		delete.validate_busAttendant_delete_success_message();

	}

	public void search_student() throws InterruptedException {

		String studentId = "STD1001";

		Students_Page search = new Students_Page(BaseClass.getDriver());

		search.select_search_option("Student ID");
		search.enter_id_in_search_input(studentId);
		search.search_result(studentId);
		Thread.sleep(3000);

	}

	@DataProvider(name = "createStudentData")
	public Object[][] getStudentData() {
		return new Object[][] { { "C:\\Users\\DELL\\Downloads\\VisualsStock_AK59032.jpg", "STD1001", "Hanshika",
				"UAE (+971)", "989898989", "IND (+91)", "9887766555", "1-A", "AB-ve", "2002-05-23", "Female",
				"januexample@gmail.com", "United Arab Emirates", "2/84,Nehru Street", "School Bus",
				"Kumalan Kuttai" } };
	}

	@DataProvider(name = "updateStudentData")
	public Object[][] putStudentData() {
		return new Object[][] {
				{ "C:\\Users\\DELL\\Downloads\\images (7).jpeg", "casandra", "IND (+91)", "6767676767", "Sudha GH" } };
	}
}
