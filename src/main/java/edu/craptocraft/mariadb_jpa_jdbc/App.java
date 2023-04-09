package edu.craptocraft.mariadb_jpa_jdbc;

import java.util.Arrays;
import java.util.List;

import edu.craptocraft.mariadb_jpa_jdbc.jpa_service.JPAService;
import edu.craptocraft.mariadb_jpa_jdbc.database.programming_language.ProgrammingLanguage;
 
public class App {
 
    private static final JPAService jpaService = JPAService.getInstance();
 
    public static void main(String[] args) {
        try {
            createProgrammingLanguages();
            printProgrammingLanguages();
        } finally {
            jpaService.shutdown();
        }
    }

    private static void createProgrammingLanguages() {
        jpaService.runInTransaction(entityManager -> {
            Arrays.stream("Java,C++,C#,JavaScript,Rust,Go,Python,PHP".split(","))
                    .map(name -> new ProgrammingLanguage(name, (int) (Math.random() * 10)))
                    .forEach(entityManager::persist);
            return null;
        });
    }

    private static void printProgrammingLanguages() {
        List<ProgrammingLanguage> programmingLanguages = jpaService.runInTransaction(entityManager ->
                entityManager.createQuery(
                        "select p from ProgrammingLanguage p",
                        ProgrammingLanguage.class
                ).getResultList());
 
        programmingLanguages.stream()
                .map(pl -> pl.getName() + ": " + pl.getRating())
                .forEach(System.out::println);
    }

}
