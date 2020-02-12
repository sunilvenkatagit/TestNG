package pageObjectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLayer.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage(WebDriver driver) {
		super.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "txtUsername")
	WebElement userNameInput;

	@FindBy(id = "txtPassword")
	WebElement passwordInput;

	@FindBy(id = "btnLogin")
	WebElement loginButton;

	public HomePage login(String email, String password) {
		userNameInput.sendKeys(email);
		passwordInput.sendKeys(password);
		loginButton.click();
		return new HomePage(driver);
	}

}
