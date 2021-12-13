package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject {
    private WebDriver driver;
    private WebElement login;
    private WebElement password;
    private WebElement loginButtonEntrance;
    private WebElement magnifier;
    private WebElement search;
    private WebElement linkForgotPassword;


    public LoginPageObject (WebDriver driver){
        this.driver=driver;
        login=driver.findElement(By.cssSelector(".bl #tl_login_id"));
        password=driver.findElement(By.cssSelector(".bl #tl_pwd_id"));
        loginButtonEntrance=driver.findElement(By.cssSelector(".bl > .auth-form p:nth-child(6) > input"));
        linkForgotPassword=driver.findElement(By.cssSelector(".bl > .auth-form p:nth-child(6) > input"));
        search=driver.findElement(By.xpath("/html/body/div[5]/header/div/div/div[4]/form/input[1]"));
        magnifier=driver.findElement(By.cssSelector("body > div.page-width > header > div > div > div.search-wrap > form > input[type=submit]:nth-child(2)"));

    }

    public void loginIn(String login, String password){
        this.login.sendKeys(login);
        this.password.sendKeys(password);
        loginButtonEntrance.click();
    }
    public void loginButtonEntranceClic(){
        loginButtonEntrance.click();
    }
    public void linkForgotPassword(){
        linkForgotPassword.click();
    }
    public void search(String text){
        search.sendKeys(text);
        magnifier.click();
    }


}
