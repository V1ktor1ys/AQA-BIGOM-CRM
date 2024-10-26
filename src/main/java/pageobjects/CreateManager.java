package pageobjects;

import core.BasePage;
import core.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.logging.Level;

public class CreateManager extends BasePage {

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

    public CreateManager() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Fill all fields on 'Create New Manager' page
     */
    public void fillAllFields(String firstNameValue, String lastNameValue, String emailValue,
                              String loginValue, String departmentValue, int phoneValue,
                              String skypeValue) {
        Logger.getLog(Level.ALL, "Fill all fields on 'Create New Manager' page");

        firstNameField.sendKeys(firstNameValue);
        lastNameField.sendKeys(lastNameValue);
        emailField.sendKeys(emailValue);
        loginField.clear();
        loginField.sendKeys(loginValue);
        new Select(departmentDropDown).selectByVisibleText(departmentValue);
        phoneField.sendKeys(String.valueOf(phoneValue));
        skypeField.sendKeys(skypeValue);
    }

    /**
     * Create New Manager with full info
     */
    public void createManagerWithFullInfo(String firstNameValue, String lastNameValue, String emailValue,
                                          String loginValue, String departmentValue, int phoneValue,
                                          String skypeValue) {
        Logger.getLog(Level.ALL, "Create New Manager with full info");

        fillAllFields(firstNameValue, lastNameValue, emailValue, loginValue, departmentValue, phoneValue, skypeValue);
        submitButton.click();
    }

    /**
     * Set First Name
     */
    public CreateManager setFN(String firstNameValue) {
        Logger.getLog(Level.ALL, "Set First Name");

        firstNameField.sendKeys(firstNameValue);
        return this;
    }

    /**
     * Set Last Name
     */
    public CreateManager setLN(String lastNameValue) {
        Logger.getLog(Level.ALL, "Set Last Name");

        lastNameField.sendKeys(lastNameValue);
        return this;
    }

    /**
     * Set Email
     */
    public CreateManager setEmail(String emailValue) {
        Logger.getLog(Level.ALL, "Set Email");

        emailField.sendKeys(emailValue);
        return this;
    }

    /**
     * Set Login
     */
    public CreateManager setLogin(String loginValue) {
        Logger.getLog(Level.ALL, "Set Login");

        loginField.clear();
        loginField.sendKeys(loginValue);
        return this;
    }

    /**
     * Set Department
     */
    public CreateManager setDepartment(String departmentValue) {
        Logger.getLog(Level.ALL, "Set Department");

        new Select(departmentDropDown).selectByVisibleText(departmentValue);
        return this;
    }

    /**
     * Set Phone
     */
    public CreateManager setPhone(int phoneValue) {
        Logger.getLog(Level.ALL, "Set Phone");

        phoneField.sendKeys(String.valueOf(phoneValue));
        return this;
    }

    /**
     * Set Skype
     */
    public CreateManager setSkype(String skypeValue) {
        Logger.getLog(Level.ALL, "Set Skype");

        skypeField.sendKeys(skypeValue);
        return this;
    }

    /**
     * Click Submit
     */
    public CreateManager submit() {
        Logger.getLog(Level.ALL, "Submit");

        submitButton.click();
        return this;
    }
}
