package edu.craptocraft.mariadb_jpa_jdbc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class Database {

    public static HikariDataSource dataSource;

    private static Connection connection;

    public Database() {
    };

    public static void initDatabaseConnectionPool() {
        dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mariadb://localhost:3306/jpa_jdbc");
        dataSource.setUsername("user");
        dataSource.setPassword("password");
    }

    public static HikariDataSource getConnectionPool() {
        return dataSource;
    }

    public static void closeDatabaseConnectionPool() {
        System.out.println("Closing connection");
        dataSource.close();

        System.out.println("Connection closed successfully");
    }

    public static void openDatabaseConnection() throws SQLException {

        connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/jpa_jdbc", "user", "password");

        System.out.println("Connecting...");
        System.out.println("Connection status: " + connection.isValid(0));
    }

    public static void closeDatabaseConnection() throws SQLException {
        System.out.println("Closing connection...");
        connection.close();
        System.out.println("Connection status: " + connection.isValid(0));
        System.out.println("Connection closed");

    }

}
