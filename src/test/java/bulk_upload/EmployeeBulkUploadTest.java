package bulk_upload;

import org.testng.annotations.Test;

import utils.BaseClass;
import pages.Employees_Page;

public class EmployeeBulkUploadTest extends BaseClass {

	@Test(priority = 0)
	public void bulk_upload() throws InterruptedException {

		perform_valid_login();

		Employees_Page bulk_upload = new Employees_Page(BaseClass.getDriver());

		bulk_upload.click_upload_button();
		bulk_upload.click_download_template_button();
		bulk_upload.verifyDownloadTemplate();
		bulk_upload.upload_xlsx_file("C:\\Users\\DELL\\Downloads\\download (18).xlsx");
		bulk_upload.verify_uploaded_file_name();
		bulk_upload.click_confirm_upload_button();
		bulk_upload.validate_file_uploaded_successfully_message();

	}

}
