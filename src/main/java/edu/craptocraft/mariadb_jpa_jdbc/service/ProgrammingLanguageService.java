package edu.craptocraft.mariadb_jpa_jdbc.service;

import java.util.Arrays;
import java.util.List;

import edu.craptocraft.mariadb_jpa_jdbc.entity.ProgrammingLanguage;

public class ProgrammingLanguageService {

    private static final JPAService jpaService = JPAService.getInstance();

    private ProgrammingLanguageService() {}

    public static void createData() {
        jpaService.runInTransaction(entityManager -> {
            Arrays.stream("Java,C++,C#,JavaScript,Rust,Go,Python,PHP".split(","))
                    .map(name -> new ProgrammingLanguage(name, (int) (Math.random() * 10)))
                    .forEach(entityManager::persist);
            return null;
        });
    }

    public static void readData() {
        List<ProgrammingLanguage> programmingLanguages = jpaService.runInTransaction(entityManager ->
                entityManager.createQuery(
                        "select p from ProgrammingLanguage p",
                        ProgrammingLanguage.class
                ).getResultList());
 
        programmingLanguages.stream()
                .map(pl -> pl.getName() + ": " + pl.getRating())
                .forEach(System.out::println);
    }

    public static void shutdownDatabase() {
        jpaService.shutdown();
    }

}
