package session;

import entity.Film;

import java.util.Collection;

/**
 * Created by Academy07 on 08/08/2016.
 */
public class JpaFilmDAO implements FilmDAO {
    @Override
    public Long insert(Film film) {
        return null;
    }

    @Override
    public boolean update(Film film) {
        return false;
    }

    @Override
    public Film selectById(Long id) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Collection selectAll() {
        return null;
    }

    @Override
    public Collection<Film> selectByTitle(String name) {
        return null;
    }
}
