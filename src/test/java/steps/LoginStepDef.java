package steps;

import baseUtil.BaseUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.AccountsPage;
import static org.testng.Assert.*;

public class LoginStepDef {
    private BaseUtil utils;
    private AccountsPage account;

    public LoginStepDef(BaseUtil utils) {
        this.utils = utils;
    }

    @Given("I am on the account login page")
    public void i_am_on_the_account_registration_page() {
        account = utils.home.clickAccountsPageLink();
    }

    @When("I enter valid {string} and {string}")
    public void i_enter_valid_username_email_and_password(String username, String password)throws InterruptedException {
        account.fillLoginForm(username,password);
        account.login();
    }

    @Then("I am directed to the account information page after login")
    public void i_am_directed_to_the_account_information_page() {
        System.out.println(account.success());
        assertTrue(account.success().contains("Hello")||account.success().contains("already registered"));
    }
}
