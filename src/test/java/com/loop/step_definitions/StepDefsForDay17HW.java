package com.loop.step_definitions;

import com.loop.pages.DocuportBasePage;
import com.loop.pages.DocuportClientsPage;
import com.loop.pages.DocuportLoginPage;
import com.loop.utilities.BrowserUtils;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Do;
import org.junit.Assert;

import java.util.Map;

public class StepDefsForDay17HW {

    DocuportLoginPage docuportLoginPage = new DocuportLoginPage();
    DocuportBasePage docuportBasePage = new DocuportBasePage();
    DocuportClientsPage docuportClientsPage = new DocuportClientsPage();

    @Given("user is login as an {string}")
    public void user_is_login_as_an(String userType) {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        docuportLoginPage.login(userType);
    }
    @Then("user clicks on {string} button from left side menu")
    public void user_clicks_on_button_from_left_side_menu(String option) {
        docuportBasePage.chooseOptionMethod(option);
    }

    @When("user create a new client")
    public void user_create_a_new_client(Map <String, String > credentials) {
        docuportClientsPage.createNewClientMethod(credentials);
    }

    @Then("user logout")
    public void user_logout() {
        docuportBasePage.logoutMethod();
    }
    @Then("user login as a new client")
    public void user_login_as_a_new_client(Map <String, String> newClientCredentials) {
        docuportLoginPage.loginForNewClient(newClientCredentials);
    }

    @Then("user validate that new client is created")
    public void user_validate_that_new_client_is_created() {
        Assert.assertTrue(docuportBasePage.userNameOnPage.getText().contains(DocuportConstants.newUserName));
    }
}
