package repository;

import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements ICustomerRepository {
    static List<Customer> customerList = new ArrayList<>();
    private static final String FIND_ALL = "SELECT * FROM customer ";
    private static final String FIND_BY_NAME = "SELECT * FROM customer where name like ? ";
    private static final String FIND_BY_ID = "SELECT * FROM customer where id = ? ";
    private static final String INSERT = " INSERT INTO customer (name, date_of_birth, gender, id_card, " +
            "phone_number, email, address ) " +
            " values( ?, ?, ?, ?, ?, ?, ?) ";

    private static final String UPDATE = " UPDATE customer SET name = ? , date_of_birth = ? , " +
            " gender = ?, id_card = ?,phone_number = ?, email = ?, address = ?  where id = ? ";

    @Override
    public List<Customer> findAll() {
        customerList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
//          Tạo câu lệnh SQL
            PreparedStatement preparedStatement =
                    connection.prepareStatement(FIND_ALL);
//          Dùng executeQuery/Update để thực thi.
//          ResultSet : Nhận kết quả từ DB trả về để xử lý
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String birthday = resultSet.getString("date_of_birth");
                int gender = resultSet.getInt("gender");
                String idCard = resultSet.getString("id_card");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                customer = new Customer(id, name, birthday, gender, idCard, phoneNumber, email, address);
                customerList.add(customer);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public void create(Customer customer) {
//      Tạo câu lệnh SQL
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(INSERT);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getBirthday());
            preparedStatement.setInt(3, customer.getGender());
            preparedStatement.setString(4, customer.getIdCard());
            preparedStatement.setString(5, customer.getPhoneNumber());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void edit(Customer customer) {
//        Tạo câu lệnh SQL
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getBirthday());
            preparedStatement.setInt(3, customer.getGender());
            preparedStatement.setString(4, customer.getIdCard());
            preparedStatement.setString(5, customer.getPhoneNumber());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setInt(8, customer.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete() {

    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;

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
                int idS = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String className = resultSet.getString("class_name");
                int gender = resultSet.getInt("gender");
                int score = resultSet.getInt("score");
//                customer = new Customer(idS, name, className, gender, score);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }
    }

