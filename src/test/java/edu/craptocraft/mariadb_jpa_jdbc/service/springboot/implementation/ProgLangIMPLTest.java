package edu.craptocraft.mariadb_jpa_jdbc.service.springboot.implementation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.craptocraft.mariadb_jpa_jdbc.AppJPA;
import edu.craptocraft.mariadb_jpa_jdbc.entity.DeveloperRating;
import edu.craptocraft.mariadb_jpa_jdbc.entity.ProgrammingLanguage;
import edu.craptocraft.mariadb_jpa_jdbc.entity.UserRating;
import edu.craptocraft.mariadb_jpa_jdbc.service.springboot.ProgrammingLanguageService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProgLangIMPLTest {

    @Autowired
    private ProgrammingLanguageService progLangImpl;

    private static ProgrammingLanguage language = null;

    @BeforeClass
    public static void setUp() {
        AppJPA.main(new String[] {});
    }

    @Test
    public void testCreateData() {

        language = new ProgrammingLanguage("Test item", new UserRating(9), new DeveloperRating(3));
        ProgrammingLanguage createdLanguage = progLangImpl.createData(language);

        assertNotNull(createdLanguage);
        assertEquals(language.getId(), createdLanguage.getId());
        assertEquals(language.getName(), createdLanguage.getName());
        assertEquals(language.getDevRating().getRating(), createdLanguage.getDevRating().getRating());
        assertEquals(language.getUserRating().getRating(), createdLanguage.getUserRating().getRating());
        
        progLangImpl.deleteData(createdLanguage.getId());
        assertNull(progLangImpl.readData(createdLanguage.getId()));

    }

    @Test
    public void testReadDataById() {

        language = new ProgrammingLanguage("Test item", new UserRating(9), new DeveloperRating(3));
        ProgrammingLanguage createdLanguage = progLangImpl.createData(language);;

        ProgrammingLanguage retrievedLanguage = progLangImpl.readData(createdLanguage.getId());

        assertNotNull(retrievedLanguage);
        assertEquals(language.getId(), retrievedLanguage.getId());

        assertEquals(language.getName(), retrievedLanguage.getName());

        assertEquals(language.getDevRating().getRating(), retrievedLanguage.getDevRating().getRating());

        assertEquals(language.getUserRating().getRating(), retrievedLanguage.getUserRating().getRating());
        
        progLangImpl.deleteData(createdLanguage.getId());
        assertNull(progLangImpl.readData(createdLanguage.getId()));
    }

    @Test
    public void testReadData() {

        language = new ProgrammingLanguage("Test item", new UserRating(9), new DeveloperRating(3));
        ProgrammingLanguage createdLanguage = progLangImpl.createData(language);;
        ProgrammingLanguage retrievedLanguage = progLangImpl.readData(createdLanguage.getId());

        assertEquals(language.getId(), retrievedLanguage.getId());
        assertEquals(language.getName(), retrievedLanguage.getName());
        assertEquals(language.getDevRating(), retrievedLanguage.getDevRating());
        assertEquals(language.getUserRating(), retrievedLanguage.getUserRating());
        
        progLangImpl.deleteData(createdLanguage.getId());
        assertNull(progLangImpl.readData(createdLanguage.getId()));

    }

    @Test
    public void testUpdateData() {
        language = new ProgrammingLanguage("Test item", new UserRating(9), new DeveloperRating(3));
        ProgrammingLanguage createdLanguage = progLangImpl.createData(language);;
        int languageId = createdLanguage.getId();

        assertEquals(language.getId(), languageId, 0);

        createdLanguage.setName("Test item updated");
        createdLanguage.setUserRating(new UserRating(7));
        createdLanguage.setDevRating(new DeveloperRating(7));

        ProgrammingLanguage updatedLanguage = progLangImpl.updateData(languageId, createdLanguage);

        assertNotNull(updatedLanguage);
        assertEquals(language.getId(), updatedLanguage.getId());
        assertEquals("Test item updated", updatedLanguage.getName());
        assertEquals(7, updatedLanguage.getUserRating().getRating());
        assertEquals(7, updatedLanguage.getDevRating().getRating());
        
        progLangImpl.deleteData(updatedLanguage.getId());
        assertNull(progLangImpl.readData(updatedLanguage.getId()));
    }

    @Test
    public void testDeleteData() {
        language = new ProgrammingLanguage("Test item", new UserRating(9), new DeveloperRating(3));
        ProgrammingLanguage createdLanguage = progLangImpl.createData(language);

        int createdId = createdLanguage.getId();
        assertNotNull(progLangImpl.readData(createdId));

        progLangImpl.deleteData(createdId);
        assertNull(progLangImpl.readData(createdId));
    }
}