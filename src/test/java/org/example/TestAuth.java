package org.example;

import org.junit.gen5.api.Assertions;
import org.junit.gen5.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;

public class TestAuth {

  private static WebDriver driver;

  private static Actions builder;

  private static WebDriverWait wait;

  private static JavascriptExecutor js;

  @BeforeAll
  public static void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    builder = new Actions(driver);
    wait = new WebDriverWait(driver, 20);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterAll
  public static void tearDown() {
    driver.quit();
  }

  @Test
  public void testAuthorization() {
    driver.get("https://www.povarenok.ru/");
    driver.manage().window().setSize(new Dimension(1296, 696));

    {
      WebElement element = driver.findElement(By.tagName("body"));
      Assertions.assertNotNull(element);
      builder.moveToElement(element, 0, 0).perform();
    }

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

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".news-bl > p")));
    WebElement newsBox = driver.findElement(By.cssSelector(".news-bl > p"));
    Assertions.assertNotNull(newsBox);
    newsBox.click();

    WebElement exitLink = driver.findElement(By.linkText("Выйти"));
    Assertions.assertEquals(exitLink.getAttribute("href"), "https://www.povarenok.ru/logout/");
    exitLink.click();
  }
}
