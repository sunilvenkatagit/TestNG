package baseLayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public Properties prop;

	@BeforeMethod
	public void setUp() throws IOException {

		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(".\\src\\mai\\resources\\Configuration\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String browserName = prop.getProperty("browser");

		try {
			if (browserName.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browserName.equals(prop.getProperty("firefox"))) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Name of the browser is not given...!");
		}

		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
