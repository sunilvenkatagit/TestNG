package pageObjectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLayer.BaseClass;

public class HomePage extends BaseClass {

	public HomePage(WebDriver driver) {
		super.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(partialLinkText = "No Employees Available")
	WebElement noEmployeePresent;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logout;

	public void noEmployeesAvailable() {
		logout.click();

		// return noEmployeePresent.getText();
	}

}
