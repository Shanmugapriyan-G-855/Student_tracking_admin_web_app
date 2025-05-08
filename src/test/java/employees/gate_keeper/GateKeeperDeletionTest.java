package employees.gate_keeper;

import org.testng.annotations.Test;

import utils.BaseClass;
import pages.EmployeesPage;

public class GateKeeperDeletionTest extends BaseClass {

	@Test(priority = 0)
	public void Login() {

		perform_valid_login();

	}
	
	@Test(priority = 1)
	public void delete_gate_keeper() throws InterruptedException {

		EmployeesPage delete = new EmployeesPage(BaseClass.getDriver());
		
		delete.click_gate_keeper_header();
		delete.search_employee("GK01");
		delete.click_delete_button();
		delete.click_confirm_delete_button();
		delete.validate_gate_keeper_delete_success_message();

	}
}
