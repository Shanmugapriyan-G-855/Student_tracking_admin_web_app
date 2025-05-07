package employees.gate_keeper;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.BaseClass;
import pages.Employees_Page;

public class GateKeeperCreationTest extends BaseClass {

	@Test(priority = 0)
	public void Login() {

		perform_valid_login();

	}

	@Test(priority = 1, dataProvider = "createGateKeeperData")
	public void create_gate_keeper(String imagePath, String idNumber, String name, String countryCode, String mobileNo,
			String bloogGroup, String gkPassword, String mobileNoInList) {

		Employees_Page create = new Employees_Page(BaseClass.getDriver());

		create.click_gate_keeper_header();
		create.click_AddNew_Button();
		create.file_Upload(imagePath);
		create.enter_id_number(idNumber);
		create.enter_gate_keeper_name(name);
		create.select_country_code(countryCode);
		create.enter_uae_number(mobileNo);
		create.select_blood_group(bloogGroup);
		create.enter_password(gkPassword);
		create.click_save_button();
		create.validate_gate_keeper_create_success_msg();
		create.verify_gate_keeper_created(idNumber, mobileNoInList);

	}

	@DataProvider(name = "createGateKeeperData")
	public Object[][] getGateKeeperData() {
		return new Object[][] { { "C:\\Users\\DELL\\Downloads\\download (1).jpeg", "GK01", "Mason", "UAE (+971)",
				"878787878", "A-ve", "12345678", "+971 878787878" } };
	}

}
