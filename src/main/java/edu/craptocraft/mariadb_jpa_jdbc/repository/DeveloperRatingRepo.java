package edu.craptocraft.mariadb_jpa_jdbc.repository;

import org.springframework.data.repository.CrudRepository;

import edu.craptocraft.mariadb_jpa_jdbc.entity.DeveloperRating;

public interface DeveloperRatingRepo extends CrudRepository<DeveloperRating, Integer> {

}
