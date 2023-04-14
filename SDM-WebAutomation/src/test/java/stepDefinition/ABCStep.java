package stepDefinition;

import util.Common;
import ddtConfig.DataReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.TestContextSetup;

public class ABCStep {

    TestContextSetup tcs;

    public ABCStep(TestContextSetup tcs) {
        this.tcs = tcs;
    }
    @Given("I have entered a search term in the search box for demo test1")
    public void i_have_entered_a_search_term_in_the_search_box_for_demo_test1(DataReader dataReader) {
        String search = Common.dataExtractorFromSheet(dataReader, "Search1");
        System.out.println(search);
        tcs.pom.getSearch434().writeInSearchBar(search);
    }

    @When("I hit enter demo1")
    public void i_hit_enter_demo1() {
        Assert.assertTrue(tcs.pom.getSearch434().hitOnSearch());
    }

    @Then("I should see the search term in the title of SRP demo1")
    public void i_should_see_the_search_term_in_the_title_of_srp_demo1(DataReader dataReader) {
        String search = Common.dataExtractorFromSheet(dataReader, "Search1");
        Assert.assertTrue(tcs.pom.getSearch434().verifyTitleOfSearch(search));
    }
}
