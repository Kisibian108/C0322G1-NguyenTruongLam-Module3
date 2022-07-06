package repository.facility;

import model.customer.Customer;
import model.facility.Facility;

import java.sql.SQLException;
import java.util.List;

public interface IFacilityRepository {
    List<Facility> findAll() throws SQLException;

    void create(Facility facility);

    void edit(Facility facility);

    boolean delete(int id);

    Facility findById(int id);

    List<Facility> findByName(String name);
}
