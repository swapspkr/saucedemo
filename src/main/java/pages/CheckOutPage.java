package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class CheckOutPage extends BasePage{
	// Step One locators
    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(id = "continue")
    private WebElement continueButton;

    // Step Two locators
    @FindBy(id = "finish")
    private WebElement finishButton;

    // Confirmation
    @FindBy(css = ".complete-header")
    private WebElement successMessage;


    // Step 1 actions
    public void enterFirstName(String fname) {
        wait.type(firstNameInput,fname);
    }

    public void enterLastName(String lname) {
        wait.type(lastNameInput,lname);
        
    }

    public void enterPostalCode(String pcode) {
        wait.waitForElementVisible(postalCodeInput);
        postalCodeInput.sendKeys(pcode);
    }

    public void clickContinue() {
        wait.waitForElementClickable(continueButton);
        continueButton.click();
    }

    // Step 2 action
    public void clickFinish() {
        wait.waitForElementClickable(finishButton);
        finishButton.click();
    }

    // Confirmation
    public String getSuccessMessage() {
        wait.waitForElementVisible(successMessage);
        return successMessage.getText();
    }
}
