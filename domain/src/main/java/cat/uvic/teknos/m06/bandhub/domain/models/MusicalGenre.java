package cat.uvic.teknos.m06.bandhub.domain.models;

import java.util.Date;
import java.util.List;

public class MusicalGenre {
    private int id;
    private String name;
    private List<Band> bands;

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

    public List<Band> getBands() {
        return bands;
    }

    public void setBands(List<Band> bands) {
        this.bands = bands;
    }
}
