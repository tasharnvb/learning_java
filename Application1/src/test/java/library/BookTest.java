package library;

import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

/**
 * Created by Academy07 on 10/08/2016.
 */
public class BookTest {
    @Before
    public void setup() throws BookException {
        String url = "jdbc:mysql://localhost:3306/library";
        try (Connection connection = DriverManager.getConnection(url, "root", "password")) {
            Statement statement = connection.createStatement();
            String sql = "TRUNCATE TABLE book;";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Book book1 = new Book("ISBN123123", "The Hunger Games");
        Book book2 = new Book("ISBN123124", "The Hunger Games: Catching Fire");
        Librarian librarian = new Librarian();
        librarian.add(book1);
        librarian.add(book2);
    }

    @Test(expected = BookException.class)
    public void isbnShouldHave10Characters() throws BookException {
        //arrange
        Book book = new Book();

        //act
        book.setIsbn("A123");

        //assert
    }

    @Test
    public void addBookAddsRowToTable() throws BookException {
        //arrange
        Librarian librarian = new Librarian();
        Book book = new Book("ISBN123456", "Noughts and Crosses");

        //act
        librarian.add(book);

        //assert
        int count = librarian.selectAll().size();
        assertEquals(3, count);
    }

    @Test
    public void selectBooksRetrievesAllBooks() throws BookException {
        //arrange
        Librarian librarian = new Librarian();
        Book book1 = new Book("ISBN123456", "Noughts and Crosses");
        Book book2 = new Book("ISBN123457", "Knife''s Edge");

        //act
        librarian.add(book1);
        librarian.add(book2);

        //assert
        int count = librarian.selectAll().size();
        assertEquals(4, count);
    }
}
