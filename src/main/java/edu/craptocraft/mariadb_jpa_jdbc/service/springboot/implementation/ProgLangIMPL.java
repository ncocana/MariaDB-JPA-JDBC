package edu.craptocraft.mariadb_jpa_jdbc.service.springboot.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.craptocraft.mariadb_jpa_jdbc.entity.ProgrammingLanguage;
import edu.craptocraft.mariadb_jpa_jdbc.repository.ProgrammingLanguageRepo;
import edu.craptocraft.mariadb_jpa_jdbc.service.springboot.ProgrammingLanguageService;

@Service
public class ProgLangIMPL implements ProgrammingLanguageService {

    @Autowired
    private ProgrammingLanguageRepo repo;

    @Override
    public ProgrammingLanguage createData(ProgrammingLanguage language) {
        language.setId(language.getId());
        language.setName(language.getName());
        language.setDevRating(language.getDevRating());
        language.setUserRating(language.getUserRating());
        return this.repo.save(language);

    }

    @Override
    public List<ProgrammingLanguage> readData() {
        return (List<ProgrammingLanguage>) this.repo.findAll();
    }

    @Override
    public ProgrammingLanguage readData(int id) {
        return this.repo.findById(id).orElse(null);
    }

    @Override
    public ProgrammingLanguage updateData(int id, ProgrammingLanguage language) {
        language.setId(id);
        language.setName(language.getName());
        language.setDevRating(language.getDevRating());
        language.setUserRating(language.getUserRating());
        return this.repo.save(language);
    }

    @Override
    public void deleteData(int id) {
        this.repo.deleteById(id);
    }

}
