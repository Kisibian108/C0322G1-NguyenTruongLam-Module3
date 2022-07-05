package repository.employee;

import model.employee.Division;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepositoryImpl implements IDivisionRepository{

    private static final String FIND_ALL = "select * from division";
    List<Division> divisionList = new ArrayList<>();
    @Override
    public List<Division> findAll() throws SQLException {
        divisionList.clear();
        Connection connection = new BaseRepository().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        Division division = null;
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("division_name");

            division = new Division(id,name);
            divisionList.add(division);
        }
        return divisionList;
    }
}
