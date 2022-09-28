package repository.customer;

import model.customer.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerRepository {

    List<Customer> findAll();

    void create(Customer customer);

    void edit(Customer customer);

    boolean delete(int id) throws SQLException;

    Customer findById(int id);

    List<Customer> findByName(String name, String phone);
}
