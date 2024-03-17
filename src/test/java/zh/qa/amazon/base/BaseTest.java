package zh.qa.amazon.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import zh.qa.amazon.factory.DriverFactory;
import zh.qa.amazon.pages.LoginPage;

public class BaseTest {
	protected WebDriver driver;
	protected DriverFactory df;
	protected LoginPage logPage;
	protected Properties prop;

	@Parameters({"browser"})
	@BeforeClass
	public void setup(String browserName) {
		df = new DriverFactory();
		prop= df.initProperties();
		if (browserName!=null) {
			prop.setProperty("browser", browserName); 
		}
		driver = df.initBrowser(prop);
		logPage = new LoginPage(driver);
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
