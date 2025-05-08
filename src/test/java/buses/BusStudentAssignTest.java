package buses;

import org.testng.annotations.Test;

import utils.BaseClass;
import pages.BusesPage;

public class BusStudentAssignTest extends BaseClass {

	@Test(priority = 0)
	public void Login() {
		perform_valid_login();
	}

	@Test(priority = 1)
	public void assign_student() throws InterruptedException {

		BusesPage assign = new BusesPage(BaseClass.getDriver());

		assign.click_buses_section();
		assign.search_bus("B001");
		assign.click_bus();
		assign.click_student_employee_allocation_edit_button();
		assign.scroll_Down_02();
		assign.click_add_students_button();
		assign.scroll_Down_03();
		assign.click_select_bus_stop();
		assign.scroll_to_cancel_button();
		assign.click_cancel_button();
		assign.click_student_employee_allocation_edit_button();
		assign.scroll_Down_02();
		assign.click_add_students_button();
		assign.select_bus_stop("Sudha GH");
		assign.select_student();
		assign.scroll_to_save_button();
		assign.click_save_button();
		assign.validate_bus_student_assigned_successfully_msg();

	}

}
