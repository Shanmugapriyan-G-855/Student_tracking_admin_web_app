package general_settings.bus_stops;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.GeneralSettings_Page;
import utils.BaseClass;

public class BusStopCreationTest extends BaseClass{
	 
	@Test(priority = 0)
	public void Login() {
		
		perform_valid_login();
	
	}
	
	@Test(priority =1,dataProvider = "busStopsData")
	public void create_class(String latitude, String longitude, String stopName) throws InterruptedException {
		
		GeneralSettings_Page bs = new GeneralSettings_Page(BaseClass.getDriver());
		
		bs.click_general_settings();
		bs.click_bus_stops();
		bs.click_add_new_Button();
		bs.enter_latitude(latitude);
		bs.enter_longitude(longitude);
		bs.enter_stop_name(stopName);
		bs.scroll_down();
		bs.click_save_button();
		bs.validate_bus_stop_create_success_message();
	}
	
	@DataProvider(name = "busStopsData")
	public Object[][] getBusStopsData(){
		return new Object[][] {{
			"8.945328694311629","77.63387578632475","Manur Stop"
		}};
	}
	
}
