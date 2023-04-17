package edu.craptocraft.mariadb_jpa_jdbc.entity;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class DevRatingTest {

    private DeveloperRating developerRating;

    @Before
    public void setUp() {
        developerRating = new DeveloperRating(9, "Excellent");
    }

    @Test
    public void testGetRating() {
        assertEquals(9, developerRating.getRating());
    }

    @Test
    public void testGetRatingComment() {
        assertEquals("Excellent", developerRating.getRatingComment());
    }

    @Test
    public void testSetRating() {
        developerRating.setRating(10);
        assertEquals(10, developerRating.getRating());
    }

    @Test
    public void testSetRatingComment() {
        developerRating.setRatingComment("Perfect");

        assertEquals("Perfect", developerRating.getRatingComment());
    }

    @Test
    public void testEquals() {
        DeveloperRating sameRating = new DeveloperRating(9, "Excellent");

        DeveloperRating differentRating = new DeveloperRating(10, "Perfect");

        assertEquals(developerRating, sameRating);
        assertNotEquals(developerRating, differentRating);
    }

    @Test
    public void testHashCode() {
        DeveloperRating sameRating = new DeveloperRating(9, "Excellent");

        assertEquals(developerRating.hashCode(), sameRating.hashCode());
    }

    @Test
    public void testToString() {
        String expectedString = "\t9: Excellent\n";
        assertEquals(expectedString, developerRating.toString());
    }
}
