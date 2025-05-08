package general_settings.bus_stops;

import org.testng.annotations.Test;

import pages.GeneralSettingsPage;
import utils.BaseClass;

public class BusStopDeletionTest extends BaseClass{
	@Test(priority = 0)
	public void Login() {

		perform_valid_login();

	}
	
	@Test(priority =1)
	public void delete_bus_stop() throws InterruptedException {
		
		GeneralSettingsPage delete = new GeneralSettingsPage(BaseClass.getDriver());
		
		delete.click_general_settings();
		delete.click_bus_stops();
		delete.click_delete_icon();
		delete.click_confirm_delete();
		delete.validate_bus_stop_delete_success_message();
		
		
	}
}
