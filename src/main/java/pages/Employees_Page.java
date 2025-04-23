package pages;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import utils.WaitUtils;

public class Employees_Page extends BasePage {

	private static final Logger logger = LoggerFactory.getLogger(Employees_Page.class);

	private By CompanyLogo = By.xpath("//img[@class='img-fluid']");
	private By AddNewBtn = By.xpath("//button[normalize-space()='+ Add new']");
	private By empUploadImage = By.xpath("//div[contains(text(),'Upload Image')]");
	private By empuploadInput = By.id("fileupload");
	private By empIdNumber = By.xpath("//input[@name='employee_id']");
	private By empName = By.xpath("//input[@name='nanny_name']");
	private By empCountryCode = By.cssSelector("div[class='mt-2'] div div select");
	private By tenDigitInput = By.xpath("//input[@placeholder='Enter 10 digit number']");
	private By nineDigitInput = By.xpath("//input[@placeholder='Enter 9 digit number']");
	private By eightDigitInput = By.xpath("//input[@placeholder='Enter 8 digit number']");
	private By empBloodGroup = By.xpath("//select[@name='blood_group']");
	private By empPassword = By.xpath("//input[@name='password']");
	private By empCancelBtn = By
			.cssSelector(".button_customButton__kmZxm.rounded.button_secondaryButton__DL98n.pointer.joy");
	private By empSaveBtn = By.xpath("//button[normalize-space()='Save']");
	private By empFirstRowDetails = By.xpath("(//tr[@class='tdata-row'])[1]");
	private By empSearchType = By.xpath("//select[@class='sc-dcJsrY cISxAM dropdown-btn']");
	private By empSearchInputField = By.xpath("//input[@placeholder='Search...']");
	private By empEditButton = By.xpath("//div[@class='action-tab']//div[1]//*[name()='svg']");
	private By empDeleteButton = By.xpath("//tbody//div[2]//*[name()='svg']");
	private By empConfirmDeleteButton = By.xpath("//button[normalize-space()='Delete']");
	private By empQrButton = By.xpath("//tbody//div[3]//*[name()='svg']");
	private By empDownloadButton = By.xpath("//button[normalize-space()='Download as png']");

	private By BusAttendantNfcId = By.xpath("//input[@name='nfc_id']");
	private By BusAttendantCreateSuccessMsg = By
			.xpath("//div[contains(text(),'Bus Attendant details created Successfully')]");
	private By BusAttendantUpdateSuccessMsg = By
			.xpath("//div[contains(text(),'Bus Attendant details updated successfully')]");
	private By BusAttendantDeleteSuccessMsg = By
			.xpath("//div[contains(text(),'Bus Attendant details deleted Successfully')]");
	private By BaDownloadCloseButton = By.xpath("(//*[name()='svg'][@role='img'])[25]");

	private By driverHeader = By.xpath("//p[normalize-space()='Driver']");
	private By driverName = By.xpath("//input[@name='driver_name']");
	private By driverCreateSuccessMsg = By.xpath("//div[contains(text(),'Driver detail created Successfully')]");
	private By driverUpdateSuccessMsg = By.xpath("//div[contains(text(),'Driver updated successfully')]");
	private By driverDeleteSuccessMsg = By.xpath("//div[contains(text(),'Driver details deleted Successfully')]");
	private By driverDownloadCloseButton = By.xpath("(//div[@class='pointer '])[2]");

	private By gateKeeperHeader = By.xpath("//p[normalize-space()='Gate Keeper']");
	private By gateKeeperName = By.xpath("//input[@name='gate_keeper_name']");
	private By gateKeeperCreateSuccessMsg = By.xpath("//div[contains(text(),'Gate keeper detail created Successfully')]");
	private By gateKeeperUpdateSuccessMsg = By.xpath("//div[contains(text(),'Gate keeper details updated successfully')]");
	private By gateKeeperDeleteSuccessMsg = By.xpath("//div[contains(text(),'Gate keeper details deleted Successfully')]");
	
	public Employees_Page(WebDriver driver) {
		super(driver);
	}

	public boolean isCompanyLogoVisible() {
		return isElementVisible(CompanyLogo);
	}

	public void click_AddNew_Button() {
		logger.info("Starting test: Bus Attendant Creation");
		click(AddNewBtn);
		logger.debug("Clicked on Add New button");
	}

	public void click_Upload_Image_Button() {
		click(empUploadImage);
	}

	public void file_Upload(String imagePath) {
		WebElement fileInput = driver.findElement(empuploadInput);
		fileInput.sendKeys(imagePath);
	}

	public void enter_id_number(String IdNumber) {
		type(empIdNumber, IdNumber);
	}

	public void enter_bus_attendant_name(String name) {
		type(empName, name);
	}

	public void select_country_code(String countryWithCode) {
		selectCountryCode(empCountryCode, countryWithCode);
	}

	public void enter_ind_number(String number) {
		type(tenDigitInput, number);
	}

	public void enter_uae_number(String number) {
		type(nineDigitInput, number);
	}

	public void enter_om_number(String number) {
		type(eightDigitInput, number);
	}

	public void select_blood_group(String bloodGroup) {
		selectbloodgroup(empBloodGroup, bloodGroup);
	}

	public void enter_nfc_id(String nfcid) {
		type(BusAttendantNfcId, nfcid);
	}

	public void enter_password(String password) {
		type(empPassword, password);
	}

	public void click_save_button() {
		click(empSaveBtn);
	}

	public void click_cancel_button() {
		click(empCancelBtn);
	}

	public void select_search_option(String searchOption) {
		searchBy(empSearchType, searchOption);
	}

	public void enter_id_in_search_input(String empid) {
		type(empSearchInputField, empid);
	}

	public void search_result(String expectedId) {
		WebElement firstRowDetails = WaitUtils.waitForVisibility(empFirstRowDetails);

		String firstRowText = firstRowDetails.getText();

		boolean isIdPresent = firstRowText.contains(expectedId);
		Assert.assertTrue(isIdPresent, "Search result not found ");
	}
	
	

	public void click_edit_button() {
		click(empEditButton);
	}

	public void click_delete_button() throws InterruptedException {
		Thread.sleep(3000);
		click(empDeleteButton);
	}

	public void click_confirm_delete_button() {
		click(empConfirmDeleteButton);
	}

	public void click_qr_button() {
		click(empQrButton);
	}

	public void click_download_as_png_button() {
		click(empDownloadButton);
	}

	/*public void verify_bus_attendant_qr_file_is_downloaded() {
		String downloadPath = "C:\\Users\\DELL\\Downloads";

		File folder = new File(downloadPath);

		File[] files = folder.listFiles((dir, name) -> name.startsWith("INS004_N_QR_") && name.endsWith(".png"));

		Assert.assertNotNull(files, "Download folder is empty or not accessible");

		Assert.assertTrue(files.length > 0, "No PNG files found in the folder");

		File downloadedFile = files[files.length - 1];

		Assert.assertTrue(downloadedFile.exists(), "Downloaded file does not exist");

		Assert.assertTrue(downloadedFile.length() > 0, "Downloaded file is empty");

		logger.info("File downloaded successfully: " + downloadedFile.getName());
	}*/

	public void click_download_qr_close_button_Bus_attendant() {
		click(BaDownloadCloseButton);
	}

	private String validateSuccessMessage(By locator, String expectedMessage) {
		try {
			WebElement successMessageElement = WaitUtils.waitForVisibility(locator);
			String successMessage = successMessageElement.getText();
			Assert.assertEquals(successMessage, expectedMessage, "Success message mismatch!");
			logger.info("Success message: " + successMessage);
			return successMessage;
		} catch (NoSuchElementException e) {
			logger.error("Success message not found: " + e.getMessage());
			Assert.fail("Success message element was not found or not visible.");
			return "";
		}
	}

	public String validate_busAttendant_create_success_message() {
		return validateSuccessMessage(BusAttendantCreateSuccessMsg, "Bus Attendant details created Successfully");
	}

	public String validate_busAttendant_update_success_message() {
		return validateSuccessMessage(BusAttendantUpdateSuccessMsg, "Bus Attendant details updated successfully");
	}

	public String validate_busAttendant_delete_success_message() {
		return validateSuccessMessage(BusAttendantDeleteSuccessMsg, "Bus Attendant details deleted Successfully");
	}

	public void verify_bus_attendant_created(String expectedId, String expectedmobileNumber) {
		verify_employee_created(expectedId, expectedmobileNumber);
	}

	public void click_driver_header() {
		click(driverHeader);
	}

	public void enter_driver_name(String name) {
		type(driverName, name);
	}

	public String validate_driver_create_success_message() {
		return validateSuccessMessage(driverCreateSuccessMsg, "Driver detail created Successfully");
	}

	public String validate_driver_update_success_message() {
		return validateSuccessMessage(driverUpdateSuccessMsg, "Driver updated successfully");
	}

	public String validate_driver_delete_success_message() {
		return validateSuccessMessage(driverDeleteSuccessMsg, "Driver details deleted Successfully");
	}

	public void verify_employee_created(String expectedId, String expectedMobileNumber) {
		WebElement firstRowDetails = WaitUtils.waitForVisibility(empFirstRowDetails);

		String firstRowText = firstRowDetails.getText();

		boolean isIdPresent = firstRowText.contains(expectedId);
		boolean isMobileNumberPresent = firstRowText.contains(expectedMobileNumber);

		Assert.assertTrue(isIdPresent, "Id not found in the first row.");
		Assert.assertTrue(isMobileNumberPresent, "Mobile Number not found in the first row.");
	}

	public void verify_driver_created(String expectedId, String expectedMobileNumber) {
		verify_employee_created(expectedId, expectedMobileNumber);
	}

/*	public void verify_driver_qr_file_is_downloaded() {
		String downloadPath = "C:\\Users\\DELL\\Downloads";

		File folder = new File(downloadPath);

		File[] files = folder.listFiles((dir, name) -> name.startsWith("INS004_D_QR_") && name.endsWith(".png"));

		Assert.assertNotNull(files, "Download folder is empty or not accessible");

		Assert.assertTrue(files.length > 0, "No PNG files found in the folder");

		File downloadedFile = files[files.length - 1];

		Assert.assertTrue(downloadedFile.exists(), "Downloaded file does not exist");

		Assert.assertTrue(downloadedFile.length() > 0, "Downloaded file is empty");

		logger.info("File downloaded successfully: " + downloadedFile.getName());
	}*/

	public void click_download_qr_close_button_driver() {
		click(driverDownloadCloseButton);
	}

	public void click_gate_keeper_header() {
		click(gateKeeperHeader);
	}

	public void enter_gate_keeper_name(String name) {
		type(gateKeeperName, name);
	}

	public String validate_gate_keeper_create_success_msg() {
		return validateSuccessMessage(gateKeeperCreateSuccessMsg, "Gate keeper detail created Successfully");
	}
	
	public String validate_gate_keeper_update_success_message() {
		return validateSuccessMessage(gateKeeperUpdateSuccessMsg, "Gate keeper details updated successfully");
	}
	
	public String validate_gate_keeper_delete_success_message() {
		return validateSuccessMessage(gateKeeperDeleteSuccessMsg,"Gate keeper details deleted Successfully");
	}

	public void verify_gate_keeper_created(String expectedId, String expectedMobileNumber) {
		verify_employee_created(expectedId, expectedMobileNumber);
	}
	
	public void click_download_qr_close_button_gate_keeper() {
		click(driverDownloadCloseButton);
	}
	


	    public void verify_qr_file_is_downloaded(String prefix) {
	        String downloadPath = "C:\\Users\\DELL\\Downloads";
	        File folder = new File(downloadPath);

	        File[] files = folder.listFiles((dir, name) -> name.startsWith(prefix) && name.endsWith(".png"));

	        assert files != null : "Download folder is empty or not accessible";
	        assert files.length > 0 : "No PNG files found with prefix: " + prefix;

	        File downloadedFile = files[files.length - 1];

	        assert downloadedFile.exists() : "Downloaded file does not exist";
	        assert downloadedFile.length() > 0 : "Downloaded file is empty";

	        System.out.println("File downloaded successfully: " + downloadedFile.getName());
	    }

	    public void verify_driver_qr_file_is_downloaded() {
	        verify_qr_file_is_downloaded("INS004_D_QR_");
	    }

	    public void verify_bus_attendant_qr_file_is_downloaded() {
	        verify_qr_file_is_downloaded("INS004_N_QR_");
	    }
	    
	    public void verify_gate_keeper_qr_file_is_downloaded() {
	    	verify_qr_file_is_downloaded("INS004_G_QR_");
	    }
	}



