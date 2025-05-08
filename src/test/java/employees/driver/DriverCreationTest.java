package employees.driver;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.BaseClass;
import pages.EmployeesPage;

public class DriverCreationTest extends BaseClass {

	@Test(priority = 0)
	public void Login() {

		perform_valid_login();

	}

	@Test(priority = 1, dataProvider = "createDriverData")
	public void create_driver(String imagePath, String driverId, String driverName, String countryCode,
			String driverMobileNo, String bloodGroup, String driverPassword, String expectedMobileNoInList) {

		EmployeesPage create = new EmployeesPage(BaseClass.getDriver());

		create.click_driver_header();
		create.click_AddNew_Button();
		create.file_Upload(imagePath);
		create.enter_id_number(driverId);
		create.enter_driver_name(driverName);
		create.select_country_code(countryCode);
		create.enter_om_number(driverMobileNo);
		create.select_blood_group(bloodGroup);
		create.enter_password(driverPassword);
		create.click_save_button();
		create.validate_driver_create_success_message();
		create.verify_driver_created(driverId, expectedMobileNoInList);
	}

	@DataProvider(name = "createDriverData")
	public Object[][] getDriverData() {
		return new Object[][] { { "C:\\Users\\DELL\\Downloads\\images (3).jpeg", "DRIVER01", "Henry", "OM (+968)",
				"87878787", "A-ve", "12345678", "+968 87878787" } };
	}

}
