package employees.gate_keeper;

import org.testng.annotations.Test;

import utils.BaseClass;
import pages.Employees_Page;

public class GateKeeperQrDownloadTest extends BaseClass {

	@Test(priority = 0)
	public void Login() {

		perform_valid_login();

	}

	@Test(priority = 1)
	public void download_gate_keeper_qr_code() throws InterruptedException {

		Employees_Page qr = new Employees_Page(BaseClass.getDriver());

		qr.click_gate_keeper_header();
		qr.search_employee("GK01");
		qr.click_qr_button();
		qr.click_download_as_png_button();
		qr.click_download_qr_close_btn();
		qr.verify_gate_keeper_qr_file_is_downloaded();
	}
}
