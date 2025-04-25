package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import utils.WaitUtils;

public class Students_Page extends BasePage {

	private static final Logger logger = LoggerFactory.getLogger(Students_Page.class);

	By studentsSideBar = By.xpath("//span[normalize-space()='Students']");
	By addStudentBtn = By.xpath("//button[normalize-space()='+ Add Student']");
	By studentUploadInput = By.xpath("//input[@id='fileupload']");
	By studentIdNumber = By.xpath("//input[@name='student_id']");
	By studentName = By.xpath("//input[@name='student_name']");
	By countryCodeParentNo = By
			.xpath("//div[@class='customPopupHeaderContainer ModelClassName']//div[1]//div[1]//div[1]//select[1]");
	By IndParentMobileNo = By.xpath("(//input[@placeholder='Enter 10 digit number'])[1]");
	By UaeParentMobileNo = By.xpath("(//input[@placeholder='Enter 9 digit number'])[1]");
	By OmParentMobileNo = By.xpath("(//input[@placeholder='Enter 8 digit number'])[1]");

	By countryCodeEmergencyNo = By.xpath(
			"//*[@id=\"root\"]/div[2]/div[2]/div/div/div[4]/div/div/div/div[4]/form/div[2]/div[2]/div[1]/div[1]/select");
	By IndEmergencyMobileNo = By.xpath("(//input[@placeholder='Enter 10 digit number'])[1]");
	By UaeEmergencyMobileNo = By.xpath("(//input[@placeholder='Enter 9 digit number'])[2]");
	By OmEmergencyMobileNo = By.xpath("(//input[@placeholder='Enter 8 digit number'])[2]");

	By ParentEmail = By.xpath("//input[@name='parents_email']");
	By scrollToClassLabel = By
			.xpath("//div[contains(@class,'customPopupHeaderContainer ModelClassName')]//div//div[3]//div[1]//h6[1]");
	By StudentClass = By.xpath("//select[@name='class_number']");
	By studentBloodGroup = By.xpath("//select[@name='blood_group']");
	By studentDOB = By.xpath("//input[@name='date_of_birth']");
	By studentGender = By.xpath("//select[@name='gender']");
	By Nationality = By.xpath("//select[@name='nationality']");
	By studentAddress = By.xpath("//textarea[@name='address']");
	By ModeOfTransport = By.xpath("//select[@name='by_bus']");
	By BusStop = By.xpath("//select[@name='stop_id']");
	By saveBtn = By.xpath("//button[normalize-space()='Save']");
	By studentCreateSuccessMsg = By.xpath("//div[contains(text(),'Student detail created Successfully')]");

	public Students_Page(WebDriver driver) {
		super(driver);
	}

	public void click_students_section() {
		click(studentsSideBar);
	}

	public void click_add_student_button() {
		logger.info("Starting test: Student Creation");
		click(addStudentBtn);
		logger.debug("Clicked on Add Student button");
	}

	public void file_Upload(String imagePath) {
		WebElement fileInput = driver.findElement(studentUploadInput);
		fileInput.sendKeys(imagePath);
	}

	public void enter_student_id_number(String idNumber) {
		type(studentIdNumber, idNumber);
	}

	public void enter_student_name(String name) {
		type(studentName, name);
	}

	public void select_country_code_parent_number(String countryCode) {
		selectCountryCode(countryCodeParentNo, countryCode);
	}

	public void enter_ind_parent_mobile_number(String number) {
		type(IndParentMobileNo, number);
	}

	public void enter_uae_parent_mobile_number(String number) {
		type(UaeParentMobileNo, number);
	}

	public void enter_Om_parent_mobile_number(String number) {
		type(OmParentMobileNo, number);
	}

	public void select_country_code_emergency_number(String countryCode) {
		selectCountryCode(countryCodeEmergencyNo, countryCode);
	}

	public void enter_ind_emergency_mobile_number(String number) {
		type(IndEmergencyMobileNo, number);
	}

	public void enter_uae_emergency_mobile_number(String number) {
		type(UaeEmergencyMobileNo, number);
	}

	public void enter_Om_emergency_mobile_number(String number) {
		type(OmEmergencyMobileNo, number);
	}

	public void select_student_class_No(String classNo) {
		selectOption(StudentClass, classNo);
	}

	public void select_student_blood_group(String bloodGroup) {
		selectbloodgroup(studentBloodGroup, bloodGroup);
	}

	public void enter_student_dob(String dob) {
		type(studentDOB, dob);
	}

	public void select_student_gender(String gender) {
		selectOption(studentGender, gender);
	}
	
	public void enter_parent_mail(String email) {
		type(ParentEmail,email);
	}
	
	public void select_student_nationality(String nationality) {
		selectOption(Nationality, nationality);
	}
	
	public void enter_student_address(String address) {
		type(studentAddress,address);
	}
	
	public void select_mode_of_transport(String transport) {
		selectOption(ModeOfTransport,transport);
	}
	
	public void select_bus_stop(String busStop) {
		selectOption(BusStop, busStop);
	}
	
	public void click_save_button() {
		click(saveBtn);
	}
	
	public void validate_student_create_success_message() {
		validateSuccessMessage(studentCreateSuccessMsg, "Student detail created Successfully");
	}
	
	
	public void scroll_Down_01() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(scrollToClassLabel);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public void scroll_Down_02() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(ModeOfTransport);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void selectOption(By dropdownLocator, String classCode) {
		try {
			Select dropdown = new Select(WaitUtils.waitForVisibility(dropdownLocator));
			dropdown.selectByVisibleText(classCode);
		} catch (NoSuchElementException e) {
			System.out.println("Not found: " + classCode);
		}
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
}
