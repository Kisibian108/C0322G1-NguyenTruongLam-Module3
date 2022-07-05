package repository.employee;

import model.employee.EducationDegree;
import model.employee.Position;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepositoryImpl implements IPositionRepository{
    private static final String FIND_ALL = "select * from position";
    List<Position> positionList = new ArrayList<>();
    @Override
    public List<Position> findAll() throws SQLException {
        Connection connection = new BaseRepository().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        Position position = null;
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("position_name");
            position = new Position(id, name);
            positionList.add(position);
        }
        return positionList;
    }
    }

