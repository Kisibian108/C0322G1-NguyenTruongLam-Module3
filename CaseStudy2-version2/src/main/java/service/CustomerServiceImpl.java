package service;

import model.Customer;
import repository.CustomerRepositoryImpl;
import repository.ICustomerRepository;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService{

    ICustomerRepository customerRepository = new CustomerRepositoryImpl();
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void create(Customer customer) {
        customerRepository.create(customer);
    }

    @Override
    public void edit(Customer customer) {
        customerRepository.edit(customer);
    }

    @Override
    public void delete() {
        customerRepository.delete();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }
}
