package session;

import entity.Film;
import entity.Genre;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//@Ignore
public class InMemoryFilmDAOTest {

    // arrange
//    private Map<Long, Film> films = new HashMap<>();
    private InMemoryFilmDAO sut = new InMemoryFilmDAO();

    @Test
    public void insertShouldReturnGeneratedId() {

        Film film1 = new Film("The Pink Panther", 5, LocalDate.of(1964, 1, 20), Genre.COMEDY);

        // act
        Long id1 = sut.insert(film1);

        // assert
        assertTrue(id1 instanceof Long);
    }

    @Test
    public void updateShouldModifyFilm() {
        // arrange
        Film film1 = new Film("The Pink Panther", 5, LocalDate.of(1964, 1, 20), Genre.COMEDY);
        Long generatedId = sut.insert(film1);
        film1.setTitle("The Black Panther");

        // act
        boolean updated = sut.update(film1);
        Film retrievedFilm = sut.selectById(generatedId);

        // assert
        assertTrue(updated);
        assertEquals("The Black Panther", retrievedFilm.getTitle());
    }

    @Test
    public void deleteShouldRemoveFilm() {
        // arrange
        Film film1 = new Film("The Pink Panther", 5, LocalDate.of(1964, 1, 20), Genre.COMEDY);
        Long generatedId = sut.insert(film1);

        // act
        boolean deleted = sut.delete(generatedId);

        // assert
        assertTrue(deleted);
        assertTrue(sut.selectAll().isEmpty());
    }

    @Test
    public void selectByIdShouldReturnMatchingFilm() {
        // arrange
        Film film1 = new Film("The Pink Panther", 5, LocalDate.of(1964, 1, 20), Genre.COMEDY);
        Film film2 = new Film("The Godfather", 2, LocalDate.of(1972, 4, 17), Genre.CRIME);
        Long id1 = sut.insert(film1);
        Long id2 = sut.insert(film2);

        // act
        Film retrievedFilm = sut.selectById(id1);

        // assert
        assertTrue(retrievedFilm.equals(film1));
    }

    @Test
    public void selectAllShouldReturnCollection() {
        // arrange
        Film film1 = new Film("The Pink Panther", 5, LocalDate.of(1964, 1, 20), Genre.COMEDY);
        Film film2 = new Film("The Godfather", 2, LocalDate.of(1972, 4, 17), Genre.CRIME);
        Long id1 = sut.insert(film1);
        Long id2 = sut.insert(film2);

        // act
        Collection<Film> films = sut.selectAll();

        // assert
        assertTrue(films.size() == 2);
    }

    @Test
    public void selectByTitleShouldGetMatchingFilms() {
        // arrange
        Film film1 = new Film("The Pink Panther", 5, LocalDate.of(1964, 1, 20), Genre.COMEDY);
        Film film2 = new Film("The Godfather", 2, LocalDate.of(1972, 4, 17), Genre.CRIME);
        Film film3 = new Film("Avatar", 2, LocalDate.of(2009, 7, 2), Genre.SCIENCE_FICTION);
        Long id1 = sut.insert(film1);
        Long id2 = sut.insert(film2);
        Long id3 = sut.insert(film3);

        // act
        Collection<Film> films = sut.selectByTitle("at");

        // assert
        assertTrue(films.size() == 2);
    }
}