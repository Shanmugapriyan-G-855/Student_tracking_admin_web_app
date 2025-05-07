package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import utils.WaitUtils;

public abstract class BasePage {
    protected WebDriver driver;
    protected WaitUtils waitUtils;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver, 3000);
    }

    protected void click(By locator) {
        waitUtils.waitForClickable(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = waitUtils.waitForVisibility(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }
    
    protected void clear(By locator) {
    	WebElement element = waitUtils.waitForVisibility(locator);
    	element.click();
    	element.clear();
    }

    protected String getText(By locator) {
        return waitUtils.waitForVisibility(locator).getText();
    }

    protected boolean isElementVisible(By locator) {
        try {
            return waitUtils.waitForVisibility(locator).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    private boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }

    public void selectCountryCode(By dropdownLocator, String countryWithCode) {
        try {
            Select dropdown = new Select(waitUtils.waitForVisibility(dropdownLocator));
            dropdown.selectByVisibleText(countryWithCode);
        } catch (NoSuchElementException e) {
            System.out.println("Country code not found: " + countryWithCode);
        }
    }

    public void selectbloodgroup(By dropdownLocator, String bloodGroup) {
        try {
            Select dropdown = new Select(waitUtils.waitForVisibility(dropdownLocator));
            dropdown.selectByVisibleText(bloodGroup);
        } catch (NoSuchElementException e) {
            System.out.println("Blood Group not found: " + bloodGroup);
        }
    }

    public void searchBy(By dropdownLocator, String searchOption) {
        try {
            Select dropdown = new Select(waitUtils.waitForVisibility(dropdownLocator));
            dropdown.selectByVisibleText(searchOption);
        } catch (NoSuchElementException e) {
            System.out.println("Search options not found: " + searchOption);
        }
    }

    public void selectOption(By dropdownLocator, String classCode) {
        try {
            Select dropdown = new Select(waitUtils.waitForVisibility(dropdownLocator));
            dropdown.selectByVisibleText(classCode);
        } catch (NoSuchElementException e) {
            System.out.println("Not found: " + classCode);
        }
    }

    protected void scrollToElement(By locator) {
        WebElement element = waitUtils.waitForPresence(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}