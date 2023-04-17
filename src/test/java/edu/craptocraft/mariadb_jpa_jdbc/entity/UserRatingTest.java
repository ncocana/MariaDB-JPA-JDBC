package edu.craptocraft.mariadb_jpa_jdbc.entity;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class UserRatingTest {

    private UserRating userRating;

    @Before
    public void setUp() {
        userRating = new UserRating(5, "Regular");
    }

    @Test
    public void testGetRating() {
        assertEquals(5, userRating.getRating());
    }

    @Test
    public void testGetRatingComment() {
        assertEquals("Regular", userRating.getRatingComment());
    }

    @Test
    public void testSetRating() {
        userRating.setRating(3);
        assertEquals(3, userRating.getRating());
    }

    @Test
    public void testSetRatingComment() {
        userRating.setRatingComment("Bad");

        assertEquals("Bad", userRating.getRatingComment());
    }

    @Test
    public void testEquals() {
        UserRating sameRating = new UserRating(5, "Regular");

        UserRating differentRating = new UserRating(9, "Excellent");

        assertEquals(userRating, sameRating);
        assertNotEquals(userRating, differentRating);
    }

    @Test
    public void testHashCode() {
        UserRating sameRating = new UserRating(5, "Regular");

        assertEquals(userRating.hashCode(), sameRating.hashCode());
    }

    @Test
    public void testToString() {
        String expectedString = "\t5: Regular\n";
        assertEquals(expectedString, userRating.toString());
    }
}
