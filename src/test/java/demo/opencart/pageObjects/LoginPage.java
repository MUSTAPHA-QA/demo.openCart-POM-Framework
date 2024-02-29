package demo.opencart.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id = 'input-email']") WebElement LOGIN_EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id = 'input-password']") WebElement LOGIN_PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@class = 'btn btn-primary']") WebElement LOGIN_ELEMENT;
	
	public void validateLoginPage(String actualText, String expectedText, String erroMessage  ) {
		validationMethod(actualText, expectedText, erroMessage);	
	}
	
	public void insertLoginEmail(String email) {
		LOGIN_EMAIL_ELEMENT.sendKeys(email);
	}
	
	public void insertLoginPassword(String password ) {
		LOGIN_PASSWORD_ELEMENT.sendKeys(password);
	}
	
	public void clickLogin() {
		LOGIN_ELEMENT.click();
	}
}
