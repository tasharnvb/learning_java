package entity;

import java.time.LocalDate;

/**
 * Created by Academy07 on 03/08/2016.
 */
public class Film {
    private String title;
    private int stock;
    private LocalDate date;
    private Genre genre;

    public Film(String title, int stock, LocalDate date, Genre genre) {
        if (stock < 0) {
            IllegalArgumentException e = new IllegalArgumentException("Stock cannot be negative");
            throw e;
        }

        this.title = title;
        this.stock = stock;
        this.date = date;
        this.genre = genre;
    }

    public Long getId() {
        return null;
    }

    public String getTitle() {
        return title;
    }

    public int getStock() {
        return stock;
    }

    public LocalDate getReleased() {
        return date;
    }

    public Genre getGenre() {
        return genre;
    }
}
