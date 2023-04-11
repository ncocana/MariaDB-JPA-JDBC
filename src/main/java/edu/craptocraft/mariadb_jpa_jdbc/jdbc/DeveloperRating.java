package edu.craptocraft.mariadb_jpa_jdbc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeveloperRating {
    private static Connection connection;

    public static void createData(int rating, String stringRating) throws SQLException {
        connection = Database.getConnection();
        System.out.println("Creating data...");

        try (PreparedStatement statement = connection
                .prepareStatement("INSERT INTO dev_rating(rating, string_rating) VALUES(?,?)")) {
            statement.setInt(1, rating);
            statement.setString(2, stringRating);
            int rowsInserted = statement.executeUpdate();
            System.out.println("Rows inserted: " + rowsInserted);
        }
    }

    public static void readData() throws SQLException {
        System.out.println("Reading data...");

        connection = Database.getConnection();

        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM dev_rating")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                boolean empty = true;
                while (resultSet.next()) {
                    int value = resultSet.getInt(1);
                    String stringValue = resultSet.getString(2);
                    System.out.println("\t> " + value + ": " + stringValue);
                    empty = false;

                }
                if (empty) {
                    System.out.println("\t No data in the database");
                }
            }
        }
    }

    public static void updateData(int rating, String newStringValue) throws SQLException {
        connection = Database.getConnection();

        try (PreparedStatement statement = connection
                .prepareStatement("UPDATE dev_rating SET string_rating = ? WHERE rating = ?")) {
            statement.setString(1, newStringValue);
            statement.setInt(2, rating);
            int rowsUpdated = statement.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
        }
    }

    public static void deleteData(String nameExpression) throws SQLException {

        connection = Database.getConnection();

        try (PreparedStatement statement = connection
                .prepareStatement("DELETE FROM dev_rating WHERE string_rating LIKE ?")) {
            statement.setString(1, nameExpression);
            System.out.println("Rows deleted: " + statement.executeUpdate());
        }
    }

}
