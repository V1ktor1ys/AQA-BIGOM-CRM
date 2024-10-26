package tests;

import core.BaseTest;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import pageobjects.CreateManager;
import pageobjects.LoginPage;
import pageobjects.ManagerDetailsPage;
import pageobjects.Managers;
import utils.GenerateRandomValue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Task13 extends BaseTest {

    @Test
    @DisplayName("[Fluent Pattern] - Create & Observe new Manager")
    public void task13_test1() throws IOException {

        //Testing Data:
        String firstNameValue = GenerateRandomValue.generateRandomStringUpperCase(10);
        String lastNameValue = GenerateRandomValue.generateRandomStringUpperCase(10);
        String emailValue = GenerateRandomValue.generateRandomStringLowerCase(7) + "@" + GenerateRandomValue.generateRandomStringLowerCase(7) + ".com";
        String loginValue = GenerateRandomValue.generateRandomStringUpperCase(1) + GenerateRandomValue.generateRandomStringLowerCase(6);
        String departmentValue = "VikTestDepartment";
        int phoneValue = GenerateRandomValue.generateRandomNumberMax10digits(10);
        String skypeValue = GenerateRandomValue.generateRandomAlphanumericString(8);

        //Make login to App;
        new LoginPage().makeLogin();

        //Go to Managers/CreateNewManager page
        new Managers().goToManagers2()
                .goToCreateNewManager();

        //Create new Manager
        new CreateManager()
                .setFN(firstNameValue)
                .setLN(lastNameValue)
                .setEmail(emailValue)
                .setLogin(loginValue)
                .setDepartment(departmentValue)
                .setPhone(phoneValue)
                .setSkype(skypeValue)
                .submit();

        //Search & Open the created manager
        new Managers().searchCreatedManager(firstNameValue, lastNameValue);
    }
}
