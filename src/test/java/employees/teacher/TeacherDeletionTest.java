package employees.teacher;

import org.testng.annotations.Test;

import utils.BaseClass;
import pages.EmployeesPage;

public class TeacherDeletionTest extends BaseClass {

	@Test(priority = 0)
	public void Login() {

		perform_valid_login();

	}

	@Test(priority = 1)
	public void delete_teacher() throws InterruptedException {

		EmployeesPage delete = new EmployeesPage(BaseClass.getDriver());

		delete.click_teacher_header();
		delete.search_employee("T01");
		delete.click_delete_button();
		Thread.sleep(1000);
		delete.click_confirm_delete_button();
		delete.validate_teacher_delete_success_message();

	}
}
