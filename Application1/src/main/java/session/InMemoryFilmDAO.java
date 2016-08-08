package session;

import entity.Film;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * Created by Academy07 on 03/08/2016.
 */
public class InMemoryFilmDAO implements FilmDAO {
    private ISerializer serializer;
    private AtomicLong currentId = new AtomicLong(1L);;
    private ConcurrentHashMap<Long, Film> films;

    public InMemoryFilmDAO() {
        films = new ConcurrentHashMap<>();
        serializer = new Serializer();
    }

    public InMemoryFilmDAO(ConcurrentHashMap<Long, Film> map, ISerializer doc) {
        films = map;
        serializer = doc;
    }

    @Override
    public Long insert(Film film) {
        long id = currentId.getAndIncrement();
        film.setId(id);
        films.put(id, film);
        if (serializer != null) {
            serializer.serialize(films);
        }
        // Should return old value then update
        return id++;
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
        if (serializer != null) {
            films = serializer.deserialize();
        }
        return films.values();
    }

    @Override
    public Collection<Film> selectByTitle(String name) {
//        ArrayList<Film> matchingFilms = new ArrayList<>();
//        for (Film film : films.values()) {
//            if (film.getTitle().contains(name)) {
//                matchingFilms.add(film);
//            }
//        }
//        return matchingFilms;
        return films.values().stream().filter(film -> film.getTitle().contains(name)).collect(Collectors.toList());
    }
}
