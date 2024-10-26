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
import java.util.List;
import java.util.logging.Level;

public class Tickets extends BasePage {

    public static String showTicketIds = "//tr//td[2]//span//span";
    public static String showTicketTitles = "//tr//td[3]//a";
    public static String showTicketAssignees = "//td[@class='ticket_assignee']/tbody//span";
    public static String showTicketStages = "//tr/td[7]";

    @FindBy(xpath = "//a[@id='menu-tickets']//i[@class='material-icons']")
    private WebElement menuTicketsButton;

    @FindBy(xpath = "//span[@class='navbar-brand']")
    private WebElement tickets;

    @FindBy(xpath = "//a[@aria-label='Next page']")
    private WebElement nextButton;

    @FindBy(xpath = "//button[@id='create-new-ticket']")
    private WebElement newTicketButton;

    @FindBy(xpath = "//input[@id='search-bar']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@id='search-bar-submit']")
    private WebElement doSearchButton;

    @FindBy(xpath = "//div[@id='accordion3']")
    private WebElement ticketsList;

    @FindBy(xpath = "//h4[@class='bs-callout_headline']")
    private WebElement ticketNameInGrid;

    @FindBy(xpath = "//p[@class='bs-callout_description']")
    private WebElement ticketDescriptionInGrid;

    @FindBy(xpath = "//div[@class='task-search_type']")
    private WebElement ticketStageInGrid;

    public Tickets() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Go to Tickets page (click on Tickets menu button)
     */
    public void goToTickets() {
        Logger.getLog(Level.ALL, "Navigate to 'Tickets' page");

        menuTicketsButton.click();
    }

    /**
     * Go to Create New Ticket page
     */
    public void goToCreateNewTicket() {
        Logger.getLog(Level.ALL, "Navigate to 'New Ticket' page");

        newTicketButton.click();
    }

    /**
     * Open ticket
     */
    public void openTicket() {
        Logger.getLog(Level.ALL, "Open ticket");

        driverWaitVisibilityOfElem(30, "//h4[@class='bs-callout_headline']");

        ticketNameInGrid.click();
    }

    /**
     * Return all Title names
     */
    public void showTitleNames() {
        Logger.getLog(Level.ALL, "Return all Title names");

        List<WebElement> listOfTitleNames = driver.findElements(By.xpath("//tr[@style='background-color: #D3D3D3;']"));
        for (WebElement result : listOfTitleNames) {
            String titleName = result.getText().replaceAll("[↑↓]", "").trim();
            System.out.println(titleName);
        }
    }

    /**
     * Print all elements from X column
     * showTicketIds / showTicketTitles / showTicketAssignees / showTicketStages
     */
    public void showElements(String locator) {
        Logger.getLog(Level.ALL, "Print all elements from X column");

        List<WebElement> listOfElements = driver.findElements(By.xpath(locator));
        for (WebElement result : listOfElements) {
            System.out.println(result.getText());
        }
    }

    /**
     * Search created Ticket
     */
    public void searchTicket(String searchingValue) {
        Logger.getLog(Level.ALL, "Search created Ticket");

        driverWaitVisibilityOfElem(30, "//table[@class='ticket-table-ex ticket-table table table-striped table-responsive']");
//        driverWaitVisibilityOf(10, searchField);
//        driverWaitAttributeToBeNotEmpty(10, searchField, "value");
        searchField.clear();
        searchField.sendKeys(searchingValue, Keys.ENTER);
        ticketsList.click();
    }

    /**
     * Get Item Name text
     */
    public String getItemNameFromUI() {
        Logger.getLog(Level.ALL, "Get Item Name text");

        driverWaitVisibilityOfElem(10, "//div[@id='collapseThree']");

        return ticketNameInGrid.getText();
    }

    /**
     * Get Item Description text
     */
    public String getItemDescriptionFromUI() {
        Logger.getLog(Level.ALL, "Get Item Description text");

        driverWaitVisibilityOfElem(10, "//div[@id='collapseThree']");

        return ticketDescriptionInGrid.getText();
    }

    /**
     * Get Item Name text, Item Description text, Item Stage text
     */
    public String getItemNameDescrStageFromUI() {
        Logger.getLog(Level.ALL, "Get Item Name text, Item Description text, Item Stage text");

        driverWaitVisibilityOfElem(10, "//div[@id='collapseThree']");

        return ticketNameInGrid.getText() + " " + ticketDescriptionInGrid.getText() + " " + ticketStageInGrid.getText();
    }
}