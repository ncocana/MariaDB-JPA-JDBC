package edu.craptocraft.mariadb_jpa_jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.craptocraft.mariadb_jpa_jdbc.entity.ProgrammingLanguage;
import edu.craptocraft.mariadb_jpa_jdbc.entity.DeveloperRating;
import edu.craptocraft.mariadb_jpa_jdbc.entity.UserRating;

public class ProgrammingLanguageService {

    @Autowired
    private static final JPAService jpaService = JPAService.getInstance();

    private ProgrammingLanguageService() {
    }

    // Create and persist a new ProgrammingLanguage entity.
    public static void createData(String name, UserRating userRating, DeveloperRating devRating) {
        jpaService.runInTransaction(entityManager -> {
            ProgrammingLanguage language = new ProgrammingLanguage();
            language.setName(name);
            language.setUserRating(userRating);
            language.setDevRating(devRating);

            entityManager.persist(language);

            return null;
        });
    }

    // Read data from the ProgrammingLanguage entity.
    public static String readData() {
        List<ProgrammingLanguage> programmingLanguages = jpaService
                .runInTransaction(entityManager -> entityManager.createQuery(
                        "select p from ProgrammingLanguage p",
                        ProgrammingLanguage.class).getResultList());

        StringBuilder programmingData = new StringBuilder();
        programmingLanguages.stream()
                .map(Object::toString)
                .forEach(programmingData::append);

        return programmingData.toString();
    }

    public static void updateData(int id, String newLanguage, UserRating newUserRating,
            DeveloperRating newDeveloperRating) {
        jpaService.runInTransaction(entityManager -> {
            ProgrammingLanguage language = entityManager.find(ProgrammingLanguage.class, id);

            if (language != null) {
                language.setName(newLanguage);
                language.setUserRating(newUserRating);
                language.setDevRating(newDeveloperRating);

                System.out.println("Data updated!");
            }

            return null;
        });

    }

    public static void deleteData(int id) {
        jpaService.runInTransaction(entityManager -> {
            ProgrammingLanguage language = entityManager.find(ProgrammingLanguage.class, id);

            if (language != null) {
                entityManager.remove(language);
                System.out.println("Language deleted!");
            }
            return null;

        });
    }

    // Close the instance associated with the service.
    public static void shutdownDatabase() {
        jpaService.shutdown();
    }

}
