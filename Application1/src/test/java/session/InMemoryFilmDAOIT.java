package session;

import entity.Film;
import entity.Genre;
import org.junit.Test;

import java.time.LocalDate;
import static org.junit.Assert.assertEquals;

/**
 * Created by Academy07 on 08/08/2016.
 */
public class InMemoryFilmDAOIT {

    @Test
    public void serializeAndDeserializeFilmsTest() {
        InMemoryFilmDAO sut = new InMemoryFilmDAO();
        Film film1 = new Film("Aliens", 2, LocalDate.of(1986, 2, 20), Genre.SCIENCE_FICTION);
        sut.insert(film1);

        sut = new InMemoryFilmDAO();
        assertEquals(1, sut.selectAll().size());
    }
}
