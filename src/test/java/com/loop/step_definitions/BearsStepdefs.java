package com.loop.step_definitions;

import com.github.javafaker.Faker;
import com.loop.pages.SmartbearSoftware;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class BearsStepdefs {
    SmartbearSoftware smartbearSoftware = new SmartbearSoftware();
    Select select;
    Faker faker = new Faker();

    @Given("user is on bear webpage")
    public void user_is_on_bear_webpage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("bear"));
    }
    @When("user enters username")
    public void user_enters_username() {
        smartbearSoftware.username.sendKeys(SmartbearSoftware.USERNAMEKEY);
    }
    @When("user enters password")
    public void user_enters_password() {
        smartbearSoftware.password.sendKeys(SmartbearSoftware.PASSWORDKEY);
    }
    @When("user click on login button")
    public void user_click_on_login_button() {
        smartbearSoftware.loginButton.click();
    }
    @When("user click on Order")
    public void user_click_on_order() {
        smartbearSoftware.order.click();
    }
    @When("user select familyAlbum from product")
    public void user_select_family_album_from_product() {
        select = new Select(smartbearSoftware.selectProduct);
        select.selectByVisibleText(SmartbearSoftware.PRODUCT);}
    @When("user select quantity {int}")
    public void user_select_quantity(Integer int1) {
        smartbearSoftware.quantity.clear();
        smartbearSoftware.quantity.sendKeys(SmartbearSoftware.QUANTITY, Keys.ENTER);}
    @When("user click calculate button")
    public void user_click_calculate_button() {
        select = new Select(smartbearSoftware.selectProduct);
    }
    @When("user fill address information")
    public void user_fill_address_information() {
        select.selectByVisibleText(SmartbearSoftware.PRODUCT);
        smartbearSoftware.quantity.clear();
        smartbearSoftware.quantity.sendKeys(SmartbearSoftware.QUANTITY, Keys.ENTER);
        smartbearSoftware.calculateButton.click();
        smartbearSoftware.customerName.sendKeys(faker.name().fullName());
        smartbearSoftware.addressStreet.sendKeys(faker.address().streetName());
        smartbearSoftware.addressCity.sendKeys(faker.address().city());
        smartbearSoftware.addressState.sendKeys(faker.address().state());
        smartbearSoftware.addressZip.sendKeys(faker.address().zipCode().replace("-",""));}
    @When("user click on {string} radio button")
    public void user_click_on_radio_button(String string) {
        smartbearSoftware.card.click();
    }
    @When("user put cardnumber")
    public void user_put_cardnumber() {
        smartbearSoftware.cardNumber.sendKeys(faker.business().creditCardNumber().replace("-", ""));
        smartbearSoftware.cardDate.sendKeys(SmartbearSoftware.cardData());}
    @When("user click on Progress")
    public void user_click_on_progress() {
        smartbearSoftware.processButton.click();
    }
    @Then("user should see success message “New order has been successfully added.”")
    public void user_should_see_success_message_new_order_has_been_successfully_added() {
        Assert.assertTrue("Test Fail",smartbearSoftware.successMessage.getText().contains(SmartbearSoftware.SUCCESS));}




}
