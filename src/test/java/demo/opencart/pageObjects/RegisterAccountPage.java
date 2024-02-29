package demo.opencart.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterAccountPage extends BasePage {
	
	WebDriver driver;
	
	public RegisterAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id = 'input-firstname']") WebElement FIRST_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id = 'input-lastname']") WebElement LAST_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id = 'input-email']") WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id = 'input-telephone']") WebElement TELEPHONE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id = 'input-password']") WebElement PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id = 'input-confirm']") WebElement PASSWORD_CONFIRM_ELEMENT;
	@FindBy(how = How.XPATH, using = "(//input[@name = 'newsletter'])[2]") WebElement NEWSLETTER_NO_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@name = 'agree']") WebElement PRIVACY_POLICY_CHECKBOX_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@class = 'btn btn-primary']") WebElement CONTINUE_ELEMENT;
	
	public void validateRegisterAccountPage(String actualText, String expectedText, String erroMessage) {
		validationMethod(actualText, expectedText, erroMessage);	
	}
	
	public void insertFirstName(String firstName) {
		FIRST_NAME_ELEMENT.sendKeys(generateRandomString() + firstName );
	}
	
	public void insertLastName(String lastName) {
		LAST_NAME_ELEMENT.sendKeys(generateRandomString() + lastName);
	}
	
	public String insertEmail(String email) {
		String randomEmail = generateRandomString() + email;
		EMAIL_ELEMENT.sendKeys(randomEmail);
		return randomEmail;
	}
	
	public void insertTelephone(String telephone) {
		TELEPHONE_ELEMENT.sendKeys(generateRandomInt() + telephone);
	}
	
	public void insertPassword(String password) {
		PASSWORD_ELEMENT.sendKeys(password);
	}
	
	public void confirmPassword(String confirmPassword) {
		PASSWORD_CONFIRM_ELEMENT.sendKeys(confirmPassword);
	}
	
	public void clickNoForNewsletter() {
		NEWSLETTER_NO_ELEMENT.click();
	}
	
	public void clickOnPrivacyPolicyCheckbox() {
		PRIVACY_POLICY_CHECKBOX_ELEMENT.click();
	}
	
	public void clickContinue() {
		CONTINUE_ELEMENT.click();
	}
}
