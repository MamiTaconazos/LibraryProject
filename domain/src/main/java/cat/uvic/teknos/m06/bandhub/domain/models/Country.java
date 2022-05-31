package cat.uvic.teknos.m06.bandhub.domain.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_country;
    private String name;

    public void setCod_country(int cod) {
        this.cod_country = cod;
    }
    public void setName(String n) {
        this.name = n;
    }
    public int getCod_country() {
        return cod_country;
    }
    public String getName() {
        return name;
    }
}
