package pl.sda.javawwa9;

import java.sql.*;
import java.util.Random;

/**
 * Created by Grzesiek on 2018-09-08
 */
public class BatchProcessing {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:MojaBazaSQLite.sqlite");
                /*PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO pracownik VALUES (NULL, ?,? )")*/) {

            /*if (connection.getMetaData().supportsBatchUpdates()) {
                System.out.println("Baza wspiera BatchUpdates");
            } else {
                System.out.println("Baza nie wspiera BatchUpdates");
            }*/

            connection.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO pracownik VALUES (NULL, ?,? )")) {

                for (int i = 0; i < 100; i++) {
                    preparedStatement.setString(1, randomName());
                    preparedStatement.setInt(2, randomAge());
                    preparedStatement.addBatch();
                }

                preparedStatement.executeBatch();
                connection.commit();
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

    private static String randomName() {
        String[] nameTab = {"Janusz", "Wiesław", "Sylwia", "Andrzej", "Ryszard"};

        Random random = new Random();
        return nameTab[random.nextInt(4)];
    }

    public static int randomAge() {
        Random random = new Random();
        return random.nextInt(21) + 20; //przedzial od 20-40lat
    }

}
