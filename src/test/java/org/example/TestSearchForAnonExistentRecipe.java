package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestSearchForAnonExistentRecipe {

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
    public void testSearchForAnonExistentRecipe(){
        driver.get("https://www.povarenok.ru/");
        driver.findElement(By.cssSelector("body > div.page-width > header > div > div > div.search-wrap > form > input[type=text]:nth-child(1)")).sendKeys("Тирлитуредуй");
        driver.findElement(By.cssSelector("body > div.page-width > header > div > div > div.search-wrap > form > input[type=submit]:nth-child(2)")).click();
        String text = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/section[1]/div[4]/div[2]/strong")).getText();
        Assertions.assertEquals(text,"ничего не найдено");
        driver.close();
    }

}
