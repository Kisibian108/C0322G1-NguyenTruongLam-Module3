package repository;

import model.Customer;

import java.util.List;

public interface ICustomerRepository {

    List<Customer> findAll();

    void create(Customer customer);

    void edit(Customer customer);

    void delete();

    Customer findById(int id);
}
