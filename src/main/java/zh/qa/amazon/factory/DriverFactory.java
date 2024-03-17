package zh.qa.amazon.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	WebDriver driver;
	Properties prop;
	OptionManager op;
	public static ThreadLocal<WebDriver> tld=new ThreadLocal<WebDriver>();
	

	public WebDriver initBrowser(Properties prop) {
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		op = new OptionManager(prop);

		switch (browserName.toLowerCase()) {
		case "chrome":
//			driver = new ChromeDriver(op.getChromeOption());
			tld.set(new ChromeDriver(op.getChromeOption()));
			break;
		case "edge":
//			driver = new EdgeDriver(op.getEdgeOption());
			tld.set(new EdgeDriver(op.getEdgeOption()));
			break;
		case "firefox":
//			driver = new FirefoxDriver(op.getFirefoxOption());
			tld.set(new FirefoxDriver(op.getFirefoxOption()));
			break;

		default:
			System.out.println("please pass the valid browser name: " + browserName);
			break;
		}


//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//		driver.get(prop.getProperty("url"));
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));

		return getDriver();
	}

	public static WebDriver getDriver() {
		return tld.get();
	}
	
	
	public Properties initProperties() {

		// mvn clean install -- we will add some arguement with upper -Denv="qa"
		prop = new Properties();
		FileInputStream ip = null;

		String envName = System.getProperty("env");
		System.out.println("the env name passed is: " + envName);

		try {
			if (envName == null) {
				ip = new FileInputStream("./src/test/resources/config/config.properties");
			} else {
				switch (envName.toLowerCase().trim()) {
				case "qa":
					ip = new FileInputStream("./src/test/resources/config/config_QA.properties");
					break;
				case "dev":
					ip = new FileInputStream("./src/test/resources/config/config_dev.properties");
					break;
				case "uat":
					ip = new FileInputStream("./src/test/resources/config/config_uat.properties");
					break;

				default:
					System.out.println("please pass the correct environment " + envName);
					break;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("the file not found");
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

}
