package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class authorizationWithoutLoginAndPasswordTest {
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
    public void authorizationWithoutLoginAndPassword(){
        driver.get("https://www.povarenok.ru/");
        driver.findElement(By.cssSelector(".bl > .auth-form p:nth-child(6) > input")).click();
        String text = driver.findElement(By.cssSelector(".fr")).getText();
        Assert.assertEquals(text,"Забыли пароль?");
        driver.close();
    }
}
