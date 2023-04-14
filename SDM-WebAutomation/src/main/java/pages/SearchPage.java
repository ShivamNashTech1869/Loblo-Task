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
import java.util.Random;

public class SearchPage {

    WebDriver driver;
    Random random;
    WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        random = new Random();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(className = "plp__productResultsBody__3f9qv")
    public WebElement brandPlpPage;
    @FindBy(xpath ="//*[@name='text']")
    public WebElement searchTextField;
    @FindBy(xpath = "(//*[@type='submit'])[1]")
    public WebElement clickSearchButton;

    By brandName = By.xpath("//*[@class='plp__brandName__n-pQ0']");

    public List<WebElement> getBrandName() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(brandName));
        return driver.findElements(brandName);

    }

}
