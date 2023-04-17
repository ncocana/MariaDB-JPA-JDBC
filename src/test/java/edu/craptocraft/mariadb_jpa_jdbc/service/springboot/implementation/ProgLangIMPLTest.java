package edu.craptocraft.mariadb_jpa_jdbc.service.springboot.implementation;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.BeforeClass;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.craptocraft.mariadb_jpa_jdbc.AppJPA;
import edu.craptocraft.mariadb_jpa_jdbc.entity.DeveloperRating;
import edu.craptocraft.mariadb_jpa_jdbc.entity.ProgrammingLanguage;
import edu.craptocraft.mariadb_jpa_jdbc.entity.UserRating;
import edu.craptocraft.mariadb_jpa_jdbc.repository.ProgrammingLanguageRepo;
import edu.craptocraft.mariadb_jpa_jdbc.service.springboot.ProgrammingLanguageService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProgLangIMPLTest {

    @Autowired
    private ProgrammingLanguageService progLangImpl;

    @Autowired
    private ProgrammingLanguageRepo repo;

    @BeforeClass
    public static void setUp() {
        AppJPA.main(new String[] {});
    }

    @Test
    public void testCreateData() {

        ProgrammingLanguage language = new ProgrammingLanguage();

        language.setId(5);
        language.setName("Rust");
        language.setUserRating(new UserRating(8));
        language.setDevRating(new DeveloperRating(8));

        ProgrammingLanguage createdLanguage = progLangImpl.createData(language);

        assertNotNull(createdLanguage);
        assertEquals(language.getId(), createdLanguage.getId());
        assertEquals(language.getName(), createdLanguage.getName());
        assertEquals(language.getDevRating().getRating(), createdLanguage.getDevRating().getRating());
        assertEquals(language.getUserRating().getRating(), createdLanguage.getUserRating().getRating());

    }

    @Test
    public void testReadDataById() {
        ProgrammingLanguage language = new ProgrammingLanguage();

        language.setId(5);
        language.setName("Rust");
        language.setUserRating(new UserRating(8));
        language.setDevRating(new DeveloperRating(8));
        repo.save(language);

        ProgrammingLanguage retrievedLanguage = progLangImpl.readData(5);

        assertNotNull(retrievedLanguage);
        assertEquals(language.getId(), retrievedLanguage.getId());

        assertEquals(language.getName(), retrievedLanguage.getName());

        assertEquals(language.getDevRating().getRating(), retrievedLanguage.getDevRating().getRating());

        assertEquals(language.getUserRating().getRating(), retrievedLanguage.getUserRating().getRating());
    }

    @Test
    public void testReadData() {
        ProgrammingLanguage language1 = new ProgrammingLanguage();
        ProgrammingLanguage language2 = new ProgrammingLanguage();

        language1.setId(5);
        language1.setName("Rust");
        language1.setUserRating(new UserRating(8));
        language1.setDevRating(new DeveloperRating(8));
        repo.save(language1);

        language2.setId(6);
        language2.setName("PHP");
        language2.setUserRating(new UserRating(9));
        language2.setDevRating(new DeveloperRating(9));
        repo.save(language2);

        List<ProgrammingLanguage> languages = progLangImpl.readData();

        assertEquals(5, languages.size());

        assertEquals(language1.getId(), languages.get(language1.getId() - 2).getId());
        assertEquals(language1.getName(), languages.get(language1.getId() - 2).getName());

        assertEquals(language2.getId(), languages.get(language2.getId() - 2).getId());
        assertEquals(language2.getName(), languages.get(language2.getId() - 2).getName());

    }

    @Test
    public void testUpdateData() {
        ProgrammingLanguage language = new ProgrammingLanguage();

        language.setId(5);
        language.setName("Rust");
        language.setUserRating(new UserRating(8));
        language.setDevRating(new DeveloperRating(8));

        ProgrammingLanguage createdLanguage = progLangImpl.createData(language);

        int languageId = createdLanguage.getId();

        assertEquals(language.getId(), languageId, 0);

        createdLanguage.setName("PHP");
        createdLanguage.setUserRating(new UserRating(7));
        createdLanguage.setDevRating(new DeveloperRating(7));

        ProgrammingLanguage updatedLanguage = progLangImpl.updateData(languageId, createdLanguage);

        assertNotNull(updatedLanguage);

        assertEquals(updatedLanguage.getId(), language.getId());

        assertNotEquals(updatedLanguage.getName(), language.getName());

        assertNotEquals(updatedLanguage.getUserRating().getRating(), language.getUserRating().getRating());

        assertNotEquals(updatedLanguage.getDevRating().getRating(), language.getDevRating().getRating());

    }

    @Test
    public void testDeleteData() {
        ProgrammingLanguage language = new ProgrammingLanguage();

        language.setId(5);
        language.setName("Rust");
        language.setUserRating(new UserRating(8));
        language.setDevRating(new DeveloperRating(8));

        ProgrammingLanguage createdLanguage = progLangImpl.createData(language);

        int createdId = createdLanguage.getId();

        assertNotNull(progLangImpl.readData(createdId));

        progLangImpl.deleteData(createdId);

        assertNull(progLangImpl.readData(createdId));

    }
}