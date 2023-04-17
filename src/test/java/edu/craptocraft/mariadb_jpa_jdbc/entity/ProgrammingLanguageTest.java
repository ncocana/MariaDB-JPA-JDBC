package edu.craptocraft.mariadb_jpa_jdbc.entity;

import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProgrammingLanguageTest {

    private ProgrammingLanguage programmingLanguage;

    @BeforeEach
    public void setUp() {

        UserRating userRating = new UserRating(6);
        DeveloperRating devRating = new DeveloperRating(7);

        programmingLanguage = new ProgrammingLanguage("Java", userRating, devRating);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("Java", programmingLanguage.getName());
        assertNotNull(programmingLanguage.getUserRating());
        assertNotNull(programmingLanguage.getDevRating());

        assertEquals(6, programmingLanguage.getUserRating().getRating());
        assertEquals(7, programmingLanguage.getDevRating().getRating());

    }

    @Test
    public void testSetters() {

        UserRating newUserRating = new UserRating(5);
        DeveloperRating newDevRating = new DeveloperRating(3);

        programmingLanguage.setName("Python");
        programmingLanguage.setUserRating(newUserRating);
        programmingLanguage.setDevRating(newDevRating);

        assertEquals("Python", programmingLanguage.getName());

        assertEquals(5, programmingLanguage.getUserRating().getRating());
        assertEquals(3, programmingLanguage.getDevRating().getRating());
    }

    @Test
    public void testToString() {
        String expected = "\n\tProgramming Language: Java\n\tUser Rating: " +
                programmingLanguage.getUserRating().getRating() +
                "\n\tDeveloper Rating: " + programmingLanguage.getDevRating().getRating() +
                "\n";
        assertEquals(expected, programmingLanguage.toString());
    }
}
