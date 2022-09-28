package model.test;

public class BenhNhan {
    private int id;
    private String name;
    private String tenBa;

    public BenhNhan() {
    }

    public BenhNhan(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getTenBa() {
        return tenBa;
    }

    public void setTenBa(String tenBa) {
        this.tenBa = tenBa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
