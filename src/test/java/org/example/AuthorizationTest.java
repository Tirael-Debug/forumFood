package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
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

public class AuthorizationTest {

  private WebDriver driver;

  private Actions builder;

  private WebDriverWait wait;

  private JavascriptExecutor js;

  @Before
  public void setUp() {
    //System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    builder = new Actions(driver);
    wait = new WebDriverWait(driver, 20);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void authorizationTest() {
    driver.get("https://www.povarenok.ru/");
    driver.manage().window().setSize(new Dimension(1296, 696));

    {
      WebElement element = driver.findElement(By.tagName("body"));
      Assert.assertNotNull(element);
      builder.moveToElement(element, 0, 0).perform();
    }

    WebElement loginInput = driver.findElement(By.cssSelector(".bl #tl_login_id"));
    Assert.assertEquals(loginInput.getAttribute("name"), "login");
    loginInput.click();
    loginInput.sendKeys("Tillibonk");

    WebElement passwordInput = driver.findElement(By.cssSelector(".bl #tl_pwd_id"));
    Assert.assertEquals(passwordInput.getAttribute("name"), "password");
    passwordInput.click();
    passwordInput.sendKeys("nastya2017");

    WebElement loginButton = driver.findElement(By.cssSelector(".bl > .auth-form p:nth-child(6) > input"));
    Assert.assertEquals(loginButton.getAttribute("value"), "Войти на сайт");
    loginButton.click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".news-bl > p")));
    WebElement newsBox = driver.findElement(By.cssSelector(".news-bl > p"));
    Assert.assertNotNull(newsBox);
    newsBox.click();

    WebElement exitLink = driver.findElement(By.linkText("Выйти"));
    Assert.assertEquals(exitLink.getAttribute("href"), "https://www.povarenok.ru/logout/");
    exitLink.click();
  }
}
