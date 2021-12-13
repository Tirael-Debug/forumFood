package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class personalAccountPage {
    private WebDriver driver;
    private WebElement linkOutLogin;
    private WebElement linkANote;
    private WebElement search;
    private WebElement hello;
    private WebElement noteLink;




    public personalAccountPage (WebDriver driver){
        this.driver=driver;
        linkOutLogin=driver.findElement(By.cssSelector("a[href=\"https://www.povarenok.ru/logout/\"]"));
        linkANote= driver.findElement(By.cssSelector("a[href=\"https://www.povarenok.ru/tip/add/\"]"));
        search=driver.findElement(By.cssSelector("body > div.page-width > header > div > div > div.search-wrap > form > input[type=text]:nth-child(1)"));
        hello= driver.findElement(By.cssSelector(".userhello"));
        noteLink = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/noindex[1]/div/ul/li[6]/a"));
    }

    public void noteLink(){
        noteLink.click();

}
}
