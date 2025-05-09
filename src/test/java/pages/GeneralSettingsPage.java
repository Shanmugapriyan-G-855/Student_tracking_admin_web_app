package pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class GeneralSettingsPage extends BasePage{
	
	private static final Logger logger = LoggerFactory.getLogger(GeneralSettingsPage.class);
	
	private By GeneralSettingsHeader = By.xpath("//span[normalize-space()='General-settings']");
	private By Classes = By.xpath("(//span[normalize-space()='Classes'])[1]");
	private By AddNewBtn = By.xpath("(//button[@class='btn add-btn-all-add1'])[1]");
	private By ClassName = By.xpath("(//input[@name='class_number'])[1]");
	private By RoomNumber = By.xpath("(//input[@name='room_number'])[1]");
	private By TeachersName = By.xpath("(//select[@name='class_teacher'])[1]");
	private By SaveButton = By.xpath("(//button[normalize-space()='Save'])[1]");
	private By ClassCreateSuccessMsg = By.xpath("(//div[contains(text(),'Class room detail created Successfully')])[1]");
	private By ClassUpdateSuccessMsg = By.xpath("//div[contains(text(),'Class details updated successfully')]");
	private By ClassDeleteSuccessMsg = By.xpath("//div[contains(text(),'class details deleted Successfully')]");
	private By EditIcon = By.xpath("(//*[name()='svg'][@role='img'])[18]");
	private By DeleteIcon = By.xpath("(//*[name()='svg'][@role='img'])[19]");
	private By DeleteButton = By.xpath("(//button[normalize-space()='Delete'])[1]");
	
	private By BusStops = By.xpath("(//span[normalize-space()='Bus Stops'])[1]");
	private By LatitudeField = By.xpath("(//input[@placeholder='Latitude'])[1]");
	private By LongitudeField = By.xpath("(//input[@placeholder='Longitude'])[1]");
	private By StopNameField = By.xpath("(//input[@name='stop_name'])[1]");
	private By BusStopCreateSuccessMsg = By.xpath("(//div[contains(text(),'Bus Stop detail created Successfully')])[1]");
	private By BusStopUpdateSuccessMsg = By.xpath("(//div[contains(text(),'updated successfully')])[1]");
	private By BusStopDeleteSuccessMsg = By.xpath("(//div[contains(text(),'Bus Stop details deleted Successfully')])[1]");
	
	private By UploadButton = By.xpath("(//span[@class='upload-txt'])[1]");
	private By downloadTemplateBtn = By.xpath("//p[@class='download-template']");
	private By uploadExcelFile = By.xpath("(//input[@type='file'])[1]");
	private String uploadedFilePath;
	private By verifyUploadedFileName = By.xpath("(//p[@class='file-name'])[1]");
	private By confirmUploadButton = By.xpath("(//button[@type='submit'])[1]");
	private By validateFileUploadedSuccessfullyMsg = By.xpath("//div[contains(text(),'File uploaded Sucessfully')]");
	
	private By Routes = By.xpath("(//span[normalize-space()='Routes'])[1]");
	private By RouteNameField = By.xpath("(//input[@name='optionData.[0].route_name'])[1]");
	private By FirstStopSelection = By.xpath("(//select[@name='optionData.[0].stop_name[0]'])[1]");
	private By AddStopButton = By.xpath("(//span[@class='pointer underline'])[1]");
	private By SecondStopSelection = By.xpath("(//select[@name='optionData.[0].stop_name[1]'])[1]");
	private By RouteCreateSuccessMsg = By.xpath("(//div[contains(text(),'Bus Route detail created Successfully')])[1]");
	private By RouteUpdateSuccessMsg = By.xpath("(//div[contains(text(),'updated successfully')])[1]");
	private By RouteDeleteSuccessMsg = By.xpath("(//div[contains(text(),'Bus Route details deleted Successfully')])[1]");
	
	
	
	
	
	
	
	public GeneralSettingsPage(WebDriver driver) {
		super(driver);
	}
	
	public void click_general_settings() {
		click(GeneralSettingsHeader);
	}
	
	public void click_classes() {
		click(Classes);
	}
	
	public void click_add_new_Button() throws InterruptedException {
		click(AddNewBtn);
		Thread.sleep(1000);
	}
	
	public void enter_class_name(String className) {
		type(ClassName,className);
	}
	
	public void enter_room_number(String roomNumber) {
		type(RoomNumber,roomNumber);
	}
	
	public void select_teacher_name(String teacherName) {
		selectOption(TeachersName,teacherName);
	}
	
	public void click_save_button() {
		click(SaveButton);
	}
	
	public void validate_class_create_success_message() {
		validateSuccessMessage(ClassCreateSuccessMsg, "Class room detail created Successfully");
	}
	
	public void click_edit_icon() {
		click(EditIcon);
	}
	
	public void validate_class_update_success_message() {
		validateSuccessMessage(ClassUpdateSuccessMsg, "Class details updated successfully");
	}
	
	public void click_delete_icon() throws InterruptedException {
		click(DeleteIcon);
		Thread.sleep(1000);
	}
	
	public void click_confirm_delete() {
		click(DeleteButton);
	}
	
	public void validate_class_delete_success_message() {
		validateSuccessMessage(ClassDeleteSuccessMsg, "class details deleted Successfully");
	}
	
//	****************Bus Stops**********************
	
	public void click_bus_stops() {
		click(BusStops);
	}
	
	public void enter_latitude(String latitude) {
		type(LatitudeField, latitude);
	}
	
	public void enter_longitude(String longitude) {
		type(LongitudeField, longitude);
	}
	
	public void enter_stop_name(String stopName) throws InterruptedException {
		Thread.sleep(3000);
		type(StopNameField, stopName);
	}
	
	public void scroll_down() {
		scrollToElement(SaveButton);
	}
	
	public void validate_bus_stop_create_success_message() {
		validateSuccessMessage(BusStopCreateSuccessMsg, "Bus Stop detail created Successfully");
	}
	
	public void validate_bus_stop_update_success_message() {
		validateSuccessMessage(BusStopUpdateSuccessMsg, "updated successfully");
	}
	
	public void validate_bus_stop_delete_success_message() {
		validateSuccessMessage(BusStopDeleteSuccessMsg, "Bus Stop details deleted Successfully");
	}
	
	public void click_upload_button() {
		click(UploadButton);
	}
	
	public void click_download_template_button() throws InterruptedException {
		Thread.sleep(1000);
		click(downloadTemplateBtn);
	}
	
	public void verify_download_template() {
		String downloadPath = "C:\\Users\\DELL\\Downloads";
		File folder = new File(downloadPath);

		File[] files = folder.listFiles((dir, name) -> name.startsWith("download") && name.endsWith(".xlsx"));

		assert files != null && files.length > 0 : "Template file not found in the download folder";

		File downloadedFile = files[files.length - 1];

		assert downloadedFile.exists() : "Downloaded template file does not exist";
		assert downloadedFile.length() > 0 : "Downloaded template file is empty";

		System.out.println("Template file downloaded successfully: " + downloadedFile.getName());

	}
	
	public void upload_xlsx_file(String filePath) {
		uploadedFilePath = filePath;
		WebElement fileInput = driver.findElement(uploadExcelFile);
		fileInput.sendKeys(filePath);
	}
	
	public void verify_uploaded_file_name() {
		WebElement fileNameLabel = waitUtils.waitForVisibility(verifyUploadedFileName);
		String displayedFileName = fileNameLabel.getText();

		String expectedFileName = new File(uploadedFilePath).getName();

		Assert.assertTrue(displayedFileName.contains(expectedFileName),
				"Uploaded file name not displayed correctly. Found: " + displayedFileName);
	}
	

	public void click_confirm_upload_button() {
		click(confirmUploadButton);
	}
	
	public void validate_file_uploaded_successfully_message() {
		validateSuccessMessage(validateFileUploadedSuccessfullyMsg, "File uploaded Sucessfully");
	}
	
	public void click_routes() {
		click(Routes);
	}
	
	public void enter_route_name(String routeName) {
		type(RouteNameField,routeName);
	}
	
	public void select_first_stop(String firstStop) {
		selectOption(FirstStopSelection, firstStop);
	}
	
	public void click_add_stop() throws InterruptedException {
		click(AddStopButton);
		Thread.sleep(1000);
	}
	
	public void select_second_stop(String secondStop) {
		selectOption(SecondStopSelection, secondStop);
	}
	
	public void validate_route_create_successfully_message() {
		validateSuccessMessage(RouteCreateSuccessMsg, "Bus Route detail created Successfully");
	}
	
	public void validate_route_update_successfully_message() {
		validateSuccessMessage(RouteUpdateSuccessMsg, "updated successfully");
	}
	
	public void validate_route_delete_success_message() {
		validateSuccessMessage(RouteDeleteSuccessMsg, "Bus Route details deleted Successfully");
	}

	
	private String validateSuccessMessage(By locator, String expectedMessage) {
		try {
			WebElement successMessageElement = waitUtils.waitForVisibility(locator);
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
	
	
}
