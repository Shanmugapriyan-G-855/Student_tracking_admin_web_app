package buses;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.BaseClass;
import pages.BusesPage;

public class BusCreationTest extends BaseClass {

	@Test(priority = 0)
	public void Login() {
		perform_valid_login();
	}

	@Test(priority = 1, dataProvider = "createBusData")
	public void create_bus(String busNumber, String vehicleNumber, String busCapacity) {

		BusesPage create = new BusesPage(BaseClass.getDriver());

		create.click_buses_section();
		create.click_add_student_button();
		create.enter_bus_number(busNumber);
		create.enter_vehicle_number(vehicleNumber);
		create.enter_bus_capacity(busCapacity);
		create.click_save_button();
		create.validate_bus_create_success_message();
	}

	@DataProvider(name = "createBusData")
	public Object[][] getBusData() {
		return new Object[][] { { "B126", "TN 122 1AH 2345", "20" } };
	}

}
