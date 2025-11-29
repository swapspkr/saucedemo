package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ConfigReader;


public class LoginTest extends BaseTest{

	
	@Test
    public void verifyValidLogin() {

        ConfigReader config = new ConfigReader();
        LoginPage login = new LoginPage();

        login.loginToAdmin(config.getUsername(), config.getPassword());
        
     // Validation - Page title after login
        Assert.assertEquals(driver.getTitle().trim(),
                "Swag Labs",
                "Login Failed!");
    }
	
	@Test()
    public void verifyInvalidLogin() {

        LoginPage login = new LoginPage();

        login.loginToAdmin("wrong@user.com", "wrongpassword");

        Assert.assertTrue(login.isLoginErrorDisplayed(), "Error message not displayed!");
    }

}
