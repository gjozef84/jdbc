package pl.sda.javawwa9;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Grzesiek on 2018-09-01
 */
public class zad7 {
    public static void main(String[] args) {
        String urlDram = "jdbc:mysql://dram.pl:3306/sda_jdbc?user=sda_academy&password=KrzysiuKrawczyk&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String query = "SELECT * FROM zad6_student";

        try (Connection connection = DriverManager.getConnection(urlDram)) {

            System.out.println("Nazwy pól w tabeli zad6_student\n" + getTableLabel(connection, query));
            System.out.println("\nTypy pól w tabeli zad6_student\n" + getColumnTypeInTable(connection, query));
            System.out.println("\nLista imion występujących w tabeli zad6_student\n" + getUniqFieldWithGivenTable(connection, "zad6_student", "name"));
            System.out.println("\nLiczba osób urodzonych w województwie Mazowieckim: " + getCountFieldInTable(connection, "birth_state", "zad6_student", "Mazowieckie"));
            System.out.println("\nLiczba osób o imieniu Jan i wieku 22lata: " + getSimpleQueryWchichReturnInteger(connection, "SELECT COUNT(*) FROM sda_jdbc.zad6_student WHERE name='Jan' AND age=22"));
            countGoodPeselAndWrongPesel(connection, "zad6_student"); //wypisuje ile osbo ma poprawny pesel a ile nie

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void countGoodPeselAndWrongPesel(Connection connection, String tableName) {
        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT pesel FROM " + tableName);

            int goodPesel = 0;
            int wrongPesel = 0;
            while (resultSet.next()) {
                if (verifyPesel(resultSet.getString(1))) goodPesel++;
                else wrongPesel++;
            }

            System.out.println("W tabeli " + tableName + " znajduje się: \n" + goodPesel + " poprawnych numerów PESEL\n" + wrongPesel + " niepoprawnych numerów PESEL");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean verifyPesel(String pesel) {
        String[] p = pesel.split("");

        int sum = 9 * Integer.parseInt(p[0])
                + 7 * Integer.parseInt(p[1])
                + 3 * Integer.parseInt(p[2])
                + 1 * Integer.parseInt(p[3])
                + 9 * Integer.parseInt(p[4])
                + 7 * Integer.parseInt(p[5])
                + 3 * Integer.parseInt(p[6])
                + 1 * Integer.parseInt(p[7])
                + 9 * Integer.parseInt(p[8])
                + 7 * Integer.parseInt(p[9]);

        return (Integer.parseInt(p[10]) == sum % (sum / 10)) ? true : false;
    }

    private static int getSimpleQueryWchichReturnInteger(Connection connection, String query) {
        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                return resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static int getCountFieldInTable(Connection connection, String field_name, String table_name, String searchValue) {
        try (Statement statement = connection.createStatement()) {

            String query = "SELECT COUNT(*) FROM " + table_name + " WHERE " + field_name + "=\"" + searchValue + "\"";

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                return resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String getTableLabel(Connection connection, String query) {
        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData metaData = resultSet.getMetaData();
            String strLabels = "";

            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                strLabels += metaData.getColumnLabel(i) + " ";
            }
            return strLabels;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getColumnTypeInTable(Connection connection, String query) {
        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData metaData = resultSet.getMetaData();
            String strLabels = "";

            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                strLabels += metaData.getColumnTypeName(i) + " ";
            }
            return strLabels;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static ArrayList<String> getUniqFieldWithGivenTable(Connection connection, String tableName, String fieldName) {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT DISTINCT " + fieldName + " FROM " + tableName + " ORDER BY " + fieldName + " ASC");
            ArrayList<String> resultList = new ArrayList();

            while (resultSet.next()) {
                resultList.add(resultSet.getString(fieldName));
            }

            return resultList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
