package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import listeners.TestListener;
import pages.CartPage;
import pages.CheckOutPage;
import pages.InventoryPage;


public class CheckoutTest {
	@Test
    public void testCheckoutFlow() {

        // Step 1 — Login steps are handled in BaseTest (if added)

        // Inventory Page
        InventoryPage inventory = new InventoryPage();
        inventory.addBackpackToCart();
        inventory.clickCart();

        // Cart Page
        CartPage cart = new CartPage();
        cart.clickCheckout();
        TestListener.getTest().info("Click on Checkout ");
        
        
        // Checkout Page
        CheckOutPage checkout = new CheckOutPage();
        checkout.enterFirstName("Swapnil");
        TestListener.getTest().info("entered FirstName : ");
        checkout.enterLastName("Supekar");
        TestListener.getTest().info("entered LastName  : ");
        checkout.enterPostalCode("411001");
        TestListener.getTest().info("entered PostalCode : ");
        checkout.clickContinue();
        TestListener.getTest().info("Click on continue ");
        checkout.clickFinish();
        TestListener.getTest().info("Click on Finish ");

        // Validation
        String confirmationMsg = checkout.getSuccessMessage();
        Assert.assertEquals(confirmationMsg, "Thank you for your order!");
    }
}
