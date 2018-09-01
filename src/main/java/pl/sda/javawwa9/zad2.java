package pl.sda.javawwa9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Grzesiek on 2018-09-01
 */
public class zad2 {
    static Connection connection;
    private Statement statement;

    public static void main(String[] args) {


        String query = "CREATE TABLE pracownik (\n" +
                "  id INTEGER NOT NULL,\n" +
                "  name VARCHAR(50),\n" +
                "  age INTEGER),\n" +
                "  PRIMARY KEY (id)\n" +
                ");";

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:MojaBazaSQLite.sqlite")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
