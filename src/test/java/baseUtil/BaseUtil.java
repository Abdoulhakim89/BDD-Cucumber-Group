package baseUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

public class BaseUtil {
    public WebDriver driver;
    public HomePage home;


    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://askomdch.com");
        home = new HomePage(driver);
    }
    @After
    public void quit(){
        driver.quit();
    }


}
