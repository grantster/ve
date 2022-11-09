package ve;

import java.io.IOException;

import com.hp.lft.report.CaptureLevel;
import com.hp.lft.report.ReportException;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.*;
import com.hp.lft.sdk.internal.web.*;
import com.hp.lft.sdk.web.*;
import com.hp.lft.verifications.*;
import static org.junit.Assert.*;
import cucumber.api.*;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LeanFtStepDefinitions {
    Browser browser;

    public LeanFtStepDefinitions() throws GeneralLeanFtException {}
    @Before
    public void setUp() throws GeneralLeanFtException {
        browser = BrowserFactory.launch(BrowserType.CHROME);
        browser.deleteCookies();

    }
    //Implementation of feature’s steps
    @Given("I can navigate to www.advantageonlineshopping.com")
    public void i_can_navigate_to_www_advantageonlineshopping_com() throws GeneralLeanFtException {
        // Write code here that turns the phrase above into concrete actions
        browser.navigate("http://advantageonlineshopping.com/#/");
       // throw new cucumber.api.PendingException();
    }

    @When("I select the profile button")
    public void i_select_the_profile_button() throws GeneralLeanFtException {
        // Write code here that turns the phrase above into concrete actions
        Link userMenuLink = browser.describe(Link.class, new LinkDescription.Builder()
                .innerText("My account My orders Sign out ")
                .tagName("A").build());
        userMenuLink.click();

        //throw new cucumber.api.PendingException();
    }

    @When("I login as dominikg with Password{int}")
    public void i_login_as_dominikg_with_Password(Integer int1) throws GeneralLeanFtException {
        // Write code here that turns the phrase above into concrete actions

        EditField usernameEditField = browser.describe(EditField.class, new EditFieldDescription.Builder()
                .name("username")
                .tagName("INPUT")
                .type("text").build());
        usernameEditField.setValue("dominikg");

        WebElement passwordWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .innerText("Password")
                .tagName("LABEL").build());
        passwordWebElement.click();

        EditField passwordEditField = browser.describe(EditField.class, new EditFieldDescription.Builder()
                .name("password")
                .tagName("INPUT")
                .type("password").build());
        passwordEditField.setSecure("636b6d9612534798ba62345a18d1e863272f554eef1e9480");
        Button signInBtnundefinedButton = browser.describe(Button.class, new ButtonDescription.Builder()
                .buttonType("button")
                .name("SIGN IN")
                .tagName("BUTTON").build());
        signInBtnundefinedButton.click();

        //throw new cucumber.api.PendingException();
    }

    @Then("the username dominikg is displayed at profile icon")
    public void the_username_dominikg_is_displayed_at_profile_icon()  throws GeneralLeanFtException {
        // Write code here that turns the phrase above into concrete actions
        WebElement dominikgWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .tagName("SPAN")
                .className("hi-user containMiniTitle ng-binding")
                .innerText("dominikg").build());
        Verify.areEqual("dominikg", dominikgWebElement.getInnerText(), "Verification", "Verify property: innerText");

        //throw new cucumber.api.PendingException();
    }


}