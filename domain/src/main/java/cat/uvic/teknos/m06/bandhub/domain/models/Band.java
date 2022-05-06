package cat.uvic.teknos.m06.bandhub.domain.models;

import java.util.Date;
import java.util.List;

public class Band {
    private int id;
    private String name;
    private Date foundedOn;
    private boolean active;
    private List<MusicalGenre> musicalGenres;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFoundedOn() {
        return foundedOn;
    }

    public void setFoundedOn(Date foundedOn) {
        this.foundedOn = foundedOn;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<MusicalGenre> getMusicalGenres() {
        return musicalGenres;
    }

    public void setMusicalGenres(List<MusicalGenre> musicalGenres) {
        this.musicalGenres = musicalGenres;
    }
}
