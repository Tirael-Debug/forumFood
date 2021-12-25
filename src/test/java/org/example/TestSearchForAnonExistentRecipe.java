package org.example;

import io.qameta.allure.Description;
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

    @Description("Тестирование поисковой системы. Ввод наименования, которое отсутствует в системе")
    @Test
    public void testSearchForAnonExistentRecipe(){
        driver.get("https://www.povarenok.ru/");
        LoginPageFactory search1=new LoginPageFactory(driver);
        search1.search("Тирлитуредуй");
        String text = driver.findElement(By.cssSelector("body > div.page-width > div.site-content > div > div.content-md > section:nth-child(2) > div.separation-block.sort-res > div.bl-right > strong")).getText();
        Assertions.assertEquals(text,"ничего не найдено");

    }

}
