package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    WebDriverWait wait;
    Actions builder;
    WebDriver driver;
    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,30);
        builder = new Actions(driver);
    }
    @FindBy(how= How.LINK_TEXT,using="Add to cart")
    private WebElement addToCart;
    @FindBy(how=How.XPATH,using="//a[contains(text(),'Home ')]")
    private WebElement home;
    public ProductPage clickOnProduct(String productName) {
        WebElement product = returnElement(productName);
        wait.until(ExpectedConditions.elementToBeClickable(product));
        product.click();
        return this;
    }

    public WebElement returnElement(String linkText){
        return this.driver.findElement(By.linkText(linkText));
    }

    public HomePage navigateBackToHomePage() {
        home.click();
        return new HomePage(driver);
    }

    public ProductPage addToCart() {
        addToCart.click();
        return this;
    }

    public ProductPage acceptPopup() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
            return this;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return this;
        }
    }
}
