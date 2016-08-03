package session;

import entity.Film;

import java.util.Collection;

/**
 * Created by Academy07 on 03/08/2016.
 */
public interface FilmDAO {
    Long insert(Film film);

    boolean update(Film film);

    Film selectById(Long id);

    boolean delete(Long id);

    Collection selectAll();

    Collection<Film> selectByTitle(String name);
}
