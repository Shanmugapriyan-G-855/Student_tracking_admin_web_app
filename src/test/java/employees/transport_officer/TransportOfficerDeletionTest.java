package employees.transport_officer;

import org.testng.annotations.Test;

import utils.BaseClass;
import pages.EmployeesPage;

public class TransportOfficerDeletionTest extends BaseClass {

	@Test(priority = 0)
	public void Login() {

		perform_valid_login();

	}

	@Test(priority = 1)
	public void delete_transport_officer() throws InterruptedException {

		EmployeesPage delete = new EmployeesPage(BaseClass.getDriver());

		delete.click_transport_officer_header();
		delete.search_employee("TO01");
		delete.click_delete_button();
		delete.click_confirm_delete_button();
		delete.validate_transport_officer_delete_success_message();

	}
}
