package com.loop.pages;

import com.loop.utilities.BrowserUtils;
import com.loop.utilities.Driver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DocuportLeadsPage extends DocuportBasePage{

    @FindBy (xpath = "//div[@class='v-data-footer__select']") public WebElement rowsPerPage;

    @FindBy (xpath = "//i[contains(@class,'mdi-menu-down')]") public WebElement dropdown;

    @FindBy (xpath = "//div[@class='v-list-item__title' and .='5']") public WebElement chooseNumofRows;


public void changeNumberOfRows(int number){
    dropdown.click();
    WebElement changing = Driver.getDriver().findElement(By.xpath("//div[@class='v-list-item__title' and .='" + number + "']"));
    BrowserUtils.waitForClickable(changing, 500);
    changing.click();

}


}
