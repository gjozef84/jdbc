package pl.sda.javawwa9;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Grzesiek on 2018-09-04
 */
public class Bajtkowo_zad1 extends zad7 {

    public static void main(String[] args) {
        String urlDram = "jdbc:mysql://dram.pl:3306/sda_jdbc?user=sda_academy&password=KrzysiuKrawczyk&useLegacyDatetimeCode=false&serverTimezone=UTC";


        {
            try (Connection connection = DriverManager.getConnection(urlDram)) {

                //zad a) Utwórz zestawienie zawierające informacje o sumarycznych liczbach dzieci przyjętych do przedszkoli w każdym wieku, tzn. w wieku 3, 4, 5 i 6 lat.
                //showListPrzedszkolaISumaryczneIlosciPrzyjetychDzieci(connection, queryGetListPrzedszkolaAndWiekPrzyjetychDzieci);

                //zad b) Podaj, ile dzieci zostało przyjętych (w tym: ile dziewczynek, a ilu chłopców) do przedszkoli wymienionych w poniższej tabeli.
                //showListPrzedszkolaAndIledziewczyneIleChlopcow(connection, queryGetListPrzedszkolaAndIleDziewczynekIluChlopcow);

                //zad c) Podaj nazwę przedszkola, do którego przyjęto najwięcej dzieci w wieku 3 lat, oraz liczbę tych dzieci. Jest tylko jedno takie przedszkole.
                //showPrzedszkoleZnajwiekszaLiczba3latkow(connection, queryGetPrzedszkoleZnajwiekszaIloscia3latkow);

                //zad d) Podaj nazwę przedszkola, w którym liczba dzieci przyjętych jest większa od liczby miejsc, oraz liczbę dzieci przyjętych dodatkowo ponad limit. Jest tylko jedno takie przedszkole.
                //showPrzedszkoleZnajwiekszaLiczba3latkow(connection, queryGetPrzedszkoleZwiekszaIlosciaDzieciNizMiejsc);

                //zad e) Napisz w programie taką możliwość: „Użytkownik podaje Pesel dziecka i na tej podstawie zostaje wyświetlone do jakiego przedszkola został przyjęty, jego imię oraz nazwisko”
                showChildDetailsGivenPesel(connection, getPeselFromUser()); //06262204017

                //showAllValuesWithTableDzieci(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getPeselFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj PESEL dziecka które chcesz sprawdzić: ");

        String peselBeforeVerify = scanner.nextLine();

        while (!pl.sda.javawwa9.zad7.verifyPesel(peselBeforeVerify)) {
            System.out.println("Błędna cyfra kontrolna PESELU, wprowadz jeszcze raz właściwy PESEL: ");
            peselBeforeVerify = scanner.nextLine();
        }
        return peselBeforeVerify;
    }

    private static void showChildDetailsGivenPesel(Connection connection, String pesel) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT p.Nazwa_przedszkola, d.Imie, d.Nazwisko FROM zad1_dzieci AS d, zad1_przedszkola AS p WHERE d.Id_przedszkola=p.Id_przedszkola AND Pesel=?")) {
            String ppesel = "p" + pesel;
            preparedStatement.setString(1, ppesel);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Dane dziecka o PESELU " + pesel);
                System.out.print(resultSet.getString("Imie") + " " + resultSet.getString("Nazwisko"));
                resultSet.beforeFirst();
                System.out.println("został przyjęty do poniższych przedszkoli: ");

                while (resultSet.next()) {
                    System.out.println(resultSet.getString("Nazwa_przedszkola"));
                }
            } else System.out.println("Dla podanego PESELU " + pesel + " nie znaleziono żadnych danych");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void showPrzedszkoleZnajwiekszaLiczba3latkow(Connection connection, String query) {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            System.out.printf("%50s %10s\n", resultSetMetaData.getColumnName(1), resultSetMetaData.getColumnName(2));
            resultSet.next();
            System.out.printf("%50s %10s\n", resultSet.getString(1), resultSet.getInt(2));


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<ResultSet> showListPrzedszkolaISumaryczneIlosciPrzyjetychDzieci(Connection connection, String query) {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            System.out.printf("%-43s %-6s %-6s %-6s %-6s\n", resultSetMetaData.getColumnName(1), resultSetMetaData.getColumnName(2), resultSetMetaData.getColumnName(3), resultSetMetaData.getColumnName(4), resultSetMetaData.getColumnName(5));
            System.out.printf("%43s %6s\n", "", "-------------------------");
            while (resultSet.next()) {
                //System.out.println(resultSet.getString("Nazwa_przedszkola") + " " + resultSet.getInt("3lata") + " " + resultSet.getInt("4lata") + " " + resultSet.getInt("5lat") + " " + resultSet.getInt("6lat"));
                System.out.printf("%-43s  %-6d %-6d %-6d %-6d\n", resultSet.getString("Nazwa_przedszkola"), resultSet.getInt("3lata"), resultSet.getInt("4lata"), resultSet.getInt("5lat"), resultSet.getInt("6lat"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<ResultSet>();
    }

    private static ArrayList<ResultSet> showListPrzedszkolaAndIledziewczyneIleChlopcow(Connection connection, String query) {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            System.out.printf("%-50s %-10s %-10s %-10s\n", resultSetMetaData.getColumnName(1), resultSetMetaData.getColumnName(2), resultSetMetaData.getColumnName(3), resultSetMetaData.getColumnName(4));
            while (resultSet.next()) {
                System.out.printf("%-50s %-10d %-10d %-10d\n", resultSet.getString("Nazwa_przedszkola"), resultSet.getInt("ogolem"), resultSet.getInt("dziewczat"), resultSet.getInt("chlopcow"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<ResultSet>();
    }

    public static void showAllValuesWithTableDzieci(Connection connection) {
        String queryAllValue = "SELECT d.Pesel, d.Nazwisko, d.Imie, d.Plec, d.Wiek, p.Nazwa_przedszkola FROM zad1_dzieci AS d, zad1_przedszkola AS p WHERE d.Id_przedszkola=p.Id_przedszkola LIMIT 50";
        //ArrayList<String> arrayList = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(queryAllValue);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            System.out.printf("%-13s %-15s %-15s %-16s %-4s %-43s\n", resultSetMetaData.getColumnName(1), resultSetMetaData.getColumnName(2), resultSetMetaData.getColumnName(3), resultSetMetaData.getColumnName(4), resultSetMetaData.getColumnName(5), resultSetMetaData.getColumnName(6));

            while (resultSet.next()) {
                System.out.printf("%-13s %-15s %-15s %-16s %-4s %-43s\n", resultSet.getString("Pesel"), resultSet.getString("Nazwisko"), resultSet.getString("Imie"), resultSet.getString("Plec"), resultSet.getInt("Wiek"), resultSet.getString("Nazwa_przedszkola"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        //return new ArrayList<String>();
    }

    public static String queryAllZad1_dzieci = "SELECT * FROM zad1_dzieci";
    public static String queryGetAllZad1_przedszkola = "SELECT * FROM zad1_przedszkola";
    public static String queryGetListPrzedszkolaAndWiekPrzyjetychDzieci = "" +
            "SELECT p.Nazwa_przedszkola,\n" +
            "      sum(case when d.Wiek=3 THEN 1 ELSE 0 END) AS 3lata,\n" +
            "      sum(case when d.Wiek=4 THEN 1 ELSE 0 END) AS 4lata,\n" +
            "      sum(case when d.Wiek=5 THEN 1 ELSE 0 END) AS 5lat,\n" +
            "      sum(case when d.Wiek=6 THEN 1 ELSE 0 END) AS 6lat\n" +
            "FROM zad1_dzieci AS d, zad1_przedszkola AS p WHERE p.Id_przedszkola=d.Id_przedszkola\n" +
            "GROUP BY p.Nazwa_przedszkola;";

    public static String queryGetListPrzedszkolaAndIleDziewczynekIluChlopcow = "" +
            "SELECT p.Nazwa_przedszkola,\n" +
            "      COUNT(*) AS ogolem,\n" +
            "      sum(CASE WHEN d.Plec=\"dziewczynka\" THEN 1 ELSE 0 END) AS dziewczat,\n" +
            "      sum(CASE WHEN d.Plec=\"chlopiec\" THEN 1 ELSE 0 END) AS chlopcow\n" +
            "FROM zad1_przedszkola AS p, zad1_dzieci AS d\n" +
            "WHERE p.Id_przedszkola=d.Id_przedszkola AND\n" +
            "      p.Nazwa_przedszkola IN (\n" +
            "          \"Przedszkole nr 28 Srebrna Kotwica\",\n" +
            "          \"Przedszkole nr 49 im. Panienki z Okienka\",\n" +
            "          \"Przedszkole nr 87 Gwiezdna Kraina\")\n" +
            "GROUP BY p.Nazwa_przedszkola;";

    public static String queryGetPrzedszkoleZnajwiekszaIloscia3latkow = "" +
            "SELECT p.Nazwa_przedszkola,\n" +
            "       COUNT(*) AS Ilosc_3_latkow\n" +
            "FROM zad1_dzieci AS d, zad1_przedszkola AS p\n" +
            "WHERE p.Id_przedszkola=d.Id_przedszkola AND d.Wiek=3\n" +
            "GROUP BY d.Wiek, p.Nazwa_przedszkola\n" +
            "ORDER BY Ilosc_3_latkow DESC\n" +
            "LIMIT 1;";

    public static String queryGetPrzedszkoleZwiekszaIlosciaDzieciNizMiejsc = "" +
            "SELECT p.Nazwa_przedszkola,\n" +
            "       p.Liczba_miejsc            AS miejsc_w_przedszkolu,\n" +
            "       COUNT(*)                   AS przyjeto_dzieci,\n" +
            "       COUNT(*) - p.Liczba_miejsc AS ilosc_dzieci_ponad_program\n" +
            "FROM zad1_przedszkola AS p,\n" +
            "     zad1_dzieci AS d\n" +
            "WHERE p.Id_przedszkola = d.Id_przedszkola\n" +
            "GROUP BY p.Nazwa_przedszkola\n" +
            "HAVING przyjeto_dzieci > p.Liczba_miejsc;";

}

