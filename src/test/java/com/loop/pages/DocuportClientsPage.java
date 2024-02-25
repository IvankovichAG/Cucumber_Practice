package com.loop.pages;

import com.github.javafaker.Faker;
import com.loop.utilities.BrowserUtils;
import com.loop.utilities.DocuportConstants;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class DocuportClientsPage extends DocuportBasePage{

    Faker faker = new Faker();
    @FindBy (xpath = "//button[@type='button' and contains(@class,'success')]") public WebElement createNewClientButton;
    @FindBy (xpath = "//i[contains(@class,'primary--text')]/following-sibling::span[.='Personal']") public WebElement personalButton;
    @FindBy (xpath = "//label[.='First name']/following-sibling::input") public WebElement newClientFirstName;
    @FindBy (xpath = "//label[.='Last name']/following-sibling::input") public WebElement newClientLastName;
    @FindBy (xpath = "//label[contains(.,'Create')]") public WebElement checkBoxCreateNewClient;
    @FindBy (xpath = "//label[.='Email address']/following-sibling::input") public WebElement emailAddress;
    @FindBy (xpath = "//label[.='Advisor']/following-sibling::input[1]") public WebElement chooseAdvisor;
    @FindBy (xpath = "(//div[contains(.,'No lastname')])[6]") public WebElement advisorNolAstName;
    @FindBy (xpath = "//label[.='Phone number']/following-sibling::input") public WebElement phoneNumber;
    @FindBy (xpath = "//label[.='Password']/following-sibling::input") public WebElement password;
    @FindBy (xpath = "//label[.='Confirm password']/following-sibling::input") public WebElement confirmPassword;
    @FindBy (xpath = "//span[.=' Save ']/..") public WebElement saveButton;
    @FindBy (xpath = "//label[.='Social Security Number']/following-sibling::input") public WebElement ssn;
    @FindBy (xpath = "(//div[@class='v-select__selections'])[1]") public WebElement services;
    @FindBy (xpath = "(//div[@class='v-simple-checkbox'])[6]") public WebElement checkBoxTesting;
public void createNewClientMethod(Map<String, String> map) {
    createNewClientButton.click();
    BrowserUtils.justWait(3);
    personalButton.click();
    BrowserUtils.waitForClickable(newClientFirstName, 8);
    newClientFirstName.sendKeys(map.get("first name"), Keys.ENTER);
    newClientLastName.sendKeys(map.get("last name"), Keys.ENTER);
    BrowserUtils.waitForClickable(checkBoxCreateNewClient, 7);
    checkBoxCreateNewClient.click();
    BrowserUtils.justWait(5);
    emailAddress.sendKeys(map.get("email"), Keys.ENTER);
    BrowserUtils.waitForClickable(chooseAdvisor, 5);
    chooseAdvisor.click();
    BrowserUtils.waitForClickable(advisorNolAstName, 5);
    advisorNolAstName.click();
    phoneNumber.sendKeys(map.get("phone number"), Keys.ENTER);
    password.sendKeys(map.get("password"), Keys.ENTER);
    confirmPassword.sendKeys(map.get("password"), Keys.ENTER);
    BrowserUtils.justWait(7);
    saveButton.click();
    BrowserUtils.justWait(10);
    ssn.sendKeys(faker.numerify("###-##-####"), Keys.ENTER);
    chooseAdvisor.click();
    advisorNolAstName.click();
    services.click();
    checkBoxTesting.click();
    BrowserUtils.justWait(7);
    saveButton.click();

}


}
