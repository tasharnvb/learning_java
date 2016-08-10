package library;

/**
 * Created by Academy07 on 10/08/2016.
 */
public class Book {
    private String title;
    private String isbn;

    public Book() {
        title = "hello";
        isbn = "world";
    }

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object obj) {
        Book otherBook = (Book) obj;
        return otherBook.getIsbn().equals(isbn) && otherBook.getTitle().equals(title);
    }

    @Override
    public int hashCode() {
        return isbn.hashCode() + title.hashCode() * 3;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
