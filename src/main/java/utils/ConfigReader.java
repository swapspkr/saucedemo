package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private FileInputStream fis ;
	private Properties prop;
	
	public ConfigReader()  {
		try {
			prop = new Properties();
			fis = new FileInputStream("src/test/resources/config/config.properties");
			prop.load(fis);
			
		} catch ( IOException e) {
			throw new RuntimeException("Failed to load config.properties:" +e.getMessage());
		}
		
	}
	
	public String getBrowser() {
		
		return prop.getProperty("browser").trim();
	}
	
	public String getAppUrl() {
		
		return prop.getProperty("url").trim();
	}
	
	public String getUsername() {
		return prop.getProperty("username").trim();
	}
	
	public String getPassword() {
		return prop.getProperty("password").trim();
	}
	
}
