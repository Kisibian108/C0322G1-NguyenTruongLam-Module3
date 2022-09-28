package repository.test;

import model.test.DanhSachBenhNhan;

import java.sql.SQLException;
import java.util.List;

public interface IDanhSachRepository {
    List<DanhSachBenhNhan> findAll();

    void create(DanhSachBenhNhan danhSachBenhNhan);

    void edit(DanhSachBenhNhan danhSachBenhNhan);

    boolean delete(int id) throws SQLException;

    DanhSachBenhNhan findById(int id);

    List<DanhSachBenhNhan> findByName(String name);
}
