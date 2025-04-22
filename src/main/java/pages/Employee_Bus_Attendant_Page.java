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

public class Employee_Bus_Attendant_Page extends BasePage {

	private static final Logger logger = LoggerFactory.getLogger(Employee_Bus_Attendant_Page.class);

	private By CompanyLogo = By.xpath("//img[@class='img-fluid']");
	private By BaAddNewBtn = By.xpath("//button[normalize-space()='+ Add new']");
	private By BaUploadImage = By.xpath("//div[contains(text(),'Upload Image')]");
	private By BaIdNumber = By.xpath("//input[@name='employee_id']");
	private By BaName = By.xpath("//input[@name='nanny_name']");
	private By BaCountryCode = By.cssSelector("div[class='mt-2'] div div select");
	private By tenDigitInput = By.xpath("//input[@placeholder='Enter 10 digit number']");
	private By nineDigitInput = By.xpath("//input[@placeholder='Enter 9 digit number']");
	private By eightDigitInput = By.xpath("//input[@placeholder='Enter 8 digit number']");
	private By BaBloodGroup = By.xpath("//select[@name='blood_group']");
	private By BaNfcId = By.xpath("//input[@name='nfc_id']");
	private By BaPassword = By.xpath("//input[@name='password']");
	private By BaCancelBtn = By.cssSelector(".button_customButton__kmZxm.rounded.button_secondaryButton__DL98n.pointer.joy");
	private By BaSaveBtn = By.xpath("//button[normalize-space()='Save']");
	private By BaCreateSuccessMsg = By.xpath("//div[contains(text(),'Bus Attendant details created Successfully')]");
	private By BaDeleteSuccessMsg = By.xpath("//div[contains(text(),'Bus Attendant details deleted Successfully')]");
	private By BaFirstRowDetails = By.xpath("(//tr[@class='tdata-row'])[1]");
	private By BaSearchType = By.xpath("//select[@class='sc-dcJsrY cISxAM dropdown-btn']");
	private By BaSearchInputField = By.xpath("//input[@placeholder='Search...']");
	private By BaEditButton = By.xpath("//div[@class='action-tab']//div[1]//*[name()='svg']");
	private By BaUpdateSuccessMsg = By.xpath("//div[contains(text(),'Bus Attendant details updated successfully')]");
	private By BaDeleteButton = By.xpath("//tbody/div[1]/tr[1]/td[7]/div[1]/div[2]//*[name()='svg']");
	private By BaConfirmDeleteButton = By.xpath("//button[normalize-space()='Delete']");
	private By BaQrButton = By.xpath("//tbody//div[3]//*[name()='svg']");
	private By BaDownloadButton = By.xpath("//button[normalize-space()='Download as png']");
	private By BaDownloadCloseButton = By.xpath("(//*[name()='svg'][@role='img'])[25]");

	public Employee_Bus_Attendant_Page(WebDriver driver) {
		super(driver);
	}

	public boolean isCompanyLogoVisible() {
		return isElementVisible(CompanyLogo);
	}

	public void click_AddNew_Button() {
		logger.info("Starting test: Bus Attendant Creation");
		click(BaAddNewBtn);
		logger.debug("Clicked on Add New button");
	}

	public void click_Upload_Image_Button() {
		click(BaUploadImage);
	}

	public void file_Upload(String imagePath) {
		By uploadInput = By.id("fileupload");
		WebElement fileInput = driver.findElement(uploadInput);
		fileInput.sendKeys(imagePath);
	}

	public void enter_id_number(String IdNumber) {
		type(BaIdNumber, IdNumber);
	}

	public void enter_name(String name) {
		type(BaName, name);
	}

	public void select_country_code(String countryWithCode) {
		selectCountryCode(BaCountryCode, countryWithCode);
	}

	public void enter_mobile_number(String number) {
		try {
			WebElement inputField = null;

			if (isElementPresent(tenDigitInput)) {
				inputField = driver.findElement(tenDigitInput);
			} else if (isElementPresent(nineDigitInput)) {
				inputField = driver.findElement(nineDigitInput);
			} else if (isElementPresent(eightDigitInput)) {
				inputField = driver.findElement(eightDigitInput);
			}

			if (inputField != null) {
				inputField.clear();
				inputField.sendKeys(number);
			} else {
				logger.error("No valid mobile input field found.");
			}

		} catch (Exception e) {
			logger.error("Error in enter_mobile_number: " + e.getMessage());
		}
	}

	// Helper method to check if element exists
	private boolean isElementPresent(By locator) {
		return !driver.findElements(locator).isEmpty();
	}

	public void select_blood_group(String bloodGroup) {
		selectbloodgroup(BaBloodGroup, bloodGroup);
	}

	public void enter_nfc_id(String nfcid) {
		type(BaNfcId, nfcid);
	}

	public void enter_password(String password) {
		type(BaPassword, password);
	}

	public void click_save_button() {
		click(BaSaveBtn);
	}

	public void click_cancel_button() {
		click(BaCancelBtn);
	}

	public void verify_bus_attendant_created(String expectedId, String expectedmobileNumber) {
		WebElement firstRowDetails = WaitUtils.waitForVisibility(BaFirstRowDetails);

		String firstRowText = firstRowDetails.getText();

		boolean isIdPresent = firstRowText.contains(expectedId);
		boolean isMobileNumberPresent = firstRowText.contains(expectedmobileNumber);

		Assert.assertTrue(isIdPresent, "Id not found in the first row.");
		Assert.assertTrue(isMobileNumberPresent, "Mobile Number not found in the first row.");
	}

	public void select_search_option(String searchOption) {
		searchBy(BaSearchType, searchOption);
	}

	public void enter_id_in_search_input(String empid) {
		type(BaSearchInputField, empid);
	}

	public void search_result(String expectedId) {
		WebElement firstRowDetails = WaitUtils.waitForVisibility(BaFirstRowDetails);

		String firstRowText = firstRowDetails.getText();

		boolean isIdPresent = firstRowText.contains(expectedId);
		Assert.assertTrue(isIdPresent, "Search result not found ");
	}

	public void click_edit_button() {
		click(BaEditButton);
	}

	public void click_delete_button() throws InterruptedException {
		Thread.sleep(3000);
		click(BaDeleteButton);
	}

	public void click_confirm_delete_button() {
		click(BaConfirmDeleteButton);
	}

	public void click_qr_button() {
		click(BaQrButton);
	}

	public void click_download_as_png_button() {
		click(BaDownloadButton);
	}

	public void verify_qr_file_is_downloaded() {
		String downloadPath = "C:\\Users\\DELL\\Downloads";

		File folder = new File(downloadPath);

		File[] files = folder.listFiles((dir, name) -> name.startsWith("INS004_N_QR_") && name.endsWith(".png"));

		Assert.assertNotNull(files, "Download folder is empty or not accessible");

		Assert.assertTrue(files.length > 0, "No PNG files found in the folder");

		File downloadedFile = files[files.length - 1]; // This assumes the last file is the latest downloaded one.

		Assert.assertTrue(downloadedFile.exists(), "Downloaded file does not exist");

		Assert.assertTrue(downloadedFile.length() > 0, "Downloaded file is empty");

		logger.info("File downloaded successfully: " + downloadedFile.getName());
	}

	public void click_download_qr_close_button() {
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

	public String validate_create_success_message() {
		return validateSuccessMessage(BaCreateSuccessMsg, "Bus Attendant details created Successfully");
	}

	public String validate_update_success_message() {
		return validateSuccessMessage(BaUpdateSuccessMsg, "Bus Attendant details updated successfully");
	}

	public String validate_delete_success_message() {
		return validateSuccessMessage(BaDeleteSuccessMsg, "Bus Attendant details deleted Successfully");
	}

}
