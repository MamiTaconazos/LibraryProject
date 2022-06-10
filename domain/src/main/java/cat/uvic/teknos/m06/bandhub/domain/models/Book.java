package cat.uvic.teknos.m06.bandhub.domain.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_book;
    private String title;

    public void setCod_book(int cod) {
        this.cod_book = cod;
    }
    public void setTitle(String t) {
        this.title = t;
    }
    public int getCod_book() {
        return cod_book;
    }
    public String getTitle() {
        return title;
    }
}
