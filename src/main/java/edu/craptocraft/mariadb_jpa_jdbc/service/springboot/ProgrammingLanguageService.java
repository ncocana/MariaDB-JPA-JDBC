package edu.craptocraft.mariadb_jpa_jdbc.service.springboot;

import edu.craptocraft.mariadb_jpa_jdbc.entity.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageService {

    public ProgrammingLanguage createData(ProgrammingLanguage language);

    public List<ProgrammingLanguage> readData();

    public ProgrammingLanguage readData(int id);

    public ProgrammingLanguage updateData(int id, ProgrammingLanguage language);

    public void deleteData(int id);

}