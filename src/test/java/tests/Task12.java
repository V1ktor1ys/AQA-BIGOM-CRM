package tests;

import core.BaseTest;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import pageobjects.*;
import utils.GenerateRandomValue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Task12 extends BaseTest {

    @Test
    @DisplayName("Create new Manager & Compare data between inputted value and value from Manager Details")
    public void task12_test1() throws IOException {

        //Testing Data:
        String firstNameValue = GenerateRandomValue.generateRandomStringUpperCase(10);
        String lastNameValue = GenerateRandomValue.generateRandomStringUpperCase(10);
        String emailValue = GenerateRandomValue.generateRandomStringLowerCase(7) + "@" + GenerateRandomValue.generateRandomStringLowerCase(7) + ".com";
        String loginValue = GenerateRandomValue.generateRandomStringUpperCase(1) + GenerateRandomValue.generateRandomStringLowerCase(6);
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

        //Save generated data into Map<String,String>
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("firstNameKey", firstNameValue);
        map1.put("lastNameKey", lastNameValue);
        map1.put("emailKey", emailValue);
        map1.put("loginKey", loginValue);
        map1.put("departmentKey", departmentValue);
        map1.put("phoneKey", String.valueOf(phoneValue));
        map1.put("skypeKey", skypeValue);

        //Search & Open the created manager
        managers.searchCreatedManager(firstNameValue, lastNameValue);

        //Save data from created manager into Map
        ManagerDetailsPage managerDetailsPage = new ManagerDetailsPage();
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("firstNameKey", managerDetailsPage.getFirstName());
        map2.put("lastNameKey", managerDetailsPage.getLastName());
        map2.put("emailKey", managerDetailsPage.getEmail());
        map2.put("loginKey", managerDetailsPage.getLogin());
        map2.put("departmentKey", managerDetailsPage.getDepartment());
        map2.put("phoneKey", managerDetailsPage.getPhone());
        map2.put("skypeKey", managerDetailsPage.getSkype());

        //Check & validate values between map1 & map2
        assertEquals(map1, map2);
    }
}
