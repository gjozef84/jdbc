package pl.sda.javawwa9;

import java.sql.*;

/**
 * Created by Grzesiek on 2018-09-01
 */
public class zad2 {
    static Connection connection;
    private Statement statement;

    public static void main(String[] args) {

        String dropTable = "DROP TABLE if exists pracownik;";

        String queryCrTable = "CREATE TABLE if not exists pracownik (\n" +
                "  id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "  name VARCHAR(50),\n" +
                "  age INTEGER)";

        String queryInsert = "INSERT INTO pracownik VALUES (null, 'Grzegorz Jozefowicz', 34);";
        String query = "SELECT * FROM pracownik WHERE id=1";

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:MojaBazaSQLite.sqlite");
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(dropTable);
            statement.executeUpdate(queryCrTable); //tworzymy tabele
            statement.executeUpdate(queryInsert); //dodajemy pracownika
            ResultSet resultSet = statement.executeQuery(query);


            ResultSetMetaData metaData = resultSet.getMetaData();

            System.out.println(metaData.getColumnName(1) + "(" + metaData.getColumnTypeName(1) + ") " + metaData.getColumnName(2) + "(" + metaData.getColumnTypeName(2) + ") " + metaData.getColumnName(3) + "(" + metaData.getColumnTypeName(3) + ")");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name") + " " + resultSet.getInt("age"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
