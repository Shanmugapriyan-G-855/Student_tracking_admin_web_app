package pages;

import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import utils.BaseClass;
import utils.WaitUtils;

public class LoginPage extends BasePage {
    
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    private By emailField = By.xpath("//input[@name='email']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By loginBtn = By.xpath("//button[normalize-space()='Login']");
    private By loginSuccessMsg = By.xpath("//div[contains(text(),'login Successfully')]");
    private By InvalidLoginMsg = By.xpath("//div[@class='Toastify']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        type(emailField, email);
        
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public LoginPage clickLoginButton() {
		WaitUtils waitUtils = new WaitUtils(BaseClass.getDriver(),30);
        waitUtils.waitForClickable(loginBtn).click();
        return this; 
    }
    
    public void validate_login_success_message() {
    	validateSuccessMessage(loginSuccessMsg, "login Successfully");
    }
    
    public void validate_invalid_login_message() {
    	validateSuccessMessage(InvalidLoginMsg, "couldn't login,check your details");
    	
    }
    
    public void validate_invalid_email_login_message() {
    	validateSuccessMessage(InvalidLoginMsg,"couldn't login,check your details");
    }
    
    private String validateSuccessMessage(By locator, String expectedMessage) {
		try {
			WebElement successMessageElement = waitUtils.waitForVisibility(locator);
			String successMessage = successMessageElement.getText();
			Assert.assertEquals(successMessage, expectedMessage, "Success message mismatch!");
			logger.info("Message: " + successMessage);
			return successMessage;
		} catch (NoSuchElementException e) {
			logger.error("Message not found: " + e.getMessage());
			Assert.fail("Message element was not found or not visible.");
			return "";
		}
	}

    
}