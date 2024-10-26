package tests;

import core.BaseTest;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import pageobjects.*;

import java.io.IOException;

public class Task9 extends BaseTest {

    @Test
    @DisplayName("Print Tickets values (Id, Title, Assignee, Stage)")
    public void task9_test1() throws IOException {

        //Make login to App;
        LoginPage loginPage = new LoginPage();
        loginPage.makeLogin();

        //Go to Tickets page;
        Tickets tickets = new Tickets();
        tickets.goToTickets();

        //Print all Title Names
        System.out.println("- - - Title Names: - - -");
        tickets.showTitleNames();

        //Print all Ids
        System.out.println("- - - Ids: - - -");
        tickets.showElements(Tickets.showTicketIds);

        //Print all Titles
        System.out.println("- - - Titles: - - -");
        tickets.showElements(Tickets.showTicketTitles);

        //Print all Assignees
        System.out.println("- - - Assignees: - - -");
        tickets.showElements(Tickets.showTicketAssignees);

        //Print all Stages
        System.out.println("- - - Stages: - - -");
        tickets.showElements(Tickets.showTicketStages);
    }

    @Test
    @DisplayName("Print values from Dashboard table (from X column & by X filter)")
    public void task9_test2() throws IOException {

        //Make login to App;
        LoginPage loginPage = new LoginPage();
        loginPage.makeLogin();

        //Go to Dashboard/DoneDeadline/DeadlineIsOver;
        Dashboard dashboard = new Dashboard();
        dashboard.deadlineIsOverList();

        //Print all Titles with Category "Разработка"
        System.out.println("- - - Titles with Category \"Разработка\": - - -");
        dashboard.showTitlesByFilter(DashboardFilter.DEVELOPMENT);

        //Print all Titles with Category "Финансы"
        System.out.println("- - - Titles with Category \"Финансы\": - - -");
        dashboard.showTitlesByFilter(DashboardFilter.FINANCE);

        //Print all IDs with Priority "P3"
        System.out.println("- - - IDs with Priority \"P3\": - - -");
        dashboard.showTitlesByFilter(DashboardFilter.P3);
    }
}
