package org.example;

//import org.junit.gen5.api.Assertions;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class TestAuth {

  private static WebDriver driver;

  @BeforeAll
  public static void setUp() {

    driver = new ChromeDriver();
      WebDriverManager.chromedriver().setup();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterAll
  public static void tearDown() {
    driver.quit();
  }

  @Description ("Позитивный тест. Тестирование авторизации с валидными данными")


  @Test
  public void testAuthorization() {
    driver.get("https://www.povarenok.ru/");
   LoginPageFactory loginPageFactory=new LoginPageFactory(driver);
   loginPageFactory.loginIn("Tillibonk", "nastya2017");
   WebElement hello=driver.findElement(By.cssSelector(".userhello"));
   Assertions.assertEquals(hello.getText(),"Здравствуйте, Tillibonk\nПоварёнок 0 уровня");
   WebElement exitLink = driver.findElement(By.linkText("Выйти"));
   Assertions.assertEquals(exitLink.getAttribute("href"), "https://www.povarenok.ru/logout/");
   exitLink.click();

  }
}
