package pageobjects;

import core.Logger;

import java.util.logging.Level;

public enum DashboardFilter {
    P1("//div[@id='collapse7']//tr[.//td[3 and contains(text(), 'P1')]]/td[2]"),
    P2("//div[@id='collapse7']//tr[.//td[3 and contains(text(), 'P2')]]/td[2]"),
    P3("//div[@id='collapse7']//tr[.//td[3 and contains(text(), 'P3')]]/td[2]"),
    P4("//div[@id='collapse7']//tr[.//td[3 and contains(text(), 'P4')]]/td[2]"),

    DEVELOPMENT("//div[@id='collapse7']//tr[.//span[@class='break-word fixed-span label label-info' and contains(text(), 'Разработка')]]/td[3]"),
    FINANCE("//div[@id='collapse7']//tr[.//span[@class='break-word fixed-span label label-info' and contains(text(), 'Финансы')]]/td[3]"),
    SALES("//div[@id='collapse7']//tr[.//span[@class='break-word fixed-span label label-info' and contains(text(), 'Продажи')]]/td[3]");


    private final String f;

    DashboardFilter(String f) {
        this.f = f;
    }

    public String getFilters() {
        return f;
    }

    public String toString() {
        return f;
    }

    /**
     * Do Filter by X name
     */
    public static DashboardFilter getFilterByName(String f) {
        Logger.getLog(Level.ALL, "Do Filter by X name");

        for (DashboardFilter e : values()) {
            if (e.getFilters().equals(f)) {
                return e;
            }
        }
        throw new IllegalArgumentException("No enum found with url: [" + f + "]");
    }
}
