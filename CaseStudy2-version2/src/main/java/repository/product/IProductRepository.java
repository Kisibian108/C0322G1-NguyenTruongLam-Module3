package repository.product;

import model.product.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void create(Product product);

    void edit(Product product);

    Product findById(int id);

    boolean delete(int id);

    List<Product> searchByName(String name);
}
