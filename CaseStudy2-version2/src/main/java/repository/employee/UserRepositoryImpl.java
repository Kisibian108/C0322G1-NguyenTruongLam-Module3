package repository.employee;

import model.employee.Position;
import model.employee.User;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements IUserRepository{
    private static final String FIND_ALL = "select * from user";
    List<User> userList = new ArrayList<>();
    @Override
    public List<User> findAll() throws SQLException {
        userList.clear();
        Connection connection = new BaseRepository().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        User user = null;
        while (resultSet.next()){
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            user = new User(username, password);
            userList.add(user);
        }
        return userList;
    }
}
