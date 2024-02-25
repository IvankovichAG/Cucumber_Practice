package com.loop.step_definitions;

import com.loop.pages.DocuportBasePage;
import com.loop.pages.DocuportLoginPage;
import com.loop.utilities.BrowserUtils;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class Homework_18_steps {

    DocuportLoginPage docuportLoginPage = new DocuportLoginPage();
    DocuportBasePage docuportBasePage = new DocuportBasePage();

    @Given("user is on docuport login page")
    public void user_is_on_docuport_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }
    @When("user login as a {string}")
    public void user_login_as_a(String role) {
       docuportLoginPage.login(role);
    }
    @Then("user validate search button is displayed")
    public void user_validate_search_button_is_displayed() {
    docuportBasePage.isDisplayedSearchButton();
        BrowserUtils.takeScreenshot();
    }
    @Then("user validate download button is displayed")
    public void user_validate_download_button_is_displayed() {
    docuportBasePage.isDisplayedDownloadButton();
    }
    @Then("user validate {string} is displayed")
    public void user_validate_is_displayed(String header) {
    docuportBasePage.headerIsDisplayed(header);
    BrowserUtils.takeScreenshot();
    }

    @Then("user clicks on {string} button")
    public void user_clicks_on_button(String basePage) {
       docuportBasePage.basePageClick();
    }


    @Then("user logout as a {string}")
    public void user_logout_as_a(String role) {
        docuportBasePage.logoutMethod(role);
    }

}
