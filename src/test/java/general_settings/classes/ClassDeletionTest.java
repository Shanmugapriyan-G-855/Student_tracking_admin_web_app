package general_settings.classes;

import org.testng.annotations.Test;

import pages.GeneralSettings_Page;
import utils.BaseClass;

public class ClassDeletionTest extends BaseClass{
	
	@Test(priority = 0)
	public void Login() {

		perform_valid_login();

	}
	
	@Test(priority =1)
	public void delete_class() throws InterruptedException {
		
		GeneralSettings_Page delete = new GeneralSettings_Page(BaseClass.getDriver());
		
		delete.click_general_settings();
		delete.click_classes();
		delete.click_delete_icon();
		delete.click_confirm_delete();
		delete.validate_class_delete_success_message();
		
		
	}
	
	

}
