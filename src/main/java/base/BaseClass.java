package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Login_Page;
import utils.ConfigReader;

public class BaseClass {

	public static WebDriver driver;
	public static String username;
	public static String password;

	@BeforeSuite
	public void launchBrowser() {
		
		String browser = ConfigReader.getProperty("browser");
		String url = ConfigReader.getProperty("url");
		
		 if (browser == null || url == null) {
	            System.out.println("Browser or URL not found in config.properties!");
	            return;
	        }
		 username = ConfigReader.getProperty("username");
	        password = ConfigReader.getProperty("password");

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("Unsupported browser: " + browser);
			return;
		}

		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void perform_valid_login() {
		Login_Page loginPage = new Login_Page(driver);

		loginPage.enterEmail(username).enterPassword(password).clickLoginButton();

		String successMessage = loginPage.validateLoginSuccessMessage();

		Assert.assertEquals(successMessage, "login Successfully", "Login was not successful!");
	}

	@AfterSuite
	public void tearDown() {
//		driver.quit();
	}

}
