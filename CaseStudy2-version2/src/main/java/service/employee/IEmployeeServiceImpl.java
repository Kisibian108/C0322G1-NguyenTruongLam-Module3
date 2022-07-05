package service.employee;

import model.customer.Customer;
import model.employee.Employee;
import repository.employee.EmployeeRepositoryImpl;
import repository.employee.IEmployeeRepository;

import java.sql.SQLException;
import java.util.List;

public class IEmployeeServiceImpl implements IEmployeeService{

    IEmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void create(Employee employee) {
        employeeRepository.create(employee);
    }

    @Override
    public void edit(Employee employee) {
        employeeRepository.edit(employee);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return employeeRepository.delete(id);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }
}
