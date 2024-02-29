package demo.opencart.pageObjects;

import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage {
	
	WebDriver driver;
	
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void validateMyAccountPage(String actualText, String expectedText, String errorMessage) {
		validationMethod(actualText, expectedText, errorMessage);	
	}
}
