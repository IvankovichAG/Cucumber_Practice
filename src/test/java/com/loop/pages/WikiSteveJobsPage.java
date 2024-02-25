package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiSteveJobsPage {

    public WikiSteveJobsPage (){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchBox;

    @FindBy(xpath = "//button[.='Search']")
    public WebElement searchButton;

    @FindBy(xpath = "//h1/span")
    public WebElement header;

    @FindBy(xpath = "//div[@class='fn']")
    public WebElement imgHeader;







}
