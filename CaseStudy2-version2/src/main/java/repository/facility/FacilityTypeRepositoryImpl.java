package repository.facility;

import model.facility.Facility;
import model.facility.FacilityType;
import repository.BaseRepository;
import service.facility.IFacilityService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityTypeRepositoryImpl implements IFacilityTypeRepository{

    private static final String FIND_ALL = "select * from facility_type";

    @Override
    public List<FacilityType> findAll() throws SQLException {
        List<FacilityType> facilityTypeList = new ArrayList<>();
        Connection connection = new BaseRepository().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        FacilityType facilityType = null;
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            facilityType = new FacilityType(id,name);
            facilityTypeList.add(facilityType);
        }
        return facilityTypeList;
    }
}
