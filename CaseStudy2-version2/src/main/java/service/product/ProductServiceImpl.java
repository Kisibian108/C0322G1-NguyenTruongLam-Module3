package service.product;

import model.product.Product;
import repository.product.CategoryRepositoryImpl;
import repository.product.ICategoryRepository;
import repository.product.IProductRepository;
import repository.product.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements IProductService {

    IProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void create(Product product) {
        productRepository.create(product);
    }

    @Override
    public void edit(Product product) {
        productRepository.edit(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return productRepository.searchByName(name);
    }
}
