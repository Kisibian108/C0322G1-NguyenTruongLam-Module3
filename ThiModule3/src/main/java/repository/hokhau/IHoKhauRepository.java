package repository.hokhau;

import model.hokhau.HoKhau;

import java.util.List;

public interface IHoKhauRepository {
    List<HoKhau> findAll();

    void edit(HoKhau hoKhau);

    HoKhau findById(int id);
}
