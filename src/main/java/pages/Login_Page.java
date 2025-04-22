package pages;

import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import utils.WaitUtils;

public class Login_Page extends BasePage {
    
    private static final Logger logger = LoggerFactory.getLogger(Login_Page.class);

    private By emailField = By.xpath("//input[@name='email']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By loginBtn = By.xpath("//button[normalize-space()='Login']");
    private By loginSuccessMsg = By.xpath("//div[contains(text(),'login Successfully')]");

    public Login_Page(WebDriver driver) {
        super(driver);
    }

    public Login_Page enterEmail(String email) {
        type(emailField, email);
        return this; 
        
    }

    public Login_Page enterPassword(String password) {
        type(passwordField, password);
        return this; 
    }

    public Login_Page clickLoginButton() {
        WaitUtils.waitForClickable(loginBtn).click();
        return this; 
    }

    public String validateLoginSuccessMessage() {
        try {
            WebElement successMessageElement = WaitUtils.waitForVisibility(loginSuccessMsg);
            String successMessage = successMessageElement.getText();
            
            logger.info("Login success message displayed: " + successMessage);
            Assert.assertEquals(successMessage, "login Successfully", 
                    "Success message mismatch!");

            return successMessage;

        } catch (NoSuchElementException e) {
            logger.error("Success message not found or not visible in time: " + e.getMessage());
            throw new AssertionError("Success message element was not found or not visible.");
        }
    }
}