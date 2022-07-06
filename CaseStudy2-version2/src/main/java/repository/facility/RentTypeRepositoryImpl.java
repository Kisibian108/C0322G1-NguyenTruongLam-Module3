package repository.facility;

import model.facility.FacilityType;
import model.facility.RentType;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepositoryImpl implements IRentTypeRepository{
    private static final String FIND_ALL = "select * from rent_type";

    @Override
    public List<RentType> findAll() throws SQLException {
        List<RentType> rentTypeList = new ArrayList<>();
        Connection connection = new BaseRepository().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        RentType rentType = null;
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            rentType = new RentType(id,name);
            rentTypeList.add(rentType);
        }
        return rentTypeList;
    }
    }
