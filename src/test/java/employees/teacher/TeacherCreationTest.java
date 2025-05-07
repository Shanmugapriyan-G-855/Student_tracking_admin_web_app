package employees.teacher;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.BaseClass;
import pages.Employees_Page;

public class TeacherCreationTest extends BaseClass {

	@Test(priority = 0)
	public void Login() {

		perform_valid_login();

	}

	@Test(priority = 1, dataProvider = "createTeacherData")
	public void create_teacher(String imagePath, String idNumber, String name, String countryCode, String mobileNumber,
			String bloodGroup, String teacherPassword, String mobileNoInList) {

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

	@DataProvider(name = "createTeacherData")
	public Object[][] getGateKeeperData() {
		return new Object[][] { { "C:\\Users\\DELL\\Downloads\\download (1).jpeg", "T01", "Mason", "OM (+968)",
				"87878787", "B+ve", "12345678", "+968 87878787" } };
	}

}
