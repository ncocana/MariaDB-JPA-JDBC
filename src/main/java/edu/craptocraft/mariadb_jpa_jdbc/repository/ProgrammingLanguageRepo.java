package edu.craptocraft.mariadb_jpa_jdbc.repository;

import org.springframework.data.repository.CrudRepository;

import edu.craptocraft.mariadb_jpa_jdbc.entity.ProgrammingLanguage;

public interface ProgrammingLanguageRepo extends CrudRepository<ProgrammingLanguage, Integer> {

}
