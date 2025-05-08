package students;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.BaseClass;
import pages.StudentsPage;

public class StudentCreationTest extends BaseClass {

	@Test(priority = 0)
	public void Login() {
		perform_valid_login();
	}

	@Test(priority = 1, dataProvider = "createStudentData")
	public void student_creation(String imagePath, String idNumber, String name, String countryCode1,
			String mobileNumber1, String countryCode2, String mobileNumber2, String classNo, String bloodGroup,
			String dob, String gender, String email, String nationality, String address, String mode, String busStop)
			throws InterruptedException {

		StudentsPage student = new StudentsPage(BaseClass.getDriver());

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

	@DataProvider(name = "createStudentData")
	public Object[][] getStudentData() {
		return new Object[][] { { "C:\\Users\\DELL\\Downloads\\VisualsStock_AK59032.jpg", "STD1001", "Hanshika",
				"UAE (+971)", "989898989", "IND (+91)", "9887766555", "1-A", "AB-ve", "2002-05-23", "Female",
				"januexample@gmail.com", "United Arab Emirates", "2/84,Nehru Street", "School Bus",
				"Kumalan Kuttai" } };
	}

	
}
