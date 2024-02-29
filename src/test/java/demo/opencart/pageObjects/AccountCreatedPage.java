package demo.opencart.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountCreatedPage extends BasePage {
	
	WebDriver driver;
	
	public AccountCreatedPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	@FindBy(how = How.XPATH, using = "//a[text() = 'Continue']") WebElement CONTINUE_ELEMENT;
	
	public void validateAccountCreated(String actualText, String expectedText, String erroMessage ) {
		validationMethod(actualText, expectedText, erroMessage);
	}
	
	public void clickContinue() {
		CONTINUE_ELEMENT.click();
	}
}
