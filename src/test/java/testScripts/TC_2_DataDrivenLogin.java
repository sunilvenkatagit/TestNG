package testScripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseLayer.BaseClass;
import pageObjectRepositry.HomePage;
import pageObjectRepositry.LoginPage;
import utilities.ExcelConfiguration;

public class TC_2_DataDrivenLogin extends BaseClass {
	LoginPage loginpage;
	HomePage homepage;

	@DataProvider
	public Object[][] getData() throws Exception {
		ExcelConfiguration excelConfig = new ExcelConfiguration(".\\src\\mai\\resources\\ExcelData\\DataSheet.xlsx");
		int rows = excelConfig.getRowCount(0);
		Object[][] credentials = new Object[rows][2];
		for (int i = 0; i < rows; i++) {
			credentials[i][0] = excelConfig.getCellValue(0, i, 0);
			credentials[i][1] = excelConfig.getCellValue(0, i, 1);
		}
		return credentials;
	}

	@Test(dataProvider = "getData", enabled=false)
	public void dataDrivenSearch(String username, String password) {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login(username, password);
	}
}
