package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import drivers.DriverFactory;
import utils.WaitUtil;

public class BasePage {
	
	protected WebDriver driver;
    protected WaitUtil wait;
    
	public BasePage() {
		this.driver = DriverFactory.getDriver();
		this.wait = new WaitUtil(driver);
		PageFactory.initElements(driver,this);
	}

}
