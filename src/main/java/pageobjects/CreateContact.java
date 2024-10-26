package pageobjects;

import core.BasePage;
import core.BaseTest;
import core.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class CreateContact extends BasePage {

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id = 'login']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@id = 'ticketPrefix']")
    private WebElement ticketsPrefixField;

    @FindBy(xpath = "//button[@id='contact-form-submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//button[@id='contact-form-cancel']")
    private WebElement cancelButton;

    @FindBy(xpath = "//input[@id='lastName']/../div")
    private WebElement errorMessageLastNameValid;

    @FindBy(xpath = "//input[@id='email']/../div/div")
    private WebElement errorMessageEmailReq;

    @FindBy(xpath = "//input[@id='email']/../div/div[2]")
    private WebElement errorMessageEmailValid;

    @FindBy(xpath = "//input[@id = 'login']/../div")
    private WebElement errorMessageLoginReq;

    @FindBy(xpath = "//input[@id = 'ticketPrefix']/../div")
    private WebElement errorMessageTicketsPrefixValid;

    public CreateContact() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Select First Name field
     */
    public void selectFN() {
        Logger.getLog(Level.ALL, "Select First Name field");

        firstNameField.click();
    }

    /**
     * Set First Name
     */
    public CreateContact setFN(String firstNameValue) {
        Logger.getLog(Level.ALL, "Set First Name");

        firstNameField.sendKeys(firstNameValue);
        return this;
    }

    /**
     * Set Last Name
     */
    public CreateContact setLN(String lastNameValue) {
        Logger.getLog(Level.ALL, "Set Last Name");

        lastNameField.sendKeys(lastNameValue);
        return this;
    }

    /**
     * Set Email
     */
    public CreateContact setEmail(String emailValue) {
        Logger.getLog(Level.ALL, "Set Email");

        emailField.sendKeys(emailValue);
        return this;
    }

    /**
     * Set Login
     */
    public CreateContact setLogin(String loginValue) {
        Logger.getLog(Level.ALL, "Set Login");

        loginField.clear();
        loginField.sendKeys(loginValue);
        return this;
    }

    /**
     * Set Tickets Prefix
     */
    public CreateContact setTicketsPrefix(String ticketPrefixValue) {
        Logger.getLog(Level.ALL, "Set Tickets Prefix");

        ticketsPrefixField.clear();
        ticketsPrefixField.sendKeys(ticketPrefixValue);
        return this;
    }

    /**
     * Get Last Name Error message
     */
    public String getTextErrorMessageLastNameValid() {
        Logger.getLog(Level.ALL, "Get Last Name Error message");

        return errorMessageLastNameValid.getText();
    }

    /**
     * Get Email Error message1
     */
    public String getTextErrorMessageEmailReq() {
        Logger.getLog(Level.ALL, "Get Email Error message1");

        return errorMessageEmailReq.getText();
    }

    /**
     * Get Email Error message2
     */
    public String getTextErrorMessageEmailValid() {
        Logger.getLog(Level.ALL, "Get Email Error message2");

        return errorMessageEmailValid.getText();
    }

    /**
     * Get Login Error message
     */
    public String getTextErrorMessageLoginReq() {
        Logger.getLog(Level.ALL, "Get Login Error message");

        return errorMessageLoginReq.getText();
    }

    /**
     * Get Tickets Prefix Error message
     */
    public String getTextErrorMessageTicketsPrefixValid() {
        Logger.getLog(Level.ALL, "Get Tickets Prefix Error message");

        return errorMessageTicketsPrefixValid.getText();
    }

    /**
     * Update First Name
     */
    public CreateContact updateFN(String firstNameValue2) {
        Logger.getLog(Level.ALL, "Update First Name");

        firstNameField.clear();
        firstNameField.sendKeys(firstNameValue2);
        return this;
    }

    /**
     * Update Last Name
     */
    public CreateContact updateLN(String lastNameValue2) {
        Logger.getLog(Level.ALL, "Update Last Name");

        lastNameField.clear();
        lastNameField.sendKeys(lastNameValue2);
        return this;
    }

    /**
     * Update Tickets Prefix
     */
    public CreateContact updateTicketsPrefix(String ticketPrefixValue2) {
        Logger.getLog(Level.ALL, "Update Tickets Prefix");

        ticketsPrefixField.clear();
        ticketsPrefixField.sendKeys(ticketPrefixValue2);
        return this;
    }

    /**
     * Click on Submit button
     */
    public void clickSubmitButton() {
        Logger.getLog(Level.ALL, "Click on Submit button");

        submitButton.click();
    }

    /**
     * Get First Name, Last Name and Tickets Prefix from Contact Details page
     */
    public List<String> getFirstLastTicketPrefix() {
        Logger.getLog(Level.ALL, "Get First Name, Last Name and Tickets Prefix from Contact Details page");

        List<String> list = new ArrayList<>();
        list.add(firstNameField.getAttribute("value"));
        list.add(lastNameField.getAttribute("value"));
        return list;
    }
}
