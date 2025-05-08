package students;

import org.testng.annotations.Test;

import utils.BaseClass;
import pages.StudentsPage;

public class StudentQrDownloadTest extends BaseClass {

	@Test(priority = 0)
	public void Login() {
		perform_valid_login();
	}

	@Test(priority = 1)
	public void download_bus_attendant_qr_code() throws InterruptedException {

		StudentsPage qr = new StudentsPage(BaseClass.getDriver());
		
		qr.click_students_section();
		qr.search_student("S10");
		qr.click_qr_button();
		qr.click_download_as_png_button();
		qr.click_download_qr_close_button();
		qr.verify_student_qr_file_is_downloaded();
	}
}
