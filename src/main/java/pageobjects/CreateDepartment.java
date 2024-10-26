package pageobjects;

import core.BasePage;
import core.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GenerateCustomStringName;

import java.util.logging.Level;

public class CreateDepartment extends BasePage {

    @FindBy(xpath = "//input[@id='name']")
    private WebElement titleField;

    @FindBy(xpath = "//a[@id='department-form-additional-info']")
    private WebElement additionalInformation;

    @FindBy(xpath = "//input[@id='phone']")
    private WebElement phoneField;

    @FindBy(xpath = "//input[@id='skype']")
    private WebElement skypeField;

    @FindBy(xpath = "//input[@id='website']")
    private WebElement websiteField;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='country']")
    private WebElement countryField;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityField;

    @FindBy(xpath = "//input[@id='street']")
    private WebElement streetField;

    @FindBy(xpath = "//input[@id='building']")
    private WebElement buildingField;

    @FindBy(xpath = "//input[@id='zipcode']")
    private WebElement zipcodeField;

    @FindBy(xpath = "//input[@id='roomNumber']")
    private WebElement roomNumberField;

    @FindBy(xpath = "//button[@id='department-form-submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//button[@id='department-form-cancel']")
    private WebElement cancelButton;

    public CreateDepartment() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Fill all fields on 'Create New Department' page
     */
    public void fillAllFields(String titleValue, String phoneValue, String skypeValue, String websiteValue,
                              String emailValue, String countryValue, String cityValue, String streetValue,
                              String buildingValue, String zipcodeValue, String roomNumberValue) {
        Logger.getLog(Level.ALL, "Fill all fields on 'Create New Department' page");

        titleField.sendKeys(GenerateCustomStringName.getStringWithDateTime(titleValue));
        additionalInformation.click();
        phoneField.sendKeys(phoneValue);
        skypeField.sendKeys(skypeValue);
        websiteField.sendKeys(websiteValue);
        emailField.sendKeys(emailValue);
        countryField.sendKeys(countryValue);
        cityField.sendKeys(cityValue);
        streetField.sendKeys(streetValue);
        buildingField.sendKeys(buildingValue);
        zipcodeField.sendKeys(zipcodeValue);
        roomNumberField.sendKeys(roomNumberValue);
    }

    /**
     * Create New Department with full info
     */
    public void createDepartmentWithFullInfo(String titleValue, String phoneValue, String skypeValue, String websiteValue,
                                             String emailValue, String countryValue, String cityValue, String streetValue,
                                             String buildingValue, String zipcodeValue, String roomNumberValue) {
        Logger.getLog(Level.ALL, "Create New Department with full info");

        fillAllFields(titleValue, phoneValue, skypeValue, websiteValue, emailValue, countryValue, cityValue, streetValue,
                buildingValue, zipcodeValue, roomNumberValue);
        submitButton.click();
    }
}
