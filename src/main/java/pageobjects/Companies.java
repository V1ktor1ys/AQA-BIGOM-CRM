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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Companies extends BasePage {

    @FindBy(xpath = "//a[@id='menu-companies']")
    private WebElement companies;

    @FindBy(xpath = "//button[@id='new-company']")
    private WebElement newCompanyButton;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@id='search-company-submit']")
    private WebElement doSearchButton;

    @FindBy(xpath = "//table[@class='table table-striped']//tr[2]//td")
    private WebElement companyNameInGrid;

    @FindBy(xpath = "//table[@class='table table-striped']//tr[2]//td[2]")
    private WebElement companyPhoneInGrid;

    @FindBy(xpath = "//table[@class='table table-striped']//tr[2]//td[3]")
    private WebElement companyEmailInGrid;

    public Companies() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Go to Companies page
     */
    public void goToCompaniesPage() {
        Logger.getLog(Level.ALL, "Navigate to 'Companies' page");

        companies.click();
    }

    /**
     * Go to Create New Company page
     */
    public void goToCreateNewCompany() {
        Logger.getLog(Level.ALL, "Navigate to 'Create New Company' page");

        newCompanyButton.click();
    }

    /**
     * Search created Company
     */
    public void searchCompany(String searchingValue) {
        Logger.getLog(Level.ALL, "Search created Company");

        driverWaitVisibilityOfElem(10, "//input[@id='name']");

        searchField.sendKeys(searchingValue, Keys.ENTER);
    }

    /**
     * Get Title(Name) text
     */
    public String getCompanyName() {
        Logger.getLog(Level.ALL, "Get Title(Name) text");

        driverWaitVisibilityOfElem(10, "//table[@class='table table-striped']//tr[2]//td");

        return companyNameInGrid.getText();
    }

    /**
     * Get Title(Name), Phone, Email texts (List)
     */
    public List<String> getCompanyNamePhoneEmailFromUI() {
        Logger.getLog(Level.ALL, "Get Title, Phone, Email texts (List)");

        driverWaitVisibilityOfElem(10, "//table[@class='table table-striped']//tr[2]//td");

        List<String> searchedCompanyNamePhoneEmail = new ArrayList<>();
        searchedCompanyNamePhoneEmail.add(companyNameInGrid.getText());
        searchedCompanyNamePhoneEmail.add(companyPhoneInGrid.getText());
        searchedCompanyNamePhoneEmail.add(companyEmailInGrid.getText());

        return searchedCompanyNamePhoneEmail;
    }
}
