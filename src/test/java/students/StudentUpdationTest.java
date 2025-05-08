package students;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.BaseClass;
import pages.StudentsPage;

public class StudentUpdationTest extends BaseClass {

	@Test(priority = 0)
	public void Login() {
		perform_valid_login();
	}

	@Test(priority = 1, dataProvider = "updateStudentData")
	public void update_bus_attendant(String studentId, String updateImagePath, String updateName, String countryCode,
			String updateMobileNumber, String busStop) throws InterruptedException {

		StudentsPage update = new StudentsPage(BaseClass.getDriver());
		
		update.click_students_section();
		update.search_student(studentId);
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

	@DataProvider(name = "updateStudentData")
	public Object[][] putStudentData() {
		return new Object[][] { { "S10", "C:\\Users\\DELL\\Downloads\\images (7).jpeg", "casandra", "IND (+91)",
				"6767676767", "Sudha GH" } };
	}
}
