package session;

import entity.Film;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by Academy07 on 03/08/2016.
 */
public class InMemoryFilmDAO implements FilmDAO {
    private Long currentId;
    private HashMap<Long, Film> films;

    public InMemoryFilmDAO() {
        currentId = 1L;
        films = new HashMap<>();
    }

    @Override
    public Long insert(Film film) {
        film.setId(currentId);
        films.put(currentId, film);
        // Should return old value then update
        return currentId++;
    }

    @Override
    public boolean update(Film film) {
        return films.replace(film.getId(), film) != null;
    }

    @Override
    public Film selectById(Long id) {
        return films.get(id);
    }

    @Override
    public boolean delete(Long id) {
        return films.remove(id, selectById(id));
    }

    @Override
    public Collection selectAll() {
        return films.values();
    }

    @Override
    public Collection<Film> selectByTitle(String name) {
        ArrayList<Film> matchingFilms = new ArrayList<>();
        for (Film film : films.values()) {
            if (film.getTitle().contains(name)) {
                matchingFilms.add(film);
            }
        }
        return matchingFilms;
    }
}
