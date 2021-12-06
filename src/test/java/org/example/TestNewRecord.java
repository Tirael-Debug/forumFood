package org.example;

import org.junit.gen5.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestNewRecord {

  private static WebDriver driver;

  private static Actions builder;

  private static WebDriverWait wait;

  private static JavascriptExecutor js;

  public static void simpleAuthorization() {
    driver.get("https://www.povarenok.ru/");
    driver.manage().window().setSize(new Dimension(1296, 696));

    WebElement loginInput = driver.findElement(By.cssSelector(".bl #tl_login_id"));
    Assertions.assertEquals(loginInput.getAttribute("name"), "login");
    loginInput.click();
    loginInput.sendKeys("Tillibonk");

    WebElement passwordInput = driver.findElement(By.cssSelector(".bl #tl_pwd_id"));
    Assertions.assertEquals(passwordInput.getAttribute("name"), "password");
    passwordInput.click();
    passwordInput.sendKeys("nastya2017");

    WebElement loginButton = driver.findElement(By.cssSelector(".bl > .auth-form p:nth-child(6) > input"));
    Assertions.assertEquals(loginButton.getAttribute("value"), "Войти на сайт");
    loginButton.click();
  }

  @BeforeAll
  public static void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    builder = new Actions(driver);
    wait = new WebDriverWait(driver, 20);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    simpleAuthorization();
  }

  @AfterAll
  public static void tearDown() {
    driver.findElement(By.linkText("Выйти")).click();
    driver.quit();
  }

  @Test
  public void testNewRecord() {

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Заметку")));
    WebElement noteLink = driver.findElement(By.linkText("Заметку"));
    Assertions.assertNotNull(noteLink);
    Assertions.assertEquals(noteLink.getAttribute("href"), "https://www.povarenok.ru/tip/add/");
    noteLink.click();

    WebElement newTipTitle = driver.findElement(By.id("post_title_id"));
    Assertions.assertEquals(newTipTitle.getAttribute("name"), "title");
    newTipTitle.click();
    newTipTitle.sendKeys("Найти новый рецепт");
    newTipTitle.click();

    WebElement shortTitle = driver.findElement(By.id("short_id"));
    Assertions.assertEquals(shortTitle.getAttribute("name"), "short");
    shortTitle.click();
    shortTitle.sendKeys("Найти новый рецепт");
    shortTitle.click();

    WebElement tipText = driver.findElement(By.id("text_body"));
    Assertions.assertEquals(tipText.getAttribute("name"), "tex");
    tipText.click();
    tipText.sendKeys("Найти новый рецепт");
    tipText.click();

    driver.findElement(By.cssSelector(".sub")).click();
    js.executeScript("window.scrollTo(0,6.6666669845581055)");

  }
}
