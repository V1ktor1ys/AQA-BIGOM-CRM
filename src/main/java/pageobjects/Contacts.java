package pageobjects;

import core.BasePage;
import core.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Level;

public class Contacts extends BasePage {

    @FindBy(xpath = "//span[@class='navbar-brand']")
    private WebElement contacts;

    @FindBy(xpath = "//a[@id='menu-contacts']//i[@class='material-icons']")
    private WebElement menuContactsButton;

    @FindBy(xpath = "//button[@id='new-contact']")
    private WebElement newContactButton;

    @FindBy(xpath = "//button[@id='infoButtonClose']")
    private WebElement closeButtonForErrorPopup;

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstNameSearchField;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastNameSearchField;

    @FindBy(xpath = "//button[@id='search-contacts']")
    private WebElement searchContactButton;

    @FindBy(xpath = "//a[@id='edit-btn']")
    private WebElement editContactButton;

    @FindBy(xpath = "//a[@id='delete-btn']")
    private WebElement deleteContactButton;

    @FindBy(xpath = "//table[@class='table table-striped']//tr[2]//td[1]")
    private WebElement fullNameInGrid;

    @FindBy(xpath = "//table[@class='table table-striped']//tr[2]//td[2]")
    private WebElement companyInGrid;

    @FindBy(xpath = "//table[@class='table table-striped']//tr[2]//td[3]")
    private WebElement phoneInGrid;

    @FindBy(xpath = "//table[@class='table table-striped']//tr[2]//td[4]")
    private WebElement emailInGrid;

    @FindBy(linkText = "Are you confirm delete?")
    private WebElement deleteConfirmPopUp;

    @FindBy(linkText = "//tr[2]")
    private WebElement firstResultLine;


    public Contacts() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Go to Contacts page (click on Contacts menu button)
     */
    public void goToContacts() {
        Logger.getLog(Level.ALL, "Navigate to 'Contacts' page");

        menuContactsButton.click();
    }

    /**
     * Close Internal Server Error Pop-up
     */
    public void closePopup() {
        Logger.getLog(Level.ALL, "Close Error Pop-up");

        closeButtonForErrorPopup.click();
    }

    /**
     * Go to Create New Ticket page
     */
    public void goToCreateNewContact() {
        Logger.getLog(Level.ALL, "Navigate to 'New Contact' page");

        newContactButton.click();
    }

    /**
     * Search the Contact
     */
    public void searchCreatedContact(String firstNameValue, String lastNameValue) {
        Logger.getLog(Level.ALL, "Search the Contact");

        firstNameSearchField.clear();
        firstNameSearchField.sendKeys(firstNameValue);
        lastNameSearchField.clear();
        lastNameSearchField.sendKeys(lastNameValue);
        searchContactButton.click();
    }

    /**
     * Click on Edit Contact button
     */
    public void clickContactEditButton() {
        Logger.getLog(Level.ALL, "Click on Edit Contact button");

        driverWaitVisibilityOfElem(10, "//a[@id='edit-btn']");

        editContactButton.click();
    }

    /**
     * Click on Delete Contact button
     */
    public void clickContactDeleteButton() {
        Logger.getLog(Level.ALL, "Click on Delete Contact button");

        driverWaitVisibilityOfElem(10, "//a[@id='delete-btn']");

        deleteContactButton.click();
    }

    /**
     * Press OK on the delete confirmation pop-up
     */
    public void confirmDeleteContact() {
        Logger.getLog(Level.ALL, "Press OK on the delete confirmation pop-up");

        driver.switchTo().alert().accept();
    }
}
