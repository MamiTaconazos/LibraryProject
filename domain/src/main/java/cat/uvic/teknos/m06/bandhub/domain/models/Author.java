package cat.uvic.teknos.m06.bandhub.domain.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_author;
    private String name;
    private String surname;
    private Date birth;
    private int cod_country;

    public void setCod_author(int cod) {
        this.cod_author = cod;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String sname) {
        this.surname = sname;
    }
    public void setBirth(Date dat) {
        this.birth = dat;
    }
    public void setCod_country(int num) {
        this.cod_country = num;
    }


    public int getCod_author() {
        return cod_author;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public Date getBirth() {
        return birth;
    }
    public int getCod_country() {
        return cod_country;
    }

}
