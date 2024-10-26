package pageobjects;

import core.BasePage;
import core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.logging.Level;

public class Dashboard extends BasePage {

    @FindBy(xpath = "//a[@id='menu-dashboard']//i[@class='material-icons']")
    private WebElement menuDashboardButton;

    @FindBy(xpath = "//span[@class='navbar-brand']")
    private WebElement dashboard;

    @FindBy(xpath = "//button[@id='dashboard-done']")
    private WebElement doneDeadlineButton;

    @FindBy(xpath = "//a[@id='company-additional-information']")
    private WebElement deadlineIsOverDropDown;

    public Dashboard() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Show/Open 'Deadline is over' table
     */
    public void deadlineIsOverList() {
        Logger.getLog(Level.ALL, "Show/Open 'Deadline is over' table");

        menuDashboardButton.click();
        doneDeadlineButton.click();
        deadlineIsOverDropDown.click();
    }

    /**
     * Print values from table (from X column & by X filter);
     */
    public void showTitlesByFilter(DashboardFilter filter) {
        Logger.getLog(Level.ALL, "Print values from table (from X column & by X filter)");

        driverWaitVisibilityOfElem(10, "//div[@id='collapse7']//tr");

        List<WebElement> matchingRows = driver.findElements(By.xpath(filter.getFilters()));
        for (WebElement result : matchingRows) {
            System.out.println(result.getText());
        }
    }
}


