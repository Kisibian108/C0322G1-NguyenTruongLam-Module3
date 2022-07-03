package repository.impl;

import model.Product;
import repository.BaseRepository;
import repository.IProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {

    private static final String FIND_ALL = "select * from product;";
    private static final String INSERT = "INSERT INTO product (name, price, description, productor ) " +
            " values( ?, ?, ?, ?) ";
    private static final String UPDATE = " UPDATE product SET name = ? , price = ? , " +
            " description = ?, productor = ? where id = ? ";
    private static final String DELETE_SQL = "delete from product where id = ?;";
    private static final String FIND_BY_ID = "SELECT * FROM product where id = ? ";

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                String productor = resultSet.getString("productor");

                Product product = new Product(id, name, price, description, productor);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public void create(Product product) {
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4, product.getProductor());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public List<Product> findById(int id) {
        List<Product> productList = null;
        try {
            Connection connection = BaseRepository.getConnectDB();
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
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                String productor = resultSet.getString("productor");

                Product product = new Product(idS, name, price, description, productor);
                productList.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }


    @Override
    public void edit(Product product) {
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4, product.getProductor());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean delete(int id) {
        boolean rowDeleted = false;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement statement = connection.prepareStatement(DELETE_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public List<Product> search(String name) {
        return null;
    }
}
