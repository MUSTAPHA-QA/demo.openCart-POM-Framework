package demo.opencart.utilities;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	public WebDriver driver;
	ReadConfig readConfig = new ReadConfig();
	String url = readConfig.getUrl();
	public Logger logger = LogManager.getLogger(this.getClass());
	
	@BeforeClass
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		logger.info("Launching The Browser");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		logger.info("Navigating To The URL");
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();	
	}
}
