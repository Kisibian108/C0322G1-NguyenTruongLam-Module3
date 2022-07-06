package repository.facility;

import model.customer.Customer;
import model.facility.Facility;
import repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacilityRepositoryImpl implements IFacilityRepository {

    private static final String FIND_ALL = "select * from facility";
    private static final String FIND_BY_NAME = "SELECT * FROM facility where name like ? ";
    private static final String FIND_BY_ID = "SELECT * FROM facility where id = ? ";
    private static final String DELETE = "delete FROM facility where id = ? ";
    private static final String INSERT = " INSERT INTO facility (id, name, area, cost, max_people, " +
            "rent_type_id, facility_type_id, standard_room, description_other_convenience, pool_area, number_of_floors, facility_free ) " +
            " values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

    private static final String UPDATE = " UPDATE facility SET name = ? , area = ? , " +
            " cost = ?, max_people = ?,rent_type_id = ?, facility_type_id = ?, standard_room = ?, description_other_convenience = ?, " +
            " pool_area = ?, number_of_floors = ?, facility_free = ? where id = ? ";

    @Override
    public List<Facility> findAll() throws SQLException {
        List<Facility> facilityList = new ArrayList<>();
        Connection connection = new BaseRepository().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        Facility facility = null;
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int area = resultSet.getInt("area");
            double cost = resultSet.getDouble("cost");
            int maxPeople = resultSet.getInt("max_people");
            int rentTypeId = resultSet.getInt("rent_type_id");
            int facilityTypeId = resultSet.getInt("facility_type_id");
            String standardRoom = resultSet.getString("standard_room");
            String description = resultSet.getString("description_other_convenience");
            double poolArea = resultSet.getDouble("pool_area");
            int floor = resultSet.getInt("number_of_floors");
            String facilityFree = resultSet.getString("facility_free");

            facility = new Facility(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId, standardRoom, description, poolArea, floor, facilityFree);
            facilityList.add(facility);
        }
        return facilityList;
    }

    @Override
    public void create(Facility facility) {
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(INSERT);
            preparedStatement.setInt(1, facility.getId());
            preparedStatement.setString(2, facility.getName());
            preparedStatement.setInt(3, facility.getArea());
            preparedStatement.setDouble(4, facility.getArea());
            preparedStatement.setInt(5, (facility.getMaxPeople()));
            preparedStatement.setInt(6, facility.getRentTypeId());
            preparedStatement.setInt(7, facility.getFacilityTypeId());
            preparedStatement.setString(8, facility.getStandardRoom());
            preparedStatement.setString(9, facility.getConvenience());
            preparedStatement.setDouble(10, facility.getPoolArea());
            preparedStatement.setInt(11, facility.getFloor());
            preparedStatement.setString(12, facility.getFacilityFree());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void edit(Facility facility) {
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(UPDATE);

            preparedStatement.setString(1, facility.getName());
            preparedStatement.setInt(2, facility.getArea());
            preparedStatement.setDouble(3, facility.getArea());
            preparedStatement.setInt(4, (facility.getMaxPeople()));
            preparedStatement.setInt(5, facility.getRentTypeId());
            preparedStatement.setInt(6, facility.getFacilityTypeId());
            preparedStatement.setString(7, facility.getStandardRoom());
            preparedStatement.setString(8, facility.getConvenience());
            preparedStatement.setDouble(9, facility.getPoolArea());
            preparedStatement.setInt(10, facility.getFloor());
            preparedStatement.setString(11, facility.getFacilityFree());
            preparedStatement.setInt(12, facility.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean delete(int id) {
        boolean rowDeleted = false;
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public Facility findById(int id) {
        Facility facility = null;
// cho gender dang chua nhap dc
        try {
            Connection connection = new BaseRepository().getConnection();
//          Tạo câu lệnh SQL
            PreparedStatement preparedStatement =
                    connection.prepareStatement(FIND_BY_ID);
//          Dùng executeQuery/Update để thực thi.
//          ResultSet : Nhận kết quả từ DB trả về để xử lý
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
//            int idS = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int area = resultSet.getInt("area");
                double cost = resultSet.getDouble("cost");
                int maxPeople = resultSet.getInt("max_people");
                int rentTypeId = resultSet.getInt("rent_type_id");
                int facilityTypeId = resultSet.getInt("facility_type_id");
                String standardRoom = resultSet.getString("standard_room");
                String description = resultSet.getString("description_other_convenience");
                double poolArea = resultSet.getDouble("pool_area");
                int floor = resultSet.getInt("number_of_floors");
                String facilityFree = resultSet.getString("facility_free");

                facility = new Facility(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId, standardRoom, description, poolArea, floor, facilityFree);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return facility;
    }

    @Override
    public List<Facility> findByName(String nameS) {
      List<Facility> facilityList = new ArrayList<>();
        try {
            Connection connection = new BaseRepository().getConnection();
//          Tạo câu lệnh SQL
            PreparedStatement preparedStatement =
                    connection.prepareStatement(FIND_BY_NAME);
//          Dùng executeQuery/Update để thực thi.
//          ResultSet : Nhận kết quả từ DB trả về để xử lý
            preparedStatement.setString(1, "%" + nameS + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            Facility facility = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int area = resultSet.getInt("area");
                double cost = resultSet.getDouble("cost");
                int maxPeople = resultSet.getInt("max_people");
                int rentTypeId = resultSet.getInt("rent_type_id");
                int facilityTypeId = resultSet.getInt("facility_type_id");
                String standardRoom = resultSet.getString("standard_room");
                String description = resultSet.getString("description_other_convenience");
                double poolArea = resultSet.getDouble("pool_area");
                int floor = resultSet.getInt("number_of_floors");
                String facilityFree = resultSet.getString("facility_free");

                facility = new Facility(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId, standardRoom, description, poolArea, floor, facilityFree);
                facilityList.add(facility);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return facilityList;
    }
}

