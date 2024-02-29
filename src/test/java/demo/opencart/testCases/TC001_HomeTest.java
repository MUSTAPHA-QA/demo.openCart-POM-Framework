package demo.opencart.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import demo.opencart.pageObjects.HomePage;
import demo.opencart.utilities.BrowserFactory;


public class TC001_HomeTest extends BrowserFactory {
	
	@Test
	public void navigateToRegisterAccountPage() {
		logger.info("Starting test case: Home Test");
		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.clickOnMyAccountArrow();
		logger.info("Clicked on the arrow next to my account");
		homePage.clickRegister();
		logger.info("Clicked Register");
		
		logger.info("HomeTest test case execution completed");
	}
}
