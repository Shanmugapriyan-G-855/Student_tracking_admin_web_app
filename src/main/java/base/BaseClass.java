package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class BaseClass {

	public static WebDriver driver;

	@BeforeSuite
	public void launchBrowser() {
		
		String browser = ConfigReader.getProperty("browser");
		String url = ConfigReader.getProperty("url");
		
		 if (browser == null || url == null) {
	            System.out.println("Browser or URL not found in config.properties!");
	            return;
	        }

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

	@AfterSuite
	public void tearDown() {
//		driver.quit();
	}

}
