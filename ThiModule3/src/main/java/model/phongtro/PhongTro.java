package model.phongtro;

public class PhongTro {

    private int id;
    private String idRent;
    private String name;
    private String phone;
    private String startDate;
    private int paymentId;
    private String note;

    public PhongTro() {
    }

    public PhongTro(int id, String idRent, String name, String phone, String startDate, int paymentId, String note) {
        this.id = id;
        this.idRent = idRent;
        this.name = name;
        this.phone = phone;
        this.startDate = startDate;
        this.paymentId = paymentId;
        this.note = note;
    }

    public PhongTro(String idRent, String name, String phone, String startDate, int paymentId, String note) {
        this.idRent = idRent;
        this.name = name;
        this.phone = phone;
        this.startDate = startDate;
        this.paymentId = paymentId;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdRent() {
        return idRent;
    }

    public void setIdRent(String idRent) {
        this.idRent = idRent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}