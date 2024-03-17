package zh.qa.amazon.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionManager {
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;
	private Properties prop;

	public OptionManager(Properties prop) {
		this.prop = prop;
	}

	public ChromeOptions getChromeOption() {
		co = new ChromeOptions();
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim())) {
			co.addArguments("--incognito");
		}
		if (Boolean.parseBoolean(prop.getProperty("headless").trim())) {
			co.addArguments("--headless");
		}
		return co;
	}

	public FirefoxOptions getFirefoxOption() {
		fo = new FirefoxOptions();
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim())) {
			fo.addArguments("--incognito");
		}
		if (Boolean.parseBoolean(prop.getProperty("headless").trim())) {
			fo.addArguments("--headless");
		}
		return fo;
	}

	public EdgeOptions getEdgeOption() {
		eo = new EdgeOptions();
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim())) {
			eo.addArguments("--inprivate");
		}
		if (Boolean.parseBoolean(prop.getProperty("headless").trim())) {
			eo.addArguments("--headless");
		}
		return eo;
	}
}
