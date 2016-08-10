package library;

/**
 * Created by Academy07 on 10/08/2016.
 */
public class Book {
    private String title;
    private String isbn;

    public Book() {
    }

    public Book(String isbn, String title) throws BookException {
        this.title = title;
        setIsbn(isbn);
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

    public void setIsbn(String isbn) throws BookException {
        if (isbn.length() != 10) {
            BookException e = new BookException("The ISBN must be 10 characters");
            throw e;
        }
        this.isbn = isbn;
    }
}
