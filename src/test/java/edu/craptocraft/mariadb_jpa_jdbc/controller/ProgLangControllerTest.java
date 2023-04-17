package edu.craptocraft.mariadb_jpa_jdbc.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import edu.craptocraft.mariadb_jpa_jdbc.AppJPA;
import edu.craptocraft.mariadb_jpa_jdbc.entity.DeveloperRating;
import edu.craptocraft.mariadb_jpa_jdbc.entity.ProgrammingLanguage;
import edu.craptocraft.mariadb_jpa_jdbc.entity.UserRating;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProgLangControllerTest {

    @Autowired
    private ProgrammingLanguageController controller;

    @BeforeClass
    public static void setUp() {
        AppJPA.main(new String[] {});

    }

    @Test
    public void testCreateLanguage() {

        ProgrammingLanguage language = new ProgrammingLanguage();

        language.setId(6);
        language.setName("MySQL");
        language.setUserRating(new UserRating(8));
        language.setDevRating(new DeveloperRating(8));

        ResponseEntity<?> response = controller.createLanguage(language.getId(), language);

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        ProgrammingLanguage createdLanguage = (ProgrammingLanguage) response.getBody();

        assertEquals(language.getId(), createdLanguage.getId());
        assertEquals(language.getName(), createdLanguage.getName());

        ResponseEntity<?> badResponse = controller.createLanguage(createdLanguage.getId(), createdLanguage);

        assertNotEquals(response, badResponse);
    }

    @Test
    public void testGetAllLanguages() {
        ResponseEntity<?> response = controller.getAllLanguages();

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        List<?> languages = (List<?>) response.getBody();
        assertNotNull(languages);
        assertTrue(languages.size() > 0);

    }

    @Test
    public void testGetOneLanguage() {

        ProgrammingLanguage language = new ProgrammingLanguage();
        language.setId(7);
        language.setName("Ruby");
        language.setUserRating(new UserRating(8));
        language.setDevRating(new DeveloperRating(8));

        ResponseEntity<?> createdResponse = controller.createLanguage(language.getId(), language);

        assertEquals(HttpStatus.CREATED, createdResponse.getStatusCode());

        ResponseEntity<?> response = controller.readOneLanguage(language.getId());

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        ProgrammingLanguage retrievedLanguage = (ProgrammingLanguage) response.getBody();

        assertNotNull(retrievedLanguage);
        assertEquals(language.getId(), retrievedLanguage.getId());
        assertEquals(language.getName(), retrievedLanguage.getName());
        assertEquals(language.getDevRating(), retrievedLanguage.getDevRating());
        assertEquals(language.getUserRating(), retrievedLanguage.getUserRating());
    }

    @Test
    public void testUpdateLanguage() {
        ProgrammingLanguage language = new ProgrammingLanguage();
        language.setId(5);
        language.setName("Rust");
        language.setUserRating(new UserRating(8));
        language.setDevRating(new DeveloperRating(8));

        ResponseEntity<?> createdResponse = controller.createLanguage(language.getId(), language);

        ProgrammingLanguage createdLanguage = (ProgrammingLanguage) createdResponse.getBody();

        int languageId = createdLanguage.getId();

        assertEquals(language.getId(), languageId, 0);

        language.setName("PHP");
        language.setUserRating(new UserRating(7));
        language.setDevRating(new DeveloperRating(7));

        ResponseEntity<?> updatedResponse = controller.updateLanguage(languageId, language);

        assertNotNull(updatedResponse);

        assertEquals(HttpStatus.CREATED, updatedResponse.getStatusCode());

        ProgrammingLanguage updatedLanguage = (ProgrammingLanguage) updatedResponse.getBody();

        assertEquals(updatedLanguage.getId(), createdLanguage.getId());

        assertNotEquals(updatedLanguage.getName(), createdLanguage.getName());
        assertNotEquals(updatedLanguage.getDevRating().getRating(), createdLanguage.getDevRating().getRating());
        assertNotEquals(updatedLanguage.getUserRating().getRating(), createdLanguage.getUserRating().getRating());

    }

    @Test
    public void testDeleteLanguage() {

        ResponseEntity<?> beforeDeleteResponse = controller.getAllLanguages();

        List<?> beforeDeleteLanguages = (List<?>) beforeDeleteResponse.getBody();

        assertNotNull(beforeDeleteLanguages);

        ProgrammingLanguage objectiveLanguage = new ProgrammingLanguage();

        objectiveLanguage.setId(1);

        ResponseEntity<?> response = controller.deleteLanguage(objectiveLanguage.getId());

        assertNotNull(response);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        ResponseEntity<?> afterDeleteResponse = controller.getAllLanguages();

        List<?> afterDeleteLanguages = (List<?>) afterDeleteResponse.getBody();

        assertNotNull(afterDeleteLanguages);

        assertNotEquals(afterDeleteLanguages.size(), beforeDeleteLanguages.size());

    }
}
