package com.loop.pages;

import com.loop.utilities.BrowserUtils;
import com.loop.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DocuportBasePage {
    //DocuportLoginPage docuportLoginPage = new DocuportLoginPage();
    public DocuportBasePage (){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy (xpath = "//div[@class='v-list-item__title']//span") List <WebElement> basePageLeftSide;

    @FindBy (xpath = "(//button[@type='button' and @role='button'])[2]") public WebElement buttonClient;
    @FindBy (xpath = "//span[.='Log out']") public WebElement logOutClient;

    @FindBy (xpath = "//button[contains(@class,'gray--text')]") public WebElement button;
    @FindBy (xpath = "//div//span[.='Log out']") public WebElement logOut;
    @FindBy (xpath = "//span[contains(@class,'gray')]") public WebElement userNameOnPage;
    @FindBy (xpath = "//span[.='Search' and @class='v-btn__content']/..") private WebElement searchButton;

    @FindBy (xpath = "//span[.='Download' and @class='v-btn__content']/..") private WebElement downloadButton;

    @FindBy (xpath = "//h1[.='Received docs']") private WebElement receivedDocsHeader;
    @FindBy (xpath = "//img[@alt='Docuport']/..") public WebElement basePageButton;

    public List<String> getOptionsMethod () {
        List <String> actual = new ArrayList<>();
        for (WebElement each : basePageLeftSide) {
            //BrowserUtils.waitForClickable(each,200);
            BrowserUtils.justWait(1000);
            actual.add(each.getText());
            BrowserUtils.justWait(500);
            //BrowserUtils.waitForClickable(each,1000);
        }
        return actual;
    }
    public void chooseOptionMethod(String option) {
        for (WebElement each : basePageLeftSide) {
            BrowserUtils.justWait(1000);
            if (each.getText().equals(option)) {
                BrowserUtils.waitForClickable(each, 800);
                each.click();
            }
        }
        BrowserUtils.justWait(5);
    }
    public void logoutMethod () {
        buttonClient.click();
        logOut.click();
    }

    public void logoutMethod (String role) {
        if (role.equals("client")) {
        buttonClient.click();
        logOutClient.click();
        } else {
            button.click();
            logOut.click();
        }
    }

    public void isDisplayedSearchButton(){
        Assert.assertTrue(searchButton.isDisplayed());
        BrowserUtils.justWait(5);
    }
    public void isDisplayedDownloadButton(){
        Assert.assertTrue(downloadButton.isDisplayed());
    }

    public void headerIsDisplayed(String header) {
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//h1[.='" + header + "']")).isDisplayed());
    }

    public void basePageClick() {
        basePageButton.click();
        BrowserUtils.justWait(5000);
}


}
