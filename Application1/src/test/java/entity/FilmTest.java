package entity;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Created by Academy07 on 03/08/2016.
 */
public class FilmTest {

    /**
     * Generate the Film class in the src/main/java directory, using Eclipse.
     * Add a constructor, fields, get and set methods, so that the assertions
     * pass
     */
    @Test
    public void constructorShouldInitialiseFields() {
        // arrange and act
        Film film = new Film("The Pink Panther", 5, LocalDate.of(1964, 1, 20), Genre.COMEDY);

        Long id = film.getId();
        String title = film.getTitle();
        int stock = film.getStock();
        LocalDate released = film.getReleased();
        Genre genre = film.getGenre();

        // assert
        assertNull(id);
        assertEquals("The Pink Panther", title);
        assertEquals(5, stock);
        assertEquals(LocalDate.of(1964, 1, 20), released);
        assertEquals(Genre.COMEDY, genre);
    }

    /**
     * throw an exception, either from the constructor or the setStock method if
     * a negative value is passed in
     */
    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldThrowExceptionIfStockNegative() {
        new Film("The Pink Panther", -1, LocalDate.of(1964, 1, 20), Genre.COMEDY);
    }

    /**
     * Override the equals and hashCode methods in the Film class
     */
    @Test
    public void filmsWithSameTitleShouldBeEqual() {
        // arrange
        Film film1 = new Film();
        film1.setTitle("The Godfather");
        Film film2 = new Film();
        film2.setTitle("The Godfather");

        // act (execute methods under test) and assert (verify test results)
        assertTrue(film1.equals(film2));
        assertTrue(film1.hashCode() == film2.hashCode());
    }
}
