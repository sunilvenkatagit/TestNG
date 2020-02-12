package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseLayer.BaseClass;
import pageObjectRepositry.HomePage;
import pageObjectRepositry.LoginPage;

public class TC_1_LoginScenarios extends BaseClass {

	LoginPage loginpage;
	HomePage homepage;

	@Test(description = "Description: Valid login details are provided")
	public void successfullLogin() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.noEmployeesAvailable();
		System.out.println("GOOD");

	}

}
