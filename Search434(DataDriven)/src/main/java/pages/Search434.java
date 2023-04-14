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
import java.util.logging.Logger;

public class Search434 {
    WebDriver driver;
    WebDriverWait wait;

    java.util.logging.Logger log = Logger.getLogger(getClass().getName());

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

    @FindBy(css = "li[class*='plp__breadcrumb']")
    WebElement breadcrumbsList;

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

    @FindBy(css= "p[class='plp__statusText__3vD_0']")
    WebElement outOfStock;


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
        log.info("Search Text : "+searchText +"\nTitle of search is :" + titleOfSearch.getText());
        String title = titleOfSearch.getText().split("\"")[1].split("\"")[0];
        return title.equals(searchText);
    }

    public boolean verifyPLP(String plpData1 , String plpData2 , String plpData3) {
        wait.until(ExpectedConditions.visibilityOfAllElements(titleOfSearch));
        List<WebElement> listedPLP = driver.findElements(By.cssSelector(".plp__brandName__n-pQ0"));
        for (WebElement brandName : listedPLP) {
            if (brandName.getText().contains(plpData1) || brandName.getText().equals(plpData2) || brandName.getText().equals(plpData3))
                continue;
            else
                return false;
        }
        return true;
    }

    public boolean checkVariants(String variant1 , String variant2) {
        wait.until(ExpectedConditions.visibilityOfAllElements(titleOfSearch));
        List<WebElement> listedPLP = driver.findElements(By.cssSelector("div[class='plp__productResultsBody__3f9qv']"));
        for (WebElement productTitle : listedPLP) {
            if (productTitle.getText().contains(variant1) || productTitle.getText().contains(variant2)) {
                log.info("variants '" + variant1 + "' and '" + variant2 + "' are found in a displayed product.");
                return true;
            }
        }
        log.info("variants '" + variant1 + "' and '" + variant2 + "' are NOT found in a displayed product.");
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
        log.info("Search text : "+searchText+"\nSearch path : "+searchPathText.getText());
        String pathText = searchPathText.getText().split(":")[1].trim();
        return pathText.equals(searchText);
    }


    public boolean verifyBreadcrumbs() {
        wait.until(ExpectedConditions.visibilityOfAllElements(breadcrumbsArrow));
        List<WebElement> arrows = driver.findElements(By.cssSelector("img[alt='arrow']"));
        List<WebElement> l = driver.findElements(By.cssSelector("li[class*='plp__breadcrumb']"));
        if(arrows.size() >= 1){
          log.info("Breadcrumbs found :  ");
          for(WebElement currentElement : l)
              log.info(currentElement.getText() + " > ");
          return true;
        }
        log.info("Breadcrumbs NOT found :  ");
        return false;
    }

    public boolean verifyShopLinkIsDisplay() {
        wait.until(ExpectedConditions.visibilityOfAllElements(shopLink));
        if(shopLink.isDisplayed()){
            log.info("Yes Shop Link is Display on Landing page :  ");
            return true;
        }
        else{
            log.info("No Shop Link is NOT Display on Landing page :  ");
            return false;
        }

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
            if(result.equals(false)) {
                log.info("All option are not visible in sort option ");
                return false;
            }
        }
        log.info("All option are visible in sort option ");
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
            if(result.equals(false)) {
                log.info("All option are not visible in sort option ");
                return false;
            }
        }
        log.info("All option are visible in sort option ");
        return true;
    }


    public boolean validateDisplayRelevantVariant(){
        wait.until(ExpectedConditions.visibilityOfAllElements(titleOfSearch));
        List<WebElement> listOfOutOfStockProducts = driver.findElements(By.cssSelector("p[class='plp__statusText__3vD_0']"));
        if(listOfOutOfStockProducts.size()>0){
            log.info("Out of stock elements are Display :");
            return true;
        }
        else {
            log.info("Out of stock product are not Display on page :");
            return false;
        }

    }
}
