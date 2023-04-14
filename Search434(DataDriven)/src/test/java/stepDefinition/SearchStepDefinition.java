package stepDefinition;

import ddtConfig.DataReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import util.Common;
import util.TestContextSetup;


public class SearchStepDefinition {

    TestContextSetup tcs;

    public SearchStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    @Given("Given I search a specific brand or badge \\(thoughtful choices)")
    public void given_i_search_a_specific_brand_or_badge_thoughtful_choices(DataReader dataReader) {
        String brandName = Common.dataExtractorFromSheet(dataReader, "SearchBrandName");
        tcs.common.addExplicitWait(tcs.pom.getSearchPage().searchTextField);
        tcs.pom.getSearchPage().searchTextField.sendKeys(brandName);


    }

    @When("When I hit enter")
    public void when_i_hit_enter() {
       tcs.common.addExplicitWait(tcs.pom.getSearchPage().clickSearchButton);
        tcs.pom.getSearchPage().clickSearchButton.submit();

    }

    @Then("It should take me to the specific brand PLP I searched")
    public void it_should_take_me_to_the_specific_brand_plp_i_searched(DataReader dataReader) {
        String brandName = Common.dataExtractorFromSheet(dataReader, "SearchBrandName");
        tcs.common.addExplicitWait(tcs.pom.getSearchPage().brandPlpPage);
        Assert.assertTrue(tcs.pom.getSearchPage().brandPlpPage.isDisplayed());
        boolean brand = false;
        for (WebElement brandNamePlp : tcs.pom.getSearchPage().getBrandName()) {
            String brandValue = brandNamePlp.getText().trim();
            if (brandValue.contains(brandName)) {
                Assert.assertTrue(brandValue.contains(brandName));
                brand = true;
                break;

            }

        }
        Assert.assertTrue(brand);

    }

}
