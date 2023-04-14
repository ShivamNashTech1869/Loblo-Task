package pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    WebDriver driver;
    HomePage homePage;
    Footer footer;

    Navigation navigation;

    Bag bag;

    PdpPage pdpPage;
    PlpPage plp;

    Search434 searchPageClass;

    public PageObjectManager(WebDriver driver){
        this.driver=driver;
    }

    public HomePage getHomePage(){
        homePage=new HomePage(driver);
        return homePage;
    }
    public Bag bag() {
        bag=new Bag(driver);
        return bag;
    }
    public Footer getFooter(){
        footer=new Footer(driver);
        return footer;
    }

    public PdpPage getPdpPage(){
        pdpPage=new PdpPage(driver);
        return pdpPage;
    }

    public PlpPage getPlp(){
        plp=new PlpPage(driver);
        return plp;
    }


    public Navigation getNavigation() {
        navigation = new Navigation(driver);
        return navigation;
    }

    public Search434 getSearch434(){
        searchPageClass=new Search434(driver);
        return searchPageClass;
    }

    public SearchPage getSearchPage(){
        return new SearchPage(driver);
    }
}
