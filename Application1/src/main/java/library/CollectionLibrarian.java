package library;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Academy07 on 10/08/2016.
 */
public class CollectionLibrarian implements ILibrarian {
    private HashSet<Book> books = new HashSet<>();

    @Override
    public void add(Book book) {
        books.add(book);
    }

    @Override
    public Collection<Book> selectAll() {
        return books;
    }

    public Book selectByIsbn(String isbn) {
        Optional<Book> foundBook = books.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst();
        return foundBook.isPresent() ? foundBook.get() : null;
    }

    public Collection<Book> selectByPartOfTitle(String title) {
        return books.stream().filter(book -> book.getTitle().contains(title)).collect(Collectors.toList());
    }

    public boolean deleteBook(String isbn) {
        Optional<Book> foundBook = books.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst();
        return foundBook.isPresent() ? books.remove(foundBook.get()) : false;
    }
}
