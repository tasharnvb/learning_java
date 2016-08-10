package library;

import java.util.Collection;

/**
 * Created by Academy07 on 10/08/2016.
 */
public interface ILibrarian {
    void add(Book book);

    Collection<Book> selectAll();
}
