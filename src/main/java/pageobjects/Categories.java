package pageobjects;

import core.BasePage;
import core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.logging.Level;

public class Categories extends BasePage {

    @FindBy(xpath = "//span[@class='navbar-brand']")
    private WebElement categories;

    @FindBy(xpath = "//a[@id='menu-categories']//i[@class='material-icons']")
    private WebElement menuCategoriesButton;

    @FindBy(xpath = "//input[@id='search-bar']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@id='search-bar-submit']")
    private WebElement doSearchButton;

    @FindBy(xpath = "//button[@id='new-category-btn']")
    private WebElement newCategoryButton;

    public Categories() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Go to Tickets page (click on Tickets menu button)
     */
    public void goToCategories() {
        Logger.getLog(Level.ALL, "Navigate to 'Tickets' page");

        menuCategoriesButton.click();
    }

    /**
     * Return Title name & Color of new created Category
     */
    public String getTitleColorFromUI(String searchedTitle) {
        Logger.getLog(Level.ALL, "Return Title name & Color of new created Category");

        WebElement webElement1 = driver.findElement(By.xpath("//a[contains(text(),'" + searchedTitle + "')]"));
        WebElement webElement2 = driver.findElement(By.xpath("//a[contains(text(),'" + searchedTitle + "')]/../..//td[2]//span"));
        return webElement1.getText() + " " + webElement2.getText();
    }

    /**
     * Go to Create New Category page
     */
    public void goToCreateNewCategory() {
        Logger.getLog(Level.ALL, "Navigate to 'Create New Category' page");

        newCategoryButton.click();
    }
}
