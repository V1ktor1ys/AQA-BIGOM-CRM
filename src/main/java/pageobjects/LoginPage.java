package pageobjects;

import core.BasePage;
import core.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.logging.Level;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id = 'username']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@id = 'password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id = 'login-signin']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@class= 'float-right']")
    private WebElement restorePasswordButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Read 'login' & 'password' from conf.properties file ==> Input ==> Log In;
     */
    public void makeLogin() throws IOException {
        Logger.getLog(Level.ALL, "User Login");

        System.getProperties().load(ClassLoader.getSystemResourceAsStream("conf.properties"));
        loginField.sendKeys(System.getProperty("login"));
        passwordField.sendKeys(System.getProperty("password"));
        loginButton.click();
    }
}
