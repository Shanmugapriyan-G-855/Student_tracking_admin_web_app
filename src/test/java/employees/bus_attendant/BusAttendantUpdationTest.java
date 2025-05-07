package employees.bus_attendant;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.BaseClass;
import pages.Employees_Page;

public class BusAttendantUpdationTest extends BaseClass {

	@Test(priority = 0)
	public void Login() {
		
		perform_valid_login();
		
	}
	
	@Test(priority = 1, dataProvider = "updateBusAttendantData")
	public void update_bus_attendant(String updateImagePath, String updateName, String updateMobileNumber)
			throws InterruptedException {

		Employees_Page update = new Employees_Page(BaseClass.getDriver());

		update.search_employee("BA300");
		update.click_edit_button();
		update.file_Upload(updateImagePath);
		update.enter_bus_attendant_name(updateName);
		update.enter_ind_number(updateMobileNumber);
		update.click_save_button();
		update.validate_busAttendant_update_success_message();
		
	}
	
	@DataProvider(name = "updateBusAttendantData")
	public Object[][] putBusAttendantData() {
		return new Object[][] { { "C:\\Users\\DELL\\Pictures\\Screenshots\\Screenshot 2024-06-30 202523.png",
				"Ganesh Kumar", "9988776655" } };
	}
}
