package service.product;

import model.product.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    void create(Product product);

    void edit(Product product);

    Product findById(int id);

    void delete(int id);

    List<Product> searchByName(String name);
}
