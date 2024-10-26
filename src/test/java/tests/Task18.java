package tests;

import core.DataBase;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;
import java.sql.SQLException;

public class Task18 {

    @Test
    @DisplayName("using String")
    public void task18_test1() throws IOException, SQLException {
        DataBase dataBase = new DataBase();
        dataBase.connectToDB();
        dataBase.selectAll_String("select * from department where name like '%Vik%'");
        dataBase.closeConnection();
    }

    @Test
    @DisplayName("using List")
    public void task18_test2() throws IOException, SQLException {
        DataBase dataBase = new DataBase();
        dataBase.connectToDB();
        dataBase.selectAll_List("select * from department where name like '%Vik%'");
        dataBase.closeConnection();
    }

    @Test
    @DisplayName("using Map")
    public void task18_test3() throws IOException, SQLException {
        DataBase dataBase = new DataBase();
        dataBase.connectToDB();
        dataBase.selectAll_Map("select * from department where name like '%Vik%'");
        dataBase.closeConnection();
    }

    @Test
    @DisplayName("using CustomString")
    public void task18_test4() throws IOException, SQLException {
        DataBase dataBase = new DataBase();
        dataBase.connectToDB();
        dataBase.returnCustomString(DataBase.query_test);
        dataBase.closeConnection();
    }

    @Test
    @DisplayName("all queries from Task16 & Task17")
    public void task18_test5() throws IOException, SQLException {
        DataBase dataBase = new DataBase();
        dataBase.connectToDB();
        dataBase.query_Task16_2_1();
        dataBase.query_Task16_2_2();
        dataBase.query_Task16_2_3();
        dataBase.query_Task16_2_4();
        dataBase.selectAll_String("select * from department where name like '%Vik%'");
        dataBase.selectAll_String("select * from manager where (first_name || ' ' || last_name) like 'Татьяна Алимова'");
        dataBase.selectAll_String("select * from manager m join department d on d.id = m.department_id where d.name like 'Vik%'");
        dataBase.selectAll_String("select * from manager where (first_name || ' ' || last_name) = (select (first_name || ' ' || last_name) as \"Full Name\" from manager order by random() limit 1)");
        dataBase.selectAll_String("select * from department where name = (select \"name\" from department order by random() limit 1)");
        dataBase.selectAll_String("select * from category where name = (select name from category order by random() limit 1)");
        dataBase.closeConnection();
    }
}
