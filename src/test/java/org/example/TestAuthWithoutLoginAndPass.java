package org.example;

import org.junit.gen5.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class TestAuthWithoutLoginAndPass {

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
    public void testAuthorizationWithoutLoginAndPassword(){
        driver.get("https://www.povarenok.ru/");
        driver.findElement(By.cssSelector(".bl > .auth-form p:nth-child(6) > input")).click();
        String text = driver.findElement(By.cssSelector(".fr")).getText();
        Assertions.assertEquals(text,"Забыли пароль?");
        driver.close();
    }
}
