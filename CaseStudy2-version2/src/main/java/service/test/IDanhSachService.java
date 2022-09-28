package service.test;

import model.customer.Customer;
import model.test.DanhSachBenhNhan;

import java.sql.SQLException;
import java.util.List;

public interface IDanhSachService {

    List<DanhSachBenhNhan> findAll();

    void create(DanhSachBenhNhan danhSachBenhNhan);

    void edit(DanhSachBenhNhan danhSachBenhNhan);

    void delete(int id) throws SQLException;

    DanhSachBenhNhan findById(int id);

    List<DanhSachBenhNhan> findByName(String name);
}
