package buses;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.BaseClass;
import pages.BusesPage;

public class BusAllocationTest extends BaseClass {

	@Test(priority = 0)
	public void Login() {
		perform_valid_login();
	}

	@Test(priority = 1, dataProvider = "allocateData")
	public void student_n_employee_allocation(String busNumber, String route, String driverName,
			String busAttendantName) throws InterruptedException {

		BusesPage allocate = new BusesPage(BaseClass.getDriver());

		allocate.click_buses_section();
		allocate.search_bus(busNumber);
		allocate.click_bus();
		allocate.scroll_Down_01();
		allocate.click_student_employee_allocation_edit_button();
		allocate.select_bus_route(route);
		allocate.select_driver(driverName);
		allocate.select_bus_attendant(busAttendantName);
		allocate.click_save_button();
		allocate.validate_student_employee_allocate_success_message();

	}

	@DataProvider(name = "allocateData")
	public Object[][] putAllocateData() {
		return new Object[][] { { "A0101", "Kumalan Kuttai To Sudha GH", "Henry", "Harley" } };
	}
}
