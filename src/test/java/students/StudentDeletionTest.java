package students;

import org.testng.annotations.Test;

import utils.BaseClass;
import pages.StudentsPage;

public class StudentDeletionTest extends BaseClass {
	
	@Test(priority = 0)
	public void Login() {
		perform_valid_login();
	}
	
	@Test(priority = 4)
	public void delete_bus_attendant() throws InterruptedException {
		
		StudentsPage delete = new StudentsPage(BaseClass.getDriver());
		
		delete.click_students_section();
		delete.search_student("EWW");
		delete.click_delete_button();
		delete.click_confirm_delete_button();
		delete.validate_busAttendant_delete_success_message();

	}

}
