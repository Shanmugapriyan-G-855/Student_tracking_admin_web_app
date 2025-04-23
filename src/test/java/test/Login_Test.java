package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.Employees_Page;
public class Login_Test extends BaseClass {

	@Test
	public void test_valid_login() {
		perform_valid_login();
	}

	@Test
	public void validLogin_display_company_logo() {
		Employees_Page logoPage = new Employees_Page(driver);

		Assert.assertTrue(logoPage.isCompanyLogoVisible(),
				"Company logo not visible after login. Login may have failed.");
	}
}
