package service.hokhau;


import model.hokhau.HoKhau;
import model.phongtro.PhongTro;

import java.sql.SQLException;
import java.util.List;

public interface IHoKhauService {

    List<HoKhau> findAll();

    void edit(HoKhau hoKhau);

    HoKhau findById(int id);

}
