package service.employee;

import model.employee.User;
import repository.employee.IUserRepository;
import repository.employee.UserRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class IUserServiceImpl implements IUserService{
    IUserRepository userRepository = new UserRepositoryImpl();
    @Override
    public List<User> findAll() throws SQLException {
        return userRepository.findAll();
    }
}
