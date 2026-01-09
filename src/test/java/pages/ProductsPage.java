package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {
    private WebDriver driver;
    private By searchField = By.cssSelector(".search-field");
    private By elementTitles = By.cssSelector("li h2");
    private By searchRes = By.xpath(".//h1[contains(text(),'Store')]");
    private By searchButton = By.cssSelector("button[value='Search']");
    private By singleProductFound = By.cssSelector("h1[class='product_title entry-title']");
    private By categoryDropdown = By.id("product_cat");
    private By productCategories = By.cssSelector("span[class='ast-woo-product-category']");
    private By startingDragger = By.cssSelector(".price_slider span:nth-of-type(1)");
    private By endingDragger = By.cssSelector(".price_slider span:nth-of-type(2)");;
    private By startingAmount = By.cssSelector("span.from");
    private By endingAmount = By.cssSelector("span.to");
    private By productPrices = By.cssSelector(".price > span,.price ins");
    private By filterButton = By.cssSelector(".price_slider_amount button[type='submit']");



    public ProductsPage(WebDriver driver){
        this.driver = driver;
    }

    //Searching
    public void queryAndSearch(String query){
        var search = driver.findElement(searchField);
        search.sendKeys(query);

        var element = driver.findElement(searchRes);
        driver.findElement(searchButton).click();

        var wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public String matchedSearchResults (String query){
        if(!driver.findElements(singleProductFound).isEmpty()){
            var singleProduct = driver.findElement(singleProductFound);
            if(singleProduct.getText().toLowerCase().contains(query.toLowerCase())) return "1 product found matching "+query;
        }

        var elements = driver.findElements(elementTitles);
        var productTitles = elements.stream().map(a -> a.getText()).toList();//collect(Collectors.toList());

        if(productTitles.isEmpty()) return "No Match";
        for(String h2:productTitles) if(!h2.toLowerCase().contains(query.toLowerCase())) return "Unmatching product detected";

        return "Matching";
    }

    //Browse by category
    public Select categoryDropdownSelect(){
        return new Select(driver.findElement(categoryDropdown));
    }

    public void selectOption(String option){
        driver.findElement(categoryDropdown).sendKeys(Keys.ENTER);
        var dropdown = categoryDropdownSelect();
        dropdown.selectByVisibleText(option);
    }
    public String selectedCategory(String expectedCategory){
        var categoryProducts= driver.findElements(productCategories)
                .stream().map(a -> a.getText()).toList();
        for(var category: categoryProducts){
            if(!category.toLowerCase().startsWith(expectedCategory.toLowerCase())) return "Incorrect category\nfound: "+category + "\ninstead of: "+expectedCategory;
        }
        return "All products match categories";
    }
    //Filter by price
    public void priceRangeDrag(int start, int end){
        if(start%10 != 0 || end%10!=0 || start < 10 || end > 150) throw new IllegalArgumentException("Please enter numbers divisible by 10 in the range 10--150");

        int startingPoint = Integer.valueOf(driver.findElement(startingAmount).getText().substring(1));
        int endingPoint = Integer.valueOf(driver.findElement(endingAmount).getText().substring(1));

        var startDrag = driver.findElement(startingDragger);
        var endDrag = driver.findElement(endingDragger);

        while(start > startingPoint){
            startDrag.sendKeys(Keys.ARROW_RIGHT);
            start-= 10;
        }
        while(start < startingPoint){
            startDrag.sendKeys(Keys.ARROW_LEFT);
            start+= 10;
        }
        while(end > endingPoint){
            endDrag.sendKeys(Keys.ARROW_RIGHT);
            end-= 10;
        }
        while(end  < endingPoint){
            endDrag.sendKeys(Keys.ARROW_LEFT);
            end+= 10;
        }
        driver.findElement(filterButton).click();
    }

    public String allMatchLimit(){
        int start = Integer.valueOf(driver.findElement(startingAmount).getText().substring(1));
        int end = Integer.valueOf(driver.findElement(endingAmount).getText().substring(1));
        var productPrices = driver.findElements(this.productPrices).stream().map(a -> Double.parseDouble(a.getText().substring(1))).toList();
        System.out.println(productPrices);
        return productPrices.stream().allMatch(a -> a >= start && a <=end)?"All match":"Not all match";

    }
}






