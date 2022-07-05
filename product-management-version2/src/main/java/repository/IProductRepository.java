package repository;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductRepository {

    List<Product> findAll() throws SQLException;

    void create(Product product);

    void save(Product product);

    Product findById(int id);

    void edit(Product product);

    boolean delete(int id);

    List<Product> search(String name);
}
