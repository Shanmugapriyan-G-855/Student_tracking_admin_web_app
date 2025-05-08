package employees.driver;

import org.testng.annotations.Test;

import utils.BaseClass;
import pages.EmployeesPage;

public class DriverQrDownloadTest extends BaseClass {

	@Test(priority = 0)
	public void Login() {

		perform_valid_login();

	}
	
	@Test(priority = 1)
	public void download_driver_qr_code() throws InterruptedException {

		EmployeesPage qr = new EmployeesPage(BaseClass.getDriver());

		qr.click_driver_header();
		qr.search_employee("S");
		qr.click_qr_button();
		qr.click_download_as_png_button();
		qr.click_download_qr_close_btn();
		qr.verify_driver_qr_file_is_downloaded();
	}


}
