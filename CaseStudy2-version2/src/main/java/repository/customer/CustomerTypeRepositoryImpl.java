package repository.customer;

import model.customer.CustomerType;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepositoryImpl implements ICustomerTypeRepository {

    static List<CustomerType> customerTypeList = new ArrayList<>();
    private static final String FIND_ALL = "SELECT * FROM customer_type ";
    private static final String SELECT_ALL1 = "select customer.id, customer.`name`, customer_type.`name` from \n" +
            "customer join customer_type on customer.customer_type_id = customer_type.id;";
    @Override
    public List<CustomerType> findAll() {
        customerTypeList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
//          Tạo câu lệnh SQL
            PreparedStatement preparedStatement =
                    connection.prepareStatement(FIND_ALL);
//          Dùng executeQuery/Update để thực thi.
//          ResultSet : Nhận kết quả từ DB trả về để xử lý
            ResultSet resultSet = preparedStatement.executeQuery();
            CustomerType customerType = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                customerType = new CustomerType(id, name);
                customerTypeList.add(customerType);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerTypeList;
    }
}
