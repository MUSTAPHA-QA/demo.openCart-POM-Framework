package demo.opencart.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import demo.opencart.pageObjects.HomePage;
import demo.opencart.pageObjects.LoginPage;
import demo.opencart.pageObjects.MyAccountPage;
import demo.opencart.utilities.BrowserFactory;
import demo.opencart.utilities.ReadConfig;

public class TC003_LoginTest extends BrowserFactory {
	
	ReadConfig readConfig = new ReadConfig();
	String loginExpectedText = readConfig.getLoginExpectedText();
	String errorMessage = readConfig.getErrorMessage();
	String password = readConfig.getPassword();
	String email = readConfig.getCapturedRandomEmail();
	String myAccountExpectedText = readConfig.getMyAccountExpectedText();

	@Test
	public void verifyLoginFunctionality() {
		logger.info("Starting test case: Login");

		// Home page
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.clickOnMyAccountArrow();
		logger.info("Clicked on the arrow next to my account");
		homePage.clickLogin();
		logger.info("Clicked Login");
		
		// Login page validation and insert details
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.validateLoginPage(driver.getTitle(), loginExpectedText, errorMessage);
		logger.info("Validated login page");
		loginPage.insertLoginEmail(email);
		logger.info("Entered email: {}", email);
		loginPage.insertLoginPassword(password);
		logger.info("Entered password");
		loginPage.clickLogin();
		logger.info("Clicked Login");
		
		//My account validation
		MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
		myAccountPage.validateMyAccountPage(driver.getTitle(), myAccountExpectedText, errorMessage);
		logger.info("Validated my account page");

		logger.info("LoginTest test case execution completed");
	}
}
