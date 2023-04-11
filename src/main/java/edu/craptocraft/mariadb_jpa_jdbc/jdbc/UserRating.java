package edu.craptocraft.mariadb_jpa_jdbc.jdbc;

import com.zaxxer.hikari.HikariDataSource;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRating {

    private static HikariDataSource dataSource;

    public UserRating() {
    };

    public static void createData(Integer value, String stringValue) throws SQLException {

        dataSource = Database.getConnectionPool();

        System.out.println("Creating data...");

        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO user_rating(rating, string_rating) VALUES(?, ?)")) {
                statement.setInt(1, value);
                statement.setString(2, stringValue);
                int rowsInserted = statement.executeUpdate();
                System.out.println("Rows inserted: " + rowsInserted);

            }
        }
    }

    public static void readData() throws SQLException {
        System.out.println("Reading data...");

        dataSource = Database.getConnectionPool();

        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM user_rating")) {
                ResultSet resultSet = statement.executeQuery();
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

    public static void updateData(int rating, String newStringRating) throws SQLException {

        dataSource = Database.getConnectionPool();

        System.out.println("Updating data...");
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection
                    .prepareStatement("UPDATE user_rating SET string_rating = ? WHERE rating LIKE ?")) {
                statement.setString(1, newStringRating);
                statement.setInt(2, rating);
                int rowsUpdated = statement.executeUpdate();
                System.out.println("Rows updated: " + rowsUpdated);

            }
        }
    }

    public static void deleteData(String nameExpression) throws SQLException {

        System.out.println("\nDeleting data...");

        dataSource = Database.getConnectionPool();

        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection
                    .prepareStatement("DELETE FROM user_rating WHERE string_rating LIKE ?")) {
                statement.setString(1, nameExpression);
                int rowsDeleted = statement.executeUpdate();
                System.out.println("Rows deleted: " + rowsDeleted);
            }
        }
    }

}
