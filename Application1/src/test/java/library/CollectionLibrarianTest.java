package library;

import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by Academy07 on 10/08/2016.
 */
public class CollectionLibrarianTest {
    @Test
    public void addBookAddsToCollection() throws BookException {
        //arrange
        CollectionLibrarian librarian = new CollectionLibrarian();
        Book book = new Book("ISBN987654", "The Girl with the Dragon Tattoo");

        //act
        librarian.add(book);

        //assert
        int count = librarian.selectAll().size();
        assertEquals(1, count);
    }

    @Test
    public void selectAllReturnsAllBooks() throws BookException {
        //arrange
        CollectionLibrarian librarian = new CollectionLibrarian();
        Book book1 = new Book("ISBN987654", "The Girl with the Dragon Tattoo");
        Book book2 = new Book("ISBN987655", "The Girl who Played with Fire");

        //act
        librarian.add(book1);
        librarian.add(book2);

        //assert
        int count = librarian.selectAll().size();
        assertEquals(2, count);
    }

    @Test
    public void selectByIsbnReturnsSpecifiedBook() throws BookException {
        //arrange
        CollectionLibrarian librarian = new CollectionLibrarian();
        Book book = new Book("ISBN987654", "The Girl with the Dragon Tattoo");

        //act
        librarian.add(book);

        //assert
        Book dbBook = librarian.selectByIsbn("ISBN987654");
        assertEquals(book, dbBook);
    }

    @Test
    public void selectByPartOfTitleShouldReturnsBooksThatContainSpecifiedString() throws BookException {
        //arrange
        CollectionLibrarian librarian = new CollectionLibrarian();
        Book book1 = new Book("ISBN987654", "The Girl with the Dragon Tattoo");
        Book book2 = new Book("ISBN987655", "The Girl who Played with Fire");
        Book book3 = new Book("ISBN987656", "The Girl who Kicked the Hornet''s Nest");

        //act
        librarian.add(book1);
        librarian.add(book2);
        librarian.add(book3);

        //assert
        Collection<Book> bookList = librarian.selectByPartOfTitle("who");
        int count = bookList.size();
        assertEquals(2, count);
    }

    @Test
    public void deleteBookRemovesBookFromCollection() throws BookException {
        //arrange
        CollectionLibrarian librarian = new CollectionLibrarian();
        Book book1 = new Book("ISBN987654", "The Girl with the Dragon Tattoo");
        Book book2 = new Book("ISBN987655", "The Girl who Played with Fire");

        //act
        librarian.add(book1);
        librarian.add(book2);

        //assert
        assertTrue(librarian.deleteBook("ISBN987654"));
        int count = librarian.selectAll().size();
        assertEquals(1, count);
    }
}
