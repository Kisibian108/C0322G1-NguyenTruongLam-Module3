package service.customer;

import common.Validate;
import model.customer.Customer;
import repository.customer.CustomerRepositoryImpl;
import repository.customer.ICustomerRepository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements ICustomerService {

    ICustomerRepository customerRepository = new CustomerRepositoryImpl();
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Map<String, String> create(Customer customer) {
        Map<String,String> mapValidate = new HashMap<>();

        if (customer.getName().equals("")){
            mapValidate.put("name","Ten ko dc de trong");
        } else if(!customer.getName().matches(Validate.REGEX_NAME)){
            mapValidate.put("name","Ten sai dinh dang");
        }
        if (!customer.getIdCard().matches(Validate.REGEX_ID_CARD)){
            mapValidate.put("idCard","idCard sai dinh dang");
        }
        if (!customer.getPhoneNumber().matches(Validate.REGEX_PHONE_NUMBER)){
            mapValidate.put("phone","phone sai dinh dang");
        }
        if (!customer.getAddress().matches(Validate.REGEX_ADDRESS)){
            mapValidate.put("address","address sai dinh dang");
        }

        if (mapValidate.isEmpty()){
            customerRepository.create(customer);
        }
        return mapValidate;
    }

    @Override
    public void edit(Customer customer) {
        customerRepository.edit(customer);
    }

    @Override
    public void delete(int id) throws SQLException {
        customerRepository.delete(id);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> findByName(String name, String phone) {
        return customerRepository.findByName(name, phone);
    }
}
