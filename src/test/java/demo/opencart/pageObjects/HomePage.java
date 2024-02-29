package demo.opencart.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "(//span[@class='caret'])[1]") WebElement MY_ACCOUNT_ARROW_ELEMENT;
	@FindBy(how = How.XPATH, using = "(//a[contains(text(), Register)])[3]") WebElement REGISTER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[text() = 'Login']") WebElement LOGIN_ELEMENT;
	
	public void clickOnMyAccountArrow() {
		MY_ACCOUNT_ARROW_ELEMENT.click();
	}
	
	public void clickRegister() {
		REGISTER_ELEMENT.click();
	}
	
	public void clickLogin() {
		LOGIN_ELEMENT.click();
	}
}
