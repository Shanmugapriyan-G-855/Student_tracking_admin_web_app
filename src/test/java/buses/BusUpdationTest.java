package buses;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.BaseClass;
import pages.Buses_Page;

public class BusUpdationTest extends BaseClass {
	
	@Test(priority = 0)
	public void Login() {
		perform_valid_login();
	}
	
	@Test(priority = 1, dataProvider = "updateBusInfoData")
	public void update_bus(String ExistsbusNumber ,String busNumber, String vehicleNumber, String busCapacity) throws InterruptedException {

		Buses_Page update = new Buses_Page(BaseClass.getDriver());

		update.click_buses_section();
		update.search_bus(ExistsbusNumber);
		update.click_bus();
		update.click_busInfo_edit_button();
		update.enter_bus_number(busNumber);
		update.enter_vehicle_number(vehicleNumber);
		update.enter_bus_capacity(busCapacity);
		update.click_save_button();
		update.validate_bus_info_update_success_message();
	}
	

	@DataProvider(name = "updateBusInfoData")
	public Object[][] putBusData() {
		return new Object[][] { { "B722","B001", "TN 76 AH 6541", "20" } };
	}
}
