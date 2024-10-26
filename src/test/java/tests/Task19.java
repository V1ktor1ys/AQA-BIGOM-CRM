package tests;

import core.BaseTest;
import core.DataBase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import pageobjects.*;
import utils.GenerateRandomValue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Task19 extends BaseTest {

    @Test
    @DisplayName("Comparing UI and DB for a new Ticket")
    public void task19_test1() throws IOException, SQLException {

        //Testing Data:
        String titleValue = GenerateRandomValue.generateRandomAlphanumericString(8);
        String descriptionValue = GenerateRandomValue.generateRandomAlphanumericString(8);
        int stageValue = 0;
        int companyValue = 0;
        int contactValue = 1;
        int priorityValue = 1;
        int departmentValue = 1;

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

        //Select Ticket name & description from DB
        DataBase dataBase = new DataBase();
        dataBase.connectToDB();
        System.out.println("Title+Description+Stage from UI: " + tickets.getItemNameDescrStageFromUI());
        String titleDescrStageFromTicketsFromDB = dataBase.getTitleDescrFromTicketsFromDB("select * from ticket t join stage s on s.id = t.stage_id where t.title = '" + titleValue + "'");
        System.out.println("Title+Description+Stage from DB: " + titleDescrStageFromTicketsFromDB);
        dataBase.closeConnection();

        //Compare Ticket name & description between UI and DB
        Assert.assertEquals(tickets.getItemNameDescrStageFromUI(), titleDescrStageFromTicketsFromDB);
        System.out.println("+ + + Ticket data is equal between UI and DB + + +");
    }

    @Test
    @DisplayName("Comparing UI and DB for a new Inner Ticket")
    public void task19_test2() throws IOException, SQLException {

        //Testing Data:
        String titleValue = GenerateRandomValue.generateRandomAlphanumericString(8);
        String descriptionValue = GenerateRandomValue.generateRandomAlphanumericString(8);
        int stageValue = 0;
        int departmentValue = 1;

        //Make login to App
        LoginPage loginPage = new LoginPage();
        loginPage.makeLogin();

        //Go to Tickets page
        Tickets tickets = new Tickets();
        tickets.goToTickets();

        //Go to Create New Ticket page
        tickets.goToCreateNewTicket();

        //Create New Inner Ticket;
        CreateTicket createTicket = new CreateTicket();
        createTicket.createInnerTicket(titleValue, descriptionValue, stageValue, departmentValue);

        //Search the created Ticket
        tickets.searchTicket(titleValue);

        //Select Ticket name & description from DB
        DataBase dataBase = new DataBase();
        dataBase.connectToDB();
        System.out.println("Title+Description from UI: " + tickets.getItemNameDescrStageFromUI());
        String titleDescrStageFromTicketsFromDB = dataBase.getTitleDescrFromTicketsFromDB("select * from ticket t join stage s on s.id = t.stage_id where t.title = '" + titleValue + "'");
        System.out.println("Title+Description from DB: " + titleDescrStageFromTicketsFromDB);
        dataBase.closeConnection();

        //Compare Ticket name & description between UI and DB
        Assert.assertEquals(tickets.getItemNameDescrStageFromUI(), titleDescrStageFromTicketsFromDB);
        System.out.println("+ + + Inner Ticket data is equal between UI and DB + + +");
    }

    @Test
    @DisplayName("Comparing UI and DB for a new Company")
    public void task19_test3() throws IOException, SQLException {

        //Testing Data:
        String companyNameValue = GenerateRandomValue.generateRandomAlphanumericString(8);
        String countryValue = "VikCountryExample";
        String cityValue = "VikCityExample";
        String streetValue = "VikStreetExample";
        String buildingValue = "VikBuildingExample";
        String zipCodeValue = "VikZipCodeExample";
        String roomNumberValue = "VikRoomNumberExample";
        String skypeValue = "VikSkypeExample";
        String websiteValue = "VikWebsiteExample";
        String emailValue = "VikEmailExample@com.com";
        String edrpouValue = "VikEDRPOUExample";
        int phoneValue = GenerateRandomValue.generateRandomNumberMax10digits(10);

        //Make login to App
        LoginPage loginPage = new LoginPage();
        loginPage.makeLogin();

        //Go to Companies page
        Companies companies = new Companies();
        companies.goToCompaniesPage();

        //Goto Create new Company page
        companies.goToCreateNewCompany();

        //Create new Company
        CreateCompany createCompany = new CreateCompany();
        createCompany.createCompanyWithFullInfo(companyNameValue, countryValue, cityValue,
                streetValue, buildingValue, zipCodeValue, roomNumberValue, skypeValue, websiteValue, emailValue,
                edrpouValue, phoneValue);

        //Search the created Company
        companies.searchCompany(companyNameValue);

        //Select Company Name, Phone and Email from DB
        DataBase dataBase = new DataBase();
        dataBase.connectToDB();
        System.out.println("Title, Phone, Email from UI: " + companies.getCompanyNamePhoneEmailFromUI());
        List<String> companyNameFromDB = dataBase.selectAll_List2("select * from company where name = '" + companyNameValue + "'");
        System.out.println("All Data from DB: " + companyNameFromDB);
        dataBase.closeConnection();

        //Compare Company name & description between UI and DB
        Assert.assertTrue(companyNameFromDB.containsAll(companies.getCompanyNamePhoneEmailFromUI()));
        System.out.println("+ + + Company data is equal between UI and DB + + +");
    }

    @Test
    @DisplayName("Comparing UI and DB for a new Manager")
    public void task19_test4() throws IOException, SQLException {

        //Testing Data:
        String firstNameValue = GenerateRandomValue.generateRandomAlphanumericString(8);
        String lastNameValue = GenerateRandomValue.generateRandomAlphanumericString(8);
        String emailValue = GenerateRandomValue.generateRandomAlphanumericString(8) + "@mail.com";
        String loginValue = GenerateRandomValue.generateRandomAlphanumericString(8);
        String departmentValue = "VikTestDepartment";
        int phoneValue = GenerateRandomValue.generateRandomNumberMax10digits(10);
        String skypeValue = GenerateRandomValue.generateRandomAlphanumericString(8);

        //Make login to App;
        LoginPage loginPage = new LoginPage();
        loginPage.makeLogin();

        //Go to Managers page
        Managers managers = new Managers();
        managers.goToManagers();

        //Go to Create New Manager page;
        managers.goToCreateNewManager();

        //Create new Manager
        CreateManager createManager = new CreateManager();
        createManager.createManagerWithFullInfo(firstNameValue, lastNameValue, emailValue, loginValue,
                departmentValue, phoneValue, skypeValue);

        //Search the created Manager
        managers.searchOnlyCreatedManager(firstNameValue, lastNameValue, departmentValue);

        //Select First Name, Last Name and Department from DB
        DataBase dataBase = new DataBase();
        dataBase.connectToDB();
        System.out.println("FullName+Department+Phone+Email from UI: " + managers.getFullNameDepPhoneEmailFromUI());
        Map<String, String> fullNameDepartPhoneEmailFromDB = dataBase.getFullNameDepartFromManagersFromDB("select * from manager m join department d on d.id = m.department_id join email e on e.person_id = m.id where m.first_name = '" + firstNameValue + "'" + " and m.last_name = '" + lastNameValue + "'" + " and d.name = '" + departmentValue + "'");
        System.out.println("FullName+Department+Phone+Email from DB: " + fullNameDepartPhoneEmailFromDB);
        dataBase.closeConnection();

        //Compare Company name & description between UI and DB
        Assert.assertEquals(managers.getFullNameDepPhoneEmailFromUI(), fullNameDepartPhoneEmailFromDB);
        System.out.println("+ + + Manager data is equal between UI and DB + + +");
    }

    @Test
    @DisplayName("Comparing UI and DB for a new Category")
    public void task19_test5() throws IOException, SQLException {

        //Testing Data:
        String titleValue = GenerateRandomValue.generateRandomAlphanumericString(8);
        String colorValue = GenerateRandomValue.generateRandomStringUpperCase(8);

        //Make login to App;
        LoginPage loginPage = new LoginPage();
        loginPage.makeLogin();

        //Go to Category page
        Categories categories = new Categories();
        categories.goToCategories();

        //Go to Create New Category page;
        categories.goToCreateNewCategory();

        //Create new Category
        CreateCategory createCategory = new CreateCategory();
        createCategory.createCategory(titleValue, colorValue);

        //Select Title(Category Name) from DB
        DataBase dataBase = new DataBase();
        dataBase.connectToDB();
        System.out.println("Title(Category Name)+Color from UI: " + categories.getTitleColorFromUI(titleValue));
        String titleColorFromDB = dataBase.getTitleColorFromManagersFromDB("select * from category where name = '" + titleValue + "'");
        System.out.println("Title(Category Name)+Color from DB: " + titleColorFromDB);
        dataBase.closeConnection();

        //Compare Company name & description between UI and DB
        Assert.assertEquals(categories.getTitleColorFromUI(titleValue), titleColorFromDB);
        System.out.println("+ + + Category data is equal between UI and DB + + +");
    }
}
