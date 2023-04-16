package edu.craptocraft.mariadb_jpa_jdbc;

import edu.craptocraft.mariadb_jpa_jdbc.service.DeveloperRatingService;
import edu.craptocraft.mariadb_jpa_jdbc.service.ProgrammingLanguageService;
import edu.craptocraft.mariadb_jpa_jdbc.service.UserRatingService;

public class App {

    public static void main(String[] args) {

        try {
            System.out.println("JPA SERVICE");

            // Creates the table "user_rating" and inserts data in it.
            UserRatingService.createData();
            System.out.println("\nUser rating:\n");
            System.out.println(UserRatingService.readData());

            // Creates the table "dev_rating" and inserts data in it.
            DeveloperRatingService.createData();
            System.out.println("\nDeveloper rating:\n");
            System.out.println(DeveloperRatingService.readData());

            // Creates the table "programming_language" and inserts data in it.
            ProgrammingLanguageService.createData("Java", 8, 9);
            ProgrammingLanguageService.createData("C++", 7, 8);
            ProgrammingLanguageService.createData("C#", 6, 7);
            ProgrammingLanguageService.createData("JavaScript", 9, 9);

            // Shows the data in the table "programming_language".
            System.out.println("Programming Languages:");
            System.out.println(ProgrammingLanguageService.readData());

            // Updates the data in the table "programming_language" and shows the updated data.
            ProgrammingLanguageService.updateData(3, "XML", 9, 8);
            System.out.println(ProgrammingLanguageService.readData());

            // Deletes the data in the table "programming_language" and shows the updated data.
            ProgrammingLanguageService.deleteData(3);
            System.out.println(ProgrammingLanguageService.readData());
        } finally {
            // Closes the instances of each service connecting to the database.
            UserRatingService.shutdownDatabase();
            DeveloperRatingService.shutdownDatabase();
            ProgrammingLanguageService.shutdownDatabase();
        }

    }

}
