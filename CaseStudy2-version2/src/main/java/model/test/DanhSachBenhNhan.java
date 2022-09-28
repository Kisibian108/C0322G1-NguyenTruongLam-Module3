package model.test;

public class DanhSachBenhNhan {

//    - Mã bệnh án (Mã bệnh án là id của bệnh án nằm trong table Bệnh Án)
//- Mã bệnh nhân (Mã bệnh nhân là id của bệnh nhân nằm trong table Bệnh Nhân)
//- Tên bệnh nhân
//- Ngày nhập viện
//- Ngày ra viện
//- Lý do nhập viện
    private int id;
    private int idBenhAn;
    private int idBenhNhan;
    private String name;
    private String enterDate;
    private String outDate;
    private String reason;

    public DanhSachBenhNhan() {
    }

    public DanhSachBenhNhan(int id, int idBenhAn, int idBenhNhan, String name, String enterDate, String outDate, String reason) {
        this.id = id;
        this.idBenhAn = idBenhAn;
        this.idBenhNhan = idBenhNhan;
        this.name = name;
        this.enterDate = enterDate;
        this.outDate = outDate;
        this.reason = reason;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdBenhAn() {
        return idBenhAn;
    }

    public void setIdBenhAn(int idBenhAn) {
        this.idBenhAn = idBenhAn;
    }

    public int getIdBenhNhan() {
        return idBenhNhan;
    }

    public void setIdBenhNhan(int idBenhNhan) {
        this.idBenhNhan = idBenhNhan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(String enterDate) {
        this.enterDate = enterDate;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
