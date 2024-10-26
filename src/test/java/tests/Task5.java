package tests;

import org.junit.jupiter.api.*;
import org.junit.Test;
import core.BaseTest;
import pageobjects.LoginPage;

import java.io.IOException;

public class Task5 extends BaseTest {

    @Test
    @DisplayName("Make login to App")
    public void test1() throws IOException {

        //Make login to App;
        LoginPage loginPage = new LoginPage();
        loginPage.makeLogin();
    }
}