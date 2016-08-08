package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by Academy07 on 03/08/2016.
 */
@Entity
public class Film implements Serializable{
    private String title;
    private int stock;
    private LocalDate date;
    @Enumerated(EnumType.STRING) private Genre genre;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version private int version;

    public Film() {
    }

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

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Film ? title.equals(((Film) obj).title) : false;
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public void setStock(int stock) {
        this.stock = stock;
    }
}
