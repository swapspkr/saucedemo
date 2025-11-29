package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class CartPage extends BasePage{

	@FindBy(xpath = "//span[@class='title']")
    private WebElement cartTitle;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private WebElement firstCartItem;

    @FindBy(className = "inventory_item_name")
    WebElement itemName;

    @FindBy(id = "checkout")
    WebElement checkoutBtn;
    
    public String getCartTitle() {
        return cartTitle.getText().trim();
    }

    public String getFirstCartItemName() {
        return firstCartItem.getText().trim();
    }
    
    public String getItemName() {
        return wait.getText(itemName);
    }

    public void clickCheckout() {
        wait.click(checkoutBtn);
    }
}
