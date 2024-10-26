package tests;

import core.BaseTest;
import core.DataBase;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import pageobjects.*;
import utils.GenerateRandomValue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Task24 extends BaseTest {

    @Test
    @DisplayName("Create & Edit Contact")
    public void task24_test1() throws IOException {

        //Testing Data:
        String firstNameValue = GenerateRandomValue.generateRandomAlphanumericString(8);
        String lastNameValue = GenerateRandomValue.generateRandomAlphanumericString(8);
        String emailValue = GenerateRandomValue.generateRandomStringLowerCase(8) + "@mail.com";
        String loginValue = GenerateRandomValue.generateRandomAlphanumericString(8);
        String prefixValue = GenerateRandomValue.generateRandomStringUpperCase(5);

        String firstNameValue2 = GenerateRandomValue.generateRandomAlphanumericString(8);
        String lastNameValue2 = GenerateRandomValue.generateRandomAlphanumericString(8);
        String prefixValue2 = GenerateRandomValue.generateRandomStringUpperCase(5);

        //Make login to App
        LoginPage loginPage = new LoginPage();
        loginPage.makeLogin();

        //Go to Contacts page
        Contacts contacts = new Contacts();
        contacts.goToContacts();

        //Go to Create New Contact page
//        contacts.closePopup();
        contacts.goToCreateNewContact();

        //Create New Contact
        CreateContact createContact = new CreateContact();
        createContact.setFN(firstNameValue)
                .setLN(lastNameValue)
                .setEmail(emailValue)
                .setLogin(loginValue)
                .setTicketsPrefix(prefixValue)
                .clickSubmitButton();

        //Search the created Contact
        contacts.searchCreatedContact(firstNameValue, lastNameValue);

        //Edit the searched Contact
        contacts.clickContactEditButton();
        createContact.updateFN(firstNameValue2)
                .updateLN(lastNameValue2)
                .clickSubmitButton();

        //Search the updated Contact
        contacts.searchCreatedContact(firstNameValue2, lastNameValue2);
        contacts.clickContactEditButton();

        //Create lists for comparing
        List<String> list1 = new ArrayList<>();
        list1.add(firstNameValue);
        list1.add(lastNameValue);

        List<String> list2 = new ArrayList<>();
        list2.add(firstNameValue2);
        list2.add(lastNameValue2);

        List<String> list3 = createContact.getFirstLastTicketPrefix();

        //Show values
        System.out.println("List1: " + list1);
        System.out.println("List2: " + list2);
        System.out.println("List3: " + list3);

        //Compare Old and New values
        Assert.assertNotEquals(list3, list1);
        System.out.println("+ + + New values from UI != Old values + + +");

        Assert.assertEquals(list3, list2);
        System.out.println("+ + + New values from UI = New inputted values + + +");
    }

    @Test
    @DisplayName("Create & Delete Contact")
    public void task24_test2() throws IOException, SQLException {

        //Testing Data:
        String firstNameValue = GenerateRandomValue.generateRandomAlphanumericString(8);
        String lastNameValue = GenerateRandomValue.generateRandomAlphanumericString(8);
        String emailValue = GenerateRandomValue.generateRandomStringLowerCase(8) + "@mail.com";
        String loginValue = GenerateRandomValue.generateRandomAlphanumericString(8);
        String prefixValue = GenerateRandomValue.generateRandomStringUpperCase(5);

        //Make login to App
        LoginPage loginPage = new LoginPage();
        loginPage.makeLogin();

        //Go to Contacts page
        Contacts contacts = new Contacts();
        contacts.goToContacts();

        //Go to Create New Contact page
//        contacts.closePopup();
        contacts.goToCreateNewContact();

        //Create New Contact
        CreateContact createContact = new CreateContact();
        createContact.setFN(firstNameValue)
                .setLN(lastNameValue)
                .setEmail(emailValue)
                .setLogin(loginValue)
                .setTicketsPrefix(prefixValue)
                .clickSubmitButton();

        //Search the created Contact
        contacts.searchCreatedContact(firstNameValue, lastNameValue);

        //Delete Contact
        contacts.clickContactDeleteButton();
        contacts.confirmDeleteContact();

        //Search the Deleted contact
        contacts.searchCreatedContact(firstNameValue, lastNameValue);

        //Select status of 'Deleted' field from DB
        DataBase dataBase = new DataBase();
        dataBase.connectToDB();
        boolean contactDataFromDB = dataBase.getDeleteStatusFromDB("select * from contact where (first_name || ' ' || last_name) = '" + firstNameValue + " " + lastNameValue + "'");
        System.out.println("Full Name: " + firstNameValue + " " + lastNameValue);
        System.out.println("Status of 'deleted' field from DB: " + contactDataFromDB);
        dataBase.closeConnection();

        //Verify that Deleted Contact is not present
        Assert.assertTrue("+ + + Contact is NOT deleted + + +", contactDataFromDB);
        System.out.println("+ + + Contact is successfully deleted + + +");
    }

    @Test
    @DisplayName("Create & Edit Ticket")
    public void task24_test3() throws IOException {

        //Testing Data:
        String titleValue = GenerateRandomValue.generateRandomAlphanumericString(8);
        String descriptionValue = GenerateRandomValue.generateRandomAlphanumericString(8);
        int stageValue = 0;
        int companyValue = 0;
        int contactValue = 1;
        int priorityValue = 1;
        int departmentValue = 1;

        String titleValue2 = GenerateRandomValue.generateRandomAlphanumericString(8);
        String descriptionValue2 = GenerateRandomValue.generateRandomAlphanumericString(8);

        //Make login to App;
        LoginPage loginPage = new LoginPage();
        loginPage.makeLogin();

        //Go to Tickets page;
        Tickets tickets = new Tickets();
        tickets.goToTickets();

        //Go to Create New Ticket page;
        tickets.goToCreateNewTicket();

        //Create New Ticket;
        CreateTicket createTicket = new CreateTicket();
        createTicket.createTicket(titleValue, descriptionValue, stageValue, companyValue, contactValue, priorityValue,
                departmentValue);

        //Search the created Ticket
        tickets.searchTicket(titleValue);

        //Show values
        System.out.println("titleValue: " + titleValue);
        System.out.println("descriptionValue: " + descriptionValue);
        System.out.println("titleValue2: " + titleValue2);
        System.out.println("descriptionValue2: " + descriptionValue2);

        //Update the searched Ticket
        tickets.openTicket();
        createTicket.updateTitleDescrInTicket(titleValue2, descriptionValue2);

        //Search the updated Ticket
        tickets.goToTickets();
        tickets.searchTicket(titleValue2);

        //Compare New Updated and UI values
        Assert.assertEquals(titleValue2, tickets.getItemNameFromUI());
        System.out.println("+ + + Title is changed. Ticket is updated. + + +");

        Assert.assertEquals(descriptionValue2, tickets.getItemDescriptionFromUI());
        System.out.println("+ + + Description is changed. Ticket is updated. + + +");
    }
}
