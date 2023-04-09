package edu.craptocraft.mariadb_jpa_jdbc;

import edu.craptocraft.mariadb_jpa_jdbc.database.programming_language.crud.CRUD;

public class App {
 
    public static void main(String[] args) {
        try {
            CRUD.createProgrammingLanguages();
            CRUD.printProgrammingLanguages();
        } finally {
            CRUD.shutdownDatabase();;
        }
    }

}
