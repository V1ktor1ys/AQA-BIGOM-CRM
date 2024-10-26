package pageobjects;

import core.BasePage;
import core.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.logging.Level;

public class CreateManager2 extends BasePage {

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id = 'login']")
    private WebElement loginField;

    @FindBy(xpath = "//select[@id = 'manager-form-department-select']")
    private WebElement departmentDropDown;

    @FindBy(xpath = "//input[@id='phone']")
    private WebElement phoneField;

    @FindBy(xpath = "//input[@id='skype']")
    private WebElement skypeField;

    @FindBy(xpath = "//button[@id='manager-form-submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//button[@id='manager-form-cancel']")
    private WebElement cancelButton;

    private static CreateManager2 instance;

    private CreateManager2() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Get Instance
     */
    public static CreateManager2 getInstance() {
        Logger.getLog(Level.ALL, "Get Instance");

        if (instance == null) {
            instance = new CreateManager2();
        }
        return instance;
    }

    /**
     * Create New Manager with full info (Method/Variant 2)
     */
    public void createManagerWithFullInfo2(String firstNameValue, String lastNameValue, String emailValue,
                                           String loginValue, String departmentValue, int phoneValue,
                                           String skypeValue) {
        Logger.getLog(Level.ALL, "Create New Manager with full info (Method 2)");

        firstNameField.sendKeys(firstNameValue);
        lastNameField.sendKeys(lastNameValue);
        emailField.sendKeys(emailValue);
        loginField.clear();
        loginField.sendKeys(loginValue);
        new Select(departmentDropDown).selectByVisibleText(departmentValue);
        phoneField.sendKeys(String.valueOf(phoneValue));
        skypeField.sendKeys(skypeValue);
        submitButton.click();
    }

    /**
     * Set First Name
     */
    public void setFN2(String firstNameValue) {
        Logger.getLog(Level.ALL, "Create New Manager with full info (Method 2)");

        firstNameField.sendKeys(firstNameValue);
    }

    /**
     * Set Last Name
     */
    public void setLN2(String lastNameValue) {
        Logger.getLog(Level.ALL, "Set Last Name");

        lastNameField.sendKeys(lastNameValue);
    }

    /**
     * Set Email
     */
    public void setEmail2(String emailValue) {
        Logger.getLog(Level.ALL, "Set Email");

        emailField.sendKeys(emailValue);
    }
}