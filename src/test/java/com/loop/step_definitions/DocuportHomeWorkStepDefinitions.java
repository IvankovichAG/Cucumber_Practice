package com.loop.step_definitions;

import com.loop.pages.DocuportBasePage;
import com.loop.pages.DocuportLoginPage;
import com.loop.utilities.BrowserUtils;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;


import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class DocuportHomeWorkStepDefinitions {
    DocuportBasePage docuportBasePage = new DocuportBasePage();
    DocuportLoginPage docuportLoginPage = new DocuportLoginPage();

    @Given("user is on login page")
    public void user_is_on_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }
    @When("user enter credentials")
    public void user_enter_credentials( List <String> users) {
        for (String eachUserType : users) {
           docuportLoginPage.login(eachUserType);
            //BrowserUtils.justWait(3);
            System.out.println(eachUserType);
        }
    }

//    @Then("user validates all accessible fields on the left panel for his usertype")
//    public void user_validates_all_accessible_fields_on_the_left_panel_for_his_usertype(Map<String, List<String>> leftSideOptions) {
//        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
//
//        for (Map.Entry<String, List<String>> each : leftSideOptions.entrySet()) {
//            docuportLoginPage.login(each.getKey());
//            each.getValue().removeIf(element -> element == null);
//            System.out.println("each.getValue() = " + each.getValue());
//            System.out.println(each.getKey());
//
//            assertEquals(docuportBasePage.getOptionsMethod(), each.getValue());
//            System.out.println("docuportBasePage.getOptionsMethod(each.getKey()) = " + docuportBasePage.getOptionsMethod());
//            BrowserUtils.justWait(4);
//            docuportBasePage.logoutMethod();
//            BrowserUtils.justWait(8);
//       }
//
//    }

    @Then("user validates all accessible fields on the left panel for his usertype")
    public void user_validates_all_accessible_fields_on_the_left_panel_for_his_usertype(Map<String, String> leftSideOptions) {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        for (Map.Entry<String, String> each : leftSideOptions.entrySet()) {
            docuportLoginPage.login(each.getKey());
            System.out.println(each.getValue());

            assertEquals(docuportBasePage.getOptionsMethod().toString().replace("[","").replace("]",""), each.getValue());

            docuportBasePage.logoutMethod(each.getKey());
            BrowserUtils.justWait(20);

        }


//        for (Map.Entry<String, List<String>> each : leftSideOptions.entrySet()) {
//            docuportLoginPage.login(each.getKey());
//            each.getValue().removeIf(element -> element == null);
//            System.out.println("each.getValue() = " + each.getValue());
//            System.out.println(each.getKey());
//
//            assertEquals(docuportBasePage.getOptionsMethod(), each.getValue());
//            System.out.println("docuportBasePage.getOptionsMethod(each.getKey()) = " + docuportBasePage.getOptionsMethod());
//            BrowserUtils.justWait(4);
//            docuportBasePage.logoutMethod();
//            BrowserUtils.justWait(8);
//        }

    }

}
