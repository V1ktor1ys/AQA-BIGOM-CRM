package core;

import org.checkerframework.checker.signature.qual.ClassGetName;
import org.junit.Before;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.logging.Level;


abstract public class BaseTest {
    protected WebDriver driver;

    @Rule
    public TestName testName = new TestName();
    String className = this.getClass().getSimpleName();

    /**
     * Open browser ==> Navigate by URL from 'conf.properties' file
     */
    @Before
    public void setUp() throws IOException {
        Logger.getLog(Level.ALL, "+ + + Test Name: \"" + testName.getMethodName() + "\" + + +");

        ChromeDriver.getInstance().setUp();
    }

    /**
     * Make screenshot & Stop WebDriver process & Close browser
     */
    @After
    public void captureScreenShot() throws IOException {
        ChromeDriver.getInstance().captureScreenShot(className, testName.getMethodName()).tearDown();
    }
}
