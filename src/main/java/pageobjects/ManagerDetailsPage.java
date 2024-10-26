package pageobjects;

import core.BasePage;
import core.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.logging.Level;

public class ManagerDetailsPage extends BasePage {

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//div[@class='several-emails_email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='manager-form-login']")
    private WebElement loginField;

    @FindBy(xpath = "//select[@id='manager-form-department-select']")
    private WebElement departmentDropDown;

    @FindBy(xpath = "//input[@id='phone']")
    private WebElement phoneField;

    @FindBy(xpath = "//input[@id='skype']")
    private WebElement skypeField;

    public ManagerDetailsPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Get First Name
     */
    public String getFirstName() {
        Logger.getLog(Level.ALL, "Get First Name");

        return firstNameField.getAttribute("value");
    }

    /**
     * Get Last Name
     */
    public String getLastName() {
        Logger.getLog(Level.ALL, "Get Last Name");

        return lastNameField.getAttribute("value");
    }

    /**
     * Get Email
     */
    public String getEmail() {
        Logger.getLog(Level.ALL, "Get Email");

        return emailField.getText();
    }

    /**
     * Get Login
     */
    public String getLogin() {
        Logger.getLog(Level.ALL, "Get Login");

        return loginField.getAttribute("value");
    }

    /**
     * Get Department
     */
    public String getDepartment() {
        Logger.getLog(Level.ALL, "Get Department");

        Select select = new Select(departmentDropDown);
        return select.getFirstSelectedOption().getText();
    }

    /**
     * Get Phone
     */
    public String getPhone() {
        Logger.getLog(Level.ALL, "Get Phone");

        return phoneField.getAttribute("value");
    }

    /**
     * Get Skype
     */
    public String getSkype() {
        Logger.getLog(Level.ALL, "Get Skype");

        return skypeField.getAttribute("value");
    }
}
