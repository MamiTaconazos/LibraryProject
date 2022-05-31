package cat.uvic.teknos.m06.bandhub.domain.models;
import java.util.Date;

public class Member {
    private int cod_member;
    private String name;
    private String surname;
    private String address;
    private String cod_postal;
    private String poblation;
    private int phone_num;
    private Date data_birth;
    public void setCod_member(int cod) {
        this.cod_member = cod;
    }
    public void setName(String n) {
        this.name = n;
    }
    public void setSurname(String sname) {
        this.surname = sname;
    }
    public void setAddress(String add) {
        this.address = add;
    }
    public void setCod_postal(String cod) {
        this.cod_postal = cod;
    }
    public void setPoblation(String p) {
        this.poblation = p;
    }
    public void setPhone_num(int num) {
        this.phone_num = num;
    }
    public void setData_birth(Date dat) {
        this.data_birth = dat;
    }

    public int getCod_member() {
        return cod_member;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getAddress() {
        return address;
    }
    public String getCod_postal() {
        return cod_postal;
    }
    public String getPoblation() {
        return poblation;
    }
    public int getPhone_num() {
        return phone_num;
    }
    public Date getData_birth() {
        return data_birth;
    }



}
