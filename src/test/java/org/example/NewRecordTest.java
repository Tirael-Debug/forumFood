package org.example;// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class NewRecordTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  private WebDriverWait wait;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
    wait = new WebDriverWait(driver, 20);
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void newRecordTest() {
    driver.get("https://www.povarenok.ru/");
    driver.manage().window().setSize(new Dimension(1296, 696));
    driver.findElement(By.cssSelector(".bl #tl_login_id")).click();
    driver.findElement(By.cssSelector(".bl #tl_login_id")).sendKeys("Tillibonk");
    driver.findElement(By.cssSelector(".bl #tl_pwd_id")).click();
    driver.findElement(By.cssSelector(".bl #tl_pwd_id")).sendKeys("nastya2017");
    driver.findElement(By.cssSelector(".bl > .auth-form p:nth-child(6) > input")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Заметку")));
    driver.findElement(By.linkText("Заметку")).click();
    driver.findElement(By.id("post_title_id")).click();
    driver.findElement(By.id("post_title_id")).sendKeys("Найти новый рецепт");
    driver.findElement(By.id("short_id")).click();
    driver.findElement(By.id("post_title_id")).click();
    driver.findElement(By.id("short_id")).click();
    driver.findElement(By.id("short_id")).sendKeys("Найти новый рецепт");
    driver.findElement(By.id("text_body")).click();
    driver.findElement(By.id("text_body")).sendKeys("Найти новый рецепт");
    driver.findElement(By.cssSelector(".sub")).click();
    js.executeScript("window.scrollTo(0,6.6666669845581055)");
    driver.findElement(By.linkText("Выйти")).click();
  }
}