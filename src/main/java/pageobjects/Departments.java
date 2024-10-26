package pageobjects;

import core.BasePage;
import core.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Level;

public class Departments extends BasePage {

    @FindBy(xpath = "//a[@id='menu-departments']")
    private WebElement departments;

    @FindBy(xpath = "//button[@id='new-department']")
    private WebElement newDepartmentButton;

    @FindBy(xpath = "//input[@id='department-search-title']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@id='department-search-filter']")
    private WebElement doSearchButton;

    public Departments() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Go to Departments page
     */
    public void goToDepartmentsPage() {
        Logger.getLog(Level.ALL, "Navigate to 'Departments' page");

        departments.click();
    }

    /**
     * Go to Create New Department page
     */
    public void goToCreateNewDepartment() {
        Logger.getLog(Level.ALL, "Navigate to 'Create New Department' page");

        newDepartmentButton.click();
    }
}
