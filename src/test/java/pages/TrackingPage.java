package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class TrackingPage extends BasePage {

	private By Tracking = By.xpath("(//span[normalize-space()='Tracking'])[1]");
	private By MapLoads = By.xpath("(//div[@aria-label='Map'])[1]");
	private By SatelLiteToggle = By.xpath("(//button[normalize-space()='Satellite'])[1]");
	private By RoadMapToggle = By.xpath("(//button[normalize-space()='Map'])[1]");
	private By SearchBar = By.xpath("(//input[@placeholder='Search by bus number...'])[1]");
	
	@FindBy(xpath = "(//div[@class='gm-style'])[1]")
	public WebElement BusLocationOnMap;
	
	
	@FindBy(xpath = "(//div[@class='bus-cards'])[1]")
	public WebElement searchResultOfBus;

	public TrackingPage(WebDriver driver) {
		super(driver);
	}

	public void click_tracking() {
		click(Tracking);
	}

	public void verify_map_loads() {
		boolean isMapVisible = isElementVisible(MapLoads);
		Assert.assertTrue(isMapVisible, "Map is not displayed on the tracking page.");
	}

	public void click_satellite_toggle() throws InterruptedException {

		click(SatelLiteToggle);
		Thread.sleep(1000);

		WebElement satelliteToggleElement = driver.findElement(SatelLiteToggle);
		String ariaChecked = satelliteToggleElement.getAttribute("aria-checked");
		Assert.assertEquals(ariaChecked, "true", "Satellite view is not active");

	}

	public void click_roadmap_toggle() throws InterruptedException {

		click(RoadMapToggle);
		Thread.sleep(1000);

		WebElement roadMapToggleElement = driver.findElement(RoadMapToggle);
		String ariaChecked = roadMapToggleElement.getAttribute("aria-checked");
		Assert.assertEquals(ariaChecked, "true", "Road Map view is not active");

	}

	public void verify_searchBy_bus_number(String busNumber) {
		type(SearchBar, busNumber);

		Assert.assertTrue(searchResultOfBus.getText().contains(busNumber), busNumber + "not found");
		Assert.assertTrue(BusLocationOnMap.getText().contains(busNumber),"Bus marker for "+busNumber+"should be visible on the map");

	}

	public void verify_attendant_driver_info(String attendantName, String driverName) {
		
		String attendant = attendantName;
		String driver = driverName;
		
		Assert.assertTrue(searchResultOfBus.getText().contains(attendant),attendant+"not found.");
		Assert.assertTrue(searchResultOfBus.getText().contains(driver),driver+"not found.");


	}
	
	

}
