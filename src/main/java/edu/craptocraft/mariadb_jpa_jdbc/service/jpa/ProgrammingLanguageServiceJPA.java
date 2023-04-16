package edu.craptocraft.mariadb_jpa_jdbc.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.craptocraft.mariadb_jpa_jdbc.entity.ProgrammingLanguage;

public class ProgrammingLanguageServiceJPA {

    @Autowired
    private static final JPAService jpaService = JPAService.getInstance();

    private ProgrammingLanguageServiceJPA() {
    }

    // Create and persist a new ProgrammingLanguage entity.
    public static void createData(String name, Integer userRating, Integer devRating) {
        jpaService.runInTransaction(entityManager -> {
            ProgrammingLanguage language = new ProgrammingLanguage();
            language.setName(name);
            language.setUserRating(UserRatingService.getDataRating(userRating));
            language.setDevRating(DeveloperRatingService.getDataRating(devRating));

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

    // Update data from the ProgrammingLanguage entity.
    public static void updateData(Integer id, String newLanguage, Integer newUserRating, Integer newDeveloperRating) {
        jpaService.runInTransaction(entityManager -> {
            ProgrammingLanguage language = entityManager.find(ProgrammingLanguage.class, id);

            if (language != null) {
                language.setName(newLanguage);
                language.setUserRating(UserRatingService.getDataRating(newUserRating));
                language.setDevRating(DeveloperRatingService.getDataRating(newDeveloperRating));

                System.out.println("Data updated!");
            }

            return null;
        });

    }

    // Delete data from the ProgrammingLanguage entity.
    public static void deleteData(Integer id) {
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
