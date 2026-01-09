package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class StorePage {
    public By viewCartLink = By.linkText("View cart");
    WebDriver driver;
    public StorePage(WebDriver driver){
        this.driver = driver;
    }

    public String clickAddToCart(){
        List<WebElement> addButtons = driver.findElements(By.linkText("ADD TO CART"));
        addButtons.getFirst().click();
        WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartLink));
        return driver.findElement(viewCartLink).getText();
    }

    public CheckoutPage hoverToBagIcon(){
        WebElement checkoutLink = driver.findElement(By.cssSelector("#ast-site-header-cart > div.ast-site-header-cart-li > a > div > span"));
        Actions actions =new Actions(driver);
        actions.moveToElement(checkoutLink).perform();
        return new CheckoutPage(driver);
    }
}
