package org.example;

//import org.junit.gen5.api.Assertions;
import io.qameta.allure.Description;
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
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterAll
  public static void tearDown() {
    driver.findElement(By.linkText("Выйти")).click();
    driver.quit();
  }

  @Description("Авторизованный пользователь создаёт заметку в личном кабинете")
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
    addingANotePage.tipText("Кушать нужно вмеру:)");
    addingANotePage.saveButton();
    Assertions.assertTrue(driver.getTitle().contains("Найти новый рецепт для новогоднего стола"));

  }
}
