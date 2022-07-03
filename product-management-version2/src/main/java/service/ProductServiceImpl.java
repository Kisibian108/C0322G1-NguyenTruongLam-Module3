package service;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements IProductService{

    IProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() throws SQLException {
        return productRepository.findAll();
    }

    @Override
    public void create(Product product) {
        productRepository.create(product);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void edit(Product product) {
        productRepository.edit(product);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public List<Product> search(String name) {
        return productRepository.search(name);
    }
}
