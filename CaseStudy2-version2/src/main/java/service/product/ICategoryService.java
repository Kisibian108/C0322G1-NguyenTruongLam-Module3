package service.product;

import model.product.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
