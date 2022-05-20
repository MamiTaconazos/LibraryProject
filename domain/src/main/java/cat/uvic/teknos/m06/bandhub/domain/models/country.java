package cat.uvic.teknos.m06.bandhub.domain.models;

public class country {
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
