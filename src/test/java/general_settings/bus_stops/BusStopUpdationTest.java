package general_settings.bus_stops;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.GeneralSettingsPage;
import utils.BaseClass;

public class BusStopUpdationTest extends BaseClass {
	@Test(priority = 0)
	public void Login() {

		perform_valid_login();

	}

	@Test(priority = 1, dataProvider = "busStopsData")
	public void create_class(String latitude, String longitude, String stopName) throws InterruptedException {

		GeneralSettingsPage bs = new GeneralSettingsPage(BaseClass.getDriver());

		bs.click_general_settings();
		bs.click_bus_stops();
		bs.click_edit_icon();
		bs.enter_latitude(latitude);
		bs.enter_longitude(longitude);
		bs.enter_stop_name(stopName);
		bs.scroll_down();
		bs.click_save_button();
		bs.validate_bus_stop_update_success_message();
	}

	@DataProvider(name = "busStopsData")
	public Object[][] getBusStopsData() {
		return new Object[][] { { "8.145328694311629", "77.13387578632475", "Mannur Stop" } };
	}
}
