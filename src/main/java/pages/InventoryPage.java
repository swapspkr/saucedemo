package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utils.WaitUtil;

public class InventoryPage extends BasePage{
	
	
	// Page Title
    @FindBy(className = "title")
    private WebElement pageTitle;

    // List of all products on the inventory page
    @FindBy(className = "inventory_item")
    private List<WebElement> allProducts;

    // First product's Add to Cart button (example)
    @FindBy(xpath = "(//button[contains(@class,'btn_inventory')])[1]")
    private WebElement firstAddToCartBtn;

    // Shopping cart icon
    @FindBy(id = "shopping_cart_container")
    private WebElement cartIcon;

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    private WebElement addBackpackToCart;
    
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement addBackpackButton;
    
    @FindBy(id = "item_4_title_link")
    WebElement firstProductLink;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartFirstProduct;
    
    // ===============================
    // ACTION METHODS
    // ===============================

    public String getPageTitle() {
        return pageTitle.getText().trim();
    }

    public int getTotalProductsCount() {
        return allProducts.size();
    }

    public void clickFirstAddToCart() {
        firstAddToCartBtn.click();
    }

    public void clickCart() {
        wait.click(cartIcon);
    }

	public void addBackpackToCart() {
		wait.waitForElementClickable(addBackpackButton).click();
	}
	
	public String getFirstProductName() {
        return wait.getText(firstProductLink);
    }

    public void addFirstProductToCart() {
        wait.click(addToCartFirstProduct);
    }

	public void addBikeLightToCart() {
		// TODO Auto-generated method stub
		
	}

}
