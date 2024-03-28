package demo.opencart.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties properties;
	
	public ReadConfig() {
		
		try {
			FileInputStream fileInputStream = new FileInputStream("./src/test/resources/config.properties");
			properties = new Properties();
			properties.load(fileInputStream);
		} catch(IOException e) {
			e.printStackTrace();
		}		
	}
	
	public String getUrl() {
		return properties.getProperty("url");
	}
	
	public String getRegisterAccExpectedText() {
		return properties.getProperty("registerAccExpectedText");
	}
	
	public String getErrorMessage() {
		return properties.getProperty("errorMessage");
	}
	
	public String getAccCreatedExpectedText() {
		return properties.getProperty("accountCreatedExpectedText");
	}
	
	public String getLoginExpectedText() {
		return properties.getProperty("loginExpectedText");
	}
	
	public String getPassword() {
		return properties.getProperty("password");
	}
	
	public void saveCapturedEmail() {
		try {
			FileOutputStream outputStream = new FileOutputStream("./src/test/resources/config.properties");
			properties.store(outputStream, "captured random email during registration");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setCapturedEmail(String key, String value) {
		properties.setProperty(key, value);
	}
	
	public String getCapturedRandomEmail() {
		return properties.getProperty("capturedRandomEmail");
	}
	
	public String getMyAccountExpectedText() {
		return properties.getProperty("myAccountExpectedText");
	}
}
