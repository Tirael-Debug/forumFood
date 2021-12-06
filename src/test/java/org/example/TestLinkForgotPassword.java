package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestLinkForgotPassword {

    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void testLinkForgotPassword(){
        driver.get("https://www.povarenok.ru/");
        driver.findElement(By.linkText("Вспомнить пароль")).click();
        String text = driver.findElement(By.cssSelector("body > div.main-form > div:nth-child(1) > div > h1")).getText();
        Assertions.assertEquals(text,"Забыли пароль?");
        driver.close();
    }
}
