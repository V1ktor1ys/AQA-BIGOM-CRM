package pageobjects;

import core.BasePage;
import core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;

public class CreateTicket extends BasePage {

    @FindBy(xpath = "//button[@id='new-inner-ticket']")
    private WebElement newInnerTicketTab;

    @FindBy(xpath = "//input[@id='title']")
    private WebElement titleTextField;

    @FindBy(xpath = "//textarea[@id='description']")
    private WebElement descriptionTextAreaField;

    @FindBy(xpath = "//select[@id='categoryId']")
    private WebElement categoryDropDown;

    @FindBy(xpath = "//select[@id='categoryId']/option")
    private WebElement categoryDropDownAllOptions;

    @FindBy(xpath = "//select[@id='stageId']")
    private WebElement stageDropDown;

    @FindBy(xpath = "//select[@id='company']")
    private WebElement companyDropDown;

    @FindBy(xpath = "//select[@id='contactId']")
    private WebElement contactDropDown;

    @FindBy(xpath = "//button[@id='new-contact-for-ticket']")
    private WebElement createNewContactButton;

    @FindBy(xpath = "//select[@id='priority']")
    private WebElement priorityDropDown;

    @FindBy(xpath = "//input[@name='deadline']")
    private WebElement doneDeadlineTextField;

    @FindBy(xpath = "//span[@class='ng-tns-c18-2 ui-calendar ui-calendar-w-btn']/button")
    private WebElement doneDeadlineCalendarButton;

    @FindBy(xpath = "//td[@class='ng-tns-c18-2 ui-datepicker-today']")
    private WebElement doneDeadlineCalendarTodayButton;

    @FindBy(xpath = "//select[@id='department']")
    private WebElement departmentDropDown;

    @FindBy(xpath = "//select[@id='manager']")
    private WebElement managerDropDown;

    @FindBy(xpath = "//button[@id='add-files']")
    private WebElement selectFilesButton;

    @FindBy(xpath = "//button[@id='submit-btn']")
    private WebElement submitButton;

    @FindBy(xpath = "//button[@id='cancel-btn']")
    private WebElement cancelButton;

    @FindBy(xpath = "//button[@id='edit-1']")
    private WebElement editButton;

    @FindBy(xpath = "//button[@id='forward-to-tickets']")
    private WebElement backButton;

    public CreateTicket() {
        PageFactory.initElements(driver, this);
    }


    /**
     * Fill all fields on CreateTicket page
     */
    public void fillAllFields(String titleValue, String descriptionValue, int stageValue, int companyValue,
                              int contactValue, int priorityValue, int departmentValue) {

        titleTextField.sendKeys(titleValue);
        descriptionTextAreaField.sendKeys(descriptionValue);
        selectRandomCategory();
        Select stage = new Select(stageDropDown);
        stage.selectByIndex(stageValue);
        Select company = new Select(companyDropDown);
        company.selectByIndex(companyValue);
        Select contact = new Select(contactDropDown);
        contact.selectByIndex(contactValue);
        Select priority = new Select(priorityDropDown);
        priority.selectByIndex(priorityValue);
        Select department = new Select(departmentDropDown);
        department.selectByIndex(departmentValue);
    }

    /**
     * Fill all fields on CreateTicket/InnerTicket page
     */
    public void fillAllFieldsInnerTicket(String titleValue, String descriptionValue, int stageValue,
                                         int departmentValue) {

        titleTextField.sendKeys(titleValue);
        descriptionTextAreaField.sendKeys(descriptionValue);
        selectRandomCategory();
        Select stage = new Select(stageDropDown);
        stage.selectByIndex(stageValue);
        Select department = new Select(departmentDropDown);
        department.selectByIndex(departmentValue);
    }

    /**
     * Create New Ticket
     */
    public void createTicket(String titleValue, String descriptionValue, int stageValue, int companyValue, int contactValue,
                             int priorityValue, int departmentValue) {
        Logger.getLog(Level.ALL, "Create New Ticket");

        driverWaitVisibilityOfElem(10, "//input[@id='title']");

        fillAllFields(titleValue, descriptionValue, stageValue, companyValue, contactValue, priorityValue, departmentValue);

        submitButton.click();
    }

    /**
     * Create New Inner Ticket
     */
    public void createInnerTicket(String titleValue, String descriptionValue, int stageValue, int departmentValue) {
        Logger.getLog(Level.ALL, "Create New Inner Ticket");

        newInnerTicketTab.click();
        fillAllFieldsInnerTicket(titleValue, descriptionValue, stageValue, departmentValue);
        submitButton.click();
    }

    /**
     * Update Ticket
     */
    public void updateTicket(String titleValue, String descriptionValue, int stageValue, int companyValue, int contactValue,
                             int priorityValue, int departmentValue) {
        Logger.getLog(Level.ALL, "Update the Ticket");

        driverWaitVisibilityOfElem(10, "//app-ticket-contact-info-details");

        editButton.click();

        driverWaitAttributeToBeNotEmpty(10, titleTextField, "value");

        titleTextField.clear();
        descriptionTextAreaField.clear();
        fillAllFields(titleValue, descriptionValue, stageValue, companyValue, contactValue, priorityValue, departmentValue);
        submitButton.click();
    }

    /**
     * Update 2 fields in the Ticket (Title & Description)
     */
    public void updateTitleDescrInTicket(String titleValue2, String descriptionValue2) {
        Logger.getLog(Level.ALL, "Update 2 fields in the Ticket");

        driverWaitVisibilityOfElem(10, "//app-ticket-contact-info-details");

        editButton.click();

        driverWaitAttributeToBeNotEmpty(10, titleTextField, "value");

        titleTextField.clear();
        titleTextField.sendKeys(titleValue2);
        descriptionTextAreaField.clear();
        descriptionTextAreaField.sendKeys(descriptionValue2);
        submitButton.click();
    }

    /**
     * Select random element from Category drop-down
     */
    public void selectRandomCategory() {
        Logger.getLog(Level.ALL, "Select random element from Category drop-down");

        Select category = new Select(categoryDropDown);
        List<WebElement> listOfCategories = category.getOptions();
        int listOfCategoriesResult = listOfCategories.size();

        Random random = new Random();
        int index = random.nextInt(listOfCategoriesResult);

        category.selectByIndex(index);
    }
}
