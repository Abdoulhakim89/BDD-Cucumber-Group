package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountsPage   {
    private WebDriver driver;
    private By usernameField = By.id("reg_username");
    private By emailField = By.id("reg_email");
    private By passwordField = By.id("reg_password");
    private By submitButton = By.name("register");
    private By successMessage = By.xpath("//p[contains(text(),'Hello')]");
    private By errorMessage = By.cssSelector(".woocommerce-error li");
    private By loginUsername = By.id("username");
    private By loginPassword = By.id("password");
    private By loginButton = By.name("login");

    public AccountsPage(WebDriver driver){
        this.driver = driver;
    }

    public void fillRegForm(String username, String email, String password){
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
    }
    public void submitRegForm(){
        driver.findElement(submitButton).click();
    }

    public String success(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(successMessage),
                ExpectedConditions.visibilityOfElementLocated(errorMessage)
        ));
        if(driver.findElements(successMessage).isEmpty()){
            return driver.findElement(errorMessage).getText();
        }
        return driver.findElement(successMessage).getText();
    }

    public void fillLoginForm (String username, String password){
        driver.findElement(loginUsername).sendKeys(username);
        driver.findElement(loginPassword).sendKeys(password);
    }
    public void login(){
        driver.findElement(loginButton).click();
        var wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(successMessage),
                ExpectedConditions.visibilityOfElementLocated(errorMessage)
        ));
    }

    public String loginMessage(){

        if(driver.findElements(successMessage).isEmpty()){
            return driver.findElement(errorMessage).getText();
        }
        return driver.findElement(successMessage).getText();
    }



}
