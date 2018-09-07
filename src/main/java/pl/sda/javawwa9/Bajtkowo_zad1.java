package pl.sda.javawwa9;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Grzesiek on 2018-09-04
 */
public class Bajtkowo_zad1 extends zad7 {

    public static void main(String[] args) {
        String urlDram = "jdbc:mysql://dram.pl:3306/sda_jdbc?user=sda_academy&password=KrzysiuKrawczyk&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String queryAllZad1_dzieci = "SELECT * FROM zad1_dzieci";
        String getQueryAllZad1_przedszkola = "SELECT * FROM zad1_przedszkola";

        {
            try (Connection connection = DriverManager.getConnection(urlDram)){

                showAllValuesWithTableDzieci(connection);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void showAllValuesWithTableDzieci (Connection connection){
        String queryAllValue = "SELECT * FROM zad1_dzieci LIMIT 10";
        //ArrayList<String> arrayList = new ArrayList<>();

        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(queryAllValue);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            System.out.println(resultSetMetaData.getColumnName(1)+"        "+resultSetMetaData.getColumnName(2)+" "+resultSetMetaData.getColumnName(3)+" "+resultSetMetaData.getColumnName(4)+" "+resultSetMetaData.getColumnName(5)+" "+resultSetMetaData.getColumnName(6));
            while(resultSet.next()) {
                System.out.println(resultSet.getString("Pesel")+" "+resultSet.getString("Nazwisko")+" "+resultSet.getString("Imie")+" "+resultSet.getString("Plec")+" "+resultSet.getInt("Wiek")+" "+resultSet.getInt("Id_przedszkola"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        //return new ArrayList<String>();
    }


}
