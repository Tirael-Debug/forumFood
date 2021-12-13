package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class addingANotePage {
    private WebDriver driver;
    private WebElement newTipTitle;
    private WebElement shortTitle;
    private WebElement tipText;
    private WebElement saveButton;

    public addingANotePage(WebDriver driver) {
        this.driver=driver;
        newTipTitle=driver.findElement(By.cssSelector("#post_title_id"));
        shortTitle=driver.findElement(By.cssSelector("#short_id"));
        tipText=driver.findElement(By.id("text_body"));
        saveButton=driver.findElement(By.cssSelector(".sub"));

    }

    public void newTipTitle(String text){
        newTipTitle.sendKeys(text);
    }
    public void shortTitle(String text){
        shortTitle.sendKeys(text);
    }
    public void tipText(String text){
        tipText.sendKeys(text);
    }
    public void saveButton(){
        saveButton.click();
    }

}
