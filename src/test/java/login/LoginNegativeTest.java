package login;

import org.testng.annotations.Test;

import utils.BaseClass;
import pages.LoginPage;

public class LoginNegativeTest extends BaseClass {

	LoginPage login = new LoginPage(BaseClass.getDriver());

	@Test(priority = 0)
	public void test_invalid_login() {

		login.enterEmail("invalid@email.com");
		login.enterPassword("ash2134");
		login.clickLoginButton().validate_invalid_login_message();
	}

	@Test(priority = 1)
	public void test_invalid_email_login() {

		BaseClass.getDriver().navigate().refresh();
		login.enterEmail("shann@gotoz.app");
		login.enterPassword("Gotoz@123");
		login.clickLoginButton();
		login.validate_invalid_email_login_message();
	}

	@Test(priority = 2)
	public void test_invalid_password_login() {
		

	}

}
