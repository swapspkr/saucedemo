package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import base.BasePage;

public class LoginPage extends BasePage{
	

    // ********* WEB ELEMENTS *********

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='app_logo']")
    private WebElement productPageHeader;

    @FindBy(xpath = "//button[@class='error-button']")
    private WebElement loginErrorMessage;
    
    // ********* ACTIONS *********

    public void enterUserName(String username) {
    	userNameInput.clear();
    	userNameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }
	
 // Combined action for login
    public void loginToAdmin(String email, String password) {
    	userNameInput.clear();
    	enterUserName(email);
        passwordInput.clear();
        enterPassword(password);
        clickLogin();

    }
    
    // Validation after login
    public boolean isProductPageDisplayed() {
        try {
            return productPageHeader.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isLoginErrorDisplayed() {
        try {
        	 return wait.waitForElementVisible(loginErrorMessage).isDisplayed();
            
        } catch (Exception e) {
            return false;
        }
    }

}
