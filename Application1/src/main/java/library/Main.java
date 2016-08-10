package library;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Academy07 on 10/08/2016.
 */
public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("The Hunger Games", "A1001");
        Book book2 = new Book("The Hunger Games", "A1001");
        System.out.println(book1.equals(book2));

        HashSet<Book> books = new HashSet<>();
        books.add(book1);
        books.remove(book2);
        System.out.println(books.size());
    }
}
