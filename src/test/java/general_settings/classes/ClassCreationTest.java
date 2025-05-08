package general_settings.classes;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.GeneralSettingsPage;
import utils.BaseClass;

public class ClassCreationTest extends BaseClass{

	@Test(priority = 0)
	public void Login() {
		
		perform_valid_login();
	
	}
	
	@Test(priority =1,dataProvider = "ClassesData")
	public void create_class(String className, String roomNumber, String teacherName) throws InterruptedException {
		
		GeneralSettingsPage create = new GeneralSettingsPage(BaseClass.getDriver());
		
		create.click_general_settings();
		create.click_classes();
		create.click_add_new_Button();
		create.enter_class_name(className);
		create.enter_room_number(roomNumber);
		create.select_teacher_name(teacherName);
		create.click_save_button();
		create.validate_class_create_success_message();
	}
	
	@DataProvider(name = "ClassesData")
	public Object[][] getClassesData(){
		return new Object[][] {{
			"BIO-MATHS","103","keerthi"
		}};
	}
	
}
