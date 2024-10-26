package tests;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import pageobjects.Contacts;
import pageobjects.CreateContact;
import pageobjects.LoginPage;
import pageobjects.Managers;
import utils.GenerateRandomValue;

import java.io.IOException;

public class Task22 extends BaseTest {

    @Test
    @DisplayName("Verify Error messages (Validation texts) on 'Create New Contact' page")
    public void task22_test1() throws IOException {

        //Testing Data:
        String lastNameValue = "a";
        String emailValue = "";
        String loginValue = "";
        String prefixValue = "a";

        String message1 = "Last name must be at least 2 characters long.";
        String message2 = "Email is required";
        String message3 = "Email must be valid";
        String message4 = "Login is required";
        String message5 = "Tickets prefix must be from 3 to 6 characters long";

        //Make login to App
        LoginPage loginPage = new LoginPage();
        loginPage.makeLogin();

        //Go to Contacts page
        Contacts contacts = new Contacts();
        contacts.goToContacts();

        //Go to Create New Manager page
//        contacts.closePopup();
        contacts.goToCreateNewContact();

        //Trigger Error messages (validation)
        CreateContact createContact = new CreateContact();
        createContact.setLN(lastNameValue)
                .setEmail(emailValue)
                .setLogin(loginValue)
                .setTicketsPrefix(prefixValue)
                .setLogin(loginValue);

        //Save texts from UI into strings
        String message1fromUI = createContact.getTextErrorMessageLastNameValid();
        String message2fromUI = createContact.getTextErrorMessageEmailReq();
        String message3fromUI = createContact.getTextErrorMessageEmailValid();
        String message4fromUI = createContact.getTextErrorMessageLoginReq();
        String message5fromUI = createContact.getTextErrorMessageTicketsPrefixValid();

        //Compare Entered and UI values
        Assert.assertEquals("+ + + Error message with Validation text 'Last name must be at least 2 characters long.' is NOT displayed + + +", message1, message1fromUI);
        System.out.println("+ + + Error message with Validation text 'Last name must be at least 2 characters long.' is displayed + + +");

        Assert.assertEquals("+ + + Error message with Validation text 'Email is required' is NOT displayed + + +", message2, message2fromUI);
        System.out.println("+ + + Error message with Validation text 'Email is required' is displayed + + +");

        Assert.assertEquals("+ + + Error message with Validation text 'Email must be valid' is NOT displayed + + +", message3, message3fromUI);
        System.out.println("+ + + Error message with Validation text 'Email must be valid' is displayed + + +");

        Assert.assertEquals("+ + + Error message with Validation text 'Login is required' is NOT displayed + + +", message4, message4fromUI);
        System.out.println("+ + + Error message with Validation text 'Login is required' is displayed + + +");

        Assert.assertEquals("+ + + Error message with Validation text 'Tickets prefix must be from 3 to 6 characters long' is NOT displayed + + +", message5, message5fromUI);
        System.out.println("+ + + Error message with Validation text 'Tickets prefix must be from 3 to 6 characters long' is displayed + + +");
    }
}
