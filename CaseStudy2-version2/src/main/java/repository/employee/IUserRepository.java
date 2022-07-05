package repository.employee;

import model.employee.Division;
import model.employee.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    List<User> findAll() throws SQLException;

}
