package stepDefinition;

import ddtConfig.DataReader;
import freemarker.template.DefaultArrayAdapter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.Common;
import util.TestContextSetup;

import javax.xml.crypto.Data;

public class Search434StepDef {

    TestContextSetup tcs;

    public Search434StepDef(TestContextSetup tcs) {
        this.tcs = tcs;
    }


    @Given("I have entered a search term in the search box")
    public void iHaveEnteredASearchTermInTheSearchBox(DataReader dataReader) {

        String search = Common.dataExtractorFromSheet(dataReader, "SearchProduct1");
        tcs.pom.getSearch434().writeInSearchBar(search);
    }

    @When("I hit enter")
    public void iHitEnter() {

        Assert.assertTrue(tcs.pom.getSearch434().hitOnSearch());
    }

    @Then("I should see the search term in the title of SRP")
    public void iShouldSeeTheSearchTermInTheTitleOfSRP(DataReader dataReader) {
        String search = Common.dataExtractorFromSheet(dataReader, "SearchProduct1");
        Assert.assertTrue(tcs.pom.getSearch434().verifyTitleOfSearch(search));
    }

    @Then("I should see the resulting PLP from search term")
    public void iShouldSeeTheResultingPLPFromSearchTerm(DataReader dataReader) {

        String plpData1 = Common.dataExtractorFromSheet(dataReader, "PLPData1");
        String plpData2 = Common.dataExtractorFromSheet(dataReader, "PLPData2");
        String plpData3 = Common.dataExtractorFromSheet(dataReader, "PLPData3");
        Assert.assertTrue(tcs.pom.getSearch434().verifyPLP(plpData1, plpData2, plpData3));
    }

    @Given("I have entered a search term in the search box\\(Pharmaprix Product Assortment)")
    public void iHaveEnteredASearchTermInTheSearchBoxPharmaprixProductAssortment(DataReader dataReader) {
        String search = Common.dataExtractorFromSheet(dataReader, "SearchProduct3");
        tcs.pom.getSearch434().writeInSearchBar(search);
    }

    @Then("I should only see products that are part of the Pharmaprix Assortment")
    public void iShouldOnlySeeProductsThatArePartOfThePharmaprixAssortment(DataReader dataReader) {
        String search = Common.dataExtractorFromSheet(dataReader, "SearchProduct3");
        Assert.assertTrue(tcs.pom.getSearch434().verifyTitleOfSearch(search));
    }

    @Given("An item has multiple variants")
    public void anItemHasMultipleVariants(DataReader dataReader) {
        String search = Common.dataExtractorFromSheet(dataReader, "SearchProduct2");
        tcs.pom.getSearch434().writeInSearchBar(search);
        Assert.assertTrue(tcs.pom.getSearch434().hitOnSearch());

    }

    @When("The product is displayed on a PLP")
    public void theProductIsDisplayedOnAPLP(DataReader dataReader) {
        String search = Common.dataExtractorFromSheet(dataReader, "SearchProduct2");
        Assert.assertTrue(tcs.pom.getSearch434().verifyTitleOfSearch(search));
    }

    @Then("All colour and size variants should be grouped into a single product tile and there should be a count that indicates the number of variants")
    public void AllColourAndSizeVariantsShouldBeGroupedIntoASingleProductTileAndThereShouldBeACountThatIndicatesTheNumberOfVariants(DataReader dataReader) {
        String variant1 = Common.dataExtractorFromSheet(dataReader, "Variant1");
        String variant2 = Common.dataExtractorFromSheet(dataReader, "Variant2");
        Assert.assertTrue(tcs.pom.getSearch434().checkVariants(variant1, variant2));
    }

    @Given("I've executed a search query")
    public void iVeExecutedASearchQuery(DataReader dataReader) {
        String search = Common.dataExtractorFromSheet(dataReader, "SearchProduct2");
        tcs.pom.getSearch434().writeInSearchBar(search);
        Assert.assertTrue(tcs.pom.getSearch434().hitOnSearch());
    }

    @When("I land on the SRP")
    public void iLandOnTheSRP(DataReader dataReader) {
        String search = Common.dataExtractorFromSheet(dataReader, "SearchProduct2");
        Assert.assertTrue(tcs.pom.getSearch434().verifyTitleOfSearch(search));
    }


    @Then("I should see the Shop link on the search page followed by the result text for the search term And the Shop link should be clickable")
    public void iShouldSeeTheShopLinkOnTheSearchPageFollowedByTheResultTextForTheSearchTermAndTheShopLinkShouldBeClickable(DataReader dataReader) {
        String search = Common.dataExtractorFromSheet(dataReader, "SearchProduct2");
        Assert.assertTrue(tcs.pom.getSearch434().verifySearchPathContainText(search));
        Assert.assertTrue(tcs.pom.getSearch434().verifyShopLinkOnSearchPage());

    }

    @Given("I search a specific category \\(e.g. Body Wash) that has a redirect associated")  //Body Wash
    public void iSearchASpecificCategoryEGThatHasARedirectAssociated(DataReader dataReader) {
        String searchProduct = Common.dataExtractorFromSheet(dataReader, "SearchProduct4");
        tcs.pom.getSearch434().writeInSearchBar(searchProduct);
    }

    @Then("I should arrive at a category PLP, showing breadcrumbs for category tree")
    public void iShouldArriveAtACategoryPLPShowingBreadcrumbsForCategoryTree() {

        Assert.assertTrue(tcs.pom.getSearch434().verifyBreadcrumbs());

    }

    @Given("I search a term that does not correspond to a product type or brand")
    public void iSearchATermThatDoesNotCorrespondToAProductTypeOrBrand(DataReader dataReader) {

        String search = Common.dataExtractorFromSheet(dataReader, "SearchProduct2");
        tcs.pom.getSearch434().writeInSearchBar(search);
    }

    @Then("Breadcrumb should reflect Shop; Search [search term] and show the results related to my search term")
    public void breadcrumbShouldReflectShopSearchSearchTermAndShowTheResultsRelatedToMySearchTerm(DataReader dataReader) {

        String search = Common.dataExtractorFromSheet(dataReader, "SearchProduct2");
        Assert.assertTrue(tcs.pom.getSearch434().verifyShopLinkIsDisplay());
        Assert.assertTrue(tcs.pom.getSearch434().verifySearchPathContainText(search));
        Assert.assertTrue(tcs.pom.getSearch434().verifyTitleOfSearch(search));
    }

    @Given("I search a specific product UPC")
    public void iSearchASpecificProductUPC(DataReader dataReader) {
        String search = Common.dataExtractorFromSheet(dataReader, "SearchProduct1");
        tcs.pom.getSearch434().writeInSearchBar(search);
    }

    @Then("It should return a SRP which has just the product that was searched.")
    public void itShouldReturnASRPWhichHasJustTheProductThatWasSearched(DataReader dataReader) {
        String search = Common.dataExtractorFromSheet(dataReader, "SearchProduct1");
        Assert.assertTrue(tcs.pom.getSearch434().verifyTitleOfSearch(search));
    }

    @Then("I should see my search term on the top left default sort -  relevance")
    public void iShouldSeeMySearchTermOnTheTopLeftWDefaultSortRelevance(DataReader dataReader) {
        String search = Common.dataExtractorFromSheet(dataReader, "SearchProduct1");
        Assert.assertTrue(tcs.pom.getSearch434().verifyTitleOfSearch(search));
    }


    @Given("I am on the home page")
    public void iAmOnTheHomePage() {

    }

    //abc
    @When("I execute a search based on a search term \\(red lipstick) that takes me to an SRP")
    public void iExecuteASearchBasedOnASearchTermRedLipstickThatTakesMeToAnSRP(DataReader dataReader) {
        String searchProduct = Common.dataExtractorFromSheet(dataReader, "SearchProduct5");
        tcs.pom.getSearch434().writeInSearchBar(searchProduct);
        Assert.assertTrue(tcs.pom.getSearch434().hitOnSearch());
        Assert.assertTrue(tcs.pom.getSearch434().verifyTitleOfSearch(searchProduct));
    }

    @Then("The results displayed on the SRP will have the below sort options, with the first being the default: Relevance Price: Low to High Price: High to Low Newest")
    public void theResultsDisplayedOnTheSRPWillHaveTheBelowSortOptionsWithTheFirstBeingTheDefaultRelevancePriceLowToHighPriceHighToLowNewest() {
        Assert.assertTrue(tcs.pom.getSearch434().validateSRPSortOption());
    }

    @When("I execute a search for a mapped keyword that takes me to a CLP")
    public void iExecuteASearchForAMappedKeywordThatTakesMeToACLP(DataReader dataReader) {
        String searchProduct = Common.dataExtractorFromSheet(dataReader, "SearchProduct6");
        tcs.pom.getSearch434().writeInSearchBar(searchProduct);
        Assert.assertTrue(tcs.pom.getSearch434().hitOnSearch());
    }


    @Then("The results displayed on the CLP will have the below sort options, with the first being the default: Recommended Price: Low to High Price: High to Low Newest")
    public void theResultsDisplayedOnTheCLPWillHaveTheBelowSortOptionsWithTheFirstBeingTheDefaultRecommendedPriceLowToHighPriceHighToLowNewest() {
        Assert.assertTrue(tcs.pom.getSearch434().validateCLPSortOption());
    }


//    @Given("I am on any search or listing page {string}")
//    public void iAmOnAnySearchOrListingPage(String searchProduct) {
//        tcs.pom.getSearch434().writeInSearchBar(searchProduct);
//        Assert.assertTrue(tcs.pom.getSearch434().hitOnSearch());
//        Assert.assertTrue(tcs.pom.getSearch434().verifyTitleOfSearch(searchProduct));
//    }
//
//    @When("I view the filters")
//    public void iViewTheFilters() {
//
//    }
//
//    @Then("I should see the facet count next to each filter to denote the number of products with that below facets:")
//    public void IShouldSeeTheFacetCountNextToEachFilterToDenoteTheNumberOfProductsWithThatBelowFacets() {
//
//    }


    @Given("A search query is made")
    public void aSearchQueryIsMade(DataReader dataReader) {
        String searchProduct = Common.dataExtractorFromSheet(dataReader, "SearchProduct7");
        tcs.pom.getSearch434().writeInSearchBar(searchProduct);
        Assert.assertTrue(tcs.pom.getSearch434().hitOnSearch());
    }

    @When("There is a tie on relevance score across variants")
    public void thereIsATieOnRelevanceScoreAcrossVariants() {
        Assert.assertTrue(tcs.pom.getSearch434().validateSRPSortOption());
    }

    @Then("Then display the relevant variant that is in stock instead of the OOS one")
    public void thenDisplayTheRelevantVariantThatIsInStockInsteadOfTheOOSOne() {
        Assert.assertFalse(tcs.pom.getSearch434().validateDisplayRelevantVariant());
    }
}
