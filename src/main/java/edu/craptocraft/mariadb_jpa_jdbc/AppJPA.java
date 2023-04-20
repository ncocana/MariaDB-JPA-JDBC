package edu.craptocraft.mariadb_jpa_jdbc;

import edu.craptocraft.mariadb_jpa_jdbc.service.jpa.DeveloperRatingService;
import edu.craptocraft.mariadb_jpa_jdbc.service.jpa.ProgrammingLanguageServiceJPA;
import edu.craptocraft.mariadb_jpa_jdbc.service.jpa.UserRatingService;

public class AppJPA {

    public static void main(String[] args) {

        try {
            // If the entity does not exist, create it and insert some mock data.
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
                ProgrammingLanguageServiceJPA.createData("Java", 8, 9);
                ProgrammingLanguageServiceJPA.createData("C++", 7, 8);
                ProgrammingLanguageServiceJPA.createData("C#", 6, 7);
                ProgrammingLanguageServiceJPA.createData("JavaScript", 9, 9);

                // Shows the data in the table "programming_language".
                System.out.println("Programming Languages:");
                System.out.println(ProgrammingLanguageServiceJPA.readData());

                // Updates the data in the table "programming_language" and shows the updated data.
                ProgrammingLanguageServiceJPA.updateData(3, "XML", 9, 8);
                System.out.println(ProgrammingLanguageServiceJPA.readData());

                // Deletes the data in the table "programming_language" and shows the updated data.
                ProgrammingLanguageServiceJPA.deleteData(3);
                System.out.println(ProgrammingLanguageServiceJPA.readData());
            } catch (Exception e) {
                // If the entity already exists, do nothing.
            }
        } finally {
            // Closes the instances of each service connecting to the database.
            UserRatingService.shutdownDatabase();
            DeveloperRatingService.shutdownDatabase();
            ProgrammingLanguageServiceJPA.shutdownDatabase();
        }

    }

}
