package com.loop.pages;

import com.github.javafaker.Faker;
import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;

public class SmartbearSoftware {
    public SmartbearSoftware() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(css = "input[type='text']") public WebElement username;
    @FindBy (css = "input[type='password']") public WebElement password;
    @FindBy (css = "input[class='button']") public WebElement loginButton;
    @FindBy (xpath = "//a[.='Order']") public WebElement order;
    @FindBy(xpath = "//select[contains(@id,'Product')]") public WebElement selectProduct;
    @FindBy(xpath = "//input[contains(@name,'Quantity')]") public WebElement quantity;
    @FindBy(xpath = "//input[@type='submit']") public WebElement calculateButton;
    @FindBy(xpath = "//input[contains(@name,'Name')]") public WebElement customerName;
    @FindBy(xpath = "//input[contains(@name,'TextBox2')]") public WebElement addressStreet;
    @FindBy(xpath = "//input[contains(@name,'TextBox3')]") public WebElement addressCity;
    @FindBy(xpath = "//input[contains(@name,'TextBox4')]") public WebElement addressState;
    @FindBy(xpath = "//input[contains(@name,'TextBox5')]") public WebElement addressZip;
    @FindBy(xpath = "//input[@value='Visa']") public WebElement card;
    @FindBy(xpath = "//input[contains(@name,'TextBox6')]") public WebElement cardNumber;
    @FindBy(xpath = "//input[contains(@id,'TextBox1')]") public WebElement cardDate;
    @FindBy(xpath = "//a[contains(@id,'InsertButton')]") public WebElement processButton;
    @FindBy(xpath = "//strong[contains(.,'New order has been successfully added')]") public WebElement successMessage;
    public static final String USERNAMEKEY = "Tester";
    public static final String PASSWORDKEY = "test";
    public static final String PRODUCT = "FamilyAlbum";
    public static final String QUANTITY = "2";
    public static final String SUCCESS = "New order has been successfully added";

    public static String cardData () {
        Faker faker = new Faker();
        SimpleDateFormat data = new SimpleDateFormat("MM/yy");
        return data.format(faker.date().birthday());
    }



}



