package bulk_upload;

import org.testng.annotations.Test;

import pages.GeneralSettings_Page;
import utils.BaseClass;

public class BusStopBulkUpload extends BaseClass {
	
	@Test(priority = 0)
	public void bulk_upload() throws InterruptedException {

		perform_valid_login();

		GeneralSettings_Page bulk_upload = new GeneralSettings_Page(BaseClass.getDriver());
		
		bulk_upload.click_general_settings();
		bulk_upload.click_bus_stops();
		bulk_upload.click_upload_button();
		bulk_upload.click_download_template_button();
		bulk_upload.verify_download_template();
		bulk_upload.upload_xlsx_file("C:\\Users\\DELL\\Downloads\\download (35).xlsx");
		bulk_upload.verify_uploaded_file_name();
		bulk_upload.click_confirm_upload_button();
		bulk_upload.validate_file_uploaded_successfully_message();

	}
}
