package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public void linkClicker(String link){
        driver.findElement(By.linkText(link)).click();
    }
    public AccountsPage clickAccountsPageLink(){
        linkClicker("Account");
        return new AccountsPage(driver);
    }
    public StorePage clickShopNow(){
        driver.findElement(By.linkText("SHOP NOW"));
        return new StorePage(driver);
    }

}
