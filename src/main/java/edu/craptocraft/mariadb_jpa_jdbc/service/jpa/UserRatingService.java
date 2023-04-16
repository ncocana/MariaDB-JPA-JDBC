package edu.craptocraft.mariadb_jpa_jdbc.service.jpa;

import java.util.List;

import edu.craptocraft.mariadb_jpa_jdbc.entity.UserRating;

public class UserRatingService {

    private static final JPAService jpaService = JPAService.getInstance();

    private UserRatingService() {
    }

    // Create and persist a new UserRating entity.
    public static void createData() {
        jpaService.runInTransaction(entityManager -> {
            for (int i = 0; i <= 10; i++) {
                if (i >= 0 && i <= 4) {
                    UserRating rating = new UserRating(i, "Bad");
                    entityManager.persist(rating);
                } else if (i >= 5 && i <= 6) {
                    UserRating rating = new UserRating(i, "Regular");
                    entityManager.persist(rating);
                } else if (i >= 7 && i <= 8) {
                    UserRating rating = new UserRating(i, "Good");
                    entityManager.persist(rating);
                } else if (i == 9) {
                    UserRating rating = new UserRating(i, "Excellent");
                    entityManager.persist(rating);
                } else {
                    UserRating rating = new UserRating(i, "Perfect");
                    entityManager.persist(rating);
                }
            }

            return null;
        });
    }

    // Read data from the UserRating entity.
    public static String readData() {
        List<UserRating> userRating = jpaService
                .runInTransaction(entityManager -> entityManager.createQuery(
                        "select ur from UserRating ur",
                        UserRating.class).getResultList());

        StringBuilder programmingData = new StringBuilder();
        userRating.stream()
                .map(Object::toString)
                .forEach(programmingData::append);

        return programmingData.toString();
    }

    // Get the rating from the UserRating entity.
    public static UserRating getDataRating(Integer rating) {
        return jpaService
                .runInTransaction(entityManager -> {
                    return entityManager.find(UserRating.class, rating);
                    });
    }

    // Close the instance associated with the service.
    public static void shutdownDatabase() {
        jpaService.shutdown();
    }

}
