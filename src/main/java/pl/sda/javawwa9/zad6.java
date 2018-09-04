package pl.sda.javawwa9;

import java.sql.*;

/**
 * Created by Grzesiek on 2018-09-01
 */
public class zad6 {
    public static void main(String[] args) {
        String avgAgeQuery = "SELECT AVG(age) AS srednia_wieku FROM pracownik;";

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:MojaBazaSQLite.sqlite");
             Statement statement = connection.createStatement()) {

            System.out.print("Srednia wieku pracowników: ");
            System.out.print(getAverage(connection, avgAgeQuery));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getAverage(Connection connection, String avgAgeQuery) {
        try (Statement statement = connection.createStatement()) {
            ResultSet avgResult = statement.executeQuery(avgAgeQuery);
            while (avgResult.next()) {
                return avgResult.getInt("srednia_wieku");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
