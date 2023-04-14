package pages;

import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    WebDriver driver;
    HomePage homePage;
    Footer footer;

    BrandPLP branchPageClass;

    Search434 searchPageClass;

    public PageObjectManager(WebDriver driver){
        this.driver=driver;
    }

    public HomePage getHomePage(){
        homePage=new HomePage(driver);
        return homePage;
    }

    public Footer getFooter(){
        footer=new Footer(driver);
        return footer;
    }

    public BrandPLP getBrandPage(){
        branchPageClass=new BrandPLP(driver);
        return branchPageClass;
    }

  public Search434 getSearch434(){
        searchPageClass=new Search434(driver);
        return searchPageClass;
  }

  public SearchPage getSearchPage(){
        return new SearchPage(driver);
  }
}
