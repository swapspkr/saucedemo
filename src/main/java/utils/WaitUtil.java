package utils;

import java.time.Duration;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

	private WebDriver driver;
    private WebDriverWait wait;

    public WaitUtil(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public WebElement waitForElementVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(WebElement element) {
    	try {
    		waitForElementClickable(element).click();
    	}
    	catch(StaleElementReferenceException e) {
    		waitForElementClickable(element).click();
    	}
    }

    public void type(WebElement element, String text) {
    	
    	 WebElement visibleElement = waitForElementVisible(element);
    	 visibleElement.clear();
         visibleElement.sendKeys(text);
    }

    public String getText(WebElement element) {
        return waitForElementVisible(element).getText();
    }
}
