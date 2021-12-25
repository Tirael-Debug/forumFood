package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
    private WebDriver driver;

    @FindBy(css = ".bl #tl_login_id")
    private WebElement login;
    @FindBy(css = ".bl #tl_pwd_id")
    private WebElement password;
    @FindBy(css = ".bl > .auth-form p:nth-child(6) > input")
    private WebElement loginButtonEntrance;
    @FindBy(css = ".bl > .auth-form p:nth-child(6) > input")
    private WebElement linkForgotPassword;
    @FindBy(css = "body > div.page-width > header > div > div > div.search-wrap > form > input[type=text]:nth-child(1)")
    private WebElement search;
    @FindBy(css = "body > div.page-width > header > div > div > div.search-wrap > form > input[type=submit]:nth-child(2)")
    private WebElement magnifier;

    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPageFactory loginIn(String login, String password) {
        this.login.sendKeys(login);
        this.password.sendKeys(password);
        loginButtonEntrance.click();
        return this;
    }

    public LoginPageFactory loginButtonEntranceClic() {
        loginButtonEntrance.click();
        return this;
    }

    public LoginPageFactory linkForgotPassword() {
        linkForgotPassword.click();
        return this;
    }

    public LoginPageFactory search(String text) {
        search.sendKeys(text);
        magnifier.click();
        return this;
    }
}


