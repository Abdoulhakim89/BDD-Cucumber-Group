package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;
    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickCheckout(){
        driver.findElement(By.cssSelector("a.button.checkout.wc-forward")).click();
    }

    public void fillOrderForm(String fName, String lName, String street, String city, String zipCode, String email){
        driver.findElement(By.id("billing_first_name")).sendKeys(fName);
        driver.findElement(By.id("billing_last_name")).sendKeys(lName);
        driver.findElement(By.id("billing_address_1")).sendKeys(street);
        driver.findElement(By.id("billing_city")).sendKeys(city);
        driver.findElement(By.id("billing_postcode")).sendKeys(zipCode);
        driver.findElement(By.id("billing_email")).sendKeys(email);
    }
    public void placeOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        By placeOrder = By.id("place_order");

        for (int i = 0; i < 3; i++) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(placeOrder)).click();
                return;
            } catch (StaleElementReferenceException e) {

            }
        }
    }
    public String getOrderConfirmationMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By confirmationMessage = By.cssSelector("p.woocommerce-thankyou-order-received");
        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage)).getText();
        System.out.print(message);
        return message;
    }

}

