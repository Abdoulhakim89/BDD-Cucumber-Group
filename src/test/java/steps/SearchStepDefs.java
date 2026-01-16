package steps;

import baseUtil.BaseUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductsPage;
import static org.testng.Assert.*;

public class SearchStepDefs {
    private BaseUtil utils;
    private ProductsPage products;

    public SearchStepDefs(BaseUtil utils) {
        this.utils = utils;
    }

    @Given("the customer is on the Store page")
    public void i_am_on_the_store_page() {
        products = utils.home.clickProductsPageLink();
    }

    @When("customer searches for {string}")
    public void customerSearchFor(String product) {
        products.queryAndSearch(product);
    }

    @Then("customer should see products that only relate to {string}")
    public void i_should_see_products_that_only_relate_to_search_product(String product) {
        assertEquals(products.matchedSearchResults(product),"Matching",products.matchedSearchResults(product));
    }

    @When("I search for non existent product {string}")
    public void i_search_for_non_existent_product(String product) {
        products.queryAndSearch(product);
    }

    @Then("I should see a product not found message for {string}")
    public void i_should_see_a_product_not_found_message(String product) {
        assertEquals(products.matchedSearchResults(product),"No Match",products.matchedSearchResults(product));
    }

}
