package tests;

import core.BaseTest;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import pageobjects.LoginPage;
import pageobjects.Managers;
import pageobjects.Tickets;

import java.io.IOException;

public class Task20 extends BaseTest {

    @Test
    @DisplayName("TempForTesting")
    public void task20_test1() throws IOException {

        //Make login to App;
        new LoginPage().makeLogin();

        //Go to Tickets page;
        new Tickets().goToTickets();

        //Go to Managers page;
        new Managers().goToManagers();
    }
}
