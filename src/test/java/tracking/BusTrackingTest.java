package tracking;

import org.testng.annotations.Test;

import pages.TrackingPage;
import utils.BaseClass;

public class BusTrackingTest extends BaseClass {
	
	@Test(priority = 0)
	public void Login() {
		
		perform_valid_login();
	
	}
	
	@Test(priority = 1)
	public void busTrackingTest() throws InterruptedException {
		
		TrackingPage tp = new TrackingPage(BaseClass.getDriver());
		
		tp.click_tracking();
		tp.verify_map_loads();
		tp.click_satellite_toggle();
		tp.click_roadmap_toggle();
		tp.verify_searchBy_bus_number("B001");
		tp.verify_attendant_driver_info("Harley","Henry");
	}

}
