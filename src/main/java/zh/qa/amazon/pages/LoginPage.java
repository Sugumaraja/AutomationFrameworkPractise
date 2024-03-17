package zh.qa.amazon.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
	private By loginBtn=By.linkText("Login");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
public String getLoginUrl() {
	LoginPage lp=new LoginPage(driver);
	lp.getElementWithWait(loginBtn, 5).click();

	return driver.getCurrentUrl();
	}
	public WebElement getElementWithWait(By locator, int timeOut) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		WebElement element=wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
		return element;
	}
}
