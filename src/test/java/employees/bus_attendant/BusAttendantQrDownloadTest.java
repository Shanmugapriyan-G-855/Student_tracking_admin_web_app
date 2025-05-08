package employees.bus_attendant;

import org.testng.annotations.Test;

import utils.BaseClass;
import pages.EmployeesPage;

public class BusAttendantQrDownloadTest extends BaseClass {

	@Test(priority = 0)
	public void Login() {
		
		perform_valid_login();
		
	}
	
	@Test(priority = 1)
	public void download_bus_attendant_qr_code() throws InterruptedException {

		EmployeesPage qr = new EmployeesPage(BaseClass.getDriver());

		qr.search_employee("BA300");
		qr.click_qr_button();
		qr.click_download_as_png_button();
		qr.click_download_qr_close_button();
		qr.verify_bus_attendant_qr_file_is_downloaded();
		
	}
}
