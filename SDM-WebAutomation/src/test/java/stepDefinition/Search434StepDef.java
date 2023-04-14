package stepDefinition;

import util.Common;
import ddtConfig.DataReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.TestContextSetup;

public class Search434StepDef {

    TestContextSetup tcs;

    public Search434StepDef(TestContextSetup tcs) {
        this.tcs = tcs;
    }



    String search1 = "dior perfume";
    String search2 = "cream";
    String search3 = "Pharmaprix Product Assortment";


    @Given("I have entered a search term in the search box")
    public void iHaveEnteredASearchTermInTheSearchBox(DataReader dataReader) {
        String search = Common.dataExtractorFromSheet(dataReader, "Search1");
        System.out.println(search);
        tcs.pom.getSearch434().writeInSearchBar(search);
    }

    @When("I hit enter")
    public void iHitEnter() {

        Assert.assertTrue(tcs.pom.getSearch434().hitOnSearch());
    }

    @Then("I should see the search term in the title of SRP")
    public void iShouldSeeTheSearchTermInTheTitleOfSRP() {

        Assert.assertTrue(tcs.pom.getSearch434().verifyTitleOfSearch(search1));
    }

    @Then("I should see the resulting PLP from search term")
    public void iShouldSeeTheResultingPLPFromSearchTerm() {

        Assert.assertTrue(tcs.pom.getSearch434().verifyPLP());
    }

    @Given("I have entered a search term in the search box\\(Pharmaprix Product Assortment)")
    public void iHaveEnteredASearchTermInTheSearchBoxPharmaprixProductAssortment() {

        tcs.pom.getSearch434().writeInSearchBar(search3);
    }

    @Then("I should only see products that are part of the Pharmaprix Assortment")
    public void iShouldOnlySeeProductsThatArePartOfThePharmaprixAssortment() {

        Assert.assertTrue(tcs.pom.getSearch434().verifyTitleOfSearch(search3));
    }

    @Given("An item has multiple variants")
    public void anItemHasMultipleVariants() {

        tcs.pom.getSearch434().writeInSearchBar(search2);
        Assert.assertTrue(tcs.pom.getSearch434().hitOnSearch());

    }

    @When("The product is displayed on a PLP")
    public void theProductIsDisplayedOnAPLP() {

        Assert.assertTrue(tcs.pom.getSearch434().verifyTitleOfSearch(search2));
    }

    @Then("All colour and size variants should be grouped into a single product tile and there should be a count that indicates the number of variants")
    public void AllColourAndSizeVariantsShouldBeGroupedIntoASingleProductTileAndThereShouldBeACountThatIndicatesTheNumberOfVariants() {

        Assert.assertTrue(tcs.pom.getSearch434().checkVariants());
    }

    @Given("I've executed a search query")
    public void iVeExecutedASearchQuery() {

        tcs.pom.getSearch434().writeInSearchBar(search2);
        Assert.assertTrue(tcs.pom.getSearch434().hitOnSearch());
    }

    @When("I land on the SRP")
    public void iLandOnTheSRP() {

        Assert.assertTrue(tcs.pom.getSearch434().verifyTitleOfSearch(search2));
    }


    @Then("I should see the Shop link on the search page followed by the result text for the search term And the Shop link should be clickable")
    public void iShouldSeeTheShopLinkOnTheSearchPageFollowedByTheResultTextForTheSearchTermAndTheShopLinkShouldBeClickable() {

        Assert.assertTrue(tcs.pom.getSearch434().verifySearchPathContainText(search2));
        Assert.assertTrue(tcs.pom.getSearch434().verifyShopLinkOnSearchPage());

    }

    @Given("I search a specific category \\(e.g. {string}) that has a redirect associated")
    public void iSearchASpecificCategoryEGThatHasARedirectAssociated(String searchProduct) {

        tcs.pom.getSearch434().writeInSearchBar(searchProduct);
    }

    @Then("I should arrive at a category PLP, showing breadcrumbs for category tree")
    public void iShouldArriveAtACategoryPLPShowingBreadcrumbsForCategoryTree() {

        Assert.assertTrue(tcs.pom.getSearch434().verifyBreadcrumbs());

    }

    @Given("I search a term that does not correspond to a product type or brand")
    public void iSearchATermThatDoesNotCorrespondToAProductTypeOrBrand() {

        tcs.pom.getSearch434().writeInSearchBar(search2);
    }

    @Then("Breadcrumb should reflect Shop; Search [search term] and show the results related to my search term")
    public void breadcrumbShouldReflectShopSearchSearchTermAndShowTheResultsRelatedToMySearchTerm() {

        Assert.assertTrue(tcs.pom.getSearch434().verifyShopLinkIsDisplay());
        Assert.assertTrue(tcs.pom.getSearch434().verifySearchPathContainText(search2));
        Assert.assertTrue(tcs.pom.getSearch434().verifyTitleOfSearch(search2));
    }

    @Given("I search a specific product UPC")
    public void iSearchASpecificProductUPC() {

        tcs.pom.getSearch434().writeInSearchBar(search1);
    }

    @Then("It should return a SRP which has just the product that was searched.")
    public void itShouldReturnASRPWhichHasJustTheProductThatWasSearched() {

        Assert.assertTrue(tcs.pom.getSearch434().verifyTitleOfSearch(search1));
    }

    @Then("I should see my search term on the top left default sort -  relevance")
    public void iShouldSeeMySearchTermOnTheTopLeftWDefaultSortRelevance() {

        Assert.assertTrue(tcs.pom.getSearch434().verifyTitleOfSearch(search1));
    }


    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        
    }


    @When("I execute a search based on a search term {string} that takes me to an SRP")
    public void iExecuteASearchBasedOnASearchTermThatTakesMeToAnSRP(String searchProduct) {
        tcs.pom.getSearch434().writeInSearchBar(searchProduct);
        Assert.assertTrue(tcs.pom.getSearch434().hitOnSearch());
        Assert.assertTrue(tcs.pom.getSearch434().verifyTitleOfSearch(searchProduct));
    }

    @Then("The results displayed on the SRP will have the below sort options, with the first being the default: Relevance Price: Low to High Price: High to Low Newest")
    public void theResultsDisplayedOnTheSRPWillHaveTheBelowSortOptionsWithTheFirstBeingTheDefaultRelevancePriceLowToHighPriceHighToLowNewest() {
        Assert.assertTrue(tcs.pom.getSearch434().validateSRPSortOption());
    }

    @When("I execute a search for a mapped keyword that takes me to a CLP {string}")
    public void iExecuteASearchForAMappedKeywordThatTakesMeToACLP(String searchProduct) {
        tcs.pom.getSearch434().writeInSearchBar(searchProduct);
        Assert.assertTrue(tcs.pom.getSearch434().hitOnSearch());
//        Assert.assertTrue(tcs.pom.getSearch434().verifyTitleOfSearch(searchProduct));
    }


    @Then("The results displayed on the CLP will have the below sort options, with the first being the default: Recommended Price: Low to High Price: High to Low Newest")
    public void theResultsDisplayedOnTheCLPWillHaveTheBelowSortOptionsWithTheFirstBeingTheDefaultRecommendedPriceLowToHighPriceHighToLowNewest() {
        Assert.assertTrue(tcs.pom.getSearch434().validateCLPSortOption());
    }


    @Given("I am on any search or listing page {string}")
    public void iAmOnAnySearchOrListingPage(String searchProduct) {
        tcs.pom.getSearch434().writeInSearchBar(searchProduct);
        Assert.assertTrue(tcs.pom.getSearch434().hitOnSearch());
        Assert.assertTrue(tcs.pom.getSearch434().verifyTitleOfSearch(searchProduct));
    }

    @When("I view the filters")
    public void iViewTheFilters() {

    }

    @Then("I should see the facet count next to each filter to denote the number of products with that below facets:")
    public void IShouldSeeTheFacetCountNextToEachFilterToDenoteTheNumberOfProductsWithThatBelowFacets() {

    }

    @Given("I have entered a search term in the search box for demo test")
    public void i_have_entered_a_search_term_in_the_search_box_for_demo_test(DataReader dataReader) {
        String search = Common.dataExtractorFromSheet(dataReader, "Search1");
        System.out.println(search);
        tcs.pom.getSearch434().writeInSearchBar(search);

    }
    @When("I hit enter demo")
    public void i_hit_enter_demo() {
        Assert.assertTrue(tcs.pom.getSearch434().hitOnSearch());
    }
    @Then("I should see the search term in the title of SRP demo")
    public void i_should_see_the_search_term_in_the_title_of_srp_demo(DataReader dataReader) {
        String search = Common.dataExtractorFromSheet(dataReader, "Search1");
        Assert.assertTrue(tcs.pom.getSearch434().verifyTitleOfSearch(search));
    }
}
