package service.employee;

import model.customer.Customer;
import model.employee.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    void create(Employee employee);

    void edit(Employee employee);

    boolean delete(int id) throws SQLException;

    Employee findById(int id);

    List<Employee> findByName(String name);
}
