package service;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepositoryImpl;

import java.sql.SQLException;
import java.util.*;

public class ProductServiceImpl implements IProductService {

    IProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() throws SQLException {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        productRepository.update(id, product);
    }

    @Override
    public void remove(int id) {
        productRepository.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList = new ArrayList<>();
        productRepository.search(name);
        return productList;
    }
}
//    private IStudentRepository studentRepository = new StudentRepositoryImpl();
//
//    @Override
//    public List<Student> findAll() {
//        return studentRepository.findAll();
//    }
//
//    @Override
//    public void create(Student student) {
//        studentRepository.create(student);
//    }
//
//    @Override
//    public void edit(Student student) {
//        studentRepository.edit(student);
//    }
//
//    @Override
//    public Student findById(int id) {
//        return studentRepository.findById(id);
//    }
//
//    @Override
//    public List<Student> findByName(String name) {
//        return studentRepository.findByName(name);
//    }
//    @Override
//    public List<Product> search(String name) {
//        List<Product> productList = new ArrayList<>();
//        for (Map.Entry<Integer, Product> entry : productMap.entrySet()) {
//            if (entry.getValue().getName().contains(name)) {
//                productList.add(entry.getValue());
//            }
//        }
//        return productList;
//    }

