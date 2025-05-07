package login;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Employees_Page;
import utils.BaseClass;
public class LoginTest extends utils.BaseClass {

	@Test
	public void test_valid_login() {
		perform_valid_login();
	}

	@Test
	public void validLogin_display_company_logo() {
		Employees_Page logoPage = new Employees_Page(BaseClass.getDriver());

		Assert.assertTrue(logoPage.isCompanyLogoVisible(),
				"Company logo not visible after login. Login may have failed.");
	}
}
