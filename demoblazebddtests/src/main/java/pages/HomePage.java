package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions builder;
    JavascriptExecutor js;
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,30);
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250);");
        builder = new Actions(driver);
    }
    @FindBy(how=How.LINK_TEXT,using = "Laptops")
    private WebElement laptop;
    @FindBy(how=How.LINK_TEXT,using = "Phones")
    private WebElement phone;
    @FindBy(how=How.LINK_TEXT,using = "Monitors")
    private WebElement monitor;
    @FindBy(how= How.LINK_TEXT,using="Cart")
    WebElement cart;
    public ProductPage clickOnLaptops() {
        wait.until(ExpectedConditions.elementToBeClickable(laptop));
        builder.moveToElement(laptop).click().build().perform();
        return new ProductPage(driver);
    }
    public ProductPage clickOnPhones() {
        wait.until(ExpectedConditions.elementToBeClickable(phone));
        builder.moveToElement(phone).click().build().perform();
        return new ProductPage(driver);
    }
    public ProductPage clickOnMonitors() {
        wait.until(ExpectedConditions.elementToBeClickable(monitor));
        builder.moveToElement(monitor).click().build().perform();
        return new ProductPage(driver);
    }
    public CartPage clickOnCart(){
        js.executeScript("window.scrollTo(0,0);");
        cart.click();
        return new CartPage(driver);
    }
}
