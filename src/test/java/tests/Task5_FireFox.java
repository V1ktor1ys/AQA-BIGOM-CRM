package tests;

import org.junit.jupiter.api.*;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class Task5_FireFox {

    @Test
    @DisplayName("Test: Open link in the FireFox browser & Close")
    public void test1_OpenClose() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("conf.properties"));
        String testingUrl = System.getProperty("url");
        WebDriver driver = new FirefoxDriver();
        driver.get(testingUrl);
        driver.quit();
    }
}
