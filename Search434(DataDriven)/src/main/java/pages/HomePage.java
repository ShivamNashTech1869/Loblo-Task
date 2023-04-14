package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    public HomePage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @FindBy(css ="img.plp__sdmLogo__2OSbd0")
    WebElement sdmLogo;

    public boolean validateHomePage(){
        wait.until(ExpectedConditions.visibilityOf(sdmLogo));
        return sdmLogo.isDisplayed();
    }
}
