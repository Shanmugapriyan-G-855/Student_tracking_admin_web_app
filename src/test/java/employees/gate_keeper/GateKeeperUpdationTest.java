package employees.gate_keeper;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.BaseClass;
import pages.EmployeesPage;

public class GateKeeperUpdationTest extends BaseClass {

	@Test(priority = 0)
	public void Login() {

		perform_valid_login();

	}
	
	@Test(priority = 1, dataProvider = "udpateGateKeeperData")
	public void update_driver(String updateImagePath, String updateName, String updateMobileNumber)
			throws InterruptedException {

		EmployeesPage update = new EmployeesPage(BaseClass.getDriver());

		update.click_gate_keeper_header();
		update.search_employee("GK01");
		update.click_edit_button();
		update.file_Upload(updateImagePath);
		update.enter_gate_keeper_name(updateName);
		update.enter_uae_number(updateMobileNumber);
		update.click_save_button();
		update.validate_gate_keeper_update_success_message();
	}
	
	@DataProvider(name = "udpateGateKeeperData")
	public Object[][] putGateKeeperData() {
		return new Object[][] { { "C:\\Users\\DELL\\Downloads\\images (4).jpeg", "Smith", "989898989" } };
	}
}
