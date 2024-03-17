package zh.qa.amazon.test; 

import org.testng.Assert;
import org.testng.annotations.Test;

import zh.qa.amazon.base.BaseTest;

public class LoginPageTest extends BaseTest {

	@Test
	public void validateLoginURL() {
		Assert.assertTrue(logPage.getLoginUrl().contains("flipkart"));
	}
}
