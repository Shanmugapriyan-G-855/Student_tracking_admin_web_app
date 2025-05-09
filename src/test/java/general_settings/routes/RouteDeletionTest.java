package general_settings.routes;

import org.testng.annotations.Test;

import pages.GeneralSettingsPage;
import utils.BaseClass;

public class RouteDeletionTest extends BaseClass {
	
	@Test(priority = 0)
	public void Login() {
		
		perform_valid_login();
	
	}
	
	@Test(priority =1)
	public void delete_route() throws InterruptedException {
		
		GeneralSettingsPage delete = new GeneralSettingsPage(BaseClass.getDriver());
		
		delete.click_general_settings();
		delete.click_routes();
		delete.click_delete_icon();
		delete.click_confirm_delete();
		delete.validate_route_delete_success_message();
		
		
	}
	
}
