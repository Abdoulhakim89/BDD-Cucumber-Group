package steps;

import baseUtil.BaseUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutPage;
import pages.StorePage;

import static org.testng.Assert.assertEquals;

public class AddToCartStep {
    public BaseUtil utils;
    public StorePage storePage;

    public AddToCartStep(BaseUtil utils) {
        this.utils = utils;
        this.storePage = new StorePage(utils.driver);
    }

    @Given("the customer is on the product page")
    public void the_customer_is_on_the_product_page() {
        StorePage store = utils.home.clickShopNow();
    }

    @When("the customer clicks on the Add to Cart button")
    public void the_customer_clicks_on_the_add_to_cart_button() {
        StorePage store = utils.home.clickShopNow();
        store.clickAddToCart();
    }

    @Then("the product should be added to the cart")
    public void the_product_should_be_added_to_the_cart() {
        System.out.println(storePage.clickAddToCart());
        assertEquals(storePage.clickAddToCart(),"View cart", "product is not added to cart");

    }

}
