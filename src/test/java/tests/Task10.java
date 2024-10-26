package tests;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import pageobjects.*;
import utils.GenerateRandomValue;

import java.io.IOException;

public class Task10 extends BaseTest {

    @Test
    @DisplayName("Create New Ticket")
    public void task10_test1() throws IOException {

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

        //Clarify the Tickets exists
        tickets.searchTicket(titleValue);
        tickets.getItemNameFromUI();
        Assert.assertEquals(titleValue, tickets.getItemNameFromUI());
        System.out.println("titleValue1 - " + titleValue);
        System.out.println("titleValue2 - " + tickets.getItemNameFromUI());
    }

    @Test
    @DisplayName("Create New Department with full info")
    public void task10_test2() throws IOException {

        //Testing Data:
        String titleValue = "VikTitleExample_";
        String phoneValue = "VikPhoneExample";
        String skypeValue = "VikSkypeExample";
        String websiteValue = "VikWebsiteExample";
        String emailValue = "VikEmailExample@com.com";
        String countryValue = "VikCountryExample";
        String cityValue = "VikCityExample";
        String streetValue = "VikStreetExample";
        String buildingValue = "VikBuildingExample";
        String zipcodeValue = "VikZipCodeExample";
        String roomNumberValue = "VikRoomNumberExample";

        //Make login to App;
        LoginPage loginPage = new LoginPage();
        loginPage.makeLogin();

        //Go to Departments page;
        Departments departments = new Departments();
        departments.goToDepartmentsPage();

        //Go to Create New Department page;
        departments.goToCreateNewDepartment();

        //Create New Department
        CreateDepartment createDepartment = new CreateDepartment();
        createDepartment.createDepartmentWithFullInfo(titleValue, phoneValue, skypeValue, websiteValue, emailValue,
                countryValue, cityValue, streetValue, buildingValue, zipcodeValue, roomNumberValue);
    }

    @Test
    @DisplayName("Create New Company with full info")
    public void task10_test3() throws IOException {

        //Testing Data:
        String companyNameValue = "VikCompanyNameExample_" + GenerateRandomValue.generateRandomAlphanumericString(8);
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

        //Make login to App;
        LoginPage loginPage = new LoginPage();
        loginPage.makeLogin();

        //Go to Companies page;
        Companies companies = new Companies();
        companies.goToCompaniesPage();

        //Go to Create New Company page;
        companies.goToCreateNewCompany();

        //Create New Company
        CreateCompany createCompany = new CreateCompany();
        createCompany.createCompanyWithFullInfo(companyNameValue, countryValue, cityValue, streetValue, buildingValue,
                zipCodeValue, roomNumberValue, skypeValue, websiteValue, emailValue, edrpouValue, phoneValue);
    }
}
