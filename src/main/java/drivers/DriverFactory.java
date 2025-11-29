package drivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    // Private constructor - Singleton
	private DriverFactory() {}
	
	public static WebDriver getDriver(String browser) {
		
		if(tlDriver.get()== null) {
			
			switch (browser.toLowerCase()) {
		
				case "chrome": 
						tlDriver.set(new ChromeDriver()); 
						break;
				case "fireforx":
						tlDriver.set(new FirefoxDriver());
						break;
				case"edge": 
						tlDriver.set(new EdgeDriver());
						break;
				default:
                    throw new RuntimeException("Invalid browser name: " + browser);
				}
			
			}
		
		 return tlDriver.get();	
	}
	
	public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}
