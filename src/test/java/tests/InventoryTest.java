package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import listeners.TestListener;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public class InventoryTest extends BaseTest{


	@Test
    public void verifyAddToCartFlow() {

        // Step 1: Login
        LoginPage login = new LoginPage();
        login.loginToAdmin("standard_user", "secret_sauce");
        TestListener.getTest().info("Login success ! ");
        
        // Step 2: Inventory Page
        InventoryPage inventory = new InventoryPage();

        Assert.assertEquals(
                inventory.getPageTitle(),
                "Products11",
                "Inventory Page not loaded!"
        );

        // Step 3: Add product to cart
        String productName = inventory.getFirstProductName();
        inventory.addFirstProductToCart();
        TestListener.getTest().info("added first product to Cart !! ");
        // Step 4: Click cart icon
        inventory.clickCart();

        TestListener.getTest().info("click cart icon !! ");
        
        // Step 5: Validate cart page
        CartPage cart = new CartPage();
        String cartItemName = cart.getItemName();
        
        Assert.assertEquals(cartItemName, productName, "Product mismatch in cart!");
    }
}
