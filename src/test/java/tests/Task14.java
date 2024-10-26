package tests;

import core.BaseTest;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import pageobjects.*;
import utils.GenerateRandomValue;

import java.io.IOException;

public class Task14 extends BaseTest {

    @Test
    @DisplayName("Builder pattern 1 - Common")
    public void task14_test1() {
        CreateManagerModel createManagerModel1 = new CreateManagerModel.Builder()
                .setFirstNameValue("qwe")
                .setLastNameValue("qwe")
                .setEmailValue("qwe")
                .setLoginValue("qwe")
                .setDepartmentValue("qwe")
                .setPhoneValue(123)
                .setSkypeValue("qwe")
                .build();

        System.out.println(createManagerModel1);
    }

    @Test
    @DisplayName("Builder pattern 2 - lombok")
    public void task14_test2() {
        CreateManagerModel2 createManagerModel2 = CreateManagerModel2.builder()
                .firstNameValue("qwe")
                .lastNameValue("qwe")
                .emailValue("qwe")
                .loginValue("qwe")
                .departmentValue("qwe")
                .phoneValue(123)
                .skypeValue("qwe")
                .build();

        System.out.println(createManagerModel2);
    }

    @Test
    @DisplayName("Singleton pattern")
    public void task14_test3() throws IOException {

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

        //Create new Manager through getInstance
        CreateManager2.getInstance().createManagerWithFullInfo2(firstNameValue, lastNameValue, emailValue, loginValue,
                departmentValue, phoneValue, skypeValue);

        //Search & Open the created manager
        new Managers().searchCreatedManager(firstNameValue, lastNameValue);
    }
}
