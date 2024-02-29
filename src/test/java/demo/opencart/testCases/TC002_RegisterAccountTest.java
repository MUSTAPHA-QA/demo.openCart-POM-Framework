package demo.opencart.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import demo.opencart.pageObjects.AccountCreatedPage;
import demo.opencart.pageObjects.HomePage;
import demo.opencart.pageObjects.RegisterAccountPage;
import demo.opencart.utilities.BrowserFactory;
import demo.opencart.utilities.DataProviders;
import demo.opencart.utilities.ReadConfig;

public class TC002_RegisterAccountTest extends BrowserFactory {
	
	ReadConfig readConfig = new ReadConfig();
	String registerAccExpectedText = readConfig.getRegisterAccExpectedText();
	String errorMessage = readConfig.getErrorMessage();
	String accountCreatedExpectedText = readConfig.getAccCreatedExpectedText();
	public String randomRegistrationEmail;
	
	
	@Test(dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void verifyRegisterAccountFunctionality(String firstName, String lastName, String email, String telephone, String password, String confirmPassword) {
		logger.info("Starting test case: Register Account");
		
		//Home page
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.clickOnMyAccountArrow();
		logger.info("Clicked on the arrow next to my account");
		homePage.clickRegister();
		logger.info("Clicked Register");
		
		//Register account validation and insert details
		RegisterAccountPage registerAccountPage = PageFactory.initElements(driver, RegisterAccountPage.class);
		registerAccountPage.validateRegisterAccountPage(driver.getTitle(), registerAccExpectedText, errorMessage);
		logger.info("Validated register account page");
		registerAccountPage.insertFirstName(firstName);
		logger.info("Entered first name: {}", firstName);
		registerAccountPage.insertLastName(lastName);
		logger.info("Entered last name: {}", lastName);
		randomRegistrationEmail = registerAccountPage.insertEmail(email);
		logger.info("Entered email: {}", randomRegistrationEmail);
		registerAccountPage.insertTelephone(telephone);
		logger.info("Entered telephone: {}", telephone);
		registerAccountPage.insertPassword(password);
		logger.info("Entered password");
		registerAccountPage.confirmPassword(confirmPassword);
		logger.info("Confirmed password");
		registerAccountPage.clickNoForNewsletter();
		logger.info("Clicked No for Newsletter");
		registerAccountPage.clickOnPrivacyPolicyCheckbox();
		logger.info("Clicked on Privacy Policy checkbox");
		registerAccountPage.clickContinue();
		logger.info("Clicked Continue");
		
		// Validate account created successfully
		AccountCreatedPage accountCreatedPage = PageFactory.initElements(driver, AccountCreatedPage.class);
		accountCreatedPage.validateAccountCreated(driver.getTitle(), accountCreatedExpectedText, errorMessage);
		logger.info("Validated account created page");
		accountCreatedPage.clickContinue();
		logger.info("Clicked Continue");
		
		// Capture the randomly generated registration email
		readConfig.setCapturedEmail("capturedRandomEmail", randomRegistrationEmail);
		readConfig.saveCapturedEmail();
		
		
		logger.info("RegisterAccount test case execution completed");	
	}
}
