package edu.craptocraft.mariadb_jpa_jdbc.service.springboot.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.craptocraft.mariadb_jpa_jdbc.entity.UserRating;
import edu.craptocraft.mariadb_jpa_jdbc.repository.UserRatingRepo;

@Service
public class UserRatingIMPL {

    @Autowired
    private static UserRatingRepo repoUR;

    public static UserRating getUserRatingById(int id) {
        return repoUR.findById(id).orElse(null);
    }

}
