package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Academy07 on 08/08/2016.
 */
@Entity
@Table(name = "OrderTable")
public class Order {
    @Id @GeneratedValue
    private int id;
    private String username;
    private boolean dispatched;
    @ManyToMany
    private Set<Film> films = new HashSet<>();

    public Order(String username) {
        this.username = username;
    }

    public boolean addFilm(Film film) {
        return films.add(film);
    }

    public void removeFilm(Film film) {
        films.remove(film);
    }
    public int getId() {
        return id;
    }

    public Boolean getDispatched() {
        return dispatched;
    }

    public String getUsername() {
        return username;
    }

    public Set<Film> getFilms() {
        return films;
    }
    
    public void setDispatched(Boolean dispatched) {
        this.dispatched = dispatched;
    }
}
