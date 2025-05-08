package general_settings.routes;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.GeneralSettings_Page;
import utils.BaseClass;

public class RouteCreationTest extends BaseClass {
	
	@Test(priority = 0)
	public void Login() {
		
		perform_valid_login();
	
	}
	
	@Test(priority =1,dataProvider = "RoutesData")
	public void create_class(String routeName, String firstStop, String secondStop) throws InterruptedException {
		
		GeneralSettings_Page route = new GeneralSettings_Page(BaseClass.getDriver());
		
		route.click_general_settings();
		route.click_routes();
		route.click_add_new_Button();
		route.enter_route_name(routeName);
		route.select_first_stop(firstStop);
		route.click_add_stop();
		route.select_second_stop(secondStop);
		route.click_save_button();
		route.validate_route_create_successfully_message();
	}
	
	@DataProvider(name = "RoutesData")
	public Object[][] getRoutesData(){
		return new Object[][] {{
			"Route01","Kumalan Kuttai","Sudha GH"
		}};
	}
	
}
