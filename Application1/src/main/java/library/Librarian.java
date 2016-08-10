package library;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Academy07 on 10/08/2016.
 */
public class Librarian implements ILibrarian {
    @Override
    public void add(Book book) {
        String url = "jdbc:mysql://localhost:3306/library";
        try (Connection connection = DriverManager.getConnection(url, "root", "password")) {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO book(isbn, title) VALUES('" + book.getIsbn() + "', '" + book.getTitle() + "')";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Book> selectAll() {
        String url = "jdbc:mysql://localhost:3306/library";
        ArrayList<Book> books = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, "root", "password")) {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM book";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String isbn = resultSet.getString("isbn");
                String title = resultSet.getString("title");
                Book book = new Book(isbn, title);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (BookException e) {
            System.out.println(e.getMessage());
        }
        return books;
    }
}
