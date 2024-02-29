package demo.opencart.pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;

public class BasePage {
	
	public void validationMethod(String actualText, String expectedText, String errorMessage) {
		Assert.assertEquals(actualText, expectedText, errorMessage);
	}
	
	public String generateRandomString() {
		return RandomStringUtils.randomAlphabetic(4);	
	}
	
	public String generateRandomInt() {
		return RandomStringUtils.randomNumeric(4);
	}
}
