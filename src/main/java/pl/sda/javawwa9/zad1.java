package pl.sda.javawwa9;

import java.sql.*;

/**
 * Created by Grzesiek on 2018-09-01
 */
public class zad1 {
    private Statement statement; //clasa do wykonywania zapytan mysql
    protected ResultSet resultSet; //clasa do obsługi odpowiedzi z DB

    public static void main(String[] args) {
        String myUrlDB = "jdbc:mysql://localhost:3306/myDB?user=root&password=tymczasowe&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String urlDram = "jdbc:mysql://dram.pl:3306/sda_jdbc?user=sda_academy&password=KrzysiuKrawczyk&useLegacyDatetimeCode=false&serverTimezone=UTC";

        //try (Connection connection = DriverManager.getConnection(urlDram)){
        try (Connection connection = DriverManager.getConnection(myUrlDB)) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
