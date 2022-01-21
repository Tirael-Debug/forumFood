package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class TestNewRecord {

  private static WebDriver driver;

  @BeforeAll
  public static void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterAll
  public static void tearDown() {
    driver.findElement(By.linkText("Выйти")).click();
    driver.quit();
  }


  @Test
  public void testNewRecord() {
    driver.get("https://www.povarenok.ru/");
    LoginPageFactory loginPageObject=new LoginPageFactory(driver);
    loginPageObject.loginIn("Tillibonk", "nastya2017");
    personalAccountPage personalAccountPage=new personalAccountPage(driver);
    personalAccountPage.noteLink();
    addingANotePage addingANotePage=new addingANotePage(driver);
    addingANotePage.newTipTitle("Найти новый рецепт для новогоднего стола");
    addingANotePage.shortTitle("Салатик, закуски, праздничные сладости");
    addingANotePage.tipText("Кшуть нужно вмеру:)");
    addingANotePage.saveButton();
    Assertions.assertTrue(driver.getTitle().contains("Найти новый рецепт для новогоднего стола"));

  }
}
