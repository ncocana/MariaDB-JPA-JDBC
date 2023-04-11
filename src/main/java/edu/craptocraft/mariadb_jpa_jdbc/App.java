package edu.craptocraft.mariadb_jpa_jdbc;

import java.sql.SQLException;

import edu.craptocraft.mariadb_jpa_jdbc.jdbc.Database;
import edu.craptocraft.mariadb_jpa_jdbc.service.ProgrammingLanguageService;
import edu.craptocraft.mariadb_jpa_jdbc.jdbc.UserRating;
import edu.craptocraft.mariadb_jpa_jdbc.jdbc.DeveloperRating;

public class App {

    public static void main(String[] args) throws SQLException {

        try {
            System.out.println("JPA Services");
            ProgrammingLanguageService.createData();
            ProgrammingLanguageService.readData();
        } finally {
            ProgrammingLanguageService.shutdownDatabase();
        }

        try {
            System.out.println("Pools Connections");
            Database.initDatabaseConnectionPool();
            UserRating.deleteData("%");
            for (int i = 0; i <= 10; i++) {
                if (i >= 0 && i <= 4) {
                    UserRating.createData(i, "Bad language");
                } else if (i >= 5 && i <= 6) {
                    UserRating.createData(i, "Regular language");
                } else if (i >= 7 && i <= 8) {
                    UserRating.createData(i, "Good language");
                } else {
                    UserRating.createData(i, "Excellent language");
                }
            }
            UserRating.readData();
            UserRating.updateData(10, "Perfect language for learning");
            UserRating.readData();

        } finally {
            Database.closeDatabaseConnectionPool();
        }

        try {
            System.out.println("Plains connections");
            Database.openDatabaseConnection();
            DeveloperRating.deleteData("%");
            for (int i = 0; i <= 10; i++) {
                if (i >= 0 && i <= 4) {
                    DeveloperRating.createData(i, "Bad language for working");
                } else if (i >= 5 && i <= 6) {
                    DeveloperRating.createData(i, "Regular language for working");
                } else if (i >= 7 && i <= 8) {
                    DeveloperRating.createData(i, "Good language for working");
                } else {
                    DeveloperRating.createData(i, "Perfect language for developers");
                }
            }
            DeveloperRating.readData();
            DeveloperRating.updateData(10, "The best language for developers");
            DeveloperRating.readData();

        } finally {
            Database.closeDatabaseConnection();
        }

    }

}
