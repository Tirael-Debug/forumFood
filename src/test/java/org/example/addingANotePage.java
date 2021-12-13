package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addingANotePage {
    private  WebDriver driver;

    @FindBy(css = "#post_title_id")
    private WebElement newTipTitle;
    @FindBy (css = "#short_id")
    private WebElement shortTitle;
    @FindBy (id = "text_body")
    private WebElement tipText;
    @FindBy (css = ".sub")
    private WebElement saveButton;

    public addingANotePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public addingANotePage newTipTitle(String text){
        newTipTitle.sendKeys(text);
        return this;
    }
    public addingANotePage shortTitle(String text){
        shortTitle.sendKeys(text);
        return this;
    }
    public addingANotePage tipText(String text){
        tipText.sendKeys(text);
        return this;
    }
    public addingANotePage saveButton(){
        saveButton.click();
        return this;
    }

}
