package repository.product;

import model.customer.CustomerType;
import model.product.Category;
import repository.BaseRepository;
import service.product.ICategoryService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements ICategoryRepository{
    static List<Category> categoryList = new ArrayList<>();
    private static final String FIND_ALL = "select * from category ";
    @Override
    public List<Category> findAll() {
        categoryList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
//          Tạo câu lệnh SQL
            PreparedStatement preparedStatement =
                    connection.prepareStatement(FIND_ALL);
//          Dùng executeQuery/Update để thực thi.
//          ResultSet : Nhận kết quả từ DB trả về để xử lý
            ResultSet resultSet = preparedStatement.executeQuery();
            Category category = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("category_name");
                category = new Category(id, name);
                categoryList.add(category);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categoryList;
    }
}
