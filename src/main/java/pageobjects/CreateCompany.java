package pageobjects;

import core.BasePage;
import core.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GenerateCustomStringName;

import java.util.logging.Level;

public class CreateCompany extends BasePage {

    @FindBy(xpath = "//input[@id='name']")
    private WebElement companyNameField;

    @FindBy(xpath = "//input[@id='ticketPrefix']")
    private WebElement ticketsPrefixField;

    @FindBy(xpath = "//a[@id='company-additional-information']")
    private WebElement additionalInformation;

    @FindBy(xpath = "//input[@id='company-country']")
    private WebElement countryField;

    @FindBy(xpath = "//input[@id='company-city']")
    private WebElement cityField;

    @FindBy(xpath = "//input[@id='company-street']")
    private WebElement streetField;

    @FindBy(xpath = "//input[@id='company-building']")
    private WebElement buildingField;

    @FindBy(xpath = "//input[@id='company-zipcode']")
    private WebElement zipCodeField;

    @FindBy(xpath = "//input[@id='company-roomNumber']")
    private WebElement roomNumberField;

    @FindBy(xpath = "//input[@id='company-skype']")
    private WebElement skypeField;

    @FindBy(xpath = "//input[@id='company-website']")
    private WebElement websiteField;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='edrpou']")
    private WebElement edrpouField;

    @FindBy(xpath = "//input[@id='company.phone']")
    private WebElement phoneField;

    @FindBy(xpath = "//input[@id='company-sla-level-1']")
    private WebElement serviceList_0_level;

    @FindBy(xpath = "//input[@id='company-sla-level-2']")
    private WebElement serviceList_1_level;

    @FindBy(xpath = "//input[@id='company-sla-level-3']")
    private WebElement serviceList_2_level;

    @FindBy(xpath = "//input[@id='company-sla-level-4']")
    private WebElement serviceList_3_level;

    @FindBy(xpath = "//button[@id='company-submit-btn']")
    private WebElement submitButton;

    @FindBy(xpath = "//button[@id='company-cancel-btn']")
    private WebElement cancelButton;

    public CreateCompany() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Fill all fields on 'Create New Company' page
     */
    public void fillAllFields(String companyNameValue, String countryValue, String cityValue, String streetValue,
                              String buildingValue, String zipCodeValue, String roomNumberValue, String skypeValue,
                              String websiteValue, String emailValue, String edrpouValue, int phoneValue) {

        Logger.getLog(Level.ALL, "Fill all fields on Create New Company page");

        companyNameField.sendKeys(companyNameValue);
        additionalInformation.click();
        countryField.sendKeys(countryValue);
        cityField.sendKeys(cityValue);
        streetField.sendKeys(streetValue);
        buildingField.sendKeys(buildingValue);
        zipCodeField.sendKeys(zipCodeValue);
        roomNumberField.sendKeys(roomNumberValue);
        skypeField.sendKeys(skypeValue);
        websiteField.sendKeys(websiteValue);
        emailField.sendKeys(emailValue);
        edrpouField.sendKeys(edrpouValue);
        phoneField.sendKeys(String.valueOf(phoneValue));
        serviceList_1_level.click();
    }

    /**
     * Create New Company with full info
     */
    public void createCompanyWithFullInfo(String companyNameValue, String countryValue, String cityValue,
                                          String streetValue, String buildingValue, String zipCodeValue,
                                          String roomNumberValue, String skypeValue, String websiteValue,
                                          String emailValue, String edrpouValue, int phoneValue) {
        Logger.getLog(Level.ALL, "Create New Company with full info");

        fillAllFields(companyNameValue, countryValue, cityValue, streetValue, buildingValue, zipCodeValue,
                roomNumberValue, skypeValue, websiteValue, emailValue, edrpouValue, phoneValue);
        submitButton.click();
    }
}
