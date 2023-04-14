package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import util.ExcelReader;
import util.TestContextSetup;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class bagStepDef {
    TestContextSetup tcs;

    public bagStepDef(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    /*@Given("I am on the bag page")
    public void i_am_on_the_bag_page(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        tcs.pom.bag().goToBagPage();
    }*/
    @Given("I am on the bag page sheetname {string} and rownumber {int}")
    public void iAmOnTheBagPageSheetnameAndRownumberRowNumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException, InterruptedException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData =
                reader.getData("src/main/java/resources/externalData/ddt_data.xlsx", sheetName);
        String heading = testData.get(rowNumber).get("Term");
        tcs.pom.bag().setSearchBoxMultiple(heading);
        tcs.pom.bag().goToBagPage();
    }

    @When("I have added products to my bag")
    public void i_have_added_products_to_my_bag() throws InterruptedException {

    }

    @Then("my added products load on the page")
    public void my_added_products_load_on_the_page() throws InterruptedException {
        Assert.assertTrue(tcs.pom.bag().productOnCart());
    }

    @Given("I am on the bag page empty")
    public void i_am_on_the_bag_page_empty() throws InterruptedException {
        tcs.pom.bag().shopClick();
    }

    @When("I have not added products to my bag")
    public void i_have_not_added_products_to_my_bag() throws InterruptedException {
        tcs.pom.bag().bagClick();
    }

    @Then("I am presented with the message that my bag is currently empty and option to keep shopping")
    public void i_am_presented_with_the_message_that_my_bag_is_currently_empty_and_option_to_keep_shopping() throws InterruptedException {
        Assert.assertTrue(tcs.pom.bag().noProduct());
    }

    @When("I remove the item")
    public void i_remove_the_item() throws InterruptedException {
        tcs.pom.bag().removeProduct();
    }

    @Then("my bag should be empty")
    public void my_bag_should_be_empty() throws InterruptedException {
        Assert.assertTrue(tcs.pom.bag().noProduct());
    }

    @When("I have a qualifying product from the beauty category")
    public void i_have_a_qualifying_product_from_the_beauty_category() throws InterruptedException {
        Assert.assertTrue(tcs.pom.bag().freeSample());
        tcs.pom.bag().addFreeSamples();
    }

    @Then("I can select up to 3 samples to be shipped alongside my order for free")
    public void i_can_select_up_to_samples_to_be_shipped_alongside_my_order_for_free() {
        Assert.assertTrue(tcs.pom.bag().sampleDisabled());
    }

    @When("I remove all qualifying product from the beauty category")
    public void i_remove_all_qualifying_product_from_the_beauty_category() throws InterruptedException {
        tcs.pom.bag().addFreeSamples();
        // Assert.assertTrue(tcs.pom.bag().freesampleOnCart());
        tcs.pom.bag().removeProduct();
    }

    @Then("I no longer see samples in my bag")
    public void i_no_longer_see_samples_in_my_bag() throws InterruptedException {
        Assert.assertTrue(tcs.pom.bag().noProduct());
    }

    @When("I have added products to my bag and I have not signed in")
    public void i_have_added_products_to_my_bag_and_i_have_not_signed_in() throws InterruptedException {
        //Assert.assertTrue(tcs.pom.bag().orderSummary());
    }

    @Then("I am presented the summary calculations of my order but not the tax value")
    public void i_am_presented_the_summary_calculations_of_my_order_but_not_the_tax_value() throws InterruptedException {
        Assert.assertTrue(tcs.pom.bag().booleantotalBeforeTax());
    }

    @When("I have added products to my bag and I have signed in with an account that has made it through checkout journey before")
    public void i_have_added_products_to_my_bag_and_i_have_signed_in_with_an_account_that_has_made_it_through_checkout_journey_before() throws InterruptedException {
        tcs.pom.bag().checkout();
        tcs.pom.bag().goToCheckoutShippingAddress();
    }

    @Then("I am presented the summary calculations of my order including the tax value")
    public void i_am_presented_the_summary_calculations_of_my_order_including_the_tax_value() {
        // Will add once QA will be integrated in Prod
    }

    @Given("I am on the bag page under50 sheetname {string} and rownumber {int}")
    public void i_am_on_the_bag_page_under50_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException, InterruptedException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData = reader.getData("src/main/java/resources/externalData/ddt_data.xlsx", sheetName);
        String heading = testData.get(rowNumber).get("under50$");
        tcs.pom.bag().setSearchBoxMultiple(heading);

    }

    @When("I have added products to my bag and my order is under fifty")
    public void i_have_added_products_to_my_bag_and_my_order_is_under_fifty() throws InterruptedException {
        tcs.pom.bag().goToBagPage();
    }

    @Then("I am presented the summary calculations of my order and the shipping costs is shownas $eight")
    public void i_am_presented_the_summary_calculations_of_my_order_and_the_shipping_costs_is_shownas_$eight() throws InterruptedException {
        Assert.assertTrue(tcs.pom.bag().shippingPrice());
    }

    @Then("I am presented the summary calculations of my order and the shipping costs is shown as Free")
    public void iAmPresentedTheSummaryCalculationsOfMyOrderAndTheShippingCostsIsShownAsFree() throws InterruptedException {
        Assert.assertTrue(tcs.pom.bag().shippingPriceFree());
    }

    @When("I select the plus and minus buttons")
    public void iSelectThePlusAndMinusButtons() throws InterruptedException {
        tcs.pom.bag().incremenetProduct();
        tcs.pom.bag().incremenetProduct();
        tcs.pom.bag().incremenetProduct();
        tcs.pom.bag().incremenetProduct();
        tcs.pom.bag().incremenetProduct();
        tcs.pom.bag().incremenetProduct();

    }

    @Then("I am able to modify the quantity to a maximum ofsix quantities per product and then the plus button is greyed out")
    public void iAmAbleToModifyTheQuantityToAMaximumOfsixQuantitiesPerProductAndThenThePlusButtonIsGreyedOut() {
        Assert.assertTrue(tcs.pom.bag().plusdisabled());
    }


    @Then("I am able to modify the quantity to a maximum ofthree quantities per product and then the plus button is greyed out")
    public void iAmAbleToModifyTheQuantityToAMaximumOfthreeQuantitiesPerProductAndThenThePlusButtonIsGreyedOut() {
        Assert.assertTrue(tcs.pom.bag().plusdisabled());
    }


    @When("I select the plus and minus buttons threetimes")
    public void iSelectThePlusAndMinusButtonsThreetimes() throws InterruptedException {
        tcs.pom.bag().incremenetProduct();
        tcs.pom.bag().incremenetProduct();
        tcs.pom.bag().incremenetProduct();
    }

    @Given("I am on the bag page with a CHANEL product")
    public void iAmOnTheBagPageWithACHANELProduct() throws InterruptedException {
        tcs.pom.bag().addToBagPageChanel();
    }
}
