package library;

import org.junit.Test;

/**
 * Created by Academy07 on 10/08/2016.
 */
public class BookTest {
    @Test(expected = IllegalArgumentException.class)
    public void isbnShouldHave10Characters() {
        //arrange
        Book book = new Book();

        //act
        book.setIsbn("A123");

        //assert
    }
}
