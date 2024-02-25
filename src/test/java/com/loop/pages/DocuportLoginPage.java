package com.loop.pages;

import com.loop.utilities.BrowserUtils;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.Key;
import java.util.Map;

public class DocuportLoginPage {

    public DocuportLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy (xpath = "//input[contains(@id,'input') and contains(@type,'text')]")
    public WebElement userNameInput;
    @FindBy (xpath = "//input[contains(@id,'input') and contains(@type,'password')]")
    public WebElement passwordInput;
    @FindBy (xpath = "//span[contains(.,'Log in')]")
    public WebElement loginButton;

    @FindBy (xpath = "//button[contains(@class,'success')]")
    public WebElement submitButton;

    public void login(String usersType){

        userNameInput.sendKeys(DocuportConstants.chooseUserNameMethod(usersType), Keys.ENTER);
        passwordInput.sendKeys(DocuportConstants.PASSWORD, Keys.ENTER);
        BrowserUtils.justWait(8);
        BrowserUtils.clickWithJS(loginButton);

        if(usersType.equals("client")){
            BrowserUtils.waitForClickable(submitButton,10);
            //WebElement cont = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
            BrowserUtils.clickWithJS(submitButton);
            //submitButton.click();
            BrowserUtils.justWait(30);
        }
        BrowserUtils.justWait(90);

    }


    public void loginForNewClient(Map<String, String> entry){
        BrowserUtils.justWait(6);
        userNameInput.sendKeys(entry.get("email"), Keys.ENTER);
        passwordInput.sendKeys((entry.get("password")), Keys.ENTER);
        BrowserUtils.justWait(8);
        BrowserUtils.clickWithJS(loginButton);
        BrowserUtils.justWait(10);
    }





}
