package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class personalAccountPage {
    private  WebDriver driver;

    @FindBy(css = "a[href=\"https://www.povarenok.ru/logout/\"]")
    private WebElement linkOutLogin;
    @FindBy(css = "a[href=\"https://www.povarenok.ru/tip/add/\"]")
    private WebElement linkANote;
    @FindBy (css = "body > div.page-width > header > div > div > div.search-wrap > form > input[type=text]:nth-child(1)")
    private WebElement search;
    @FindBy (css = ".userhello")
    private WebElement hello;
    @FindBy (xpath ="/html/body/div[5]/div[3]/div/div[2]/noindex[1]/div/ul/li[6]/a" )
    private WebElement noteLink;

    public personalAccountPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

        public personalAccountPage noteLink(){
            noteLink.click();
            return this;
    }
}
