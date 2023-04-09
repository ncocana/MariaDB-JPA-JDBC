package edu.craptocraft.mariadb_jpa_jdbc;

import edu.craptocraft.mariadb_jpa_jdbc.service.ProgrammingLanguageService;

public class App {

    public static void main(String[] args) {
        try {
            ProgrammingLanguageService.createData();
            ProgrammingLanguageService.readData();
        } finally {
            ProgrammingLanguageService.shutdownDatabase();
        }
    }

}
