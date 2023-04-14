package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Log;

import java.time.Duration;
import java.util.Random;

public class Bag {

    WebDriver driver;
    WebDriverWait wait;

    Random random;
    String productName;
    @FindBy(css = "input[placeholder='Search']")
    WebElement searchBox;
    @FindBy(css = "button[aria-label='Search']")
    WebElement searchBtn;
    @FindBy(css = "div.plp__imageWrapper__1iSxD")
    WebElement plpTile;
    @FindBy(xpath = "//div[@class =\"product-info brand\"]//p[@class=\"product-name\"]/a")
    WebElement chanelplptitle;
    @FindBy(xpath = "//p[text()='Add to bag']")
    WebElement addToBagFromQuickView;
    @FindBy(xpath = "//div[@class =\"button-wrapper\"]/input")
    WebElement chanelAddtobag;
    @FindBy(xpath = "//button[@data-testid='quickview-view-bag']")
    WebElement viewBagButtonFromQuickView;
    @FindBy(xpath = "//*[@id=\"bag-items\"]/li[1]/div/div/div[1]/picture/img")
    WebElement productImage;
    @FindBy(xpath = "//div[@class= \"plp__navHeaderLayout__3zdYO\"]//li[1]")
    WebElement shop;
    @FindBy(xpath = "//div[@class= \"plp__lvl1UserAccountNav__1_zh0\"]//li[3]//span")
    WebElement bag;
    @FindBy(xpath = "//div[@class= \"page-empty-cart\"]//span")
    WebElement noProduct;
    @FindBy(xpath = "//div[@class= \"incrementing-button\"]/button/span")
    WebElement remove;
    @FindBy(xpath = "//div[@class= \"free-sample-bar\"]//span[2]")
    WebElement freeSample;
    @FindBy(xpath = "//ul[@class= \"sample-list\"]/li[1]//button")
    WebElement firstSample;
    @FindBy(xpath = "//ul[@class= \"sample-list\"]/li[2]//button")
    WebElement secondSample;
    @FindBy(xpath = "//ul[@class= \"sample-list\"]/li[3]//button")
    WebElement thirdSample;
    @FindBy(xpath = "//ul[@class= \"sample-list\"]/li[4]//button")
    WebElement fourthSample;
    @FindBy(xpath = "//*[@id=\"bag-items\"]/li[2]/div/div/div[2]/div[2]/div/p")
    WebElement freesampleOnCart;
    @FindBy(xpath = "//div[@class= \"order-summary-title summary-row\"]/h4/span")
    WebElement orderSummary;
    @FindBy(xpath = "//div[@id= \"order-summary\"]//div[@class=\"order-total summary-row\"]//span")
    WebElement totalBeforeTax;
    @FindBy(xpath = "//*[@id=\"checkout-mobile-cta\"]")
    WebElement checkout;
    @FindBy(xpath = "//input[@type = \"email\"]")
    WebElement email;
    @FindBy(xpath = "//button/span")
    WebElement next;
    @FindBy(xpath = "//input[@type = \"password\"]")
    WebElement password;
    @FindBy(xpath = "//*[@id=\"passwordNext\"]//span")
    WebElement nextPassword;
    @FindBy(css = "input.checkout-input-field")
    WebElement guestEmailField;
    @FindBy(xpath = "//button[@class='CTA-button small-text']")
    WebElement checkoutAsGuestButton;
    @FindBy(xpath = "//div[@class= \"shipping summary-row\"]//span")
    WebElement shipping;
    @FindBy(xpath = "//div[@class= \"shipping summary-row\"]//p[@class=\"bold\"]/span")
    WebElement shippingprice;
    @FindBy(xpath = "//div[@class='incrementing-button-wrapper']/button[@class= \"CTA-button square\"]")
    WebElement incremenetButton;
    @FindBy(xpath = "//button[@class= \"CTA-button square is-disabled\"]")
    WebElement buttonDisabled;
    @FindBy(xpath = "//div[@class= \"brand-category-list top\"]//li[2]/a")
    WebElement luxaryproduct;
    @FindBy(xpath = "//button[@class =\"btn-checkout default-btn\"]")
    WebElement checkoutChanel;
    @FindBy(css = ".square:nth-child(3)")
    WebElement addmore;

    public void siignInGoogle() throws InterruptedException {
        Thread.sleep(5000);
        email.click();
        email.sendKeys("");
        Thread.sleep(4000);
        next.click();
        password.click();
        password.sendKeys("");
        nextPassword.click();
    }

    public boolean plusdisabled() {
        boolean disabledbutton = buttonDisabled.isEnabled();
        if (disabledbutton) {
            return false;
        }
        return true;
    }

    public void addToBagPageChanel() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.sendKeys("Chanel");
        searchBtn.click();
        Thread.sleep(50000);
        luxaryproduct.click();
        Thread.sleep(50000);
        chanelplptitle.click();
        Thread.sleep(50000);
        chanelAddtobag.click();
        Thread.sleep(5000);
        checkoutChanel.click();
    }

    public void incremenetProduct() throws InterruptedException {
        Thread.sleep(6000);
        addmore.click();
        Thread.sleep(10000);

    }

    public Bag(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        random = new Random();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean orderSummary() throws InterruptedException {
        Thread.sleep(10000);
        return orderSummary.getText().contains("Order Summary");
    }

    public void checkout() throws InterruptedException {
        Thread.sleep(5000);
        checkout.click();
    }

    public void goToCheckoutShippingAddress() throws InterruptedException {
        Thread.sleep(30000);
        wait.until(ExpectedConditions.visibilityOf(guestEmailField));
        guestEmailField.sendKeys("sdmweb@yopmail.com");
        checkoutAsGuestButton.click();
    }

    public boolean booleantotalBeforeTax() throws InterruptedException {
        Thread.sleep(4000);
        return totalBeforeTax.getText().contains("TOTAL BEFORE TAXES");
    }

    public boolean productOnCart() throws InterruptedException {
        Thread.sleep(10000);
        return productImage.isDisplayed();
    }

    public boolean freeSample() throws InterruptedException {
        Thread.sleep(10000);
        return freeSample.getText().contains("Free Samples");
    }

    public boolean freesampleOnCart() throws InterruptedException {
        Thread.sleep(4000);
        return freesampleOnCart.getText().contains("Free Gift");
    }

    public boolean noProduct() throws InterruptedException {
        Thread.sleep(5000);
        return noProduct.getText().contains("Psst, your shopping bag is empty!");
    }

    public void removeProduct() throws InterruptedException {
        Thread.sleep(10000);
        remove.click();
    }

    public void setSearchBoxMultiple(String searchTerm) {
        searchBox.sendKeys(searchTerm);
        productName = searchTerm;
    }

    public void addChanelProduct() throws InterruptedException {
        setSearchBoxMultiple("Chanel");
        goToBagPage();
    }

    public boolean shippingPrice() throws InterruptedException {
        Thread.sleep(5000);
        return shipping.getText().contains("Shipping") && shippingprice.getText().contains("$8");
    }

    public boolean shippingPriceFree() throws InterruptedException {
        Thread.sleep(50000);
        return shipping.getText().contains("Shipping") && shippingprice.getText().contains("FREE");
    }

    public void goToBagPage() throws InterruptedException {

        searchBtn.click();
        Thread.sleep(10000);
        plpTile.click();
        Log.info("after pdp click");
        Thread.sleep(60000);
        addToBagFromQuickView.click();
        Thread.sleep(6000);
        viewBagButtonFromQuickView.click();
    }

    public void shopClick() throws InterruptedException {
        Thread.sleep(400);
        shop.click();
    }

    public void bagClick() throws InterruptedException {
        Thread.sleep(3000);
        bag.click();
    }

    public void addFreeSamples() throws InterruptedException {
        Thread.sleep(5000);
        firstSample.click();
        Thread.sleep(4000);
        secondSample.click();
        Thread.sleep(4000);
        thirdSample.click();
        Thread.sleep(3000);
    }

    public boolean sampleDisabled() {
        boolean disabledbutton = fourthSample.isEnabled();
        if (disabledbutton) {
            return false;
        }
        return true;
    }


}
