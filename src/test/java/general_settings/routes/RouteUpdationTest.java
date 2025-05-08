package general_settings.routes;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.GeneralSettings_Page;
import utils.BaseClass;

public class RouteUpdationTest extends BaseClass{
	
	@Test(priority = 0)
	public void Login() {
		
		perform_valid_login();
	
	}
	
	@Test(priority =1,dataProvider = "RoutesData")
	public void create_class(String routeName, String firstStop, String secondStop) throws InterruptedException {
		
		GeneralSettings_Page route = new GeneralSettings_Page(BaseClass.getDriver());
		
		route.click_general_settings();
		route.click_routes();
		route.click_edit_icon();
		route.enter_route_name(routeName);
		route.select_first_stop(firstStop);
		route.select_second_stop(secondStop);
		route.click_save_button();
		route.validate_route_update_successfully_message();
	}
	
	@DataProvider(name = "RoutesData")
	public Object[][] getRoutesData(){
		return new Object[][] {{
			"Route001","stop 1","stop 2"
		}};
	}
}
