package employees.bus_attendant;

import java.util.concurrent.TimeoutException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Employees_Page;
import utils.BaseClass;

public class BusAttendantCreationTest extends BaseClass {

	@Test(priority = 0)
	public void Login() {
		
		perform_valid_login();
	
	}

	@Test(priority = 1, dataProvider = "createBusAttendantData")
	public void create_bus_attendant(String imagePath, String idNumber, String name, String countryCode,
			String mobileNumber, String bloodGroup, String password, String expectedMobileInList)
			throws TimeoutException {

		Employees_Page create = new Employees_Page(BaseClass.getDriver());

		create.click_AddNew_Button();
		create.file_Upload(imagePath);
		create.enter_id_number(idNumber);
		create.enter_bus_attendant_name(name);
		create.select_country_code(countryCode);
		create.enter_ind_number(mobileNumber);
		create.select_blood_group(bloodGroup);
		create.enter_password(password);
		create.click_save_button();
		create.validate_busAttendant_create_success_message();
		create.verify_bus_attendant_created(idNumber, expectedMobileInList);
		
	}

	@DataProvider(name = "createBusAttendantData")
	public Object[][] getBusAttendantData() {
		return new Object[][] { { "C:\\Users\\DELL\\Pictures\\Screenshots\\Screenshot 2025-03-20 122344.png", "BA300",
				"Ganesh", "IND (+91)", "1122334455", "A+ve", "securePass123", "+91 1122334455" } };
	}

}
