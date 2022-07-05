package service.customer;

import model.customer.CustomerType;
import repository.customer.CustomerTypeRepositoryImpl;
import repository.customer.ICustomerTypeRepository;

import java.util.List;

public class CustomerTypeImpl implements ICustomerTypeService {
    ICustomerTypeRepository customerTypeRepository = new CustomerTypeRepositoryImpl();
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
