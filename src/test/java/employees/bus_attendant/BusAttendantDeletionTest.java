package employees.bus_attendant;

import org.testng.annotations.Test;

import utils.BaseClass;
import pages.EmployeesPage;

public class BusAttendantDeletionTest extends BaseClass {

	@Test(priority = 0)
	public void Login() {

		perform_valid_login();

	}

	@Test(priority = 1)
	public void delete_bus_attendant() throws InterruptedException {

		EmployeesPage delete = new EmployeesPage(BaseClass.getDriver());

		delete.search_employee("BA300");
		delete.click_delete_button();
		delete.click_confirm_delete_button();
		delete.validate_busAttendant_delete_success_message();

	}

}
