package repository.product;

import model.product.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAll();
}
