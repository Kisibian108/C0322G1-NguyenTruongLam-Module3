package model.hokhau;

public class HoKhau {

    private int id;
    private int idHoKhau;
    private String name;
    private String number;
    private String date;
    private String address;

    public HoKhau() {

    }

    public HoKhau(int id, int idHoKhau, String name, String number, String date, String address) {
        this.id = id;
        this.idHoKhau = idHoKhau;
        this.name = name;
        this.number = number;
        this.date = date;
        this.address = address;
    }

    public HoKhau(int idHoKhau, String name, String number, String date, String address) {
        this.idHoKhau = idHoKhau;
        this.name = name;
        this.number = number;
        this.date = date;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHoKhau() {
        return idHoKhau;
    }

    public void setIdHoKhau(int idHoKhau) {
        this.idHoKhau = idHoKhau;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}


