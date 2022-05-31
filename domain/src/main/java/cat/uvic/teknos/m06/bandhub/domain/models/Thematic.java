package cat.uvic.teknos.m06.bandhub.domain.models;

public class Thematic {
    private int cod_book;
    private int cod_genre;
    private String title;
    private String description;

    public void setCod_book(int cod) {
        this.cod_book = cod;
    }
    public void setCod_genre(int n) {
        this.cod_genre = n;
    }
    public void setTitle(String t) {
        this.title = t;
    }
    public void setDescription(String d) {
        this.description = d;
    }


    public int getCod_book() {
        return cod_book;
    }
    public int getCod_genre() {
        return cod_genre;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }



}
