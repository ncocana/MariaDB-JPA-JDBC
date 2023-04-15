package edu.craptocraft.mariadb_jpa_jdbc.service;

import edu.craptocraft.mariadb_jpa_jdbc.entity.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageServices {

    public ProgrammingLanguage createData(ProgrammingLanguage language);

    public List<ProgrammingLanguage> readData();

    public ProgrammingLanguage readData(int id);

    public ProgrammingLanguage updateData(ProgrammingLanguage language);

    public void deleteData(int id);

}