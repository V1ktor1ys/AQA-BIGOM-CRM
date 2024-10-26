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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task21 extends BaseTest {

    @Test
    @DisplayName("Create Manager. Comparing Entered and DB values. Comparing UI & DB values.")
    public void task21_test1() throws IOException, SQLException {

        //Testing Data:
        String firstNameValue = GenerateRandomValue.generateRandomAlphanumericString(8);
        String lastNameValue = GenerateRandomValue.generateRandomAlphanumericString(8);
        String emailValue = GenerateRandomValue.generateRandomStringLowerCase(8) + "@mail.com";
        String loginValue = GenerateRandomValue.generateRandomAlphanumericString(8);
        String departmentValue = "VikTestDepartment";
        int phoneValue = GenerateRandomValue.generateRandomNumberMax10digits(10);
        String skypeValue = GenerateRandomValue.generateRandomAlphanumericString(8);

        //Make login to App
        LoginPage loginPage = new LoginPage();
        loginPage.makeLogin();

        //Go to Managers page
        Managers managers = new Managers();
        managers.goToManagers();

        //Go to Create New Manager page
        managers.goToCreateNewManager();

        //Create new Manager
        CreateManager createManager = new CreateManager();
        createManager.createManagerWithFullInfo(firstNameValue, lastNameValue, emailValue, loginValue,
                departmentValue, phoneValue, skypeValue);

        //Save generated data into Map<String,String>
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("fullName", firstNameValue + " " + lastNameValue);
        map1.put("email", emailValue);
        map1.put("department", departmentValue);
        map1.put("phone", String.valueOf(phoneValue));

        //Search the created Manager
        managers.searchOnlyCreatedManager(firstNameValue, lastNameValue, departmentValue);

        //Get Full Name, Department, Phone, Email texts
        Map<String, String> fullNameDepartPhoneEmailFromUI = managers.getFullNameDepPhoneEmailFromUI();

        //Compare Entered and UI values
        Assert.assertEquals("+ + + Manager data is NOT equal between Entered and UI values + + +", map1, fullNameDepartPhoneEmailFromUI);
        System.out.println("+ + + Manager data is equal between Entered and UI values + + +");

        //Select First Name, Last Name and Department from DB
        DataBase dataBase = new DataBase();
        dataBase.connectToDB();
        Map<String, String> fullNameDepartPhoneEmailFromDB = dataBase.getFullNameDepartFromManagersFromDB("select * from manager m join department d on d.id = m.department_id join email e on e.person_id = m.id where m.first_name = '" + firstNameValue + "'" + " and m.last_name = '" + lastNameValue + "'" + " and d.name = '" + departmentValue + "'");
        dataBase.closeConnection();

        //Compare UI and DB values
        Assert.assertEquals("+ + + Manager data is NOT equal between UI and DB values + + +", fullNameDepartPhoneEmailFromUI, fullNameDepartPhoneEmailFromDB);
        System.out.println("+ + + Manager data is equal between UI and DB values + + +");

        //Show values from all sources
        System.out.println("Entered values: " + map1);
        System.out.println("UI values: " + fullNameDepartPhoneEmailFromUI);
        System.out.println("DB values: " + fullNameDepartPhoneEmailFromDB);
    }

    @Test
    @DisplayName("Create Company. Comparing Entered and DB values. Comparing UI & DB values.")
    public void task21_test2() throws IOException, SQLException {

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
        String emailValue = GenerateRandomValue.generateRandomStringLowerCase(8) + "@mail.com";
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

        //Save generated data into List1
        List<String> companyDataEnteredValues = new ArrayList<>();
        companyDataEnteredValues.add(companyNameValue);
        companyDataEnteredValues.add(String.valueOf(phoneValue));
        companyDataEnteredValues.add(emailValue);

        //Search the created Company
        companies.searchCompany(companyNameValue);

        //Get Name, Phone, Email texts
        List<String> companyDataFromUI = companies.getCompanyNamePhoneEmailFromUI();

        //Compare Entered and UI values
        Assert.assertEquals("+ + + Company data is NOT equal between Entered and UI values + + +", companyDataEnteredValues, companyDataFromUI);
        System.out.println("+ + + Company data is equal between Entered and UI values + + +");

        //Select Company Name, Phone and Email from DB
        DataBase dataBase = new DataBase();
        dataBase.connectToDB();
        List<String> companyDataFromDB = dataBase.selectAll_List2("select * from company where name = '" + companyNameValue + "'");
        dataBase.closeConnection();

        //Compare Company name & description between UI and DB
        Assert.assertTrue("+ + + Company data is NOT equal between UI and DB + + +", companyDataFromDB.containsAll(companyDataFromUI));
        System.out.println("+ + + Company data is equal between UI and DB + + +");

        //Show values from all sources
        System.out.println("Entered values: " + companyDataEnteredValues);
        System.out.println("UI values: " + companyDataFromUI);
        System.out.println("DB values: " + companyDataFromDB);
    }
}
