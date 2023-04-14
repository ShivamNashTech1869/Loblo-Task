package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Footer;
import util.TestContextSetup;

import java.io.IOException;
import java.time.Duration;

public class Hooks {
   TestContextSetup tcs;
    public Hooks(TestContextSetup tcs){
        this.tcs=tcs;
    }

    @Before
    public void setUp(){
        tcs.pom.getFooter().closeFooterPopup();
    }

    @After
    public void tearDown() throws IOException {
        tcs.base.initializeDriver().quit();
    }



    /*@BeforeAll
    public static void beforeAll() throws IOException {
        Hooks hooks=new Hooks(new TestContextSetup());
        hooks.closeFooterNotificationInCode();
    }

    public void closeFooterNotificationInCode() throws IOException {
        tcs.pom.getFooter().closeFooterPopup();
    }*/
}
