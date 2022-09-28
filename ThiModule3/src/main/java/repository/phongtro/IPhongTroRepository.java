package repository.phongtro;

import model.phongtro.PhongTro;

import java.sql.SQLException;
import java.util.List;

public interface IPhongTroRepository {
    List<PhongTro> findAll();

    void create(PhongTro phongTro);

    void edit(PhongTro phongTro);

    boolean delete(int id) throws SQLException;

    PhongTro findById(int id);

    List<PhongTro> findByName(String idRent ,String name, String phone);
}
