package employees.transport_officer;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.BaseClass;
import pages.Employees_Page;

public class TransportOfficerUpdationTest extends BaseClass {

	@Test(priority = 0)
	public void Login() {

		perform_valid_login();

	}

	@Test(priority = 1, dataProvider = "udpateTransportOfficerData")
	public void update_driver(String updateImagePath, String updateName, String updateMobileNumber)
			throws InterruptedException {

		Employees_Page update = new Employees_Page(BaseClass.getDriver());

		update.click_transport_officer_header();
		update.search_employee("TO01");
		update.click_edit_button();
		update.file_Upload(updateImagePath);
		update.enter_transport_officer_name(updateName);
		update.enter_om_number(updateMobileNumber);
		update.click_save_button();
		update.validate_transport_officer_update_success_message();
		Thread.sleep(3000);
	}

	@DataProvider(name = "udpateTransportOfficerData")
	public Object[][] putGateKeeperData() {
		return new Object[][] { { "C:\\Users\\DELL\\Downloads\\download (2).jpeg", "Smith", "98989898" } };
	}
}
