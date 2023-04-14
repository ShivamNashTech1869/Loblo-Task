package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BrandPLP {

    WebDriver driver;
    WebDriverWait wait;

    public BrandPLP(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }


    @FindBy(css = "input[type='text']")
    WebElement searchBar;

    @FindBy(xpath = "//h2[normalize-space()='CHANEL']")
    WebElement logo;

    @FindBy(css = "img[alt='chanel coco mademoiselle.']")
    WebElement brand1;

    @FindBy(css = "div[class='plp__bannerImage__1DIlA plp__imageBanner__26fd3']")
    WebElement brand2;

    @FindBy(css = "ul[id='chanel-left-side-nav'] a[class='active']")
    WebElement clickableHeader;

    @FindBy(css = "li.subcategory:nth-child(6) > a:nth-child(1)")
    WebElement headerMakeup1;

    @FindBy(xpath = "//a[normalize-space()='Makeup']")
    WebElement headerMakeup2;

    @FindBy(css = "p[class='product-brand-name']")
    WebElement productBrandName;

    @FindBy(css = "p[class='product-line-name']")
    WebElement productName;

    @FindBy(css = "p[class='product-price']")
    WebElement productPrice;

    @FindBy(css = "a[class='chanel-header']")
    WebElement chanelHeader;

    @FindBy(css = "div[class='lds__accordion plp__filterGroup__dcC05']")
    WebElement brandFilterList;

    @FindBy(css = "img[alt='Shoppers Drug Mart']")
    WebElement websiteLogo;

    By badgeSelector = By.cssSelector("div[class='plp__ribbonWrapper__GHKpz']");
    By heartSelector = By.cssSelector("img[alt='heart']");
    By ratingSelector = By.cssSelector("div[class='plp__ratingContainer__OI4tH']");
    By filterListSelector = By.cssSelector("div[class='lds__accordion plp__filterGroup__dcC05']");

    public boolean searchBrand(String searchText) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfAllElements(searchBar));
        String preURL = driver.getCurrentUrl();
        searchBar.click();
        searchBar.sendKeys(searchText);
        driver.findElement(By.cssSelector("img[alt='Search']")).click();
        String postURL = driver.getCurrentUrl();
        if (preURL.equals(postURL))
            return false;
        else
            return true;
    }

    public boolean isBrandDisplay() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfAllElements(websiteLogo));
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(brand1));
            if (logo.isDisplayed() && brand1.isDisplayed())
                return true;
            else
                return false;
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfAllElements(brand2));
            if (logo.isDisplayed() && brand2.isDisplayed())
                return true;
            else
                return false;
        }
    }

    public boolean clickOnHeader() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfAllElements(websiteLogo));
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(headerMakeup1));
            String preURL = driver.getCurrentUrl();
            headerMakeup1.click();
            String postURL = driver.getCurrentUrl();
            if (preURL.equals(postURL))
                return false;
            else
                return true;
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfAllElements(headerMakeup2));
            String preURL = driver.getCurrentUrl();
            headerMakeup2.click();
            String postURL = driver.getCurrentUrl();
            if (preURL.equals(postURL))
                return false;
            else
                return true;
        }
    }

    public boolean verifyHeaderClick() {
        wait.until(ExpectedConditions.visibilityOfAllElements(clickableHeader));
        return clickableHeader.getText().equals("MAKEUP");

    }

    public boolean checkBadges() {
        wait.until(ExpectedConditions.visibilityOfAllElements(websiteLogo));
        List<WebElement> badges = driver.findElements(badgeSelector);
        if (badges.size() >= 1)
            return true;
        else
            return false;

    }


    public boolean verifyProductBrandName() {
        wait.until(ExpectedConditions.visibilityOfAllElements(productBrandName));
        return productBrandName.isDisplayed();
    }

    public boolean verifyProductName() {
        wait.until(ExpectedConditions.visibilityOfAllElements(productName));
        return productName.isDisplayed();
    }

    public boolean verifyProductPrice() {
        wait.until(ExpectedConditions.visibilityOfAllElements(productPrice));
        return productPrice.isDisplayed();
    }

    public boolean checkFavouriteOption() {
        wait.until(ExpectedConditions.visibilityOfAllElements(websiteLogo));
        List<WebElement> hearts = driver.findElements(heartSelector);
        if (hearts.size() >= 1)
            return true;
        else
            return false;
    }

    public boolean checkBrandHeader() {
        wait.until(ExpectedConditions.visibilityOfAllElements(chanelHeader));
        return chanelHeader.isDisplayed();
    }

    public boolean checkRatingOption() {
        wait.until(ExpectedConditions.visibilityOfAllElements(websiteLogo));
        List<WebElement> ratings = driver.findElements(ratingSelector);
        if (ratings.size() >= 1)
            return true;
        else
            return false;
    }

    public boolean checkFilterList() {
        List<WebElement> filterLists = driver.findElements(filterListSelector);
        if (filterLists.size() >= 1)
            return true;
        else
            return false;

    }

}

