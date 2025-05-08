package employees.teacher;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.BaseClass;
import pages.EmployeesPage;

public class TeacherUpdationTest extends BaseClass {

	@Test(priority = 0)
	public void Login() {

		perform_valid_login();

	}

	@Test(priority = 1, dataProvider = "udpateTeacherData")
	public void update_driver(String updateImagePath, String updateName, String updateMobileNumber)
			throws InterruptedException {

		EmployeesPage update = new EmployeesPage(BaseClass.getDriver());

		update.click_teacher_header();
		update.search_employee("T01");
		update.click_edit_button();
		update.file_Upload(updateImagePath);
		update.enter_teacher_name(updateName);
		update.enter_om_number(updateMobileNumber);
		update.click_save_button();
		update.validate_teacher_update_success_message();
	}

	@DataProvider(name = "udpateTeacherData")
	public Object[][] putGateKeeperData() {
		return new Object[][] { { "C:\\Users\\DELL\\Downloads\\download (2).jpeg", "Smith", "98989898" } };
	}
}
