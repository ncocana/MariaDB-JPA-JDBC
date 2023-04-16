package edu.craptocraft.mariadb_jpa_jdbc.service.springboot.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.craptocraft.mariadb_jpa_jdbc.entity.DeveloperRating;
import edu.craptocraft.mariadb_jpa_jdbc.repository.DeveloperRatingRepo;

@Service
public class DevRatingIMPL {

    @Autowired
    private static DeveloperRatingRepo repoDR;

    public static DeveloperRating getDeveloperRatingById(int id) {
        return repoDR.findById(id).orElse(null);
    }

}
