package cat.uvic.teknos.m06.bandhub.domain.models;

public class Genre {
    private int cod_genre;
    private String description;
    public void setCod_genre(int cod) {
        this.cod_genre = cod;
    }
    public void setDescription(String d) {
        this.description = d;
    }
    public int getCod_genre() {
        return cod_genre;
    }
    public String getDescription() {
        return description;
    }


}
