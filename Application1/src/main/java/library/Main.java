package library;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Academy07 on 10/08/2016.
 */
public class Main {
    public static void main(String[] args) throws BookException {
        dbTest();
        try {
            Book book1 = new Book("A1001", "The Hunger Games");
            Book book2 = new Book("A1001", "The Hunger Games");
            System.out.println(book1.equals(book2));

            HashSet<Book> books = new HashSet<>();
            books.add(book1);
            books.remove(book2);
            System.out.println(books.size());
        } catch (BookException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void dbTest() throws BookException {
        Librarian librarian = new Librarian();
        Book book = new Book("ISBN123456", "Noughts and Crosses");

        //act
        librarian.add(book);

        //assert
        int count = librarian.selectAll().size();
    }
}
