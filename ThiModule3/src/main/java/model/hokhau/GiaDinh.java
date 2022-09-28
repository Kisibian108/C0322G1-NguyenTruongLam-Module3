package model.hokhau;

public class GiaDinh {


    private int id;
    private String hoKhau;
    private int idCard;
    private String name;
    private String birthday;

    public GiaDinh() {
    }

    public GiaDinh(int id, String hoKhau, int idCard, String name, String birthday) {
        this.id = id;
        this.hoKhau = hoKhau;
        this.idCard = idCard;
        this.name = name;
        this.birthday = birthday;
    }

    public GiaDinh(String hoKhau, int idCard, String name, String birthday) {
        this.hoKhau = hoKhau;
        this.idCard = idCard;
        this.name = name;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoKhau() {
        return hoKhau;
    }

    public void setHoKhau(String hoKhau) {
        this.hoKhau = hoKhau;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
