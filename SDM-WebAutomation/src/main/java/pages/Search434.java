package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Search434 {
    WebDriver driver;
    WebDriverWait wait;

    public Search434(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    String search1 = "dior perfume";
    @FindBy(css = "input[type='text']")
    WebElement searchBar;


    @FindBy(css = ".plp__pageHeading__zUcEq.plp__resultsHeading__SXLWG")
    WebElement titleOfSearch;

    @FindBy(css = "img[alt='Shoppers Drug Mart']")
    WebElement websiteLogo;

    @FindBy(css = "div[class='plp__productResultsBody__3f9qv']")
    WebElement productList;

    @FindBy(css = "p[data-testid='breadcrumb1']")
    WebElement searchPathText;

    @FindBy(css = "a[class='plp__breadcrumbLink__PGAYA']")
    WebElement shopLink;


    @FindBy(css = "img[alt='arrow']")
    WebElement breadcrumbsArrow;

    @FindBy(css = "button[id='desktop-sort-dropdown-button']")
    WebElement relevanceDropDown;

    @FindBy(css = "li[data-value='relevance'] button[class='plp__listItemBtn__UhHM4']")
    WebElement relevance;

    @FindBy(css = "li[data-value='price-asc'] button[class='plp__listItemBtn__UhHM4']")
    public WebElement lowToHigh;

    @FindBy(css = "li[data-value='price-desc'] button[class='plp__listItemBtn__UhHM4']")
    public WebElement highToLow;

    @FindBy(css = "li[data-value='newest'] button[class='plp__listItemBtn__UhHM4']")
    public WebElement newest;

    @FindBy(css = "li[data-value='trending'] button[class='plp__listItemBtn__UhHM4']")
    public WebElement recommended;


    public void writeInSearchBar(String searchText) {
        wait.until(ExpectedConditions.visibilityOfAllElements(searchBar));
        searchBar.click();
        searchBar.sendKeys(searchText);
    }

    public boolean hitOnSearch() {
        String preURL = driver.getCurrentUrl();
        driver.findElement(By.cssSelector("img[alt='Search']")).click();
        String postURL = driver.getCurrentUrl();
        return !preURL.equals(postURL);
    }

    public boolean verifyTitleOfSearch(String searchText) {
        wait.until(ExpectedConditions.visibilityOfAllElements(titleOfSearch));
        String title = titleOfSearch.getText().split("\"")[1].split("\"")[0];
        return title.equals(searchText);
    }

    public boolean verifyPLP() {
        wait.until(ExpectedConditions.visibilityOfAllElements(titleOfSearch));
        List<WebElement> listedPLP = driver.findElements(By.cssSelector(".plp__brandName__n-pQ0"));
        for (WebElement brandName : listedPLP) {
            if (brandName.getText().contains("Dior") || brandName.getText().equals("J'Adore") || brandName.getText().equals("Sauvage"))
                continue;
            else
                return false;
        }
        return true;
    }

    public boolean checkVariants() {
        wait.until(ExpectedConditions.visibilityOfAllElements(titleOfSearch));
        List<WebElement> listedPLP = driver.findElements(By.cssSelector("div[class='plp__productResultsBody__3f9qv']"));
        for (WebElement productTitle : listedPLP) {
            if (productTitle.getText().contains("size") || productTitle.getText().contains("colours"))
                return true;
        }
        return false;
    }


    public boolean verifyShopLinkOnSearchPage() {
        wait.until(ExpectedConditions.visibilityOfAllElements(shopLink));
        String preURL = driver.getCurrentUrl();
        shopLink.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(websiteLogo));
        String postURL = driver.getCurrentUrl();
        return !preURL.equals(postURL);

    }

    public boolean verifySearchPathContainText(String searchText) {
        wait.until(ExpectedConditions.visibilityOfAllElements(searchPathText));
        String pathText = searchPathText.getText().split(":")[1].trim();
        return pathText.equals(searchText);
    }


    public boolean verifyBreadcrumbs() {
        wait.until(ExpectedConditions.visibilityOfAllElements(breadcrumbsArrow));
        List<WebElement> arrows = driver.findElements(By.cssSelector("img[alt='arrow']"));
        return arrows.size() >= 1;
    }

    public boolean verifyShopLinkIsDisplay() {
        wait.until(ExpectedConditions.visibilityOfAllElements(shopLink));
        return shopLink.isDisplayed();

    }

    public boolean validateSRPSortOption(){
        wait.until(ExpectedConditions.visibilityOf(relevanceDropDown));
        relevanceDropDown.click();
        wait.until(ExpectedConditions.visibilityOf(relevance));
        List<Boolean> optionVisibilities = new ArrayList<>();
        optionVisibilities.add(relevance.isDisplayed());
        optionVisibilities.add(lowToHigh.isDisplayed());
        optionVisibilities.add(highToLow.isDisplayed());
        optionVisibilities.add(newest.isDisplayed());
        for(Boolean result : optionVisibilities){
            if(result.equals(false))
                return false;
        }
            return true;
    }

    public boolean validateCLPSortOption(){
        wait.until(ExpectedConditions.visibilityOf(relevanceDropDown));
        relevanceDropDown.click();
        wait.until(ExpectedConditions.visibilityOf(recommended));
        List<Boolean> optionVisibilities = new ArrayList<>();
        optionVisibilities.add(recommended.isDisplayed());
        optionVisibilities.add(lowToHigh.isDisplayed());
        optionVisibilities.add(highToLow.isDisplayed());
        optionVisibilities.add(newest.isDisplayed());
        for(Boolean result : optionVisibilities){
            if(result.equals(false))
                return false;
        }
        return true;
    }


}
