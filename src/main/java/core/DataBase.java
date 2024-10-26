package core;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

public class DataBase {

    private Connection connection;

    public static String query_test = "SELECT * FROM public.manager ORDER BY creation_timestamp DESC;";


    /**
     * Connection to DB
     */
    public void connectToDB() throws IOException {
        Logger.getLog(Level.ALL, "Connect to DB");

        System.getProperties().load(ClassLoader.getSystemResourceAsStream("conf.properties"));
        String dbServerUrl = System.getProperty("dbServerUrl");
        String dbLogin = System.getProperty("dbUser");
        String dbPassword = System.getProperty("dbPassword");

        try {
            connection = DriverManager.getConnection(dbServerUrl, dbLogin, dbPassword);
            System.out.println("+ + + Connected to the PostgreSQL server successfully. + + +");

        } catch (SQLException e) {
            System.out.println("+ + + Error in connecting to PostgreSQL server + + +");
            e.printStackTrace();
        }
    }

    /**
     * Close the DB connection
     */
    public void closeConnection() throws SQLException {
        Logger.getLog(Level.ALL, "Close the DB connection");

        if (connection != null) {
            try {
                connection.close();
                System.out.println("+ + + Connection closed successfully. + + +");

            } catch (SQLException e) {
                System.out.println("+ + + Error closing the connection + + +");
                e.printStackTrace();
            }
        }
    }

    /**
     * Select ALL method (String)
     */
    public void selectAll_String(String sqlQuery) {
        Logger.getLog(Level.ALL, "Select ALL method (String)");

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String value = resultSet.getString(i);
                    System.out.print(value + "\t");
                }
                System.out.println();
            }

            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");

        } catch (SQLException e) {
            System.out.println("Error with Data select");
            e.printStackTrace();
        }
    }

    /**
     * Select ALL method (List)
     */
    public void selectAll_List(String sqlQuery) {
        Logger.getLog(Level.ALL, "Select ALL method (List)");

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                List<String> row = new ArrayList<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(resultSet.getString(i));
                }
                System.out.println(row);
            }

            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");

        } catch (SQLException e) {
            System.out.println("Error with Data select");
            e.printStackTrace();
        }
    }

    /**
     * Select ALL method (List)
     * for Task19
     */
    public List<String> selectAll_List2(String sqlQuery) {
        Logger.getLog(Level.ALL, "Select ALL method (List)");

        List<String> row = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                row = new ArrayList<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(resultSet.getString(i));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error with Data select");
            e.printStackTrace();
        }
        return row;
    }

    /**
     * Select ALL method (Map)
     */
    public void selectAll_Map(String sqlQuery) {
        Logger.getLog(Level.ALL, "Select ALL method (Map)");

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                Map<String, String> map = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    map.put(metaData.getColumnName(i), resultSet.getString(i));
                }
                System.out.println(map);
            }

            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");

        } catch (SQLException e) {
            System.out.println("Error with Data select");
            e.printStackTrace();
        }
    }

    /**
     * Custom String
     */
    public void returnCustomString(String sqlQuery) throws SQLException {
        Logger.getLog(Level.ALL, "Using custom String");

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String roles = resultSet.getString("roles");

                System.out.println(id + "\t" + firstName + "\t" + lastName + "\t" + roles);
            }

        } catch (SQLException e) {
            System.out.println("+ + + Error with Data select + + +");
            e.printStackTrace();
        }
    }

    /**
     * --Task16_2_1
     * SELECT man.first_name, man.last_name, dep.name
     * FROM public.manager man
     * join public.department dep on dep.id = man.department_id
     * where dep.name = 'Комната добра';
     */
    public void query_Task16_2_1() {
        Logger.getLog(Level.ALL, "Select...");

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT man.first_name, man.last_name, dep.name\n" +
                    "FROM public.manager man\n" +
                    "join public.department dep on dep.id = man.department_id \n" +
                    "where dep.name = 'Комната добра';");

            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String name = resultSet.getString("name");

                System.out.println(firstName + "\t" + lastName + "\t" + name);
            }

            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");

        } catch (SQLException e) {
            System.out.println("Error with Data select");
            e.printStackTrace();
        }
    }

    /**
     * --Task16_2_2
     * SELECT first_name, last_name, phone, email
     * FROM public.manager
     * where phone is not null
     * and email like '%@gmail.com'
     */
    public void query_Task16_2_2() {
        Logger.getLog(Level.ALL, "Select...");

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT first_name, last_name, phone, email\n" +
                    "FROM public.manager\n" +
                    "where phone is not null\n" +
                    "and email like '%@gmail.com'");

            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");

                System.out.println(firstName + "\t" + lastName + "\t" + phone + "\t" + email);
            }

            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");

        } catch (SQLException e) {
            System.out.println("Error with Data select");
            e.printStackTrace();
        }
    }

    /**
     * --Task16_2_3
     * select t.id
     * from ticket t
     * join category c on c.id = t.category_id
     * where t.done_deadline is not null
     * and t.creation_timestamp between '2018.04.19' and '2018.05.03'
     * and c.name = 'Финансы'
     */
    public void query_Task16_2_3() {
        Logger.getLog(Level.ALL, "Select...");

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select t.id\n" +
                    "from ticket t\n" +
                    "join category c on c.id = t.category_id\n" +
                    "where t.done_deadline is not null\n" +
                    "and t.creation_timestamp between '2018.04.19' and '2018.05.03'\n" +
                    "and c.name = 'Финансы'");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");

                System.out.println(id);
            }

            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");

        } catch (SQLException e) {
            System.out.println("Error with Data select");
            e.printStackTrace();
        }
    }

    /**
     * --Task16_2_4
     * select t.title
     * from ticket t
     * join ticket_persons_for_notify tpfn on tpfn.ticket_id = t.id
     * join manager m on m.id = tpfn.persons_for_notify_id
     * where t.done_deadline is not null
     * and t.priority = 'P4'
     * and (m.first_name || ' ' || m.last_name) like 'Татьяна Алимова'
     */
    public void query_Task16_2_4() {
        Logger.getLog(Level.ALL, "Select...");

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select t.title\n" +
                    "from ticket t\n" +
                    "join ticket_persons_for_notify tpfn on tpfn.ticket_id = t.id \n" +
                    "join manager m on m.id = tpfn.persons_for_notify_id\n" +
                    "where t.done_deadline is not null\n" +
                    "and t.priority = 'P4'\n" +
                    "and (m.first_name || ' ' || m.last_name) like 'Татьяна Алимова'");

            while (resultSet.next()) {
                String title = resultSet.getString("title");

                System.out.println(title);
            }

            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");

        } catch (SQLException e) {
            System.out.println("Error with Data select");
            e.printStackTrace();
        }
    }

    /**
     * Get title, description from tickets for DB
     * Task19
     */
    public String getTitleDescrFromTicketsFromDB(String sqlQuery) throws SQLException {
        Logger.getLog(Level.ALL, "Select...");

        String title = null;
        String description = null;
        String stage = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                title = resultSet.getString("title");
                description = resultSet.getString("description");
                stage = resultSet.getString("name");
            }

        } catch (SQLException e) {
            System.out.println("+ + + Error with Data select + + +");
            e.printStackTrace();
        }
        return title + " " + description + " " + stage;
    }

    /**
     * Get title from companies from DB
     * Task19
     */
    public String getTitleFromCompaniesFromDB(String sqlQuery) throws SQLException {
        Logger.getLog(Level.ALL, "Get title from companies from DB");

        String title = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                title = resultSet.getString("name");
            }

        } catch (SQLException e) {
            System.out.println("+ + + Error with Data select + + +");
            e.printStackTrace();
        }
        return title;
    }

    /**
     * Get Full Name, Department, Phone, Email from Managers from DB
     * Task19
     */
    public Map<String, String> getFullNameDepartFromManagersFromDB(String sqlQuery) {
        Logger.getLog(Level.ALL, "Get Full Name, Department, Phone, Email from Managers from DB");

        Map<String, String> map2 = new HashMap<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                map2.put("fullName", resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
                map2.put("department", resultSet.getString("name"));
                map2.put("phone", resultSet.getString("phone"));
                map2.put("email", resultSet.getString("email_address"));
            }

        } catch (SQLException e) {
            System.out.println("+ + + Error with Data select + + +");
            e.printStackTrace();
        }
        return map2;
    }

    /**
     * Get Title(Category Name) from Categories from DB
     * Task19
     */
    public String getTitleColorFromManagersFromDB(String sqlQuery) throws SQLException {
        Logger.getLog(Level.ALL, "Get Title(Category Name) from Categories from DB");

        String title = null;
        String color = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                title = resultSet.getString("name");
                color = resultSet.getString("color");

            }

        } catch (SQLException e) {
            System.out.println("+ + + Error with Data select + + +");
            e.printStackTrace();
        }
        return title + " " + color;
    }

    /**
     * Get status of 'deleted' field from DB
     * for task24_test2
     */
    public boolean getDeleteStatusFromDB(String sqlQuery) throws SQLException {
        Logger.getLog(Level.ALL, "Get status of 'deleted' field from DB");

        boolean deleted = false;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                deleted = resultSet.getBoolean("deleted");
            }

        } catch (SQLException e) {
            System.out.println("+ + + Error with Data select + + +");
            e.printStackTrace();
        }
        return deleted;
    }
}
