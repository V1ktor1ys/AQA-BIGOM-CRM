package tests;

import core.BaseTest;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class Vik_Test_123 extends BaseTest {

    @Test
    @DisplayName("Vik test 123")

    public void test1() throws InterruptedException {

        driver = new org.openqa.selenium.chrome.ChromeDriver();
        driver.get("https://steamcommunity.com/id/Viktoriys/");
        sleep(3000);
        driver.quit();

    }

}
