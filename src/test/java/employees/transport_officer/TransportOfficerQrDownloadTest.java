package employees.transport_officer;

import org.testng.annotations.Test;

import utils.BaseClass;
import pages.Employees_Page;

public class TransportOfficerQrDownloadTest extends BaseClass {

	@Test(priority=0)
	public void Login() {

		perform_valid_login();

	}
	
	@Test(priority=1)
	public void download_transport_officer_qr_code() throws InterruptedException {

		Employees_Page qr = new Employees_Page(BaseClass.getDriver());

		qr.click_transport_officer_header();
		qr.search_employee("TO01");
		qr.click_qr_button();
		qr.click_download_as_png_button();
		qr.click_download_qr_close_button_transport_officer();
		qr.verify_transport_officer_qr_file_is_downloaded();
	}
}
