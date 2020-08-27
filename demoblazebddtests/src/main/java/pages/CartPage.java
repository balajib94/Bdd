package pages;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    public CartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        js = (JavascriptExecutor) driver;
    }
    @FindBy(how= How.ID,using = "totalp")
    private WebElement totalAmount;
    @FindBy(how = How.XPATH,using = "//button[text()='Place Order']")
    private WebElement placeOrder;
    @FindBy(how=How.ID,using = "name")
    private WebElement name;
    @FindBy(how=How.ID,using = "country")
    private WebElement country;
    @FindBy(how=How.ID,using = "city")
    private WebElement city;
    @FindBy(how=How.ID,using = "card")
    private WebElement card;
    @FindBy(how=How.ID,using = "month")
    private WebElement month;
    @FindBy(how=How.ID,using = "year")
    private WebElement year;
    @FindBy(how=How.XPATH,using = "//button[text()='Purchase']")
    private WebElement purchase;
    @FindBy(how=How.XPATH,using = "//div[contains(@class,'sweet-alert')]/p")
    private WebElement confirmAlert;
    @FindBy(how=How.XPATH,using="//button[text()='OK']")
    private WebElement ok;
    public void removeProduct(String productName) {
        WebElement delete = driver.findElement(By.xpath("//td[text()='" + productName + "']/following-sibling::td/a"));
        delete.click();
    }
    public String getTotalAmount() throws InterruptedException {
        Thread.sleep(7000);
        return totalAmount.getText();
    }

    public CartPage clickOnPlaceOrder() {
        placeOrder.click();
        return this;
    }

    public CartPage fillPaymentDetails(Map<String,String> data) {
        name.sendKeys(data.get("Name"));
        country.sendKeys(data.get("Country"));
        city.sendKeys(data.get("City"));
        card.sendKeys(data.get("Credit card"));
        month.sendKeys(data.get("Month"));
        year.sendKeys(data.get("Year"));
        return this;
    }

    public CartPage clickOnPurchase() {
        purchase.click();
        return this;
    }

    public String getPurchaseDetails() {

        return confirmAlert.getText();
    }

    public void clickOk() {
        ok.click();
        driver.quit();
    }
}
