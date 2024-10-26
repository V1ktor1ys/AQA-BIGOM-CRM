package pageobjects;

import core.BasePage;
import core.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Level;

public class CreateCategory extends BasePage {

    @FindBy(xpath = "//input[@id='name']")
    private WebElement titleTextField;

    @FindBy(xpath = "//input[@id='color']")
    private WebElement colorTextField;

    @FindBy(xpath = "//button[@id='category-form-submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//button[@id='category-form-cancel']")
    private WebElement cancelButton;

    @FindBy(xpath = "//button[@id='stage-details-back-to-list']")
    private WebElement backButton;

    public CreateCategory() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Create New Category
     */
    public void createCategory(String titleValue, String colorValue) {
        Logger.getLog(Level.ALL, "Create New Category");

        titleTextField.sendKeys(titleValue);
        colorTextField.sendKeys(colorValue);
        submitButton.click();
        backButton.click();
    }
}
