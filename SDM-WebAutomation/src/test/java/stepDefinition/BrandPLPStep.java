package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.TestContextSetup;

public class BrandPLPStep {

    TestContextSetup tcs;

    public BrandPLPStep(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    @Given("I am viewing the Brand Landing Page")
    public void iAmViewingTheBrandLandingPage() throws InterruptedException {

        Assert.assertTrue(tcs.pom.getBrandPage().searchBrand("chanel"));
    }

    @When("The page Loads")
    public void thePageLoads() {
    }

    @Then("I can see the Logo as well as a large display of brand \\(mostly luxury beauty brands)")
    public void iCanSeeTheLogoAsWellAsALargeDisplayOfBrandMostlyLuxuryBeautyBrands() throws InterruptedException {

        Assert.assertTrue(tcs.pom.getBrandPage().isBrandDisplay());
    }


    @Given("I am viewing the Brand Landing Page \\(Chanel)")
    public void iAmViewingTheBrandLandingPageChanel() throws InterruptedException {

        Assert.assertTrue(tcs.pom.getBrandPage().searchBrand("chanel"));
    }

    @When("Clicking on header links")
    public void clickingOnHeaderLinks() throws InterruptedException {

        Assert.assertTrue(tcs.pom.getBrandPage().clickOnHeader());

    }

    @Then("Takes me to the appropriate section of that brand")
    public void takesMeToTheAppropriateSectionOfThatBrand() {

        Assert.assertTrue(tcs.pom.getBrandPage().verifyHeaderClick());
    }

    @Given("I am viewing a Brand CLP")
    public void iAmViewingABrandCLP() throws InterruptedException {

        Assert.assertTrue(tcs.pom.getBrandPage().searchBrand("chanel"));
        Assert.assertTrue(tcs.pom.getBrandPage().clickOnHeader());


    }

    @Then("I cannot see product badging \\(Chanel) but I can for others \\(Dior)")
    public void iCannotSeeProductBadgingChanelButICanForOthersDior() throws InterruptedException {

        Assert.assertFalse(tcs.pom.getBrandPage().checkBadges());

        Assert.assertTrue(tcs.pom.getBrandPage().searchBrand("Dior"));

        Assert.assertTrue(tcs.pom.getBrandPage().checkBadges());
    }


    @Then("I can see the product brand indicated")
    public void iCanSeeTheProductBrandIndicated() {

        Assert.assertTrue(tcs.pom.getBrandPage().verifyProductBrandName());
    }

    @Then("I can see the product name indicated")
    public void iCanSeeTheProductNameIndicated() {

        Assert.assertTrue(tcs.pom.getBrandPage().verifyProductName());
    }


    @Then("I can see the product price or price range indicated")
    public void iCanSeeTheProductPricePriceRangeIndicated() {

        Assert.assertTrue(tcs.pom.getBrandPage().verifyProductPrice());

    }

    @Then("I cannot see the favourite option for certain BCLP \\(Chanel) but i can for others \\(Dior)")
    public void iCannotSeeTheFavouriteOptionForCertainBCLPChanelButICanForOthersDior() throws InterruptedException {


        Assert.assertFalse(tcs.pom.getBrandPage().checkFavouriteOption());

        Assert.assertTrue(tcs.pom.getBrandPage().searchBrand("Dior"));

        Assert.assertTrue(tcs.pom.getBrandPage().checkFavouriteOption());

    }

    @Then("I can see the brand header")
    public void iCanSeeTheBrandHeader() {

        Assert.assertTrue(tcs.pom.getBrandPage().checkBrandHeader());

    }

    @Given("I am on a Brand PLP")
    public void iAmOnABrandPLP() throws InterruptedException {

        Assert.assertTrue(tcs.pom.getBrandPage().searchBrand("chanel"));
        Assert.assertTrue(tcs.pom.getBrandPage().clickOnHeader());
    }

    @Then("Then I don't see a brands filter in the filters list")
    public void thenIDonTSeeABrandsFilterInTheFiltersList() {

        Assert.assertFalse(tcs.pom.getBrandPage().checkFilterList());
    }


    @Then("I cannot see the rating or size option for certain BCLP \\(Chanel) but I can for others \\(Dior)")
    public void iCannotSeeTheRatingOrSizeOptionForCertainBCLPChanelButICanForOthersDior() throws InterruptedException {

        Assert.assertFalse(tcs.pom.getBrandPage().checkRatingOption());

        Assert.assertTrue(tcs.pom.getBrandPage().searchBrand("Dior"));

        Assert.assertTrue(tcs.pom.getBrandPage().checkRatingOption());

    }

}
