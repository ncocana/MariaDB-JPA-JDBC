package edu.craptocraft.mariadb_jpa_jdbc;

import edu.craptocraft.mariadb_jpa_jdbc.service.DeveloperRatingService;
import edu.craptocraft.mariadb_jpa_jdbc.service.ProgrammingLanguageService;
import edu.craptocraft.mariadb_jpa_jdbc.service.UserRatingService;

public class App {

    public static void main(String[] args) {

        try {
            System.out.println("JPA SERVICE");

            UserRatingService.createData();
            System.out.println("\nUser rating:\n");
            System.out.println(UserRatingService.readData());
            
            DeveloperRatingService.createData();
            System.out.println("\nDeveloper rating:\n");
            System.out.println(DeveloperRatingService.readData());

            ProgrammingLanguageService.createData("Java", UserRatingService.getDataRating(8), DeveloperRatingService.getDataRating(9));
            ProgrammingLanguageService.createData("C++", UserRatingService.getDataRating(7), DeveloperRatingService.getDataRating(8));
            ProgrammingLanguageService.createData("C#", UserRatingService.getDataRating(6), DeveloperRatingService.getDataRating(7));
            ProgrammingLanguageService.createData("JavaScript", UserRatingService.getDataRating(9), DeveloperRatingService.getDataRating(9));
            System.out.println("Programming Languages:");
            System.out.println(ProgrammingLanguageService.readData());
        } finally {
            UserRatingService.shutdownDatabase();
            DeveloperRatingService.shutdownDatabase();
            ProgrammingLanguageService.shutdownDatabase();
        }

    }

}
