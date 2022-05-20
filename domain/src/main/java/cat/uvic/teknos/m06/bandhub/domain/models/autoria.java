package cat.uvic.teknos.m06.bandhub.domain.models;

public class autoria {
    private int cod_book;
    private String cod_author;

    public void setCod_book(int cod) {
        this.cod_book = cod;
    }
    public void setCod_author(String cod) {
        this.cod_author = cod;
    }
    public int getCod_book() {
        return cod_book;
    }
    public String getCod_author() {
        return cod_author;
    }
}
