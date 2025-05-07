package employees.teacher;

import org.testng.annotations.Test;

import utils.BaseClass;
import pages.Employees_Page;

public class TeacherQrDownloadTest extends BaseClass {

	@Test(priority = 0)
	public void Login() {

		perform_valid_login();

	}
	

	@Test(priority = 1)
	public void download_teacher_qr_code() throws InterruptedException {

		Employees_Page qr = new Employees_Page(BaseClass.getDriver());

		qr.click_teacher_header();
		qr.search_employee("T01");
		qr.click_qr_button();
		qr.click_download_as_png_button();
		qr.click_download_qr_close_btn();
		qr.verify_teacher_qr_file_is_downloaded();
	}
}
