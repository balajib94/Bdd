package stepDefinitions;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import utils.Context;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Uisteps {
    WebDriver driver;
    HomePage homePage;
    ProductPage productPage;
    CartPage cartPage;
    TestContext testContext;

    private static final Logger log = LoggerFactory.getLogger("test");

    public Uisteps(TestContext context){
        testContext = context;
    }
    @Given("^the browser is launched$")
    public void launchBrowser(){
        System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Given("^the user is on home page$")
    public void openApplication(){

        driver.get("https://www.demoblaze.com/index.html");
    }

    @When("^the user searches for '(.*)'$")
    public void searchCategory(String productCategory){
        homePage=new HomePage(driver);
        switch (productCategory){
            case "Laptops":
                homePage.clickOnLaptops();
                break;
            case "Phones":
                homePage.clickOnPhones();
                break;
            case "Monitors":
                homePage.clickOnMonitors();
                break;
            default:
                log.info("Invalid Product Category");

        }
    }
    @When("^the user adds the given products$")
    public void addProduct(DataTable dataTable){
        productPage = new ProductPage(driver);
        List<String> products = dataTable.asList();
        for(String productName:products)
        {
            productPage.clickOnProduct(productName)
            .addToCart()
            .acceptPopup()
            .navigateBackToHomePage().clickOnLaptops();
        }
    }
    @And("^the user navigates to cart$")
    public void navigateToCart(){
        homePage = new HomePage(driver);
        homePage.clickOnCart();
    }
    @And("^the user deletes the product from cart$")
    public void deleteProduct(DataTable dataTable) throws InterruptedException {
        List<String> productsToDelete = dataTable.asList();
        cartPage=new CartPage(driver);
        for (String prod:productsToDelete)
        {
            cartPage.removeProduct(prod);
        }
        String totalAmount = cartPage.getTotalAmount();
        testContext.scenarioContext.setContext(Context.EXPECTED_AMOUNT,totalAmount);
    }
    @And("^the user clicks on Place Order$")
    public void clickPlaceOrder(DataTable dataTable){
        Map<String, String> paymentDetails = dataTable.asMap(String.class, String.class);
        cartPage=new CartPage(driver);
        cartPage.clickOnPlaceOrder().fillPaymentDetails(paymentDetails).clickOnPurchase();
    }
    @Then("^the purchase id should be generated$")
    public void assertPurchaseId(){
        cartPage=new CartPage(driver);
        String orderDetails = cartPage.getPurchaseDetails();
        String[] details = orderDetails.split("\\n");
        String purchaseId = details[0].substring(3).trim();
        testContext.scenarioContext.setContext(Context.PURCHASE_ID,purchaseId);
        log.info("Purchase ID - "+purchaseId);
        String purchaseAmount = details[1].substring(7).trim();
        testContext.scenarioContext.setContext(Context.ACTUAL_AMOUNT,purchaseAmount);
    }
    @Then("^the purchase amount should match with expected value$")
    public void assertPurchaseAmount(){
        String expectedAmount = testContext.scenarioContext.getContext(Context.EXPECTED_AMOUNT).toString();
        String actualAmount = testContext.scenarioContext.getContext(Context.ACTUAL_AMOUNT).toString();
        log.info("Purchase Amount - "+actualAmount);
        String actualValue = actualAmount.replaceAll("[A-Z]", "").trim();
        Assert.assertEquals("Expected and Actual Amount are not same",expectedAmount,actualValue);
    }
    @And("^the user clicks on OK$")
    public void clickOnOK(){
        cartPage=new CartPage(driver);
        cartPage.clickOk();
    }
}
