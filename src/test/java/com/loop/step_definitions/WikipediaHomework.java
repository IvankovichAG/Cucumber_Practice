package com.loop.step_definitions;

import com.loop.pages.WikiSteveJobsPage;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class WikipediaHomework {

    WikiSteveJobsPage wikiSteveJobsPage = new WikiSteveJobsPage();

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("wiki"));
    }

    @When("User types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String input) {
       wikiSteveJobsPage.searchBox.sendKeys(input);
    }
    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikiSteveJobsPage.searchButton.click();

    }
    @Then("User sees {string} is in the wiki title")
    public void user_sees_is_in_the_wiki_title(String input) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(input));
    }
    @Then("User sees {string} is in the main header")
    public void user_sees_is_in_the_main_header(String input) {
        Assert.assertTrue(wikiSteveJobsPage.header.getText().contains(input));
    }
    @Then("User sees {string} is in the image header")
    public void user_sees_is_in_the_image_header(String input) {
       Assert.assertTrue(wikiSteveJobsPage.imgHeader.getText().contains(input));
    }






}
