package core;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.GenerateCustomStringName;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class ChromeDriver extends BasePage{

    private static ChromeDriver instance;

    private ChromeDriver() {}

    public static ChromeDriver getInstance() {
        Logger.getLog(Level.ALL, "Get Instance of ChromeDriver");

        if(instance == null) {
            instance = new ChromeDriver();
        }
        return instance;
    }

    public WebDriver setUp() throws IOException {
        Logger.getLog(Level.ALL, "Setup configuration of WebDriver");

        driver = new org.openqa.selenium.chrome.ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        BasePage.setDriver(driver);
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("conf.properties"));
        driver.get(System.getProperty("url"));
        return driver;
    }

    /**
     * Make screenshot
     */
    public ChromeDriver captureScreenShot(String className, String testName) throws IOException {
        Logger.getLog(Level.ALL, "Make screenshot");

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./screenshots/"+GenerateCustomStringName.getStringWithDateTime(className + "_" + testName + "_") +".png"));
            System.out.println("Screenshot taken");
        }
        catch (Exception e) {
            System.out.println("Screenshot is not taken");
            e.printStackTrace();
        }
        return instance;
    }

    public void tearDown() {
        Logger.getLog(Level.ALL, "Stop WebDriver process & Close browser");

//        driver.close(); // close the current browser/tab, if there’s only one browser window open then will close the entire browser session.
        driver.quit(); // quit the entire browser session along with all the windows, tabs and pop-ups, terminate the WebDriver session.
    }
}
