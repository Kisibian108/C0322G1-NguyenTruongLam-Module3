package service.phongtro;

import model.customer.Customer;
import model.phongtro.PhongTro;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IPhongTroService {

    List<PhongTro> findAll();

    Map<String, String> create(PhongTro phongTro);

    void edit(PhongTro phongTro);

    void delete(int id) throws SQLException;

    PhongTro findById(int id);

    List<PhongTro> findByName(String idRent ,String name, String phone);
}
