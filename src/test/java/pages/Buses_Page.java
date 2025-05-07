package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import utils.BaseClass;
import utils.WaitUtils;

public class Buses_Page extends BasePage {

	private static final Logger logger = LoggerFactory.getLogger(Buses_Page.class);

	By BusesHeader = By.xpath("(//span[normalize-space()='Buses'])[1]");
	By BusAddNewButton = By.xpath("(//button[normalize-space()='+ Add New'])[1]");
	By BusNumber = By.xpath("(//input[@name='bus_number'])[1]");
	By VehicleNumber = By.xpath("(//input[@name='vehicle_number'])[1]");
	By BusCapacity = By.xpath("(//input[@name='seat_number'])[1]");
	By SaveButton = By.xpath("(//button[normalize-space()='Save'])[1]");
	By BusCreateSuccessMsg = By.xpath("//div[contains(text(),'bus detail created Successfully')]");
	By BusSearchInput = By.xpath("(//input[@placeholder='Search...'])[1]");
	By BusFirstRowDetails = By.xpath("(//tr[@class='tdata-row'])[1]");

	By BusInfoEditButton = By.xpath("(//button[@class='edit-student'])[1]");
	By BusInfoUpdateSuccessMsg = By.xpath("//div[contains(text(),'updated successfully')]");

	By scrollToStudentEmployeeAllocation = By.xpath("//h6[normalize-space()='Student & Employee allocation']");
	By AllocationEditButton = By.xpath("(//button[@class='edit-student'])[2]");
	By SelectBusRoute = By.xpath("(//select[@name='route_id'])[1]");
	By SelectDriver = By.xpath("(//select[@name='driver_id'])[1]");
	By SelectBusAttendant = By.xpath("(//select[@name='nanny_id'])[1]");
	By BusAllocateSuccessMsg = By.xpath("//div[contains(text(),'Bus allocated Successfully')]");
	By AssignStudents = By.xpath("(//p[normalize-space()='Assigned students'])[1]");
	By AddStudentsBtn = By.xpath("(//button[normalize-space()='+ Add Students'])[1]");
	By filterByStop = By.xpath("(//div[@class='card-1 assign mt-3'])[1]");
	By SelectByStop = By.xpath("(//select[@class='sc-dcJsrY hIcopX dropdown-btn'])[1]");
	By CancelButton = By.xpath("(//button[normalize-space()='Cancel'])[1]");
	By status = By.xpath("(//h6[normalize-space()='Status*'])[1]");
	By SelectCheckBox = By.xpath("(//input[@type='checkbox'])[1]");

	public Buses_Page(WebDriver driver) {
		super(driver);
	}

	public void click_buses_section() {
		click(BusesHeader);
	}

	public void click_add_student_button() {
		logger.info("Starting test: Bus Creation");
		click(BusAddNewButton);
		logger.debug("Clicked on Add New button");
	}

	public void enter_bus_number(String busNumber) {
		type(BusNumber, busNumber);
	}

	public void enter_vehicle_number(String vehicleNumber) {
		type(VehicleNumber, vehicleNumber);
	}

	public void enter_bus_capacity(String busCapacity) {
		type(BusCapacity, busCapacity);
	}

	public void click_save_button() {
		click(SaveButton);
	}

	public void validate_bus_create_success_message() {
		validateSuccessMessage(BusCreateSuccessMsg, "bus detail created Successfully");
	}

	public void enter_bus_number_in_search_input(String SearchInput) {
		type(BusSearchInput, SearchInput);
	}

	public void search_result(String busNumber) {
		WaitUtils waitUtils = new WaitUtils(BaseClass.getDriver(),30);
		WebElement firstRowDetails = waitUtils.waitForVisibility(BusFirstRowDetails);

		String firstRowText = firstRowDetails.getText();

		boolean isBusNoPresent = firstRowText.contains(busNumber);
		Assert.assertTrue(isBusNoPresent, "Search result not found ");
	}

	public void click_bus() {
		click(BusFirstRowDetails);
	}

	public void click_busInfo_edit_button() {
		click(BusInfoEditButton);
	}

	public void validate_bus_info_update_success_message() {
		validateSuccessMessage(BusInfoUpdateSuccessMsg, "updated successfully");
	}

	public void scroll_Down_01() {
		scrollToElement(scrollToStudentEmployeeAllocation);
	}

	public void click_student_employee_allocation_edit_button() {
		click(AllocationEditButton);
	}

	public void select_bus_route(String routeName) {
		selectOption(SelectBusRoute, routeName);
	}

	public void select_driver(String driverName) {
		selectOption(SelectDriver, driverName);
	}

	public void select_bus_attendant(String busAttendantName) {
		selectOption(SelectBusAttendant, busAttendantName);
	}

	public void validate_student_employee_allocate_success_message() {
		validateSuccessMessage(BusAllocateSuccessMsg, "Bus allocated Successfully");
	}

	public void scroll_Down_02() {
		scrollToElement(AssignStudents);
	}

	public void click_add_students_button() {
		click(AddStudentsBtn);
	}

	public void scroll_Down_03() {
		scrollToElement(filterByStop);
	}

	public void click_select_bus_stop() {
		click(SelectByStop);
	}
	
	public void scroll_to_cancel_button() throws InterruptedException {
		scrollToElement(status);
		Thread.sleep(3000);
	}

	public void select_bus_stop(String stopName) {
		selectOption(SelectByStop, stopName);
	}

	public void click_cancel_button() {
		click(CancelButton);
	}
	
	public void select_student() {
		click(SelectCheckBox);
	}
	
	public void scroll_to_save_button() {
		scrollToElement(status);
	}
	
	public void validate_bus_student_assigned_successfully_msg() {
		validateSuccessMessage(BusInfoUpdateSuccessMsg, "updated successfully");
	}

	public void search_bus(String BusNumber) throws InterruptedException {

		Buses_Page search = new Buses_Page(BaseClass.getDriver());

		search.enter_bus_number_in_search_input(BusNumber);
		Thread.sleep(3000);
		search.search_result(BusNumber);
		Thread.sleep(3000);

	}

	private String validateSuccessMessage(By locator, String expectedMessage) {
		try {
			WaitUtils waitUtils = new WaitUtils(BaseClass.getDriver(),30);
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
