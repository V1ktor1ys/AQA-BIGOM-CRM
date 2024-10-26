package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.*;

abstract public class BasePage {
    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        Logger.getLog(Level.ALL, "Setup the WebDriver");

        driver = webDriver;
    }

    public void driverWaitVisibilityOfElem(int durationSec, String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSec));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public void driverWaitAttributeToBeNotEmpty(int durationSec, WebElement webElement, String attribute) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSec));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(webElement, attribute));
    }

    public void driverWaitVisibilityOf(int durationSec, WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSec));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}
