package edu.craptocraft.mariadb_jpa_jdbc;

import java.sql.SQLException;

// import edu.craptocraft.mariadb_jpa_jdbc.jdbc.UserRating;
import edu.craptocraft.mariadb_jpa_jdbc.jdbc.Database;
// import edu.craptocraft.mariadb_jpa_jdbc.service.ProgrammingLanguageService;
import edu.craptocraft.mariadb_jpa_jdbc.jdbc.UserRating;

public class App {

    public static void main(String[] args) throws SQLException {
        // try {
        // ProgrammingLanguageService.createData();
        // ProgrammingLanguageService.readData();
        // } finally {
        // ProgrammingLanguageService.shutdownDatabase();
        // }

        try {
            Database.initDatabaseConnectionPool();
            UserRating.deleteData("%");
            for (int i = 0; i <= 10; i++) {
                if (i >= 0 && i <= 4) {
                    UserRating.createData(i, "Bad language");
                } else if (i >= 5 && i <= 6) {
                    UserRating.createData(i, "Regular Language");
                } else if (i >= 7 && i <= 8) {
                    UserRating.createData(i, "Good Language");
                } else {
                    UserRating.createData(i, "Excellent Language");
                }
            }
            UserRating.readData();

        } finally {
            Database.closeDatabaseConnectionPool();
        }

        // try {
        // Database.openDatabaseConnection();
        // } finally {
        // Database.closeDatabaseConnection();
        // }

    }

}
