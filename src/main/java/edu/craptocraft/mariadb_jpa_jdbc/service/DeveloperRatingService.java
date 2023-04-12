package edu.craptocraft.mariadb_jpa_jdbc.service;

import java.util.List;

import edu.craptocraft.mariadb_jpa_jdbc.entity.DeveloperRating;

public class DeveloperRatingService {

    private static final JPAService jpaService = JPAService.getInstance();

    private DeveloperRatingService() {
    }

    // Create and persist a new DeveloperRating entity.
    public static void createData() {
        jpaService.runInTransaction(entityManager -> {
            for (int i = 0; i <= 10; i++) {
                if (i >= 0 && i <= 4) {
                    DeveloperRating rating = new DeveloperRating(i, "Bad");
                    entityManager.persist(rating);
                } else if (i >= 5 && i <= 6) {
                    DeveloperRating rating = new DeveloperRating(i, "Regular");
                    entityManager.persist(rating);
                } else if (i >= 7 && i <= 8) {
                    DeveloperRating rating = new DeveloperRating(i, "Good");
                    entityManager.persist(rating);
                } else if (i == 9) {
                    DeveloperRating rating = new DeveloperRating(i, "Excellent");
                    entityManager.persist(rating);
                } else {
                    DeveloperRating rating = new DeveloperRating(i, "Perfect");
                    entityManager.persist(rating);
                }
            }

            return null;
        });
    }

    // Read data from the DeveloperRating entity.
    public static String readData() {
        List<DeveloperRating> developerRating = jpaService
                .runInTransaction(entityManager -> entityManager.createQuery(
                        "select dr from DeveloperRating dr",
                        DeveloperRating.class).getResultList());

        StringBuilder programmingData = new StringBuilder();
        developerRating.stream()
                .map(Object::toString)
                .forEach(programmingData::append);

        return programmingData.toString();
    }

    // Get the rating from the DeveloperRating entity.
    public static DeveloperRating getDataRating(Integer rating) {
        return jpaService
                .runInTransaction(entityManager -> {
                    return entityManager.find(DeveloperRating.class, rating);
                    });
    }

    // Close the instance associated with the service.
    public static void shutdownDatabase() {
        jpaService.shutdown();
    }

}
