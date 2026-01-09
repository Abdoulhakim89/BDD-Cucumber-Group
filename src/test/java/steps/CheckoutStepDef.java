package steps;

import baseUtil.BaseUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutPage;
import pages.StorePage;

public class CheckoutStepDef {
    public BaseUtil utils;
    public CheckoutPage checkoutPage;

    public CheckoutStepDef(BaseUtil utils) {
        this.utils = utils;
        this.checkoutPage = new CheckoutPage(utils.driver);
    }

    @Given("Customer has added items to the cart")
    public void customer_has_added_items_to_the_cart() {
        StorePage addToCart = utils.home.clickShopNow();
        addToCart.clickAddToCart();
        var checkout = addToCart.hoverToBagIcon();
        checkout.clickCheckout();
    }
    @When("Customer proceeds to checkout and fill in {string} and {string} and {string} and {string} and {string} and {string} properly")
    public void customer_proceeds_to_checkout(String fname, String lname, String address, String city, String zip, String email) {
       checkoutPage.fillOrderForm(fname, lname, address, city, zip, email);
       checkoutPage.placeOrder();
       ///uhjghiujkhnoljohhnijhbui
    }

    @Then("Order is placed successfully")
    public void order_is_placed_successfully() {
        checkoutPage.getOrderConfirmationMessage();

    }
}
