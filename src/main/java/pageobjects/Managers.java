package pageobjects;

import core.BasePage;
import core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class Managers extends BasePage {

    @FindBy(xpath = "//a[@id='menu-managers']")
    private WebElement menuManagersButton;

    @FindBy(xpath = "//button[@id='managers-new-manager']")
    private WebElement newManagerButton;

    @FindBy(xpath = "//input[@id='search-manager-firstname']")
    private WebElement firstNameSearchField;

    @FindBy(xpath = "//input[@id='search-manager-lastname']")
    private WebElement lastNameSearchField;

    @FindBy(xpath = "//input[@id='search-manager-department']")
    private WebElement departmentSearchField;

    @FindBy(xpath = "//a[@id='managers-edit-btn']")
    private WebElement editManagerButton;

    @FindBy(xpath = "//table[@class='table table-striped']//tr[2]//td")
    private WebElement fullNameInGrid;

    @FindBy(xpath = "//table[@class='table table-striped']//tr[2]//td[2]")
    private WebElement departmentInGrid;

    @FindBy(xpath = "//table[@class='table table-striped']//tr[2]//td[3]")
    private WebElement phoneInGrid;

    @FindBy(xpath = "//table[@class='table table-striped']//tr[2]//td[4]")
    private WebElement emailInGrid;

    public Managers() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Go to Managers page
     */
    public void goToManagers() {
        Logger.getLog(Level.ALL, "Navigate to 'Managers' page");

        menuManagersButton.click();
    }

    /**
     * Go to Create New Manager page
     */
    public void goToCreateNewManager() {
        Logger.getLog(Level.ALL, "Navigate to 'Create New Manager' page");

        newManagerButton.click();
    }

    /**
     * Search & Open the created manager
     */
    public void searchCreatedManager(String aaa, String bbb) {
        Logger.getLog(Level.ALL, "Search & Open the created manager");

        driverWaitVisibilityOfElem(10, "//input[@id='search-manager-firstname']");

        firstNameSearchField.sendKeys(aaa);
        lastNameSearchField.sendKeys(bbb, Keys.ENTER);
        editManagerButton.click();
    }

    /**
     * Only Search the created manager
     */
    public void searchOnlyCreatedManager(String aaa, String bbb, String ccc) {
        Logger.getLog(Level.ALL, "Search the created manager");

        driverWaitVisibilityOfElem(10, "//input[@id='search-manager-firstname']");

        firstNameSearchField.sendKeys(aaa);
        lastNameSearchField.sendKeys(bbb);
        departmentSearchField.sendKeys(ccc, Keys.ENTER);
    }

    /**
     * Get Full Name text
     */
    public String getFullName() {
        Logger.getLog(Level.ALL, "Get Full Name text");

        driverWaitVisibilityOfElem(10, "//table[@class='table table-striped']//tr[2]//td");

        return fullNameInGrid.getText();
    }

    /**
     * Get Department text
     */
    public String getDepartment() {
        Logger.getLog(Level.ALL, "Get Department text");

        driverWaitVisibilityOfElem(10, "//table[@class='table table-striped']//tr[2]//td[2]");

        return departmentInGrid.getText();
    }

    /**
     * Get Full Name, Department, Phone, Email texts (Map)
     */
    public Map<String, String> getFullNameDepPhoneEmailFromUI() {
        Logger.getLog(Level.ALL, "Get Full Name, Department, Phone, Email texts (Map)");

        driverWaitVisibilityOfElem(10, "//table[@class='table table-striped']//tr[2]//td");

        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("fullName", fullNameInGrid.getText());
        map1.put("department", departmentInGrid.getText());
        map1.put("phone", phoneInGrid.getText());
        map1.put("email", emailInGrid.getText());
        return map1;
    }

    /**
     * Navigate to 'Managers' page
     * Method for Task13
     */
    public Managers goToManagers2() {
        Logger.getLog(Level.ALL, "Navigate to 'Managers' page");

        menuManagersButton.click();
        return this;
    }
}
