package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import drivers.DriverFactory;
import utils.ConfigReader;




public class BaseTest {

	protected WebDriver driver;
	private ConfigReader config;
	
	
	@BeforeMethod
	public void setup() {
		config = new ConfigReader();
		driver = DriverFactory.getDriver(config.getBrowser());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(config.getAppUrl());
	}
	
	 @AfterMethod
	    public void tearDown() {
	        DriverFactory.quitDriver();
	    }
}
