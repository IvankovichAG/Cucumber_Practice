package com.loop.step_definitions;

import com.loop.pages.DocuportLeadsPage;
import com.loop.utilities.BrowserUtils;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;

public class Homework20_steps {

    DocuportLeadsPage docuportLeadsPage = new DocuportLeadsPage();

    @Then("user validate that Rows per page shows by default {int}")
    public void user_validate_that_rows_per_page_shows_by_default(Integer defaultValue) {
        assertTrue(docuportLeadsPage.rowsPerPage.getText().contains(String.valueOf(defaultValue)));
        BrowserUtils.takeScreenshot();
    }

    @Then("user change rows per page to {int}")
    public void user_change_rows_per_page_to(Integer number) {
        docuportLeadsPage.changeNumberOfRows(number);
        BrowserUtils.takeScreenshot();
    }

    @Then("user validates rows per page is showing {int}")
    public void user_validates_rows_per_page_is_showing(Integer newValue) {
        assertTrue(docuportLeadsPage.rowsPerPage.getText().contains(String.valueOf(newValue)));
    }
}
