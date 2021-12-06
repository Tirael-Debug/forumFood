package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class linkForgotPasswordTest {
    private WebDriver driver;

    @Before
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @After
    public void tearDown() {

        driver.quit();
    }

    @Test
    public void linkForgotPassword(){
        driver.get("https://www.povarenok.ru/");
        driver.findElement(By.linkText("Вспомнить пароль")).click();
        String text = driver.findElement(By.cssSelector("body > div.main-form > div:nth-child(1) > div > h1")).getText();
        Assert.assertEquals(text,"Забыли пароль?");
        driver.close();
    }
}
