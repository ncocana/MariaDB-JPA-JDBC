package edu.craptocraft.mariadb_jpa_jdbc.database.programming_language.crud;

import java.util.Arrays;
import java.util.List;

import edu.craptocraft.mariadb_jpa_jdbc.jpa_service.JPAService;
import edu.craptocraft.mariadb_jpa_jdbc.database.programming_language.ProgrammingLanguage;

public class CRUD {
    
    private static final JPAService jpaService = JPAService.getInstance();

    private CRUD() {}
 
    public static void createProgrammingLanguages() {
        jpaService.runInTransaction(entityManager -> {
            Arrays.stream("Java,C++,C#,JavaScript,Rust,Go,Python,PHP".split(","))
                    .map(name -> new ProgrammingLanguage(name, (int) (Math.random() * 10)))
                    .forEach(entityManager::persist);
            return null;
        });
    }

    public static void printProgrammingLanguages() {
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
