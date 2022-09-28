package repository.employee;

import model.customer.Customer;
import model.employee.Employee;
import model.facility.Facility;
import repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//private int id;
//private String name;
//private String birthday;
//private String idCard;
//private double salary;
//private String phoneNumber;
//private String email;
//private String address;
//private int positionId;
//private int educationDegreeId;
//private int divisionId;
//private String username;

public class EmployeeRepositoryImpl implements IEmployeeRepository{
    static List<Employee> employeeList = new ArrayList<>();
    private static final String FIND_ALL = "SELECT * FROM employee ";
    private static final String FIND_BY_NAME = "SELECT * FROM employee where name like ? ";
    private static final String FIND_BY_ID = "SELECT * FROM employee where id = ? ";
    private static final String DELETE = "delete FROM employee where id = ? ";
    private static final String INSERT = " INSERT INTO employee ( name, date_of_birth, id_card, salary, " +
            "phone_number, email, address, position_id, education_degree_id, division_id, username ) " +
            " values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) ";

    private static final String UPDATE = " UPDATE employee SET name = ? , date_of_birth = ? , " +
            " id_card = ?, salary = ?,phone_number = ?, email = ?, address = ?, position_id = ?, " +
            " education_degree_id = ?, division_id = ?, username = ? where id = ? ";
    @Override
    public List<Employee> findAll() {
        employeeList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
//          Tạo câu lệnh SQL
            PreparedStatement preparedStatement =
                    connection.prepareStatement(FIND_ALL);
//          Dùng executeQuery/Update để thực thi.
//          ResultSet : Nhận kết quả từ DB trả về để xử lý
            ResultSet resultSet = preparedStatement.executeQuery();
            Employee employee = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String birthday = resultSet.getString("date_of_birth");
                String idCard = resultSet.getString("id_card");
                double salary = resultSet.getDouble("salary");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                employee = new Employee(id, name, birthday, idCard,salary, phoneNumber, email, address,positionId,educationDegreeId,divisionId,username);
                employeeList.add(employee);
            }
//
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void create(Employee employee) {
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(INSERT);
//            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setDate(2,  (Date.valueOf(employee.getBirthday())));
            preparedStatement.setString(3, employee.getIdCard());
            preparedStatement.setDouble(4, (employee.getSalary()));
            preparedStatement.setString(5, employee.getPhoneNumber());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8, employee.getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivisionId());
            preparedStatement.setString(11, employee.getUsername());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void edit(Employee employee) {
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setDate(2,  (Date.valueOf(employee.getBirthday())));
            preparedStatement.setString(3, employee.getIdCard());
            preparedStatement.setDouble(4, (employee.getSalary()));
            preparedStatement.setString(5, employee.getPhoneNumber());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8, employee.getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivisionId());
            preparedStatement.setString(11, employee.getUsername());
            preparedStatement.setInt(12, employee.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
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
    public Employee findById(int id) {

        Employee employee = null;
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
//                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String birthday = resultSet.getString("date_of_birth");
                String idCard = resultSet.getString("id_card");
                double salary = resultSet.getDouble("salary");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                employee = new Employee(id, name, birthday, idCard,salary, phoneNumber, email, address,positionId,educationDegreeId,divisionId,username);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> findByName(String nameS) {
        employeeList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
//          Tạo câu lệnh SQL
            PreparedStatement preparedStatement =
                    connection.prepareStatement(FIND_BY_NAME);
//          Dùng executeQuery/Update để thực thi.
//          ResultSet : Nhận kết quả từ DB trả về để xử lý
            preparedStatement.setString(1, "%" + nameS + "%");
//            preparedStatement.setString(2, "%" + phoneS + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            Employee employee = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String birthday = resultSet.getString("date_of_birth");
                String idCard = resultSet.getString("id_card");
                double salary = resultSet.getDouble("salary");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                employee = new Employee(id, name, birthday, idCard,salary, phoneNumber, email, address,positionId,educationDegreeId,divisionId,username);
                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }
}
