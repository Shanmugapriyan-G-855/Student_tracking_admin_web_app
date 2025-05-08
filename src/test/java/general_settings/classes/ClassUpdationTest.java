package general_settings.classes;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.GeneralSettingsPage;
import utils.BaseClass;

public class ClassUpdationTest extends BaseClass {
	
	@Test(priority = 0)
	public void Login() {

		perform_valid_login();

	}

	@Test(priority = 1, dataProvider = "ClassesData")
	public void update_class(String className, String roomNumber, String teacherName) throws InterruptedException {

		GeneralSettingsPage edit = new GeneralSettingsPage(BaseClass.getDriver());

		edit.click_general_settings();
		edit.click_classes();
		edit.click_edit_icon();
		edit.enter_class_name(className);
		edit.enter_room_number(roomNumber);
		edit.select_teacher_name(teacherName);
		edit.click_save_button();
		edit.validate_class_update_success_message();
	}

	@DataProvider(name = "ClassesData")
	public Object[][] getClassesData() {
		return new Object[][] { { "BIO-CHE", "104", "keerthi" } };
	}
}
