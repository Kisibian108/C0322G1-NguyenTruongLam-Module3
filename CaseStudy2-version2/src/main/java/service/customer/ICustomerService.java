package service.customer;

import model.customer.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();

    void create(Customer customer);

    void edit(Customer customer);

    void delete(int id) throws SQLException;

    Customer findById(int id);

    List<Customer> findByName(String name);
}
